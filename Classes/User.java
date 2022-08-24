public class User
{
    private String username;
    private String user_id;
    private Post[] posts;

    public User(String username, String user_id, Post[] posts)
    {
        this.username = username;
        this.user_id = user_id;
        this.posts = posts;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getUser_id()
    {
        return user_id;
    }

    public void setUser_id(String user_id)
    {
        this.user_id = user_id;
    }

    public Post[] getPosts()
    {
        return posts;
    }

    public void setPosts(Post[] posts)
    {
        this.posts = posts;
    }
}



