package org.campusmolndal.demo;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;


public class WeatherAPI {

    private final String apiKey = "f6afdf0f361d0dc9ff397c821a4ce2d3";
    private final String requestUrl = "http://api.openweathermap.org/geo/1.0/direct?q=London&limit=5&appid={f6afdf0f361d0dc9ff397c821a4ce2d3}";

    public WeatherAPI() {
    }

    public Weather getWeatherData() throws IOException {
        String apiData = getData();
        JSONObject jsonObject = new JSONObject(apiData);

        // Anpassa datan efter behov
        JSONArray weatherArray = jsonObject.getJSONArray("weather");
        JSONObject weatherObject = weatherArray.getJSONObject(0);
        String main = weatherObject.getString("main");
        String description = weatherObject.getString("description");

        JSONObject mainObject = jsonObject.getJSONObject("main");
        double temp = mainObject.getDouble("temp");

        // Skapa ett Weather-objekt med den anpassade datan
        Weather weather = new Weather(main, description, temp);
        return weather;
    }


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
