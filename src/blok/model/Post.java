package blok.model;

import java.util.Arrays;
import java.util.Date;

public class Post {
    private String title;
    private String text;
    private String category;
    private Date date;
    private User[] user;

    public Post() {
    }

    public Post(String title, String text, String category, Date date, User[] user) {
        this.title = title;
        this.text = text;
        this.category = category;
        this.date = date;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User[] getUser() {
        return user;
    }

    public void setUser(User[] user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", category='" + category + '\'' +
                ", date=" + date +
                ", user=" + Arrays.toString(user) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (title != null ? !title.equals(post.title) : post.title != null) return false;
        if (text != null ? !text.equals(post.text) : post.text != null) return false;
        if (category != null ? !category.equals(post.category) : post.category != null) return false;
        if (date != null ? !date.equals(post.date) : post.date != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(user, post.user);
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(user);
        return result;
    }
}

