import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Classe che legge da JSON la Astronomy Picture of the Day della NASA
 * Poi modifica il JSON aggiungendo degli attributi, e salvandolo.
 * 
 * ATTENZIONE: attualmente ci sono dei limiti sull'uso di questo servizio, se
 * non
 * dovesse restituire un Json, impostare una API Key
 * 
 * Corso di informatica Progettazione, Algoritmi e Computabilità, Unibg, A.A.
 * 2022-2023
 */

public class Json {
	public static void main(String[] args) {
		try {
			// Get data from API
			URL url = new URI("https://api.nasa.gov/planetary/apod?concept_tags=True&api_key=DEMO_KEY").toURL();

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				sb.append(line);
			}
			bufferedReader.close();
			String s = sb.toString();

			// Parse JSON object
			JSONObject o = new JSONObject(s);
			System.out.println("URL Immagine: " + o.getString("url"));
			System.out.println("Titolo: " + o.getString("title"));
			System.out.println("Descrizione: " + o.getString("explanation"));

			// Example of edit
			JSONObject myAttr = new JSONObject();
			myAttr.accumulate("data", new SimpleDateFormat("dd-MM-yyyy").format(new Date()));

			JSONArray gradimenti = new JSONArray();
			for (int i = 0; i < 3; i++) {
				JSONObject t = new JSONObject();
				t.put("User" + (i + 1), "" + (int) (Math.random() * 10 + 0.5));
				gradimenti.put(t);
			}

			myAttr.put("gradimenti", gradimenti);
			o.accumulate("myAttr", myAttr);
			System.out.println("\nJSON CON ATTRIBUTI AGGIUNTI:\n" + o.toString(2));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
