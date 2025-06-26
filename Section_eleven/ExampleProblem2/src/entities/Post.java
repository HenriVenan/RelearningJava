package entities;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Post {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private LocalDateTime moment;
    private String title;
    private String content;
    private int likes;
    private final ArrayList<Comment> comments = new ArrayList<>();

    public Post(LocalDateTime moment, String title, String content, int likes) {
        this.moment = moment;
        this.title = title;
        this.content = content;
        this.likes = likes;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n").append(title).append("\n");
        sb.append(likes)
            .append(" Likes - ");
        sb.append(formatter.format(moment)).append("\n");
        sb.append(content).append("\n");
        sb.append("Comments: \n");
        for (Comment comment : comments) {
            sb.append(comment.getComment())
                    .append("\n");
        }

        return sb.toString();
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment text) {
        comments.add(text);
    }

    public void removeComment(Comment text) {
        comments.remove(text);
    }
}
