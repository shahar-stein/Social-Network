import java.util.ArrayList;
import java.util.List;

public class Post
{
    private String text;
    private List<Comment> comments;
    public Post(String text, Comment comments)
    {
        this.text = text;
        this.comments = new ArrayList<Comment>();
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public List<Comment> getComments()
    {
        return comments;
    }

    public void setComments(List<Comment> comments)
    {
        this.comments = comments;
    }

//        public Post NewPost()
//    {
//        String text = "";
//        List<comment> comments = new ArrayList<Comment>();
//        for(int i = 0; i<2; i++)
//        {
//            NewComment(comments);
//        }
//        return new Post(content, comments);
//    }
}
