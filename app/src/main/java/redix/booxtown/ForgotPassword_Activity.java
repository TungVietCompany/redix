package redix.booxtown;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ForgotPassword_Activity extends AppCompatActivity implements View.OnClickListener{
Button mButtonBackForgot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
mButtonBackForgot = (Button) findViewById(R.id.btn_back_forgot);
        mButtonBackForgot.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_back_forgot:
                Intent intent = new Intent(ForgotPassword_Activity.this,SignIn_Activity.class);
                startActivity(intent);
                break;
        }
    }
}
