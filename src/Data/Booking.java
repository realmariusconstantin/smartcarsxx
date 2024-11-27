package Data;
import java.time.LocalDate;
import java.time.LocalTime;

// Booking class
public class Booking {
    private int bookingId; // Booking number
    private int vehicleId; // Vehicle number
    private int custNo; // Customer number
    private LocalDate pickUpDate; // Pick up date
    private LocalTime pickUpTime; // Pick up time
    private LocalDate returnDate; // Return date
    private LocalTime returnTime; // Return time
    private String pickUpLocation; // Pick up location

    public Booking(int bookingId, int vehicleId, int custNo, LocalDate pickUpDate, LocalTime pickUpTime, LocalDate returnDate, LocalTime returnTime, String pickUpLocation, double rate) {
        this.bookingId = bookingId;
        this.vehicleId = vehicleId;
        this.custNo = custNo;
        this.pickUpDate = pickUpDate;
        this.pickUpTime = pickUpTime;
        this.returnDate = returnDate;
        this.returnTime = returnTime;
        this.pickUpLocation = pickUpLocation;
    }

    @Override
    public String toString() {
        return "Booking ID: " + bookingId
                + "\nVehicle ID: " + vehicleId
                + "\nCustomer Number: " + custNo
                + "\nPick up date: " + pickUpDate + " at " + pickUpTime
                + "\nReturn date: " + returnDate + " at " + returnTime
                + "\nPick up location: " + pickUpLocation;
    }

}
