package org.campusmolndal.demo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WeatherServiceTest {
    @BeforeEach
    public void setUp() throws IOException {
        WeatherAPI weatherAPI = mock(WeatherAPI.class);
        when(weatherAPI.getData()).thenReturn("The weather is sunny");
        WeatherService weatherService = new WeatherService(weatherAPI);
    }

    // Testar att WeatherService-klassen kan hämta data från API:et
    @Test
    public void testGetWeatherData() throws IOException {
        // Mocka WeatherAPI-klassen
        WeatherAPI weatherAPI = mock(WeatherAPI.class);
        // Skapa ett JSON-svar för att simulera API-responsen
        String json = "{\"weather\":\"Sunny\",\"wind\":5.3,\"temperature\":25.5}";
        // Sätt upp stubbning för att returnera JSON-svaret när getData() anropas
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

}
