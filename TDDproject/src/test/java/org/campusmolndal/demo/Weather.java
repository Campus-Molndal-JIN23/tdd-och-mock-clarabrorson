package org.campusmolndal.demo;
import org.json.JSONObject;

public class Weather {

    String weather;
    double wind;
    double temperature;

    public Weather(String weather, double wind, double temperature) {
        this.weather = weather;
        this.wind = wind;
        this.temperature = temperature;
    }

    public String getWeather() {
        return weather;
    }

    public double getWind() {
        return wind;
    }

    public double getTemperature() {
        return temperature;
    }



    public String toString() {
        return "Weather: " + weather + ", Wind: " + wind + ", Temperature: " + temperature;
    }

    // Skapa ett JSON-objekt av Weather-objektet
    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("weather", weather);
        json.put("wind", wind);
        json.put("temperature", temperature);
        return json;
    }



}
