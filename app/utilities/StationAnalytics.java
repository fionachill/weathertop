//package utilities;
//
//import models.Reading;
//import models.Station;
//import play.Logger;
//import play.mvc.Controller;
//
//import java.util.List;
//public class StationAnalytics extends Controller{
//
//    public static void stationAnalytics(){}
//
//    public static double getMaxTemp(List<Reading> readings){
//        double maxTemp = 0;
//        if(readings.size() > 0){
//            maxTemp = readings.get(0).getTemperature();
//            for(Reading reading: readings){
//                if(reading.getTemperature() > maxTemp){
//                    maxTemp = reading.getTemperature();
//                }
//            }
//        }return maxTemp;
//    }
//
//}
