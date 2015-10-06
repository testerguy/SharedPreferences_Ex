package com.example.root.sharedpreferences_ex;

import android.content.SharedPreferences;
import android.content.Context;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    TextView showText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        showText = (TextView) findViewById(R.id.showText);
    }

    public void saveInfoClicked(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String usernameStr = username.getText().toString();
        String passwordStr = password.getText().toString();

        editor.putString("username", usernameStr);
        editor.putString("password", passwordStr);

        editor.apply();

        username.setText("");
        password.setText("");

        Toast.makeText(this, "info saved!", Toast.LENGTH_LONG).show();
    }

    public void showInfoClicked(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);

        String usernameStr = sharedPreferences.getString("username", "");
        String passwordStr = sharedPreferences.getString("password", "");

        showText.setText(usernameStr + " " + passwordStr);
    }

}
