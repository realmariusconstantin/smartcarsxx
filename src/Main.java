import Data.*;

import javax.swing.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Vehicle> fleet = new ArrayList<Vehicle>(); // Create an array list of vehicles
    private static ArrayList<Booking> bookings = new ArrayList<Booking>(); // Create an array list of bookings
    private static ArrayList<Customer> customers = new ArrayList<Customer>(); // Create an array list of customers
    private static ArrayList<Employee> employees = new ArrayList<Employee>(); // Create an array list of employees

    public static void main(String[] args) {

        boolean exit = false;
        while (!exit) {
            String[] options = {"Customer Menu", "Employee Menu", "Exit"};// Menu options
            int choice = JOptionPane.showOptionDialog(null, "Select a option", "SmartCar System",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]); // Display the menu

            switch (choice) {
                case 0 -> customerMenu();
                case 1 -> employeeMenu();
                case 2 -> exit = true;
                default -> JOptionPane.showMessageDialog(null, "Invalid option selected");
            }

        }
    }

    private static void customerMenu() {
        boolean back = false;
        while (!back) {
            String[] options = {"Sign up", "Book vehicle", "View bookings", "Back"};// Menu options
            int choice = JOptionPane.showOptionDialog(null, "Select a option", "Customer Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]); // Display the menu

            switch (choice) {
                case 0 -> Signup();
                case 1 -> bookVehicle();
                case 2 -> viewBookings();
                case 3 -> back = true;
                default -> JOptionPane.showMessageDialog(null, "Invalid option selected");
            }

        }
    }

    private static void viewBookings() {
        for (Vehicle booking : fleet) {
            JOptionPane.showMessageDialog(null, booking); // Display the booking
        }

    }

    private static void bookVehicle() {
     String[] vehicleTypes = {"City", "Tripper", "Electric", "Van"}; // Vehicle types
        int choice = JOptionPane.showOptionDialog(null, "Select a vehicle type", "Book Vehicle",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, vehicleTypes, vehicleTypes[0]); // Display the vehicle types
        switch(choice){
            case 0 -> JOptionPane.showMessageDialog(null, "City selected");
            case 1 -> JOptionPane.showMessageDialog(null, "Tripper selected");
            case 2 -> JOptionPane.showMessageDialog(null, "Electric selected");
            case 3 -> JOptionPane.showMessageDialog(null, "Van selected");
            default -> JOptionPane.showMessageDialog(null, "Invalid option selected");
        }

        if(choice == 0){
            System.out.println(fleet);
            int custNo = Integer.parseInt(JOptionPane.showInputDialog("Enter your Customer Number"));
            int vehicleId = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of the vehicle")); // Get the ID of the vehicle
            LocalDate pickUpDate = LocalDate.parse(JOptionPane.showInputDialog("Enter the date of the booking (yyyy-mm-dd)")); // Get the date of the booking
            LocalDate ReturnDate = LocalDate.parse(JOptionPane.showInputDialog("Enter the date of the return (yyyy-mm-dd)")); //Get the date of the return
            LocalTime pickUpTime = LocalTime.parse(JOptionPane.showInputDialog("Enter the time of the booking (hh:mm)")); // Get the time of the booking
            LocalTime ReturnTime = LocalTime.parse(JOptionPane.showInputDialog("Enter the time of the return (hh:mm)"));
            String location = JOptionPane.showInputDialog("Enter the location of the booking"); // Get the location of the booking
            int km = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of km you will be travelling")); // Get the number of km the customer will be travelling
            int bookingId = bookings.size() + 1; // Generate a booking number
            JOptionPane.showMessageDialog(null, "Booking successful"); // Display a message to confirm the booking has been added

            Booking booking = new Booking(bookingId, vehicleId, custNo, pickUpDate, pickUpTime, ReturnDate, ReturnTime, location) {
                @Override
                public String toString() {
                    return super.toString();
                }
            }; // Create a new booking object

            class DateTimeUtils {
                public static double calculateHours(LocalDate pickUpDate, LocalTime pickUpTime, LocalDate returnDate, LocalTime returnTime) {
                    LocalDateTime pickUpDateTime = LocalDateTime.of(pickUpDate, pickUpTime);
                    LocalDateTime returnDateTime = LocalDateTime.of(returnDate, returnTime);
                    Duration duration = Duration.between(pickUpDateTime, returnDateTime);
                    return duration.toHours() + (duration.toMinutesPart() / 60.0);
                }
            }

            double hours = DateTimeUtils.calculateHours(pickUpDate, pickUpTime, ReturnDate, ReturnTime);
            // Create an instance of SmartCity
            SmartCity smartCity = new SmartCity(vehicleId, "Model", "RegNo", "Manufacturer", LocalDate.now(), location, 1.0, 100);

            // Calculate the rate using the SmartCity instance
            double rate = smartCity.calculateRate((int) hours, km);

            System.out.println("Hours: " + hours);
            System.out.println("Km: " + km);
            System.out.println("Rate: " + rate);

            JOptionPane.showMessageDialog(null, "The rate for the booking is: " + rate);
            bookings.add(booking); // Add the booking to the array list
            System.out.println(bookings);


        }
        else if(choice == 1){
            System.out.println(fleet);
            int custNo = Integer.parseInt(JOptionPane.showInputDialog("Enter your Customer Number"));
            int vehicleId = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of the vehicle")); // Get the ID of the vehicle
            LocalDate pickUpDate = LocalDate.parse(JOptionPane.showInputDialog("Enter the date of the booking (yyyy-mm-dd)")); // Get the date of the booking
            LocalDate ReturnDate = LocalDate.parse(JOptionPane.showInputDialog("Enter the date of the return (yyyy-mm-dd)")); //Get the date of the return
            LocalTime pickUpTime = LocalTime.parse(JOptionPane.showInputDialog("Enter the time of the booking (hh:mm)")); // Get the time of the booking
            LocalTime ReturnTime = LocalTime.parse(JOptionPane.showInputDialog("Enter the time of the return (hh:mm)"));
            String location = JOptionPane.showInputDialog("Enter the location of the booking"); // Get the location of the booking
            int km = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of km you will be travelling")); // Get the number of km the customer will be travelling
            int bookingId = bookings.size() + 1; // Generate a booking number
            JOptionPane.showMessageDialog(null, "Booking successful"); // Display a message to confirm the booking has been added

            Booking booking = new Booking(bookingId, vehicleId, custNo, pickUpDate, pickUpTime, ReturnDate, ReturnTime, location) {
                @Override
                public String toString() {
                    return super.toString();
                }
            }; // Create a new booking object

            class DateTimeUtils {
                public static double calculateHours(LocalDate pickUpDate, LocalTime pickUpTime, LocalDate returnDate, LocalTime returnTime) {
                    LocalDateTime pickUpDateTime = LocalDateTime.of(pickUpDate, pickUpTime);
                    LocalDateTime returnDateTime = LocalDateTime.of(returnDate, returnTime);
                    Duration duration = Duration.between(pickUpDateTime, returnDateTime);
                    return duration.toHours() + (duration.toMinutesPart() / 60.0);
                }
            }

            double hours = DateTimeUtils.calculateHours(pickUpDate, pickUpTime, ReturnDate, ReturnTime);
            // Create an instance of SmartTripper
            SmartTripper smartTripper= new SmartTripper(vehicleId, "Model", "RegNo", "Manufacturer", LocalDate.now(), location, 1.0, 100);

            // Calculate the rate using the SmartTripper instance
            double rate = smartTripper.calculateRate((int) hours, km);

            System.out.println("Hours: " + hours);
            System.out.println("Km: " + km);
            System.out.println("Rate: " + rate);

            JOptionPane.showMessageDialog(null, "The rate for the booking is: " + rate);
            bookings.add(booking); // Add the booking to the array list
            System.out.println(bookings);


        }
        else if(choice ==2){

        }
    }


    private static void Signup(){
            String firstname = JOptionPane.showInputDialog("Enter your first name"); // Get the first name of the customer
            String lastname = JOptionPane.showInputDialog("Enter your last name"); // Get the last name of the customer
            String email = JOptionPane.showInputDialog("Enter your email address"); // Get the email address of the customer
            String address = JOptionPane.showInputDialog("Enter your address"); // Get the address of the customer
            int custNo = customers.size() + 1; // Generate a customer number
            JOptionPane.showMessageDialog(null, "Sign up successful"); // Display a message to confirm the customer has been added

            Customer customer = new Customer(firstname, lastname, email, address, custNo); // Create a new customer object
            customers.add(customer); // Add the customer to the array list
            System.out.println(customers);

    }

    private static void employeeMenu() {
        boolean back = false;
        while (!back) {
            String[] options = {"Add Vehicle", "RemoveVehicle","View bookings", "Add Employee", "RemoveEmployee", "View Employees", "Back"};// Menu options
            int choice = JOptionPane.showOptionDialog(null, "Select a option", "Employee Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]); // Display the menu

            switch (choice) {
                case 0 -> addVehicle();
                case 1 -> removeVehicle();
                case 2 -> viewbookings();
                case 3 -> addEmployee();
                case 4 -> removeEmployee();
                case 5 -> viewEmployees();
                case 6 -> back = true;
                default -> JOptionPane.showMessageDialog(null, "Invalid option selected");
            }

        }


    }

    private static void viewEmployees() {
    }

    private static void removeEmployee() {
    }

    private static void addEmployee() {
    }

    private static void viewbookings() {
    }

    private static void removeVehicle() {
        int vehicleId = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of the vehicle you want to remove")); // Get the ID of the vehicle
        for (Vehicle vehicle : fleet) {
            if (vehicle.getId() == vehicleId) {
                fleet.remove(vehicle); // Remove the vehicle from the array list
                JOptionPane.showMessageDialog(null, "Vehicle removed successfully"); // Display a message to confirm the vehicle has been removed
                System.out.println(fleet);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Vehicle not found"); // Display a message if the vehicle is not found

    }

    private static void addVehicle() {
        String[] vehicleTypes = {"City", "Tripper", "Electric", "Van"}; // Vehicle types
        int choice = JOptionPane.showOptionDialog(null, "Select a vehicle type", "Add Vehicle",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, vehicleTypes, vehicleTypes[0]); // Display the vehicle types
        switch(choice) {
            case 0 -> JOptionPane.showMessageDialog(null, "City selected");
            case 1 -> JOptionPane.showMessageDialog(null, "Tripper selected");
            case 2 -> JOptionPane.showMessageDialog(null, "Electric selected");
            case 3 -> JOptionPane.showMessageDialog(null, "Van selected");
        }
        int ID = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of the vehicle")); // Get the ID of the vehicle
        String model = JOptionPane.showInputDialog("Enter the model of the vehicle"); // Get the model of the vehicle
        String regNo = JOptionPane.showInputDialog("Enter the registration number of the vehicle"); // Get the registration number of the vehicle
        String manufacturer = JOptionPane.showInputDialog("Enter the manufacturer of the vehicle"); // Get the manufacturer of the vehicle
        String location = JOptionPane.showInputDialog("Enter the location of the vehicle"); // Get the location of the vehicle
        int vehicleId = fleet.size() + 1; // Generate a vehicle number
        JOptionPane.showMessageDialog(null, "Vehicle added successfully"); // Display a message to confirm the vehicle has been added

        Vehicle vehicle = new Vehicle(ID, model, regNo, manufacturer, null, location) {
            @Override
            public double calculateRate(int hours, int km) {
                return 0;
            }
        }; // Create a new vehicle object
        fleet.add(vehicle); // Add the vehicle to the array list
        System.out.println(fleet);

    }
}