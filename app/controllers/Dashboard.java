package controllers;

import java.util.List;

import models.Member;
import models.Station;
import play.Logger;
import play.mvc.Controller;

public class Dashboard extends Controller
{
  public static void index()
  {
    Logger.info("Rendering Admin");
    Member member = Accounts.getLoggedInMember();
    List<Station> stations = member.stations;
    render ("dashboard.html", stations);
  }

  public static void addStation(String name, double latitude, double longitude){
    Member member = Accounts.getLoggedInMember();
    Station station = new Station(name, latitude, longitude);
    member.stations.add(station);
    member.save();
    Logger.info ("Adding a new station called " + name);
    redirect ("/dashboard");
  }

  public static void deleteStation(Long id, Long stationid){
    Member member = Member.findById(id);
    Station station = Station.findById(stationid);
    member.stations.remove(station);
    member.save();
    station.delete();
    Logger.info("Deleting Station");
    redirect("/dashboard");
  }

}

