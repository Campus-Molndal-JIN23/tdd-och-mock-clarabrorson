package org.campusmolndal.demo;
import org.json.JSONObject;
public class Weather {

    String main;
    String description;
    double temp;

    public Weather(String main, String description, double temp) {
        this.main = main;
        this.description = description;
        this.temp = temp;
    }

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }

    public double getTemp() {
        return temp;
    }

    //Skapa ett json objekt med datan
    public JSONObject getJson() {
        JSONObject json = new JSONObject();
        json.put("main", main);
        json.put("description", description);
        json.put("temp", temp);
        return json;
    }

}
