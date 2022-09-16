package Logic;

import Data.User;
import UI.CommandLineInterface;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    private Map<String, User> users = new HashMap<>();
    private CommandLineInterface cli = new CommandLineInterface();

    public void PrintUsers(Map<Integer, String> indexToUser) {
        for (Map.Entry<Integer, String> userEntry : indexToUser.entrySet()) {
            Integer index = userEntry.getKey();
            String username = userEntry.getValue();
            cli.print(index + ". " + username);
        }
    }

    private void PrintMenu(Map<Integer, String> indexToUser) {
        cli.print("Choose your user:");
        PrintUsers(indexToUser);
        cli.print(users.size() + 1 + " - Add New User");
        cli.print("0 - EXIT");
    }

    private void AddUser() {
        cli.print("What user do you like to add ? ");
        String username = cli.getInputFromUser();
        if (!users.containsKey(username)) {
            users.put(username, new User(username));
//            indexToUser.put(count, userName);
        } else {
            cli.print("User already exists");
        }
    }

    private void HandleUser(User user) {
        cli.print("On who's wall do you want to write?  ");
        int friend_user = cli.getIntInputFromUser();
        cli.print("What do you want to write? ");
        String text = cli.getInputFromUser();
        users.get(friend_user).addPost(text);
        //Print all posts
    }

    private Map<Integer, String> GetIndices() {
        Map<Integer, String> result = new HashMap<>();
        int count = 1;
        for (Map.Entry<String, User> userEntry : users.entrySet()) {
            result.put(count++, userEntry.getKey());
        }
        return result;
    }

    public void Run() {
        users.put("Shahar", new User("Shahar"));
        users.put("Shay", new User("Shay"));

        cli.print("Hello and Welcome to Shahar's App !");
        int choice;
        while (true) {
            Map<Integer, String> indexToUser = GetIndices();

            PrintMenu(indexToUser);
            choice = cli.getIntInputFromUser();
            if (choice >= 1 && choice <= users.size()) {
                String index = indexToUser.get(choice);
                User user = users.get(index);
                HandleUser(user);
            } else if (choice == users.size() + 1) {
                AddUser();
            } else if (choice == 0) {
                cli.print("Exiting Program...");
                break;
            }
        }
    }
}