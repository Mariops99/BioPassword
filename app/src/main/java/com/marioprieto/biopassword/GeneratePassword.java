package com.marioprieto.biopassword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class GeneratePassword extends AppCompatActivity {

    TextView newpasword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_password);

        PasswordGenerator passwordGenerator = new PasswordGenerator();
        passwordGenerator.generateStrongPassword();
        String passsword = passwordGenerator.getFinalpassword();

        newpasword = (TextView) findViewById(R.id.newpassword);
        newpasword.setText(passsword);
        newpasword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getApplicationContext().getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("BioPassword", newpasword.getText());
                clipboard.setPrimaryClip(clip);
                Toast.makeText(getApplicationContext(), getString(R.string.Clipboard), Toast.LENGTH_SHORT).show();
            }
        });
    }
}