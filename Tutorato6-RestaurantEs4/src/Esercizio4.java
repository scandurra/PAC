import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import com.restaurant.code.domain.Restaurant;

@SpringBootApplication
public class Esercizio4 {
	
	public static void main(String[] args) throws IOException {
		System.out.println("Inserisci il nome del ristorante che ti interessa: ");
		
		// Using Scanner for Getting Input from User
		Scanner in = new Scanner(System.in);
		String restaurantName = in.nextLine();
		
		URL url = new URL("http://localhost:8080/restaurants/");

        // Make connection
        URLConnection urlc = url.openConnection();
        urlc.setDoOutput(true);

        // Send query
        PrintStream ps = new PrintStream(urlc.getOutputStream());
        ps.close();

        // Get result
        BufferedReader br = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
        String l = null;
        while ((l=br.readLine())!=null) {
            System.out.println(l);
        }
        br.close();
		
	}
}
