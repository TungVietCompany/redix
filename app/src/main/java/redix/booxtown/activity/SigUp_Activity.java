package redix.booxtown.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import redix.booxtown.R;

public class SigUp_Activity extends AppCompatActivity implements View.OnClickListener{
Button mButtonBackSigup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mButtonBackSigup = (Button) findViewById(R.id.btn_back_sigup);
        mButtonBackSigup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_back_sigup:
                Intent intent = new Intent(SigUp_Activity.this,WelcomeActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
