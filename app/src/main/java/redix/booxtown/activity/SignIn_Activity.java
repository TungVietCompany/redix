package redix.booxtown.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import redix.booxtown.Controller.UserController;
import redix.booxtown.R;
import redix.booxtown.model.Result;

public class SignIn_Activity extends AppCompatActivity implements View.OnClickListener{
Button mButtonForgotPass;
    EditText edt_username,edt_pass;
    TextView mButtonBackSignIn;
    Button mButtonBack;
    Button mButtonSigin;
    Result result;
    String session_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        edt_pass  = (EditText) findViewById(R.id.password_login);
        edt_username = (EditText) findViewById(R.id.username_login);
        mButtonForgotPass = (Button) findViewById(R.id.btn_forgotpass);
        mButtonBack = (Button) findViewById(R.id.btn_back_sigin);
        mButtonBackSignIn = (TextView) findViewById(R.id.btn_sigin);
        mButtonBack.setOnClickListener(this);
        mButtonBackSignIn.setOnClickListener(this);
        mButtonForgotPass.setOnClickListener(this);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor  = pref.edit();
        session_id = pref.getString("session_id", null);
        if (session_id != null){
            Intent intent = new Intent(SignIn_Activity.this, MainAllActivity.class);
            startActivity(intent);
        }
        if (isOnline() == false){
            Toast.makeText(getApplicationContext(),"Check network state please",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_forgotpass:
                Intent itent = new Intent(SignIn_Activity.this,ForgotPassword_Activity.class);
                startActivity(itent);
                break;
            case R.id.btn_back_sigin:
                onBackPressed();
                break;
            case R.id.btn_sigin:
                if (edt_username.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Enter username please",Toast.LENGTH_LONG).show();
                }else  if (edt_pass.getText().toString().equals("")){
                Toast.makeText(getApplicationContext(),"Enter password please",Toast.LENGTH_LONG).show();
                }else {
                    SiginAsystask siginAsystask = new SiginAsystask();
                    siginAsystask.execute(edt_username.getText().toString(), edt_pass.getText().toString(), "iphonecuatung");
                }
            default:
                break;
        }
    }


    class SiginAsystask extends AsyncTask<String,Void,String>{

        ProgressDialog dialog;

        @Override
        protected String doInBackground(String... params) {
            UserController userController  = new UserController();
            String session_id = userController.checkLoginValidate(params[0],params[1],params[2]);
            return session_id;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(SignIn_Activity.this);
            dialog.setMessage("Please wait...");
            dialog.setIndeterminate(true);
            dialog.show();
        }

        @Override
        protected void onPostExecute(String aBoolean) {
            if (aBoolean != null) {
                Intent intent = new Intent(SignIn_Activity.this, MainAllActivity.class);
                startActivity(intent);
                dialog.dismiss();
                String session_id = aBoolean.toString();
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("session_id", session_id);
                editor.putString("username",edt_username.getText().toString());
                editor.commit();
            }else{
                Toast.makeText(getApplicationContext(),"Username or password error!",Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
            super.onPostExecute(aBoolean);
        }
    }

    public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    @Override
    public void onBackPressed() {
        Intent iten = new Intent(SignIn_Activity.this,WelcomeActivity.class);
        startActivity(iten);
        finish();
    }
}
