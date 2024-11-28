package Data;
import java.time.LocalDate;
import java.util.Arrays;

// Petrol class is an abstract class that extends Vehicle class
public abstract class Petrol extends Vehicle{
    private double engine; // Engine size in litres
    private int co2; // CO2 emissions in g/km

    public Petrol(int id, String model, String regNo, String manufacturer, LocalDate regDate, String []location, double engine, int co2) {
        super(id, model, regNo, manufacturer, regDate, Arrays.toString(location));
        this.engine = engine;
        this.co2 = co2;
    }
}
