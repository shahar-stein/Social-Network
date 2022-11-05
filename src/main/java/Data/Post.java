package Data;

import java.util.ArrayList;
import java.util.List;

public class Post
{
    private String text;
    private String writer;
    private List<Comment> comments;
    public Post(String text, String writer)
    {
        this.text = text;
        this.writer = writer;
        //this.comments = new ArrayList<Data.Comment>();
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public List<Comment> getComments()
    {
        return comments;
    }

    public void setComments(List<Comment> comments)
    {
        this.comments = comments;
    }

//        public Data.Post NewPost()
//    {
//        String text = "";
//        List<comment> comments = new ArrayList<Data.Comment>();
//        for(int i = 0; i<2; i++)
//        {
//            NewComment(comments);
//        }
//        return new Data.Post(content, comments);
//    }
}
