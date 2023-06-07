package org.campusmolndal.demo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;

    /**
     * Klassen WeatherService hämtar data från ett API och anpassar datan till ett Weather-objekt
     */
public class WeatherService {

        WeatherAPI weatherAPI;

        public WeatherService(WeatherAPI weatherAPI) {
            this.weatherAPI = weatherAPI;
        }

        /**
         * Hämtar data från API:et och anpassar datan till ett Weather-objekt
         * @return
         * @throws IOException
         */
        public Weather getWeatherData() throws IOException {
            try {
                String json = weatherAPI.getData();
                JSONObject jsonObject = new JSONObject(json);

                String weather = jsonObject.getString("weather");
                double wind = jsonObject.getDouble("wind");
                double temperature = jsonObject.getDouble("temperature");

                return new Weather(weather, wind, temperature);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;

            /*String apiData = weatherAPI.getData(); // Hämta data från API:et
            JSONObject jsonObject = new JSONObject(apiData);// Skapa ett json-objekt av datan
            JSONArray jsonArray = jsonObject.getJSONArray("weather"); // Hämta en array från json-objektet
            JSONObject weatherObject = jsonArray.getJSONObject(0); // Hämta ett json-objekt från arrayen
            String weather = weatherObject.getString("main"); // Hämta en sträng från json-objektet
            JSONObject windObject = jsonObject.getJSONObject("wind"); // Hämta ett json-objekt från json-objektet
            double wind = windObject.getDouble("speed"); // Hämta ett double-värde från json-objektet
            JSONObject mainObject = jsonObject.getJSONObject("main"); // Hämta ett json-objekt från json-objektet
            double temperature = mainObject.getDouble("temp"); // Hämta ett double-värde från json-objektet

            return new Weather(weather, wind, temperature); // Skapa ett Weather-objekt*/
        }

        //Test för att kolla om API:et fungerar
        public static void main(String[] args) {
            WeatherAPI weatherAPI = new WeatherAPI();
            WeatherService weatherService = new WeatherService(weatherAPI);

            try {
                Weather weatherData = weatherService.getWeatherData();
                System.out.println("Weather: " + weatherData.getWeather());
                System.out.println("Temp: " + weatherData.getTemperature());
                System.out.println("Wind: " + weatherData.getWind());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
