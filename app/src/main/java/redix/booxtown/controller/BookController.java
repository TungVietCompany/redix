package redix.booxtown.controller;

import android.os.StrictMode;

import java.util.Hashtable;
import java.util.List;

import redix.booxtown.api.ServiceGenerator;
import redix.booxtown.api.ServiceInterface;
import redix.booxtown.model.Book;
import redix.booxtown.model.BookResult;
import redix.booxtown.model.Result;
import retrofit2.Call;

/**
 * Created by thuyetpham94 on 11/09/2016.
 */
public class BookController {
    private ServiceInterface service;
    Boolean success;
    public BookController(){
        service = ServiceGenerator.GetInstance();
    }
    public boolean addbook(Book book, String session_id){
        Hashtable obj = ObjectCommon.ObjectDymanic(book);
        obj.put("session_id",session_id);
        Call<Result> status = service.addbook(obj);
        try {
            if (android.os.Build.VERSION.SDK_INT > 9) {
                StrictMode.ThreadPolicy policy =
                        new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
            Result str = status.execute().body();
            if (str.getCode() == 200){
                return true;
            }
            String s = "";
        } catch (Exception ex) {
            String s = "";
        }
        return false;
    }

    public List<Book> getAllBookById(String session_id){
        Call<BookResult> profile = service.getAllBookByUser(session_id);
        try {
            if (android.os.Build.VERSION.SDK_INT > 9) {
                StrictMode.ThreadPolicy policy =
                        new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
            BookResult str = profile.execute().body();
            if (str.getCode() == 200){
                return str.getBook();
            }
        } catch (Exception ex) {
        }
        return null;
    }

    public Boolean updatebook(Book book,String session_id){
        Hashtable table = ObjectCommon.ObjectDymanic(book);
        table.put("session_id",session_id);
        Call<Result> imagebook = service.update(table);
        try {
            if (android.os.Build.VERSION.SDK_INT > 9) {
                StrictMode.ThreadPolicy policy =
                        new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
            Result str = imagebook.execute().body();
            if (str.getCode() == 200){
                return true;
            }
        } catch (Exception ex) {
        }
        return false;
    }

    public Boolean deletebook(String book_id){
        Hashtable hashtable  = ObjectCommon.ObjectDymanic(book_id);
        hashtable.put("book_id",book_id);
        Call<Result> delte = service.deletebook(hashtable);
        try {
            if (android.os.Build.VERSION.SDK_INT > 9) {
                StrictMode.ThreadPolicy policy =
                        new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
            Result str = delte.execute().body();
            if (str.getCode() == 200){
                success = true;
            }
        } catch (Exception ex) {
            success = false;
        }
        return success;
    }

    public List<Book> getallbook(){
        Call<BookResult> getall = service.getAllBook();
        try {
            if (android.os.Build.VERSION.SDK_INT > 9) {
                StrictMode.ThreadPolicy policy =
                        new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
            BookResult str = getall.execute().body();
            if (str.getCode() == 200){
                return str.getBook();
            }
        } catch (Exception ex) {
        }
        return null;

    }

}
