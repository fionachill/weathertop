package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import utilities.Conversions;

import play.db.jpa.Model;

@Entity
public class Station extends Model
{
    public String name;
    public double latitude;
    public double longitude;
    @OneToMany(cascade = CascadeType.ALL)
    public List<Reading> readings = new ArrayList<Reading>();


    public Station(String name, double latitude, double longitude)
    {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName(){
        return this.name;
    }
    public double getLat(){
        return Conversions.latitude(this.latitude);
    }
    public double getLong(){
        return Conversions.longitude(this.longitude);
    }
    public Reading listLatestReading(){
        if (readings.size() > 0) {
            Reading latestReading = readings.get(readings.size() - 1);
            return latestReading;
        } else{
            Reading latestReading = new Reading(0, 0, 0, 0, 0);
            return latestReading;
        }
    }
}
