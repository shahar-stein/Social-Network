package UI;

import java.util.Scanner;

public class CommandLineInterface
{
    private Scanner myObj = new Scanner(System.in);
    public void print(String text)
    {
        System.out.println(text);
    }

    public String getInputFromUser()
    {
        return myObj.nextLine();
    }
}
