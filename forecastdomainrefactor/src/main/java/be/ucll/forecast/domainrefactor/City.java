package be.ucll.forecast.domainrefactor;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Filip and Tom on 13/11/2016.
 */
public class City {

    @JsonProperty(value = "id")
    private int id;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "country")
    private String county;

    public City() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

}
