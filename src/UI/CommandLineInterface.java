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
        String response = myObj.next();
        return response;
    }
    public int getIntInputFromUser(int min, int max)
    {
        int response = myObj.nextInt();
        while (response < min || response > max)
        {
            response = myObj.nextInt();
        }
        return response;
    }
}
