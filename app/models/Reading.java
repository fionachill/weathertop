package models;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import utilities.Conversions;

import play.db.jpa.Model;

@Entity
public class Reading extends Model {
    public int code;
    public double temperature;
    public double windSpeed;
    public int pressure;
    public double windDirection;
    public String date;


    public Reading(String date, int code, double temperature, double windSpeed, int pressure, double windDirection) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.date = formatter.format(LocalDateTime.now());
        this.code = code;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        this.windDirection = windDirection;
    }

    /*////////////
    ///GETTERS////
    ////////////*/

    public int getCode() {
        return this.code;
    }

    public double getTemperature() {
        return this.temperature;
    }

    public double FTemp() {
        return Conversions.convertToF(this.temperature);
    }

    public double getWindSpeed() {
        return this.windSpeed;
    }

    public int getPressure() {
        return this.pressure;
    }

    public double getWindDirection() {
        return this.windDirection;
    }


    public String weatherConditions() {
        return Conversions.convertWCode(this.code);
    }

    public int getBeaufort() {
        return Conversions.convertToBFort(this.windSpeed);
    }

    public String getWindCompass() {
        return Conversions.windCompass(this.windDirection);
    }

    public double getWindChill() {
        return Conversions.windChill(this.temperature, this.windSpeed);
    }

    public String getWCodeIcon() {
        return Conversions.wCodeIcon(this.code);
    }

}