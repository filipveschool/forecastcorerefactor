package be.ucll.forecast.domainrefactor;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Filip and Tom on 27/9/2016.
 */
public class Observation {

    private String dt;

    private Temperature temp;

    public Observation() {
    }

    public void setDt(String dt){
        int milli = Integer.parseInt(dt);
        System.out.println("HELLOOOOOOOOOOOOO");
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dat = new Date((long)milli*1000);
        this.dt = format.format(dat);
    }

    @JsonProperty(value = "date", access = JsonProperty.Access.READ_ONLY)
    public String getDt() {
        return dt;
    }

    public Temperature getTemp() {
        return temp;
    }

    public void setTemp(Temperature temp) {
        this.temp = temp;
    }
}
