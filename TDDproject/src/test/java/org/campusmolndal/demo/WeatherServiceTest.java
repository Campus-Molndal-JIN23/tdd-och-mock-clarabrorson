package org.campusmolndal.demo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class WeatherServiceTest {
    @BeforeEach
    public void setUp() throws IOException {
        WeatherAPI weatherAPI = Mockito.mock(WeatherAPI.class);
        when(weatherAPI.getData()).thenReturn("The weather is sunny");
        WeatherService weatherService = new WeatherService(weatherAPI);
    }


}
