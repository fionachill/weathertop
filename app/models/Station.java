package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import utilities.Conversions;

import play.db.jpa.Model;

@Entity
public class Station extends Model {
    public String name;
    public double latitude;
    public double longitude;
    @OneToMany(cascade = CascadeType.ALL)
    public List<Reading> readings = new ArrayList<Reading>();


    public Station(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return this.name;
    }

    public double getLat() {
        return Conversions.latitude(this.latitude);
    }

    public double getLong() {
        return Conversions.longitude(this.longitude);
    }

    public Reading listLatestReading() {
        if (readings.size() > 0) {
            Reading latestReading = readings.get(readings.size() - 1);
            return latestReading;
        } else {
            Reading latestReading = new Reading("", 0, 0, 0, 0, 0);
            return latestReading;
        }
    }

    public double getMaxTemp() {
        double maxTemp = 0;
        if (readings.size() > 0) {
            maxTemp = readings.get(0).getTemperature();
            for (Reading reading : readings) {
                if (reading.getTemperature() > maxTemp) {
                    maxTemp = reading.getTemperature();
                }
            }
        }
        return maxTemp;
    }


    public double getMinTemp() {
        double minTemp = 0;
        if (readings.size() > 0) {
            minTemp = readings.get(0).getTemperature();
            for (Reading reading : readings) {
                if (reading.getTemperature() < minTemp) {
                    minTemp = reading.getTemperature();
                }
            }
        }
        return minTemp;
    }

    public double getMaxSpeed() {
        double maxSpeed = 0;
        if (readings.size() > 0) {
            maxSpeed = readings.get(0).getWindSpeed();
            for (Reading reading : readings) {
                if (reading.getWindSpeed() > maxSpeed) {
                    maxSpeed = reading.getWindSpeed();
                }
            }
        }
        return maxSpeed;
    }

    public double getMinSpeed() {
        double minSpeed = 0;
        if (readings.size() > 0) {
            minSpeed = readings.get(0).getWindSpeed();
            for (Reading reading : readings) {
                if (reading.getWindSpeed() < minSpeed) {
                    minSpeed = reading.getWindSpeed();
                }
            }
        }
        return minSpeed;
    }

    public int getMaxPressure() {
        int maxPressure = 0;
        if (readings.size() > 0) {
            maxPressure = readings.get(0).getPressure();
            for (Reading reading : readings) {
                if (reading.getPressure() > maxPressure) {
                    maxPressure = reading.getPressure();
                }
            }
        }
        return maxPressure;
    }

    public int getMinPressure() {
        int minPressure = 0;
        if (readings.size() > 0) {
            minPressure = readings.get(0).getPressure();
            for (Reading reading : readings) {
                if (reading.getPressure() < minPressure) {
                    minPressure = reading.getPressure();
                }
            }
        }
        return minPressure;
    }

}
