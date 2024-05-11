/**
 * 
 */
package co.edu.unbosque.model;

import co.edu.unbosque.helper.ValidationsCyclist;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * 
 */
public class Squad {
    private String name;

    private LocalTime raceTime;

    private String country;

    private ArrayList<Cyclist> platoon;

    public Squad(String name, String country) {
        ValidationsCyclist.verifyName(name);
        this.name = name;
        this.raceTime = LocalTime.of(0, 0, 0);
        if (country != null) {
            this.country = country;
        }
        this.country = null;
        platoon = new ArrayList<>(8);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalTime getRaceTime() {
        return raceTime;
    }

    public void setRaceTime(LocalTime raceTime) {
        this.raceTime = raceTime;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ArrayList<Cyclist> getPlatoon() {
        return platoon;
    }

    public void setPlatoon(ArrayList<Cyclist> platoon) {
        this.platoon = platoon;
    }
}
