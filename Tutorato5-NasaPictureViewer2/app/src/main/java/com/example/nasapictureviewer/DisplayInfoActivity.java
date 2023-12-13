package com.example.nasapictureviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;

public class DisplayInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_info);

        // Recupero le informazioni nell'intent
        Intent intent = getIntent();
        String psw = intent.getStringExtra(MainActivity.PASSWORD);
        String usr = intent.getStringExtra(MainActivity.USERNAME);

        // Aggiungo quello che ho ricevuto nella visualizzazione
        TextView user = findViewById(R.id.user);
        user.setText(usr);
        TextView pass = findViewById(R.id.pass);
        pass.setText(psw);

        ImageView img = findViewById(R.id.imageView);
        new ImageDownloader(img).execute();
    }

    public static Drawable LoadImageFromWebOperations(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
            return d;
        } catch (Exception e) {
            return null;
        }
    }
}