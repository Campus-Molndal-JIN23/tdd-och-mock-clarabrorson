package org.campusmolndal.demo;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
    /**
     * @Author Clara Brorson
    */
    /**
    * Klassen WeatherAPI hämtar data från ett API
    */
public class WeatherAPI {
    private final String apiKey = "4c86c5169b47e303de836399b857d6a9";
    private final String requestUrl = "http://api.openweathermap.org/geo/1.0/direct?q=London&limit=5&appid={4c86c5169b47e303de836399b857d6a9}";
    /**
     * Hämtar data från API:et
     * @return Returnerar data från API:et som en sträng
     * @throws IOException Använder ett IO-exception för att hantera fel
     */
    public String getData() throws IOException {
        URL url = new URL(requestUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            return response.toString();
        } else {
            throw new IOException("Failed to get data from API. HTTP response code: " + responseCode);
        }
    }
}
