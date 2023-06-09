package controllers;

import java.util.Collections;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import models.Member;
import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;

public class StationCtrl extends Controller {
    public static void index(Long id) {
        Station station = Station.findById(id);
        Logger.info("Station id = " + id);
        render("station.html", station);
    }


    public static void addReading(String date, Long id, int code, double temperature, double windSpeed, int pressure, double windDirection) {
        Member member = Accounts.getLoggedInMember();
        Reading reading = new Reading(date, code, temperature, windSpeed, pressure, windDirection);
        Station station = Station.findById(id);
        station.readings.add(reading);
        station.save();
        redirect("/station/" + id);
    }

    public static void deleteReading(Long id, Long readingid) {
        Station station = Station.findById(id);
        Reading reading = Reading.findById(readingid);
        Logger.info("Removing" + readingid);
        station.readings.remove(reading);
        station.save();
        reading.delete();
        render("station.html", station);
    }
}
