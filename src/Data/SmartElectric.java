package Data;

import java.time.LocalDate;

public class SmartElectric extends Vehicle {
    private static final double HOURLY_RATE = 14;//Hourly rate in euros
    private static final double DAILY_RATE = 70; //Daily rate in euros
    private double battery; //Battery capacity in kWh
    private int range; //Range in km
    private int efficiency; //Efficiency in Wh/km

    public SmartElectric(int id, String regNo, String manufacturer, String model, LocalDate regDate, String location, double battery, int range, int efficiency) {
        super(id, regNo, manufacturer, model, regDate, location);
        this.battery = battery;
        this.range = range;
        this.efficiency = efficiency;
    }

    @Override
    public double calculateRate(int hours, int km) {
        return (hours <= 24) ? hours * HOURLY_RATE : DAILY_RATE;
    } //This calculates the base rate based on the number of hours.
}
