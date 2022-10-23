package UI;

import java.util.Scanner;

public class CommandLineInterface
{
    private Scanner myObj;
    public void print(String text)
    {
        System.out.println(text);
    }

    public String getInputFromUser()
    {
        myObj = new Scanner(System.in);
        String response = myObj.nextLine();
        return response;
    }
    public int getIntInputFromUser(int min, int max)
    {
        myObj = new Scanner(System.in);
        int response = myObj.nextInt();
        while (response < min || response > max)
        {
            response = myObj.nextInt();
        }
        return response;
    }
}
