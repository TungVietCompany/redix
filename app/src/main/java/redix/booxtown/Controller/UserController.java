package redix.booxtown.Controller;

import android.content.SharedPreferences;
import android.os.StrictMode;
import android.widget.Toast;

import redix.booxtown.API.ServiceGenerator;
import redix.booxtown.API.ServiceInterface;
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

    public boolean checkLoginValidate(String username,String password,String device_type){
                Call<Result> callService = service.login(username,password,device_type);
                try{
                    if (android.os.Build.VERSION.SDK_INT > 9) {
                        StrictMode.ThreadPolicy policy =
                                new StrictMode.ThreadPolicy.Builder().permitAll().build();
                        StrictMode.setThreadPolicy(policy);
                    }
                    Result result = callService.execute().body();
                    if (result.getCode() == 200){
//                        SharedPreferences.Editor editor = getSharedPreferences("SessionId", MODE_PRIVATE).edit();
//                        editor.putInt("idName", 12);
//                        editor.commit();
                        return true;
                    }
                }
                catch (Exception ex){

                }
        return false;
    }


    public boolean signUp(User user){
        boolean success = false;
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
}
