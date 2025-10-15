package com.example.nasapictureviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String PASSWORD = "com.example.NasaPictureViewer.PASSWORD";
    public static final String USERNAME = "com.example.NasaPictureViewer.USERNAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick(view);
            }
        });*/
    }

    public void onClick(View view) {
        // Recupero le due informazioni inserite dall'utente
        String psw = ((EditText)findViewById(R.id.password)).getText().toString();
        String usr = ((EditText)findViewById(R.id.username)).getText().toString();

        // Creo un nuovo intent per la comunicazione delle due activities
        Intent intent = new Intent(this, DisplayInfoActivity.class);

        // Aggiungo all'intent le informazioni
        intent.putExtra(PASSWORD, psw);
        intent.putExtra(USERNAME, usr);
        startActivity(intent);
    }
}