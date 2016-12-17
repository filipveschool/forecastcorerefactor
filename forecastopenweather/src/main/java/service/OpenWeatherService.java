package service;

import be.ucll.forecast.domain.Forecast;
import be.ucll.forecast.domain.Observation;

/**
 * Created by Filip and Tom on 12/11/2016.
 */
public interface OpenWeatherService {
    Observation getObservation(String location);
    Forecast getForecast(String location);
}
