package Data;

import java.time.LocalDate;
//Smart City, SmartTripper, SmartVan are all the same, different hourly and daily rates.

public class SmartTripper extends Petrol{
    private static final double HOURLY_RATE = 12; //Hourly rate
    private static final double DAILY_RATE = 60; //Daily rate


    public SmartTripper(int id, String model, String regNo, String manufacturer, LocalDate regDate, String location, double engine, int co2) { //Constructor
        super(id, model, regNo, manufacturer, regDate, location, engine, co2); //Constructor
    }

    @Override
    public double calculateRate(int hours, int km) { //Method to calculate the rate
        double rate = (hours <= 24) ? hours * HOURLY_RATE : DAILY_RATE; //Calculates the base rate based on the number of hours
        return rate + (km > 50 ? (km - 50) * 0.25 : 0); //Adds an additional charge if the distance is greater than 50 km
    }
}
