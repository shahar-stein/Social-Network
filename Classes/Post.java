public class Post
{
    private String content;
    private Comment[] comments;
    public Post(String content, Comment[] comments)
    {
        this.content = content;
        this.comments = comments;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public Comment[] getComments()
    {
        return comments;
    }

    public void setComments(Comment[] comments)
    {
        this.comments = comments;
    }

//    public Post NewPost()
//    {
//        String content = "";
//        Comment[] comments = new Comment[];
//        for(int i = 0; i<2; i++)
//        {
//            content = this.content;
//            NewComment(comments);
//        }
//        return new Post(content, comments);
//    }
}
