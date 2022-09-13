package Logic;

import Data.User;
import UI.CommandLineInterface;

import java.util.HashMap;
import java.util.Map;

public class Menu
{
    private Map<String, User> users = new HashMap<>();
    private CommandLineInterface cli = new CommandLineInterface();
    private Map<Integer, String> indexToUser = new HashMap<>(); // Map<int, String> ?

    public void Run()
    {
        cli.print("Hello and Welcome to Shahar's App !");
        int choice = -1, count = 1;
        do
        {
            cli.print("Choose your user:");
            for (Map.Entry<String, User> userEntry: users.entrySet())
            {
                String userName = userEntry.getKey();
                User userData = userEntry.getValue();
                cli.print(count + ". " + userName);
                indexToUser.put(count, userName);
                count++;
            }

            cli.print(users.size() + 1 + " - Add New User");
            cli.print("0 - EXIT");
            choice = cli.getIntInputFromUser();

            switch (choice)
            {
                case 0:
                    cli.print("Exiting Program...");
                    System.exit(0);
                    break;

                case users.size() + 1:
                    cli.print("What user do you like to add ? ");
                    String username = cli.getInputFromUser();
                    if(!users.containsKey(username))
                    {
                        users.put(username, new User(username));
                    }
                    else
                    {
                        cli.print("User already exists");
                    }

                default:
                    cli.print("On who's wall do you want to write?  ");
                    int friend_user = cli.getIntInputFromUser();
                    cli.print("What do you want to write? ");
                    String text = cli.getInputFromUser();
                    users.get(friend_user).addPost(text);
                    //Print all posts
            }
        }
        while(choice != users.size() + 1);
    }
}