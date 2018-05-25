package com.example.administrator.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SignIn extends AppCompatActivity {
private TextView textViewUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        textViewUp = (TextView) findViewById(R.id.tv_sign_in);
        textViewUp.setOnClickListener(new MyClickListener());
    }

    public class MyClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.tv_sign_in:
                    Intent intent = new Intent(SignIn.this, SignUpP.class);
                    startActivity(intent);
                    break;
            }
        }
    }
}
