package com.example.nasaviewer;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//public class ImageDownloader extends AsyncTask<Void, Integer, Bitmap> {
//    private static final String TAG = "ImageDownloader";
//    // https://api.nasa.gov/
//    private static final String NASA_API_URL =
//            "https://api.nasa.gov/planetary/apod?api_key=PyWOtdgtiujR9GO4WYVdfGDhyweY3fEY9eLiR5y1";
//
//    private static final int CONNECT_TIMEOUT = 100_000;
//    private static final int READ_TIMEOUT = 300_000;
//
//    private WeakReference<ImageView> imageViewRef;
//    private ProgressDialog progressDialog;
//    private Exception error;
//
//    public ImageDownloader(ImageView imageView) {
//        this.imageViewRef = new WeakReference<>(imageView);
//    }
//
//    @Override
//    protected void onPreExecute() {
//        ImageView imageView = imageViewRef.get();
//        if (imageView != null) {
//            progressDialog = new ProgressDialog(imageView.getContext());
//            progressDialog.setTitle("NASA APOD");
//            progressDialog.setMessage("Caricamento...");
//            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//            progressDialog.setProgress(0);
//            progressDialog.show();
//        }
//    }
//
//    @Override
//    protected Bitmap doInBackground(Void... voids) {
//        try {
//            publishProgress(10);
//
//            // 1️⃣ Scarica JSON
//            URL url = new URL(NASA_API_URL);
//            HttpURLConnection jsonConn = (HttpURLConnection) url.openConnection();
//            jsonConn.setConnectTimeout(CONNECT_TIMEOUT);
//            jsonConn.setReadTimeout(READ_TIMEOUT);
//            jsonConn.connect();
//
//            int code = jsonConn.getResponseCode();
//            Log.d(TAG, "HTTP response code = " + code);
//
//            InputStream is;
//            if (code >= 200 && code < 300) {
//                is = jsonConn.getInputStream();
//            } else {
//                is = jsonConn.getErrorStream();
//            }
//
//            BufferedReader reader = new BufferedReader(
//                    new InputStreamReader(is)
//            );
//
//            StringBuilder json = new StringBuilder();
//            String line;
//            while ((line = reader.readLine()) != null) {
//                json.append(line);
//            }
//
//            reader.close();
//            jsonConn.disconnect();
//
//            publishProgress(40);
//
//            // 2️⃣ Parse JSON
//            JSONObject object = new JSONObject(json.toString());
//
//            String mediaType = object.getString("media_type");
//            if (!"image".equals(mediaType)) {
//                throw new Exception("Media non supportato: " + mediaType);
//            }
//
//            String imageUrl = object.getString("url");
//
//            publishProgress(60);
//
//            // 3️⃣ Scarica immagine
//            URL imgUrl = new URL(imageUrl);
//            HttpURLConnection imgConn = (HttpURLConnection) imgUrl.openConnection();
//            imgConn.setConnectTimeout(CONNECT_TIMEOUT);
//            imgConn.setReadTimeout(READ_TIMEOUT);
//            imgConn.setInstanceFollowRedirects(true);
//            imgConn.connect();
//
//            InputStream inputStream = imgConn.getInputStream();
//            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
//            inputStream.close();
//            imgConn.disconnect();
//
//            publishProgress(100);
//            return bitmap;
//
//        } catch (Exception e) {
//            error = e;
//            Log.e(TAG, "Errore download", e);
//            return null;
//        }
//    }
//
//    @Override
//    protected void onProgressUpdate(Integer... values) {
//        if (progressDialog != null) {
//            progressDialog.setProgress(values[0]);
//            progressDialog.setMessage("Caricamento... " + values[0] + "%");
//        }
//    }
//
//    @Override
//    protected void onPostExecute(Bitmap bitmap) {
//        if (progressDialog != null) {
//            progressDialog.dismiss();
//        }
//
//        ImageView imageView = imageViewRef.get();
//        if (imageView == null) return;
//
//        if (bitmap != null) {
//            imageView.setImageBitmap(bitmap);
//            Toast.makeText(imageView.getContext(),
//                    "Immagine caricata",
//                    Toast.LENGTH_SHORT).show();
//        } else {
//            imageView.setImageResource(android.R.drawable.ic_dialog_alert);
//            Toast.makeText(imageView.getContext(),
//                    error != null ? error.getMessage() : "Errore sconosciuto",
//                    Toast.LENGTH_LONG).show();
//        }
//    }
//}

public class ImageDownloader {

    private static final String TAG = "NasaImageLoader";
    private static final String NASA_API_URL =
            "https://api.nasa.gov/planetary/apod?date=2024-08-10&api_key=PyWOtdgtiujR9GO4WYVdfGDhyweY3fEY9eLiR5y1";
    private static final String NASA_API_URL_TODAY =
            "https://api.nasa.gov/planetary/apod?api_key=PyWOtdgtiujR9GO4WYVdfGDhyweY3fEY9eLiR5y1";

    public static void load(ImageView imageView, ProgressBar progressBar) {
        // ExecutorService: Thread separato per rete (non blocca UI)
        ExecutorService executor = Executors.newSingleThreadExecutor();
        // Handler: Torna sul main thread per Glide/UI updates
        Handler mainHandler = new Handler(Looper.getMainLooper());

        progressBar.setVisibility(View.VISIBLE);

        executor.execute(() -> {
            try {
                Log.d(TAG, "Inizio richiesta NASA APOD...");
                Log.d(TAG, "URL: " + NASA_API_URL);
                // JSON
                URL url = new URL(NASA_API_URL);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(30_000);
                conn.setReadTimeout(30_000);
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");
                conn.setRequestProperty("User-Agent", "NASAViewer/1.0");

                Log.d(TAG, "Timeout: Connect=30s, Read=30s");
                Log.d(TAG, "Headers inviati:");
                conn.getRequestProperties().forEach((key, value) ->
                        Log.d(TAG, "  " + key + ": " + value.get(0)));

                conn.connect();
                Log.d(TAG, "Connessione stabilita");

                // LOG RESPONSE HEADERS (stile Postman)
                int responseCode = conn.getResponseCode();
                String responseMsg = conn.getResponseMessage();
                Log.d(TAG, "RESPONSE:");
                Log.d(TAG, "  Status: " + responseCode + " " + responseMsg);
                Log.d(TAG, "  Headers:");
                conn.getHeaderFields().forEach((key, value) -> {
                    if (key != null) {
                        Log.d(TAG, "    " + key + ": " + value.get(0));
                    } else {
                        Log.d(TAG, "    NULL: " + value.get(0));
                    }
                });

                if (responseCode != HttpURLConnection.HTTP_OK) {
                    throw new Exception("HTTP " + responseCode);
                }

                Log.d(TAG, "Download JSON...");
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream())
                );

                StringBuilder json = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    json.append(line);
                }

                reader.close();
                conn.disconnect();

                JSONObject obj = new JSONObject(json.toString());

                Log.d(TAG, "Parsing JSON:");
                Log.d(TAG, "  date: " + obj.optString("date", "N/A"));
                Log.d(TAG, "  title: " + obj.optString("title", "N/A"));
                Log.d(TAG, "  media_type: " + obj.optString("media_type", "N/A"));
                Log.d(TAG, "  url: " + obj.optString("url", "N/A"));
                Log.d(TAG, "  hdurl: " + obj.optString("hdurl", "N/A"));
                Log.d(TAG, "  service_version: " + obj.optString("service_version", "N/A"));

                // Verifica media_type == "image" (APOD può essere video!)
                if (!"image".equals(obj.getString("media_type"))) {
                    Log.w(TAG, "Media non immagine: " + obj.getString("media_type"));
                    throw new Exception("APOD non è un'immagine oggi: " + obj.getString("media_type"));
                }

                String imageUrl_hd = obj.getString("hdurl");
                String imageUrl = obj.getString("url");

                Log.d(TAG, "URL selezionato: " + imageUrl);
                Log.d(TAG, "Caricamento immagine con Glide...");

                // 2️⃣ UI thread
                // mainHandler.post(): Garantisce esecuzione su UI thread
                mainHandler.post(() -> {
                    Glide.with(imageView)
                            .load(imageUrl)
                            .placeholder(android.R.drawable.ic_menu_gallery)
                            .error(android.R.drawable.ic_dialog_alert)
                            .into(imageView);

                    progressBar.setVisibility(View.GONE);
                });

            } catch (Exception e) {

                Log.e(TAG, "ERRORE NASA COMPLETO", e);
                Log.e(TAG, "Messaggio: " + e.getMessage());
                Log.e(TAG, "Stack trace: " + Log.getStackTraceString(e));

                mainHandler.post(() -> {
                    progressBar.setVisibility(View.GONE);

                    Glide.with(imageView)
                            .load("https://apod.nasa.gov/apod/image/2512/Crab_Chen_1920.jpg")
                            .placeholder(android.R.drawable.ic_menu_gallery)
                            .error(android.R.drawable.ic_dialog_alert)
                            .into(imageView);

                    Toast.makeText(
                            imageView.getContext(),
                            "FALLBACK IMAGE due to " + e.getMessage(),
                            Toast.LENGTH_LONG
                    ).show();
                });
            }
        });
    }
}