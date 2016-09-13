package redix.booxtown.model;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by vietp on 04/09/2016.
 */
public class Book implements Serializable{
    @Expose
    private String title;
    @Expose
    private String author;
    @Expose
    private String photo;
    @Expose
    private String hash_tag;
    @Expose
    private float location_longitude;
    @Expose
    private float location_latitude;
    @Expose
    private String genre;
    @Expose
    private String b_condition;
    @Expose
    private String b_action;
    @Expose
    private float price;
    @Expose
    private String id;

    public Book(String id,String title, String author, String photo, String hash_tag, float location_longitude, float location_latitude, String genre, String b_condition, String b_action,
                float price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.photo = photo;
        this.hash_tag = hash_tag;
        this.location_longitude = location_longitude;
        this.location_latitude = location_latitude;
        this.genre = genre;
        this.b_condition = b_condition;
        this.b_action = b_action;
        this.price = price;
    }

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getHash_tag() {
        return hash_tag;
    }

    public void setHash_tag(String hash_tag) {
        this.hash_tag = hash_tag;
    }

    public float getLocation_longitude() {
        return location_longitude;
    }

    public void setLocation_longitude(float location_longitude) {
        this.location_longitude = location_longitude;
    }

    public float getLocation_latitude() {
        return location_latitude;
    }

    public void setLocation_latitude(float location_latidude) {
        this.location_latitude = location_latidude;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCondition() {
        return b_condition;
    }

    public void setCondition(String condition) {
        this.b_condition = condition;
    }

    public String getAction() {
        return b_action;
    }

    public void setAction(String action) {
        this.b_action = action;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", photo='" + photo + '\'' +
                ", hash_tag='" + hash_tag + '\'' +
                ", location_longitude=" + location_longitude +
                ", location_latitude=" + location_latitude +
                ", genre='" + genre + '\'' +
                ", b_condition='" + b_condition + '\'' +
                ", b_action='" + b_action + '\'' +
                ", price='" + price + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
