package com.ruby.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Show extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        findViewById(R.id.Go).setOnClickListener(this);
    }


    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.Go:
                startActivity(new Intent(this, ProfileActivity.class));
                break;
        }
    }
}