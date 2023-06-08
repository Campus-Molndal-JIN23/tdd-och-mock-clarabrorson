package org.campusmolndal.demo;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;

/**
 * @Author Clara Brorson
 */
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
        }
}
