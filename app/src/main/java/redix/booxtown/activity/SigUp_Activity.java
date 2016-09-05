package redix.booxtown.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import redix.booxtown.Controller.UserController;
import redix.booxtown.R;
import redix.booxtown.model.User;

public class SigUp_Activity extends AppCompatActivity implements View.OnClickListener{
Button mButtonBackSigup;
    EditText edt_name,edt_firtname,edt_phone,edt_mail,edt_password,edt_confirmpass,edt_lastname;
    CheckBox checkSignup;
    EditText edt_birthday;
    String birthday;
    TextView signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mButtonBackSigup = (Button) findViewById(R.id.btn_back_sigup);
        signUp = (TextView) findViewById(R.id.signup);
        signUp.setOnClickListener(this);
        mButtonBackSigup.setOnClickListener(this);
        edt_firtname = (EditText) findViewById(R.id.firstname);
        edt_lastname = (EditText) findViewById(R.id.lastname);
        edt_name = (EditText) findViewById(R.id.username);
        edt_mail = (EditText) findViewById(R.id.email);
        edt_phone = (EditText) findViewById(R.id.phone);
        edt_birthday = (EditText) findViewById(R.id.birthday);
        edt_password = (EditText) findViewById(R.id.password);
        edt_confirmpass = (EditText) findViewById(R.id.confirmpassword);
        checkSignup = (CheckBox) findViewById(R.id.checksignup);
//        birthday = String.valueOf(edt_birthday.getYear()) + String.valueOf(edt_birthday.getMonth()) + String.valueOf(edt_birthday.getDayOfMonth());


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signup:
                UserController userController = new UserController();
                User user  = new User();
                user.setBirthday(birthday);
                user.setEmail(edt_mail.getText().toString());
                user.setFirst_name(edt_firtname.getText().toString());
                user.setLast_name(edt_lastname.getText().toString());
                user.setPhone(edt_phone.getText().toString());
                user.setUsername(edt_name.getText().toString());
                user.setPassword(edt_password.getText().toString());
                if (edt_name.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"User name null",Toast.LENGTH_LONG).show();
                }else if(edt_lastname.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Last name null",Toast.LENGTH_LONG).show();
                }else if(edt_firtname.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"First name null",Toast.LENGTH_LONG).show();
                }else if(edt_phone.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Phone null",Toast.LENGTH_LONG).show();
                }else if(edt_birthday.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Birthday null",Toast.LENGTH_LONG).show();
                }else if(edt_mail.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Email null",Toast.LENGTH_LONG).show();
                }else if(edt_password.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Password null",Toast.LENGTH_LONG).show();
                }else if(!edt_password.getText().toString().equals(edt_confirmpass.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Enter Password",Toast.LENGTH_LONG).show();
                }else if (checkSignup.isChecked() == false) {
                    Toast.makeText(getApplicationContext(), "unCheck", Toast.LENGTH_LONG).show();

                }else {
                    boolean success = userController.signUp(user);
                    if (success == true){
                        Intent intent = new Intent(SigUp_Activity.this,MainAllActivity.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                    }
                }

                break;
            case R.id.btn_back_sigup:
                Intent intent = new Intent(SigUp_Activity.this,WelcomeActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
