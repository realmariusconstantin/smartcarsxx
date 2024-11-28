package Data;

import java.time.LocalDate;
import java.util.Arrays;

public class SmartCity extends Petrol{
 private static final double HOURLY_RATE = 11; //Hourly rate
 private static final double DAILY_RATE = 55; //Daily rate

 public SmartCity(int id, String model, String regNo, String manufacturer, LocalDate regDate, String[] location, double engine, int co2) {//Constructor
     super(id, model, regNo, manufacturer, regDate, new String[]{Arrays.toString(location)}, engine, co2);
 }


    @Override
    public double calculateRate(int hours, int km) {//Method to calculate the rate
        double rate = (hours <= 24) ? hours * HOURLY_RATE : DAILY_RATE; //Calculates the base rate based on the number of hours
        return rate + (km > 50 ? (km - 50) * 0.25 : 0); //Adds an additional charge if the distance is greater than 50 km
    }
}


