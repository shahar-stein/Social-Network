package Logic;

import Data.User;
import UI.CommandLineInterface;

import java.util.HashMap;
import java.util.Map;

public class Menu
{
    private Map<String, User> users = new HashMap<>();
    private CommandLineInterface cli = new CommandLineInterface();

    public void Run()
    {
        cli.print("Hello and Welcome to Shahar's App !");
        int choice;
        do
        {
            cli.print("Choose user:");
            for (Map.Entry<String, User> userEntry: users.entrySet())
            {
                String userName = userEntry.getKey();
                User userData = userEntry.getValue();
                //cli.print(userName);
            }
            cli.print(users.size() + " - Add New User");
            choice = cli.getIntInputFromUser();
            cli.print("0 - EXIT");
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
                    String friend_user = cli.getInputFromUser();
                    cli.print("What do you want to write? ");
                    String text = cli.getInputFromUser();
                    users.get(friend_user).addPost(text);
                    //Print all posts
            }
        }
        while(choice != users.size() + 1);
    }

}

