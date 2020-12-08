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
    Button savePassword,deletePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_password);

        identifyer = (EditText) findViewById(R.id.identifyerET);
        deletePassword = (Button) findViewById(R.id.deletePassword);
        deletePassword.setVisibility(View.GONE);
        username = (EditText) findViewById(R.id.usernameET);
        password = (EditText) findViewById(R.id.passwordET);
        savePassword = (Button) findViewById(R.id.savePassword);
        final Intent intent = getIntent();
        int editable = intent.getIntExtra("editable", 0);
        final int id = intent.getIntExtra("id", -1);
        String app_name = intent.getStringExtra("app_name");
        if(!app_name.equals("")) {
            identifyer.setText(app_name);
            identifyer.setEnabled(false);
        }
        if(id != -1) {
            SQLiteController sqLiteController = new SQLiteController(getApplicationContext());
            Password password2 = sqLiteController.getConcretePassword(id);
            identifyer.setText(password2.getIdentifyer());
            username.setText(password2.getUsername());
            password.setText(password2.getPassword());
        }
        if(editable != 0) {
            deletePassword.setVisibility(View.VISIBLE);
            savePassword.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(identifyer.getText().toString().isEmpty() || username.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
                        Toast.makeText(getApplicationContext(), getString(R.string.errorSavePassword), Toast.LENGTH_SHORT).show();
                    } else {
                        SQLiteController sqLiteController = new SQLiteController(getApplicationContext());
                        sqLiteController.updatePassword(id, identifyer.getText().toString(), username.getText().toString(), password.getText().toString());
                        Intent intent = new Intent(SavePassword.this, ViewPasswords.class);
                        Toast.makeText(getApplicationContext(), getString(R.string.savePasswordSuccess), Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }
                }
            });
        } else {
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


        deletePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteController sqLiteController = new SQLiteController(getApplicationContext());
                sqLiteController.deleteConcretePassword(id);
                Intent intent1 = new Intent(SavePassword.this, ViewPasswords.class);
                startActivity(intent1);
            }
        });
    }
}
