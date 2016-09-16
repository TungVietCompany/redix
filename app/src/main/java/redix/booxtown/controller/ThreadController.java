package redix.booxtown.controller;

import android.os.StrictMode;

import java.util.List;

import redix.booxtown.api.ServiceGenerator;
import redix.booxtown.api.ServiceInterface;
import redix.booxtown.model.Thread;
import redix.booxtown.model.ThreadResult;
import redix.booxtown.model.Topic;
import redix.booxtown.model.TopicResult;
import retrofit2.Call;

/**
 * Created by thuyetpham94 on 16/09/2016.
 */
public class ThreadController {
    private ServiceInterface service;
    Boolean success;
    public ThreadController(){
        service = ServiceGenerator.GetInstance();
    }

    public List<Thread> getalltopic(){
        Call<ThreadResult> getAllThread = service.getAllThread();
        try {
            if (android.os.Build.VERSION.SDK_INT > 9) {
                StrictMode.ThreadPolicy policy =
                        new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
            ThreadResult str = getAllThread.execute().body();
            if (str.getCode()==200){
                return str.getListThread();
            }
        } catch (Exception ex) {
        }
        return null;
    }
}
