package redix.booxtown.controller;

import android.app.Activity;
import android.os.StrictMode;

import java.util.Hashtable;
import java.util.List;

import redix.booxtown.api.ServiceGenerator;
import redix.booxtown.api.ServiceInterface;
import redix.booxtown.model.Book;
import redix.booxtown.model.Notification;
import redix.booxtown.model.Result;
import retrofit2.Call;

/**
 * Created by Administrator on 26/09/2016.
 */
public class NotificationController {
    private ServiceInterface service;
    Boolean success;
    Activity mActivity;
    public NotificationController(){
        service = ServiceGenerator.GetInstance();
    }

    public NotificationController(Activity mActivity) {
        this.mActivity = mActivity;
    }

    public boolean sendNotification(List<Notification> notifications){
        Hashtable obj = new Hashtable();
        obj.put("notification_list",notifications);
        try {
            Call<Result> status = service.sendNotification(obj);
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
            String s = ex.getMessage();
        }
        return false;
    }
}
