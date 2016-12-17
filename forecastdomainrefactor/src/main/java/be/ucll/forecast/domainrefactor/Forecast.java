package be.ucll.forecast.domainrefactor;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by Filip and Tom on 27/9/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {

    private City city;

    private List<Observation> list;


    public Forecast(){
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Observation> getList() {
        return list;
    }

    public void setList(List<Observation> list) {
        this.list = list;
    }
}