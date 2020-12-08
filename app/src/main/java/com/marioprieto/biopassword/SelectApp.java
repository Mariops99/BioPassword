package com.marioprieto.biopassword;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SelectApp extends AppCompatActivity {

    CardView twitter, instagram, facebook, google, outlook, protonmail, tumblr, pinterest, linkedin, reddit, spotify, netflix, amazon, hbo, disney, other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_app);

        twitter = (CardView) findViewById(R.id.twitter);
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("app_name", "Twitter");
                bundle.putInt("editable", 0);
                bundle.putInt("id", -1);
                Intent intent = new Intent(SelectApp.this, SavePassword.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        instagram = (CardView) findViewById(R.id.instagram);
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("app_name", "Instagram");
                bundle.putInt("editable", 0);
                bundle.putInt("id", -1);
                Intent intent = new Intent(SelectApp.this, SavePassword.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        facebook = (CardView) findViewById(R.id.facebook);
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("app_name", "Facebook");
                bundle.putInt("editable", 0);
                bundle.putInt("id", -1);
                Intent intent = new Intent(SelectApp.this, SavePassword.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        google = (CardView) findViewById(R.id.google);
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("app_name", "Google");
                bundle.putInt("editable", 0);
                bundle.putInt("id", -1);
                Intent intent = new Intent(SelectApp.this, SavePassword.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        outlook = (CardView) findViewById(R.id.outlook);
        outlook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("app_name", "Outlook");
                bundle.putInt("editable", 0);
                bundle.putInt("id", -1);
                Intent intent = new Intent(SelectApp.this, SavePassword.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        protonmail = (CardView) findViewById(R.id.protonmail);
        protonmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("app_name", "Protonmail");
                bundle.putInt("editable", 0);
                bundle.putInt("id", -1);
                Intent intent = new Intent(SelectApp.this, SavePassword.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        tumblr = (CardView) findViewById(R.id.tumblr);
        tumblr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("app_name", "Tumblr");
                bundle.putInt("editable", 0);
                bundle.putInt("id", -1);
                Intent intent = new Intent(SelectApp.this, SavePassword.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        pinterest = (CardView) findViewById(R.id.pinterest);
        pinterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("app_name", "Pinterest");
                bundle.putInt("editable", 0);
                bundle.putInt("id", -1);
                Intent intent = new Intent(SelectApp.this, SavePassword.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        linkedin = (CardView) findViewById(R.id.linkedin);
        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("app_name", "LinkedIn");
                bundle.putInt("editable", 0);
                bundle.putInt("id", -1);
                Intent intent = new Intent(SelectApp.this, SavePassword.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        reddit = (CardView) findViewById(R.id.reddit);
        reddit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("app_name", "Reddit");
                bundle.putInt("editable", 0);
                bundle.putInt("id", -1);
                Intent intent = new Intent(SelectApp.this, SavePassword.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        spotify = (CardView) findViewById(R.id.spotify);
        spotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("app_name", "Spotify");
                bundle.putInt("editable", 0);
                bundle.putInt("id", -1);
                Intent intent = new Intent(SelectApp.this, SavePassword.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        netflix = (CardView) findViewById(R.id.netflix);
        netflix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("app_name", "Netflix");
                bundle.putInt("editable", 0);
                bundle.putInt("id", -1);
                Intent intent = new Intent(SelectApp.this, SavePassword.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        amazon = (CardView) findViewById(R.id.amazon);
        amazon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("app_name", "Amazon");
                bundle.putInt("editable", 0);
                bundle.putInt("id", -1);
                Intent intent = new Intent(SelectApp.this, SavePassword.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        hbo = (CardView) findViewById(R.id.hbo);
        hbo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("app_name", "HBO");
                bundle.putInt("editable", 0);
                bundle.putInt("id", -1);
                Intent intent = new Intent(SelectApp.this, SavePassword.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        other = (CardView) findViewById(R.id.other);
        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("app_name", "");
                bundle.putInt("editable", 0);
                bundle.putInt("id", -1);
                Intent intent = new Intent(SelectApp.this, SavePassword.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
