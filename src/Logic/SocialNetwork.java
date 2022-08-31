package Logic;
import Data.User;
import UI.CommandLineInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SocialNetwork
{
    private Map<String, User> users = new HashMap<>();
    private CommandLineInterface cli = new CommandLineInterface();
    public void Run()
    {
        int ok = 1;
        cli.print("Hello and Welcome to Shahar's App !");
        while (ok == 1){
            cli.print("What's your name? ");
            String username = cli.getInputFromUser();
            cli.print("On who's wall do you want to write?  ");
            String friend_user = cli.getInputFromUser();
            cli.print("What do you want to write? ");
            String text = cli.getInputFromUser();
            if(!users.containsKey(friend_user)) {
                users.put(friend_user,new User(username));

            }
            users.get(friend_user).addPost(text);
            cli.print("Do you want to exit? 1 - No, 2 - Yes ");
            ok = Integer.parseInt(cli.getInputFromUser());
        }
    }
}
