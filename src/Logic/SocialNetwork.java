package Logic;

import Data.Post;
import Data.User;
import UI.CommandLineInterface;

import java.util.HashMap;
import java.util.Map;

public class SocialNetwork
{
    private Map<String, User> users = new HashMap<>();
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
        while(true)
        {
            cli.print("Enter your username: ");
            String username = cli.getInputFromUser();
            cli.print("Enter your Password: ");
            String password = cli.getInputFromUser();
            if (users.containsKey(username) && users.get(username).getPassword().equals(password))
            {
                cli.print("Welcome " + username + " :)");
                return users.get(username);
            }
            else
            {
                cli.print("Try again");
            }
        }
    }

    private void PrintUsersToWritePost(Map<Integer, String> indexToUser)
    {
        cli.print("Choose user to write a post on his wall:");
        PrintUsers(indexToUser);
        cli.print("0. - Main menu");
    }

    private void PrintMenu()
    {
        cli.print("1. To write a post on user’s wall");
        cli.print("2. Add New User");
        cli.print("3. Add a new friend :)");
        cli.print("4. Print all users");
        cli.print("5. Print all users wall");
        cli.print("0. EXIT");
    }

    private void PrintAllUsersWall ()
    {
        //שילוב של פרינט יוזרס והפור הזה: for (Post post : userToWriteTo.getPosts())
        //        {
        //            cli.print("The writer of the post: " + post.getWriter());
        //            cli.print(post.getText());
        //        }
    }

    private void AddUser()
    {
        cli.print("What user do you like to add ? ");
        String username = cli.getInputFromUser();
        cli.print("Enter password: ");
        String password = cli.getInputFromUser();
        if (!users.containsKey(username))
        {
            users.put(username, new User(username, password));
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
        for (Map.Entry<String, User> userEntry : users.entrySet()) {
            result.put(count++, userEntry.getKey());
        }
        return result;
    }

    private void AddFriend()
    {

    }

    public void Run()
    {
        users.put("Shahar", new User("Shahar", "123456"));
        users.put("Shay", new User("Shay", "123S"));

        cli.print("Hello and Welcome to Shahar's App !");
        int userToWriteToIndex;
        while (true)
        {
            Map<Integer, String> indexToUser = GetIndices();

            User loggedInUser = Login();
            PrintMenu();
            int menuSelection = cli.getIntInputFromUser(0, 5);
            switch (menuSelection)
            {
                case 1:
                    PrintUsersToWritePost(indexToUser);
                    userToWriteToIndex = cli.getIntInputFromUser(0, users.size());
                    if(userToWriteToIndex == 1)
                    {
                        PrintUsersToWritePost(indexToUser);
                        if (userToWriteToIndex >= 1 && userToWriteToIndex <= users.size())
                        {
                            User userToWriteTo = users.get(indexToUser.get(userToWriteToIndex));
                            WriteAPost(loggedInUser, userToWriteTo);
                        }

                        else if (userToWriteToIndex == 0)
                        {
                            cli.print("Going back to main menu");
                            break;
                        }
                    }
                    break;
                case 2:
                    AddUser();
                    break;
                case 3:
                    break;
                case 4:
                    PrintUsers(indexToUser);
                    break;
                case 5:
                    break;
                case 0:
                    cli.print("Exiting Program...");
                    return;
            }
        }
    }
}