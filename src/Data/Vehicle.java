package Data;

import java.time.LocalDate;

public abstract class Vehicle {
    private int id; //Unique identifier
    private String model; //Model of the vehicle
    private String regNo; //Registration number
    private String manufacturer; //Manufacturer of the vehicle
    private LocalDate regDate; //Registration date
    private String location; //Location of the vehicle

    public Vehicle(int id, String model, String regNo, String manufacturer, LocalDate regDate, String location) { //Constructor
        this.id = id;
        this.model = model;
        this.regNo = regNo;
        this.manufacturer = manufacturer;
        this.regDate = regDate;
        this.location = location;
    }


    //Different for each type of vehicle
    public abstract double calculateRate(int hours, int km); //This calculates the base rate based on the number of hours and the distance travelled.

    public String toString(){
        return "vehicle ID: " + id
                + "\nRegistration: " + regNo + " registered on " + regDate
                + "\nModel: " + manufacturer + " " + model
                + "\nLocation " + location;
    }
}
