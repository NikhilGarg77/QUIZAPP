package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class RegisterActivity extends AppCompatActivity {
    EditText username, password, dob, country, address, email, phone;
    RadioGroup gender;
    Button register, cancel;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        dob = findViewById(R.id.dob);
        country = findViewById(R.id.country);
        address = findViewById(R.id.address);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        gender = findViewById(R.id.gender);
        register = findViewById(R.id.register);
        cancel = findViewById(R.id.cancel);

        preferences = getSharedPreferences("UserInfo", 0);

        register.setOnClickListener(new View.OnClickListener()   {

            @Override
            public void onClick(View view){
                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();
                String dobValue = dob.getText().toString();
                String countryValue = country.getText().toString();
                String addressValue = address.getText().toString();
                String emailValue = email.getText().toString();
                String phoneValue = phone.getText().toString();
                RadioButton checkedBtn = findViewById(gender.getCheckedRadioButtonId());
                String genderValue = checkedBtn.getText().toString();

                if (usernameValue.length() > 1) {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("username", usernameValue);
                    editor.putString("password", passwordValue);
                    editor.putString("dob", dobValue);
                    editor.putString("country", countryValue);
                    editor.putString("address", addressValue);
                    editor.putString("email", emailValue);
                    editor.putString("phone", phoneValue);
                    editor.putString("gender", genderValue);
                    editor.apply();

                    Toast.makeText(RegisterActivity.this, "User registered", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(RegisterActivity.this, "Enter value in the fields", Toast.LENGTH_SHORT).show();
                }
            }



        });

        cancel.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View view){
            emptyField();
            }

        });
    }




    public void emptyField() {
        username.setText("");
        password.setText("");
        dob.setText("");
        country.setText("");
        email.setText("");
        address.setText("");
        phone.setText("");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_register, menu);
        return true;
    }
}