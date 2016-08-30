package redix.booxtown.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import redix.booxtown.R;

public class SignIn_Activity extends AppCompatActivity implements View.OnClickListener{
Button mButtonForgotPass;
    Button mButtonBackSignIn;
    Button mButtonBack;
    Button mButtonSigin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        mButtonForgotPass = (Button) findViewById(R.id.btn_forgotpass);
        mButtonBack = (Button) findViewById(R.id.btn_back_sigin);
        mButtonBackSignIn = (Button) findViewById(R.id.btn_sigin);
        mButtonBack.setOnClickListener(this);
        mButtonBackSignIn.setOnClickListener(this);
        //mButtonForgotPass.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_forgotpass:
                Intent itent = new Intent(SignIn_Activity.this,ForgotPassword_Activity.class);
                startActivity(itent);
                break;
            case R.id.btn_back_sigin:
                Intent itentback = new Intent(SignIn_Activity.this,WelcomeActivity.class);
                startActivity(itentback);
                break;
            case R.id.btn_sigin:
                Intent itentsign = new Intent(SignIn_Activity.this,ListingCollectionActivity.class);
                startActivity(itentsign);
            default:
                break;
        }
    }
}
