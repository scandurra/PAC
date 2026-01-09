//package com.example.nasaviewer;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.graphics.drawable.Drawable;
//import android.os.Bundle;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.io.InputStream;
//import java.net.URL;
//
//public class DisplayInfoActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_display_info);
//
//        // Recupero le informazioni nell'intent
//        Intent intent = getIntent();
//        String psw = intent.getStringExtra(MainActivity.PASSWORD);
//        String usr = intent.getStringExtra(MainActivity.USERNAME);
//
//        // Validazione
//        if (usr.isEmpty() || psw.isEmpty()) {
//            Toast.makeText(this, "Username e password non possono essere vuoti",
//                    Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        if (psw.length() < 6) {
//            Toast.makeText(this, "Password deve essere almeno 6 caratteri",
//                    Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        // Aggiungo quello che ho ricevuto nella visualizzazione
//        TextView user = findViewById(R.id.user);
//        user.setText(usr);
//        TextView pass = findViewById(R.id.pass);
//        pass.setText(psw);
//
//        ImageView img = findViewById(R.id.imageView);
//        new ImageDownloader(img).execute();
//    }
//
//    public static Drawable LoadImageFromWebOperations(String url) {
//        try {
//            InputStream is = (InputStream) new URL(url).getContent();
//            Drawable d = Drawable.createFromStream(is, "src name");
//            return d;
//        } catch (Exception e) {
//            return null;
//        }
//    }
//}

package com.example.nasaviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class DisplayInfoActivity extends AppCompatActivity {

    private static final String TAG = "DisplayInfoActivity";
    private ImageDownloader imageDownloader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_info);

        // Recupera i dati dall'Intent
        Intent intent = getIntent();
        String username = intent.getStringExtra(MainActivity.USERNAME);
        String password = intent.getStringExtra(MainActivity.PASSWORD);

        // Mostra i dati (nota: in produzione NON mostrare password!)
        TextView userTextView = findViewById(R.id.user);
        TextView passTextView = findViewById(R.id.pass);

        userTextView.setText("Utente: " + (username != null ? username : ""));
        passTextView.setText("Password: " + (password != null ? password : ""));

        // Avvia download immagine NASA
        ImageView imageView = findViewById(R.id.imageView);
        ProgressBar progressBar = findViewById(R.id.progressBar);
        /*imageDownloader = new ImageDownloader(imageView);
        imageDownloader.execute();*/
        ImageDownloader.load(imageView, progressBar);

        Log.d(TAG, "DisplayInfoActivity creata con utente: " + username);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Cancella il task se ancora in corso
        /*if (imageDownloader != null) {
            imageDownloader.cancel(true);
            Log.d(TAG, "ImageDownloader cancellato");
        }*/
    }
}