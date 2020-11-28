package com.marioprieto.biopassword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SavePassword extends AppCompatActivity {

    EditText identifyer, username, password;
    Button savePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_password);

        identifyer = (EditText) findViewById(R.id.identifyerET);
        username = (EditText) findViewById(R.id.usernameET);
        password = (EditText) findViewById(R.id.passwordET);
        savePassword = (Button) findViewById(R.id.savePassword);
        savePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(identifyer.getText().toString().isEmpty() || username.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), getString(R.string.errorSavePassword), Toast.LENGTH_SHORT).show();
                } else {
                    SQLiteController sqLiteController = new SQLiteController(getApplicationContext());
                    sqLiteController.addPassword(identifyer.getText().toString(), username.getText().toString(), password.getText().toString());
                    Intent intent = new Intent(SavePassword.this, ViewPasswords.class);
                    Toast.makeText(getApplicationContext(), getString(R.string.savePasswordSuccess), Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }
        });
    }
}
