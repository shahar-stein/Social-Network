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
        int choice;
        do
        {
            int i = 0;
            cli.print("Hello and Welcome to Shahar's App !");
            cli.print("Choose user:");
            cli.print(i + " - " + "Add New User");
            for (i = 1; i <= users.size(); i++) {
                String username = users.toString();
                cli.print(i + " - " + username);
            }
            cli.print(i++ + " - Exit");
            choice = cli.getIntInputFromUser();

            switch (choice)
            {
                case 0:
                    cli.print("What user do you like to add ? ");
                    String username = cli.getInputFromUser();
                    if(!users.containsKey(username)) {
                        users.put(username, new User(username));
                    }
                    else {
                        cli.print("User already exists");
                    }
                case choice == users.size() + 1:
                    cli.print("Exiting Program...");
                    System.exit(0);
                    break;
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

