package org.campusmolndal.demo;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
    /**
     * @Auther Clara Brorson
     */
public class WeatherServiceTest {

    private WeatherAPI weatherAPI;
    private WeatherService weatherService;

    /**
     * Skapar ett nytt WeatherAPI-objekt och ett nytt WeatherService-objekt innan varje test
     * Mockar WeatherAPI-objektet
     */
    @BeforeEach
    public void setUp() {
        weatherAPI = mock(WeatherAPI.class);
        weatherService = new WeatherService(weatherAPI);
    }

    /**
     * Testar att WeatherService-klassen kan anpassa datan från API:et till ett Weather-objekt
     * when().thenReturn() används för att mocka WeatherAPI-klassen
     */
    @Test
    void testGetData() throws IOException {

        String json = "{\"weather\":\"Rain\",\"wind\":7.2,\"temperature\":2.0}";
        when(weatherAPI.getData()).thenReturn(json);

        Weather weatherData = weatherService.getWeatherData();

        assertEquals("Rain", weatherData.getWeather());
        assertEquals(7.2, weatherData.getWind());
        assertEquals(2.0, weatherData.getTemperature());
    }

    /**
     * Testar att WeatherService-klassen kan anpassa datan från API:et till ett Weather-objekt
     * Hjälpt av chatGPT
     */
    @Test
    void testGetWeatherData() throws IOException {

        // Mocka WeatherAPI-klassen
        WeatherAPI weatherAPI = mock(WeatherAPI.class);

        // Skapa ett JSON-svar för att simulera API-responsen
        String json = "{\"weather\":\"Sunny\",\"wind\":5.3,\"temperature\":25.5}";

        // När WeatherAPI-klassen anropar getData() ska mocksvaret returneras
        when(weatherAPI.getData()).thenReturn(json);

        // Skapa ett WeatherService-objekt med den mockade WeatherAPI-klassen
        WeatherService weatherService = new WeatherService(weatherAPI);

        // Anropa metoden som ska testas
        Weather weatherData = weatherService.getWeatherData();

        // Kontrollera att rätt värden har extraherats och att Weather-objektet är korrekt
        assertEquals("Sunny", weatherData.getWeather());
        assertEquals(5.3, weatherData.getWind());
        assertEquals(25.5, weatherData.getTemperature());
    }

    /**
     * Testar att funktionen getWeather() returnerar rätt värden
     * when och thenReturn används för att mocka WeatherAPI-klassen
     */
    @Test
    void testGetWeather() throws IOException {

        String json = "{\"weather\":\"Sunny\",\"wind\":5.3,\"temperature\":25.5}";
        when(weatherAPI.getData()).thenReturn(json);

        Weather weatherData = weatherService.getWeatherData();

        assertEquals("Sunny", weatherData.getWeather());
        assertEquals(5.3, weatherData.getWind());
        assertEquals(25.5, weatherData.getTemperature());
    }
    /**
     * Testar om vindhastigheten är större än 0
     * when och thenReturn används för att mocka WeatherAPI-klassen
     */
    @Test
    void testGetWind() throws IOException {

        String json = "{\"weather\":\"Cloudy\",\"wind\":2.5,\"temperature\":10.0}";
        when(weatherAPI.getData()).thenReturn(json);

        Weather weatherData = weatherService.getWeatherData();

        assertTrue(weatherData.getWind() > 0);
    }

    /**
     * Testar om temperaturen är större än 0
     * when och thenReturn används för att mocka WeatherAPI-klassen
     * Hjälpt av chatGPT
     */
    @Test
    void testGetTemperature() throws IOException {

        String json = "{\"weather\":\"Rainy\",\"wind\":11.5,\"temperature\":6.5}";
        when(weatherAPI.getData()).thenReturn(json);

        Weather weatherData = weatherService.getWeatherData();

        assertNotNull(weatherData.getTemperature());
    }
    /**
     * Testar om väderbeskrivningen är en sträng och har samma värde som i JSON-objektet
     */
    @Test
    void testToString() {

        Weather weather = new Weather("Misty", 8.4, 18.0);

        String result = weather.toString();

        assertEquals("Weather: Misty, Wind: 8.4, Temperature: 18.0", result);
    }

    /**
     * Test för att kontrollera om två JSON-objekt inte är samma
     * Hjälpt av chatGPT
     */
    @Test
    void testToJSON() {

        Weather weather = new Weather("Sunny", 4.2, 13.0);

        // Skapar två separat JSON-objekt för att kunna jämföra dem
        JSONObject json1 = weather.toJSON();
        JSONObject json2 = weather.toJSON();

        assertFalse(json1 == json2);
    }
}
