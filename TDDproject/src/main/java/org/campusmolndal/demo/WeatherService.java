package org.campusmolndal.demo;


public class WeatherService {
    private WeatherAPI weatherAPI;

    public WeatherService(WeatherAPI weatherAPI) {
        this.weatherAPI = weatherAPI;

    }

    public String getWeather() {
        return "The weather is " + weatherAPI.getData();
    }


}