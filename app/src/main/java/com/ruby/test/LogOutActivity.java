package com.ruby.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class LogOutActivity extends AppCompatActivity {

    FirebaseAuth fauth;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_out);

        fauth = FirebaseAuth.getInstance();
        logout = (Button) findViewById(R.id.btn_sign_out);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Logout();
            }
        });
    }

    private  void Logout(){

        String result = getIntent().getStringExtra("Result");
        Toast.makeText(getApplicationContext(), result+" is Winner ", Toast.LENGTH_SHORT).show();
        fauth.signOut();
        finish();
        startActivity(new Intent(LogOutActivity.this, MainActivity.class));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.btn_sign_out:
                {
                    Logout();
                    break;
                }
        }
        return true;
    }
}
