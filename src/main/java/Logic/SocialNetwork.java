package Logic;

import Data.Post;
import Data.User;
import Data.UsersData;
import UI.CommandLineInterface;


import java.io.*;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SocialNetwork
{
    public static final int INDEX_TO_EXIT = 0;
    public static final int NUMBER_OF_RETRIES = 3;
    private UsersData users = new UsersData();
    private CommandLineInterface cli = new CommandLineInterface();

    public void PrintUsers(Map<Integer, String> indexToUser)
    {
        for (Map.Entry<Integer, String> userEntry : indexToUser.entrySet())
        {
            Integer index = userEntry.getKey();
            String username = userEntry.getValue();
            cli.print(index + ". " + username);
        }
    }
    private User Login()
    {
        //while(true)
        cli.print("Enter your username: ");
        String username = cli.getInputFromUser();
        for(int i = 0; i< NUMBER_OF_RETRIES; i++)
        {
            cli.print("Enter your Password: ");
            String password = cli.getInputFromUser();
            if (users.getUsers().containsKey(username) && users.getUsers().get(username).getPassword().equals(password))
            {
                cli.print("Welcome " + username + " :)");
                return users.getUsers().get(username);
            }
            else
            {
                cli.print("Attempt number " + String.valueOf(i+1) + " Failed. Please try again");
            }
        }
        cli.print("Failed 3 times. Exit program...");
        return null;
    }

    private void PrintUsersToWritePost(Map<Integer, String> indexToUser)
    {
        cli.print("Choose user to write a post on his wall:");
        PrintUsers(indexToUser);
        cli.print("0. - Main menu");
    }

    private void PrintMenu()
    {
        cli.print("Main Menu:");
        cli.print("1. To write a post on users wall");
        cli.print("2. Add New User");
        cli.print("3. Add a new friend :)");
        cli.print("4. Print all users");
        cli.print("5. Print all users wall");
        cli.print("6. Log Out");
        cli.print("0. EXIT");
    }

    private void PrintAllUsersWall ()
    {
        for (Map.Entry<String, User> userEntry : users.getUsers().entrySet())
        {
            cli.print("Username: " + userEntry.getKey());
            for (Post post : userEntry.getValue().getPosts())
            {
                cli.print("The writer of the post: " + post.getWriter());
                cli.print(post.getText());
            }
        }
    }

    private void AddUser()
    {
        cli.print("What user do you like to add ? ");
        String username = cli.getInputFromUser();
        cli.print("Enter password: ");
        String password = cli.getInputFromUser();
        if (!users.getUsers().containsKey(username))
        {
            users.getUsers().put(username, new User(username, password));
        }
        else
        {
            cli.print("User already exists");
        }
    }

    private void WriteAPost(User loggedInUser, User userToWriteTo)
    {
        cli.print("What do you want to write? ");
        String text = cli.getInputFromUser();
        userToWriteTo.addPost(text, loggedInUser.getUsername());
        //Print all posts
        for (Post post : userToWriteTo.getPosts())
        {
            cli.print("The writer of the post: " + post.getWriter());
            cli.print(post.getText());
        }
    }

    private Map<Integer, String> GetIndices()
    {
        Map<Integer, String> result = new HashMap<>();
        int count = 1;
        for (Map.Entry<String, User> userEntry : users.getUsers().entrySet()) {
            result.put(count++, userEntry.getKey());
        }
        return result;
    }

    private void AddFriend()
    {

    }
    private void LogOut()
    {

    }

    private void saveData()
    {
        Gson gson = new Gson();
        try {
            Writer writer = new FileWriter("./DataFiles.json");
            gson.toJson(users, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadData()
    {
        Gson gson = new Gson();

        try (Reader reader = new FileReader("./DataFiles.json")) {

            // Convert JSON File to Java Object
            users = gson.fromJson(reader,UsersData.class);

            // print staff object
            System.out.println(users);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void Run()
    {
//        users.put("Shay", new User("Shay", "123"));

        loadData();
        users.getUsers().put("Admin", new User("Admin", "123"));
        cli.print("Hello and Welcome to Shahar's App !");
        int userToWriteToIndex;
        while (true)
        {
            Map<Integer, String> indexToUser = GetIndices();

            User loggedInUser = Login();
            if(loggedInUser != null)
            {
                while (true)
                {
                    PrintMenu();
                    int menuSelection = cli.getIntInputFromUser(0, 5);
                    switch (menuSelection)
                    {
                        case 1:
                            PrintUsersToWritePost(indexToUser);
                            userToWriteToIndex = cli.getIntInputFromUser(0, users.getUsers().size());
                            if (userToWriteToIndex >= 1 && userToWriteToIndex <= users.getUsers().size())
                            {
                                User userToWriteTo = users.getUsers().get(indexToUser.get(userToWriteToIndex));
                                WriteAPost(loggedInUser, userToWriteTo);
                            }

                            else if (userToWriteToIndex == INDEX_TO_EXIT)
                            {
                                cli.print("Going back to main menu");
                                break;
                            }
                            break;
                        case 2:
                            AddUser();
                            break;
                        case 3:
                            AddFriend();
                            break;
                        case 4:
                            PrintUsers(indexToUser);
                            break;
                        case 5:
                            PrintAllUsersWall();
                            break;
                        case 6:
                            LogOut();
                        case 0:
                            cli.print("Exiting Program...");
                            saveData();
                            return;
                    }
                }
            }

        }
    }
}