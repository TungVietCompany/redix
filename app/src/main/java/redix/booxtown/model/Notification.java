package redix.booxtown.model;

import com.google.gson.annotations.Expose;

/**
 * Created by Administrator on 26/09/2016.
 */
public class Notification {
    @Expose
    private String id;
    @Expose
    private String content;
    @Expose
    private String title_notifi;
    @Expose
    private String key_screen;
    @Expose
    private String id_screen;
    @Expose
    private int is_read;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIs_read() {
        return is_read;
    }

    public void setIs_read(int is_read) {
        this.is_read = is_read;
    }

    public String getTitle_notifi() {
        return title_notifi;
    }

    public void setTitle_notifi(String title_notifi) {
        this.title_notifi = title_notifi;
    }

    public Notification(String id, String content, String title_notifi, String key_screen, int is_read) {
        this.id = id;
        this.content = content;
        this.title_notifi = title_notifi;
        this.key_screen = key_screen;
        this.is_read = is_read;
    }

    public Notification(String title_notifi, String key_screen,String id_screen) {
        this.id_screen=id_screen;
        this.title_notifi = title_notifi;
        this.key_screen = key_screen;
    }

    public String getKey_screen() {
        return key_screen;
    }

    public void setKey_screen(String key_screen) {
        this.key_screen = key_screen;
    }

    public Notification() {
    }

    public String getId_screen() {
        return id_screen;
    }

    public void setId_screen(String id_screen) {
        this.id_screen = id_screen;
    }
}
