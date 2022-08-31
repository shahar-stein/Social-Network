package Data;

import Data.Post;

import java.util.ArrayList;
import java.util.List;

public class User
{
    private String username;
    private List<Post> posts = new ArrayList<>();

    public User(String username)
    {
        this.username = username;
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

    public void addPost(String text)
    {
        posts.add(new Post(text));
    }
}



