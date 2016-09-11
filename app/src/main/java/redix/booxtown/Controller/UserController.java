package redix.booxtown.controller;

import android.os.StrictMode;

import redix.booxtown.api.ServiceGenerator;
import redix.booxtown.api.ServiceInterface;
import redix.booxtown.model.Book;
import redix.booxtown.model.Result;
import redix.booxtown.model.User;
import retrofit2.Call;

/**
 * Created by duong on 9/5/2016.
 */
public class UserController {
    private ServiceInterface service;
    public UserController(){
        service = ServiceGenerator.GetInstance();
    }

    public String checkLoginValidate(String username, String password, String device_type){
                Call<Result> callService = service.login(username,password,device_type);
                try{
                    if (android.os.Build.VERSION.SDK_INT > 9) {
                        StrictMode.ThreadPolicy policy =
                                new StrictMode.ThreadPolicy.Builder().permitAll().build();
                        StrictMode.setThreadPolicy(policy);
                    }
                    Result result = callService.execute().body();
                    if (result.getCode() == 200){
                        return result.getSession_id();
                    }
                }
                catch (Exception ex){

                }
        return null;
    }


    public boolean signUp(User user){
        Call<Result> callService = service.addUser(user);
        try{
            if (android.os.Build.VERSION.SDK_INT > 9) {
                StrictMode.ThreadPolicy policy =
                        new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
            Result result = callService.execute().body();
            if (result.getCode()==200){
                return true;
            }
        }
        catch (Exception ex){

        }
        return false;
    }


    public boolean forgetPassword(String email) {
        Call<Result> status = service.forgotpassword(email);
        try {
            if (android.os.Build.VERSION.SDK_INT > 9) {
                StrictMode.ThreadPolicy policy =
                        new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
            Result str = status.execute().body();
            if (str.getCode() == 200) {
                return true;
            }
        } catch (Exception ex) {

        }
        return false;
    }


    public boolean logout(String session_id){
        Call<Result> response = service.logout(session_id);
        try {
            if (android.os.Build.VERSION.SDK_INT > 9) {
                StrictMode.ThreadPolicy policy =
                        new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
            Result rs = response.execute().body();
            if (rs.getCode() == 200){
                return true;
            }
        }catch (Exception e){
        }

        return false;
    }

    public boolean addbook(Book book,String session_id){
        Call<Result> status = service.addbook(book,session_id);
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

}
