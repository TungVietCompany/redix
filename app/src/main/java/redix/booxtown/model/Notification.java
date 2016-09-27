package redix.booxtown.model;

import com.google.gson.annotations.Expose;

/**
 * Created by Administrator on 26/09/2016.
 */
public class Notification {
    @Expose
    private String user_id;
    @Expose
    private String messages;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getMessage() {
        return messages;
    }

    public void setMessage(String message) {
        this.messages = message;
    }

    public Notification(String user_id, String message) {
        this.user_id = user_id;
        this.messages = message;
    }

    public Notification() {
    }
}
