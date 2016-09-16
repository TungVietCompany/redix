package redix.booxtown.model;

import java.io.Serializable;

/**
 * Created by duong on 9/16/2016.
 */
public class Topic implements Serializable {
            public String id;
            public String title;
            public String description;
            public String create_date;
            public int is_expire;
            public String user_id;

    public Topic() {
    }

    public Topic(String id, String title, String description, String create_date, int is_expire, String user_id) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.create_date = create_date;
        this.is_expire = is_expire;
        this.user_id = user_id;
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

    public int getIs_expire() {
        return is_expire;
    }

    public void setIs_expire(int is_expire) {
        this.is_expire = is_expire;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
