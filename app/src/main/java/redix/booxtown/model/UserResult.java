package redix.booxtown.model;

import java.util.List;

/**
 * Created by vietp on 04/09/2016.
 */
public class UserResult {
    private int code;
    private List<Book> book;

    public UserResult(int code, List<Book> book) {
        this.code = code;
        this.book = book;
    }

    public UserResult() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }
}
