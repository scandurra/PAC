//package com.example.nasaviewer;
//
//import androidx.appcompat.app.AppCompatActivity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.EditText;
//
//public class MainActivity extends AppCompatActivity {
//
//    public static final String PASSWORD = "com.example.NasaPictureViewer.PASSWORD";
//    public static final String USERNAME = "com.example.NasaPictureViewer.USERNAME";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        /*findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                onClick(view);
//            }
//        });*/
//    }
//
//    public void onClick(View view) {
//        // Recupero le due informazioni inserite dall'utente
//        String psw = ((EditText)findViewById(R.id.password)).getText().toString();
//        String usr = ((EditText)findViewById(R.id.username)).getText().toString();
//
//        // Creo un nuovo intent per la comunicazione delle due activities
//        Intent intent = new Intent(this, DisplayInfoActivity.class);
//
//        // Aggiungo all'intent le informazioni
//        intent.putExtra(PASSWORD, psw);
//        intent.putExtra(USERNAME, usr);
//        startActivity(intent);
//    }
//}

package com.example.nasaviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

    public class MainActivity extends AppCompatActivity {

        public static final String PASSWORD = "com.example.NasaPictureViewer.PASSWORD";
        public static final String USERNAME = "com.example.NasaPictureViewer.USERNAME";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }

        public void onClick(View view) {
            EditText usernameEditText = findViewById(R.id.username);
            EditText passwordEditText = findViewById(R.id.password);

            String username = usernameEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            // Validazione input
            if (!validateInput(username, password)) {
                return;  // Validazione fallita, non procedere
            }

            // Procedi con il login
            Intent intent = new Intent(this, DisplayInfoActivity.class);
            intent.putExtra(USERNAME, username);
            intent.putExtra(PASSWORD, password);
            startActivity(intent);
        }

        /**
         * Valida username e password
         * @return true se valido, false altrimenti
         */
        private boolean validateInput(String username, String password) {
            // Controlla campi vuoti
            if (username.isEmpty()) {
                showError("Username non può essere vuoto");
                return false;
            }

            if (password.isEmpty()) {
                showError("Password non può essere vuota");
                return false;
            }

            // Controlla lunghezza minima
            if (username.length() < 3) {
                showError("Username deve avere almeno 3 caratteri");
                return false;
            }

            if (password.length() < 6) {
                showError("Password deve avere almeno 6 caratteri");
                return false;
            }

            // Controlla caratteri non validi
            if (!username.matches("^[a-zA-Z0-9_]*$")) {
                showError("Username può contenere solo lettere, numeri e underscore");
                return false;
            }

            return true;
        }

        /**
         * Mostra un messaggio di errore all'utente
         */
        private void showError(String message) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }
