package redix.booxtown.controller;

import android.os.StrictMode;

import java.util.List;

import redix.booxtown.api.ServiceGenerator;
import redix.booxtown.api.ServiceInterface;
import redix.booxtown.model.Topic;
import redix.booxtown.model.TopicResult;
import retrofit2.Call;

/**
 * Created by thuyetpham94 on 16/09/2016.
 */
public class TopicController {
    private ServiceInterface service;
    Boolean success;
    public TopicController(){
        service = ServiceGenerator.GetInstance();
    }

    public List<Topic> getalltopic(){
        Call<TopicResult> getall = service.topic_getall();
        try {
            if (android.os.Build.VERSION.SDK_INT > 9) {
                StrictMode.ThreadPolicy policy =
                        new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
            TopicResult str = getall.execute().body();
            if (str.getCode()==200){
                return str.getTopic();
            }
        } catch (Exception ex) {
        }
        return null;
    }
}
