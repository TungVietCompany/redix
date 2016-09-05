package redix.booxtown.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import redix.booxtown.Controller.UserController;
import redix.booxtown.R;

public class SignIn_Activity extends AppCompatActivity implements View.OnClickListener{
Button mButtonForgotPass;
    EditText edt_username,edt_pass;
    TextView mButtonBackSignIn;
    Button mButtonBack;
    Button mButtonSigin;
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
                UserController userController  = new UserController();
                boolean success = userController.checkLoginValidate(edt_username.getText().toString(),edt_pass.getText().toString(),"iphonecuatung");
                if (success ==true){
                    Intent intent = new Intent(SignIn_Activity.this,MainAllActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"Username or password error!",Toast.LENGTH_LONG).show();
                }
            default:
                break;
        }
    }
}
