package utilities;

import java.util.List;

import models.Reading;
import models.Station;
import play.Logger;
import play.mvc.Controller;

public class Conversions extends Controller{

    public static void conversions(){
    }

    public static double convertToF(double temperature){
        double FTemp = (temperature* 9/5) + 32;
        return FTemp;
    }

    public static String convertWCode(int code){
        String weather = " ";
       switch (code) {
           case 100:
               weather = weather +"Clear";
           break;
           case 200:
               weather = weather + "Partial Clouds";
           break;
           case 300:
               weather = weather + "Cloudy";
           break;
           case 400:
               weather = weather + "Light Showers";
           break;
           case 500:
               weather = weather + "Heavy Showers";
           break;
           case 600:
               weather = weather + "Rain";
           break;
           case 700:
               weather = weather + "Snow";
           break;
           case 800:
               weather = weather + "Thunder";
           break;
         }
         return weather;
       }

       public static String wCodeIcon(int code){
        String wCodeIcon = "";
           switch (code) {
               case 100:
                   wCodeIcon = "fa-solid fa-sun";
                   break;
               case 200:
                   wCodeIcon = wCodeIcon + "fa-solid fa-cloud-sun";
                   break;
               case 300:
                   wCodeIcon = wCodeIcon + "fa-solid fa-cloud";
                   break;
               case 400:
                   wCodeIcon = wCodeIcon + "fa-solid fa-cloud-rain";
                   break;
               case 500:
                   wCodeIcon = wCodeIcon +"fa-solid fa-cloud-showers-heavy";
                   break;
               case 600:
                   wCodeIcon = wCodeIcon + "fa-solid fa-cloud-showers-water";
                   break;
               case 700:
                   wCodeIcon = wCodeIcon + "fa-solid fa-snowflake";
                   break;
               case 800:
                   wCodeIcon = wCodeIcon + "fa-solid fa-cloud-bolt";
                   break;
           }
           return wCodeIcon;
       }


    public static int convertToBFort(double wSpeed) {
        //we want this to take in the wSpeed and determine the beaufort
        int bFort = 0;
        if (wSpeed == 1) {
            bFort = 0;
        }else if ((wSpeed > 1) && (wSpeed < 6)) {
            bFort = 1;
        } else if ((wSpeed > 5) && (wSpeed < 12)) {
            bFort = 2;
        } else if ((wSpeed > 11) && (wSpeed < 20)) {
            bFort = 3;
        } else if ((wSpeed > 19) && (wSpeed < 29)) {
            bFort = 4;
        } else if ((wSpeed > 28) && (wSpeed < 39)) {
            bFort = 5;
        } else if ((wSpeed > 38) && (wSpeed < 50)) {
            bFort = 6;
        } else if ((wSpeed > 49) && (wSpeed < 62)) {
            bFort = 7;
        } else if ((wSpeed > 61) && (wSpeed < 75)) {
            bFort = 8;
        } else if ((wSpeed > 74) && (wSpeed < 89)) {
            bFort = 9;
        } else if ((wSpeed > 88) && (wSpeed < 103)) {
            bFort = 10;
        } else if ((wSpeed > 102) && (wSpeed < 118)) {
            bFort = 11;
        }
        return bFort;
    }

    public static String windCompass(double windDirection){
        String windCompass = "";
        if ((windDirection > 348.75) && (windDirection < 11.25)){
            windCompass = "North";
        }else if((windDirection > 11.25) && (windDirection < 33.75 )){
            windCompass = "North North East";
        }else if((windDirection > 33.75) && (windDirection < 56.25)){
            windCompass = "North East";
        }else if((windDirection > 56.25) && (windDirection < 78.75)){
            windCompass = "East North East";
        }else if((windDirection > 78.75) && (windDirection < 101.25)){
            windCompass = "East";
        }else if((windDirection > 101.25) && (windDirection < 123.75)){
            windCompass = "East South East";
        }else if((windDirection > 123.75) && (windDirection < 146.25)){
            windCompass = "South East";
        }else if((windDirection > 146.25) && (windDirection < 168.75)){
            windCompass = "South South East";
        }else if((windDirection > 168.75) && (windDirection < 191.25)){
            windCompass = "South";
        }else if((windDirection > 191.25) && (windDirection < 213.75)){
            windCompass = "South South West";
        }else if((windDirection > 213.75) && (windDirection < 236.25)){
            windCompass = "South West";
        }else if((windDirection > 236.25) && (windDirection < 258.75)){
            windCompass = "West South West";
        }else if((windDirection > 258.75) && (windDirection < 281.25)){
            windCompass = "West";
        }else if((windDirection > 281.25) && (windDirection < 303.75)){
            windCompass = "West North West";
        }else if((windDirection > 303.75) && (windDirection < 326.25)){
            windCompass = "North West";
        }else{
            windCompass = "North North West";
        }
        return windCompass;
    }

    public static double windChill(double temperature, double wSpeed) {
        if ((temperature > 9) && (wSpeed > 4.8)) {
            double windChill = (13.12 + (0.6215 * temperature) - 11.37 * (Math.pow(wSpeed, 0.16)) + (0.3965 * temperature) * (Math.pow(wSpeed, 0.16)));
            return toTwoDecimalPlaces(windChill);
        } else {
            return temperature;
        }
    }
    public static double latitude(double latitude){
        return toTwoDecimalPlaces(latitude);
    }
    public static double longitude(double longitude){
        return toTwoDecimalPlaces(longitude);
    }

    private static double toTwoDecimalPlaces(double num){
        return (int) (num*100)/100.0;
    }
}
