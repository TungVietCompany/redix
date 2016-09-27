package redix.booxtown.controller;

import android.os.StrictMode;

import java.util.Hashtable;
import java.util.List;

import redix.booxtown.api.ServiceGenerator;
import redix.booxtown.api.ServiceInterface;
import redix.booxtown.model.Result;
import redix.booxtown.model.User;
import redix.booxtown.model.UserResult;
import retrofit2.Call;

/**
 * Created by duong on 9/5/2016.
 */
public class UserController {
    private ServiceInterface service;
    public UserController(){
        service = ServiceGenerator.GetInstance();
    }

    public String checkLoginValidate(String username, String password, String device_type,String session_id){
        try {
            Hashtable obj = new Hashtable();
            obj.put("username", username);
            obj.put("password", password);
            obj.put("device_type", device_type);
            obj.put("session_id", session_id);
            Call<Result> callService = service.login(obj);
            try {
                if (android.os.Build.VERSION.SDK_INT > 9) {
                    StrictMode.ThreadPolicy policy =
                            new StrictMode.ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                }
                Result result = callService.execute().body();
                if (result.getCode() == 200) {
                    return result.getSession_id();
                }
            } catch (Exception ex) {
                String ss = ex.toString();
            }
            return null;
        }catch (Exception exx){

            return null;
        }
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
        Hashtable obj = new Hashtable();
        obj.put("email",email);
        Call<Result> status = service.forgotpassword(obj);
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
        Hashtable obj = new Hashtable();
        obj.put("session_id",session_id);
        Call<Result> response = service.logout(obj);
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

    public List<User> getprofile(String session_id){
        Call<UserResult> profile = service.getprofile(session_id);
        try {
            if (android.os.Build.VERSION.SDK_INT > 9) {
                StrictMode.ThreadPolicy policy =
                        new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
            UserResult str = profile.execute().body();
            if (str.getCode() == 200){
                return str.getUser();
            }
        } catch (Exception ex) {
        }
        return null;
    }

    public String getUserID(String session_id){
        Call<Result> profile = service.getuserID(session_id);
        try {
            if (android.os.Build.VERSION.SDK_INT > 9) {
                StrictMode.ThreadPolicy policy =
                        new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
            Result str = profile.execute().body();
            if (str.getCode() == 200){
                return str.getSession_id();
            }
        } catch (Exception ex) {
        }
        return null;
    }

    public boolean changePassword(String session_id,String pwd_old,String pwd_new){
        Call<Result> profile = service.changepassword(session_id,pwd_old,pwd_new);
        try {
            if (android.os.Build.VERSION.SDK_INT > 9) {
                StrictMode.ThreadPolicy policy =
                        new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
            Result str = profile.execute().body();
            if (str.getCode() == 200){
                return true;
            }
        } catch (Exception ex) {
        }
        return false;
    }
}
