package Logic;

import Data.Post;
import Data.User;
import UI.CommandLineInterface;

import java.util.HashMap;
import java.util.Map;

public class Menu
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
    private void Login()
    {
        while() {
            cli.print("Enter your username: ");
            String username = cli.getInputFromUser();
            cli.print("Enter your Password: ");
            String password = cli.getInputFromUser();
            User user = new User(username, password);
            if (users.containsValue(user)) {
                cli.print("Welcome " + username + " :)");
            } else {
                cli.print("Try again");
            }
        }
    }

    private void PrintUsersToWritePost(Map<Integer, String> indexToUser)
    {
        cli.print("Choose user to write a post on his wall:");
        PrintUsers(indexToUser);
        cli.print(users.size() + 1 + ". - Add New User");
        cli.print("0. - EXIT");
    }

    private void PrintMenu()
    {
        cli.print("1. To write a post on user’s wall");
        cli.print("2. - Add New User");
        cli.print("3. Add a new friend :)");
        cli.print("0. - EXIT");
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
//            indexToUser.put(count, userName);
        }
        else
        {
            cli.print("User already exists");
        }
    }

    private void HandleUser(User user, Map<Integer, String> indexToUser)
    {
        cli.print("On who's wall do you want to write?  ");
        int friend_user_num = cli.getIntInputFromUser(0, users.size() + 1);
        cli.print("What do you want to write? ");
        String text = cli.getInputFromUser();
        String friend_user_name = indexToUser.get(friend_user_num);
        users.get(friend_user_name).addPost(text);
        //Print all posts
        for (Post post : users.get(friend_user_name).getPosts())
        {
            cli.print("The writer of the post: " + user.getUsername());
            cli.print(post.getText());
        }
        //Print all users walls
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
        int choice;
        while (true)
        {
            Map<Integer, String> indexToUser = GetIndices();

            Login();
            PrintMenu();
            choice = cli.getIntInputFromUser(0, users.size() + 1);
            if(choice == 1)
            {
                PrintUsersToWritePost(indexToUser);
                if (choice >= 1 && choice <= users.size())
                {
                    String index = indexToUser.get(choice);
                    User user = users.get(index);
                    HandleUser(user, indexToUser);
                }
                else if (choice == users.size() + 1)
                {
                    AddUser();
                }
                else if (choice == 0)
                {
                    cli.print("Exiting Program...");
                    break;
                }
            }
        }
    }
}