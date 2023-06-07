package org.campusmolndal.demo;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;


public class WeatherAPI {

    private final String apiKey = "f6afdf0f361d0dc9ff397c821a4ce2d3";
    private final String requesturl = "http://api.openweathermap.org/geo/1.0/direct?q=London&limit=5&appid={f6afdf0f361d0dc9ff397c821a4ce2d3}";

    public WeatherAPI() {
    }

    public String getData() throws IOException {
        URL url = new URL(requesturl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        int responseCode = connection.getResponseCode();

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        return response.toString();
    }
}

