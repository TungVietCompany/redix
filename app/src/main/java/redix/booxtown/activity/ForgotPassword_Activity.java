package redix.booxtown.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import redix.booxtown.Controller.UserController;
import redix.booxtown.R;

public class ForgotPassword_Activity extends AppCompatActivity implements View.OnClickListener{
Button mButtonBackForgot;
    TextView mButtonSubmit;
    EditText edt_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        edt_email = (EditText) findViewById(R.id.email_forgot);
        mButtonBackForgot = (Button) findViewById(R.id.btn_back_forgot);
        mButtonSubmit = (TextView)  findViewById(R.id.submit_forgot);
        mButtonSubmit.setOnClickListener(this);
        mButtonBackForgot.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_back_forgot:
                onBackPressed();
                break;
            case R.id.submit_forgot:
                UserController userController = new UserController();
                boolean success = userController.forgetPassword(edt_email.getText().toString());
                if (success == true){
                    Toast.makeText(getApplicationContext(), "Check Email Please", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Email Eror", Toast.LENGTH_LONG).show();
                }
                break;

            default:
                break;
        }
    }
}
