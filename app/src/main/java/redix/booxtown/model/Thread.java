package redix.booxtown.model;

import com.google.gson.annotations.Expose;

/**
 * Created by thuyetpham94 on 16/09/2016.
 */
public class Thread {
    @Expose
    private String id;
    @Expose
    private String title;
    @Expose
    private String description;
    @Expose
    private String create_date;
    @Expose
    private String topic_id;
    @Expose
    private String user_id;
    @Expose
    private String is_read;
    @Expose
    private String username;

    public Thread(String id, String title, String description, String create_date, String topic_id, String user_id, String is_read, String username) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.create_date = create_date;
        this.topic_id = topic_id;
        this.user_id = user_id;
        this.is_read = is_read;
        this.username = username;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getIs_read() {
        return is_read;
    }

    public void setIs_read(String is_read) {
        this.is_read = is_read;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Thread() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }
}
