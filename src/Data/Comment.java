package Data;

import java.util.Scanner;

public class Comment
{
    private String user_id;
    private String username;
    private String content;

    public Comment(String user_id, String username, String content)
    {
        super();
        this.user_id = user_id;
        this.username = username;
        this.content = content;
    }

    public String getUser_id()
    {
        return user_id;
    }

    public String getUsername()
    {
        return username;
    }

    public String getContent()
    {
        return content;
    }

    public void setUser_id(String user_id)
    {
        this.user_id = user_id;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

}
