package Data;

import java.time.LocalDate;

public abstract class Vehicle {
    private int id;
    private String model;
    private String regNo;
    private String manufacturer;
    private LocalDate regDate;
    private String location;

    public Vehicle(int id, String model, String regNo, String manufacturer, LocalDate regDate, String location) {
        this.id = id;
        this.model = model;
        this.regNo = regNo;
        this.manufacturer = manufacturer;
        this.regDate = regDate;
        this.location = location;
    }


    //Different for each type of vehicle
    public abstract double calculateRate(int hours, int km);
}
