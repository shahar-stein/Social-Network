import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        int ok = 1;
        System.out.println("Hello and Welcome to Shahar's App !");
        while (ok == 1){
            Scanner myObj = new Scanner(System.in);
            System.out.println("What's your name? ");
            String username = myObj.nextLine();
            System.out.println("On who's wall do you want to write?  ");
            String friend_user = myObj.nextLine();
            System.out.println("What do you want to write? ");
            String text = myObj.nextLine();
            System.out.println("Do you want to exit? 1 - No, 2 - Yes ");
            ok = myObj.nextInt();
        }
    }
}