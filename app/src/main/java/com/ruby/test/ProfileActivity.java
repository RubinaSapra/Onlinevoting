package com.ruby.test;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity {

    Button button;
    RadioButton genderadioButton;
    RadioGroup radioGroup;
    ProgressBar progressBar;
    public static int cpp,r,java,js,py;

       String result="";
    public String choice="";
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        addListenerOnButton();
    }

    public void addListenerOnButton() {
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                int selectedId = radioGroup.getCheckedRadioButtonId();
                genderadioButton = (RadioButton) findViewById(selectedId);

                if (selectedId == -1) {
                    Toast.makeText(ProfileActivity.this, "Nothing selected! Select an option", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ProfileActivity.this, ProfileActivity.class));

                } else {
                    choice = genderadioButton.getText().toString();
                    if(choice.equals("Java"))
                        java++;
                    else if(choice.equals("C++"))
                        cpp++;
                     else  if(choice.equals("Python"))
                        py++;
                    else if(choice.equals("Javascript"))
                        js++;
                    else
                        r++;
                   if(java>cpp && java>py && java>js && java>r)
                       result="Java";
                   else if(cpp>py && cpp>js && cpp>r)
                       result = "Cpp";
                   else if(py>js && py>r)
                       result = "Python";
                   else if(js>r)
                       result = "Javascript";
                   else
                       result = "Ruby";
                    Toast.makeText(ProfileActivity.this, choice+" is voted successfully!!!! ", Toast.LENGTH_SHORT).show();
                    Intent intent = (new Intent(ProfileActivity.this, LogOutActivity.class));
                    intent.putExtra("Result",result);
                    startActivity(intent);

                }
            }
        });
    }

    }









