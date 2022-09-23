package Data;

import Data.Post;

import java.util.ArrayList;
import java.util.List;

public class User
{
    private String username;
    private String password;
    private List<Post> posts = new ArrayList<>();

    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public List<Post> getPosts()
    {
        return posts;
    }

    public void setPosts(List<Post> posts)
    {
        this.posts = posts;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void addPost(String text)
    {
        posts.add(new Post(text));
    }
}



