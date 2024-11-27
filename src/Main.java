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
    private static ArrayList<SmartCity> cityVehicles = new ArrayList<>();
    private static ArrayList<SmartTripper> tripperVehicles = new ArrayList<>();
    private static ArrayList<SmartElectric> electricVehicles = new ArrayList<>();
    private static ArrayList<SmartVan> vanVehicles = new ArrayList<>();

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
        switch (choice) {
            case 0 -> JOptionPane.showMessageDialog(null, "City selected");
            case 1 -> JOptionPane.showMessageDialog(null, "Tripper selected");
            case 2 -> JOptionPane.showMessageDialog(null, "Electric selected");
            case 3 -> JOptionPane.showMessageDialog(null, "Van selected");
            default -> JOptionPane.showMessageDialog(null, "Invalid option selected");
        }
        if (choice == 0) {
            int vehicleId = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of the City vehicle you want to book")); // Get the ID of the vehicle
            for (Vehicle vehicle : cityVehicles) {
                if (vehicle.getId() == vehicleId) {
                    int custNo = Integer.parseInt(JOptionPane.showInputDialog("Enter your customer number")); // Get the customer number
                    LocalDate pickUpDate = LocalDate.parse(JOptionPane.showInputDialog("Enter the pick up date (yyyy-mm-dd)")); // Get the pick up date
                    LocalTime pickUpTime = LocalTime.parse(JOptionPane.showInputDialog("Enter the pick up time (hh:mm)")); // Get the pick up time
                    LocalDate returnDate = LocalDate.parse(JOptionPane.showInputDialog("Enter the return date (yyyy-mm-dd)")); // Get the return date
                    LocalTime returnTime = LocalTime.parse(JOptionPane.showInputDialog("Enter the return time (hh:mm)")); // Get the return time
                    String pickUpLocation = JOptionPane.showInputDialog("Enter the pick up location"); // Get the pick up location
                    int bookingId = bookings.size() + 1; // Generate a booking number
                    double rate = vehicle.calculateRate((int) Duration.between(LocalDateTime.of(pickUpDate, pickUpTime), LocalDateTime.of(returnDate, returnTime)).toHours(), 0); // Calculate the rate
                    Booking booking = new Booking(bookingId, vehicleId, custNo, pickUpDate, pickUpTime, returnDate, returnTime, pickUpLocation, rate); // Create a new booking object
                    bookings.add(booking); // Add the booking to the array list
                    JOptionPane.showMessageDialog(null, "Booking successful"); // Display a message to confirm the booking has been added
                    System.out.println(bookings);
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Vehicle not found"); // Display a message if the vehicle is not found
        } else if (choice == 1) {
            int vehicleId = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of the Tripper vehicle you want to book")); // Get the ID of the vehicle
            for (Vehicle vehicle : tripperVehicles) {
                if (vehicle.getId() == vehicleId) {
                    int custNo = Integer.parseInt(JOptionPane.showInputDialog("Enter your customer number")); // Get the customer number
                    LocalDate pickUpDate = LocalDate.parse(JOptionPane.showInputDialog("Enter the pick up date (yyyy-mm-dd)")); // Get the pickup date
                    LocalTime pickUpTime = LocalTime.parse(JOptionPane.showInputDialog("Enter the pick up time (hh:mm)")); // Get the pickup time
                    LocalDate returnDate = LocalDate.parse(JOptionPane.showInputDialog("Enter the return date (yyyy-mm-dd)")); // Get the return date
                    LocalTime returnTime = LocalTime.parse(JOptionPane.showInputDialog("Enter the return time (hh:mm)")); // Get the return time
                    String pickUpLocation = JOptionPane.showInputDialog("Enter the pick up location"); // Get the pickup location
                    int bookingId = bookings.size() + 1; // Generate a booking number
                    double rate = vehicle.calculateRate((int) Duration.between(LocalDateTime.of(pickUpDate, pickUpTime), LocalDateTime.of(returnDate, returnTime)).toHours(), 0); // Calculate the rate
                    Booking booking = new Booking(bookingId, vehicleId, custNo, pickUpDate, pickUpTime, returnDate, returnTime, pickUpLocation, rate); // Create a new booking object
                    bookings.add(booking); // Add the booking to the array list
                    JOptionPane.showMessageDialog(null, "Booking successful"); // Display a message to confirm the booking has been added
                    System.out.println(bookings);
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Vehicle not found"); // Display a message if the vehicle is not found
        } else if (choice == 2) {
            int vehicleId = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of the Electric vehicle you want to book")); // Get the ID of the vehicle
            for (Vehicle vehicle : electricVehicles) {
                if (vehicle.getId() == vehicleId) {
                    int custNo = Integer.parseInt(JOptionPane.showInputDialog("Enter your customer number")); // Get the customer number
                    LocalDate pickUpDate = LocalDate.parse(JOptionPane.showInputDialog("Enter the pick up date (yyyy-mm-dd)")); // Get the pick up date
                    LocalTime pickUpTime = LocalTime.parse(JOptionPane.showInputDialog("Enter the pick up time (hh:mm)")); // Get the pick up time
                    LocalDate returnDate = LocalDate.parse(JOptionPane.showInputDialog("Enter the return date (yyyy-mm-dd)")); // Get the return date
                    LocalTime returnTime = LocalTime.parse(JOptionPane.showInputDialog("Enter the return time (hh:mm)")); // Get the return time
                    String pickUpLocation = JOptionPane.showInputDialog("Enter the pick up location"); // Get the pick up location
                    int bookingId = bookings.size() + 1; // Generate a booking number
                    double rate = vehicle.calculateRate((int) Duration.between(LocalDateTime.of(pickUpDate, pickUpTime), LocalDateTime.of(returnDate, returnTime)).toHours(), 0); // Calculate the rate
                    Booking booking = new Booking(bookingId, vehicleId, custNo, pickUpDate, pickUpTime, returnDate, returnTime, pickUpLocation, rate); // Create a new booking object
                    bookings.add(booking); // Add the booking to the array list
                    JOptionPane.showMessageDialog(null, "Booking successful"); // Display a message to confirm the booking has been added
                    System.out.println(bookings);
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Vehicle not found"); // Display a message if the vehicle is not found
        } else if (choice == 3) {
            int vehicleId = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of the Van vehicle you want to book")); // Get the ID of the vehicle
            for (Vehicle vehicle : vanVehicles) {
                if (vehicle.getId() == vehicleId) {
                    int custNo = Integer.parseInt(JOptionPane.showInputDialog("Enter your customer number")); // Get the customer number
                    LocalDate pickUpDate = LocalDate.parse(JOptionPane.showInputDialog("Enter the pick up date (yyyy-mm-dd)")); // Get the pick up date
                    LocalTime pickUpTime = LocalTime.parse(JOptionPane.showInputDialog("Enter the pick up time (hh:mm)")); // Get the pick up time
                    LocalDate returnDate = LocalDate.parse(JOptionPane.showInputDialog("Enter the return date (yyyy-mm-dd)")); // Get the return date
                    LocalTime returnTime = LocalTime.parse(JOptionPane.showInputDialog("Enter the return time (hh:mm)")); // Get the return time
                    String pickUpLocation = JOptionPane.showInputDialog("Enter the pick up location"); // Get the pick up location
                    int bookingId = bookings.size() + 1; // Generate a booking number
                    double rate = vehicle.calculateRate((int) Duration.between(LocalDateTime.of(pickUpDate, pickUpTime), LocalDateTime.of(returnDate, returnTime)).toHours(), 0); // Calculate the rate
                    Booking booking = new Booking(bookingId, vehicleId, custNo, pickUpDate, pickUpTime, returnDate, returnTime, pickUpLocation, rate); // Create a new booking object
                    bookings.add(booking); // Add the booking to the array list
                    JOptionPane.showMessageDialog(null, "Booking successful"); // Display a message to confirm the booking has been added
                    System.out.println(bookings);
                    return;

                }
            }
        }
        JOptionPane.showMessageDialog(null, "Vehicle not found"); // Display a message if the vehicle is not found



    }


    private static void Signup() {
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
            String[] options = {"Add Vehicle", "RemoveVehicle", "View bookings", "Add Employee", "RemoveEmployee", "View Employees", "Back"};// Menu options
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
        switch (choice) {
            case 0 -> {
                JOptionPane.showMessageDialog(null, "City selected");
                int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of the City vehicle")); // Get the ID of the vehicle
                String model = JOptionPane.showInputDialog("Enter the model of the City vehicle"); // Get the model of the vehicle
                String regNo = JOptionPane.showInputDialog("Enter the registration number of the City vehicle"); // Get the registration number of the vehicle
                String manufacturer = JOptionPane.showInputDialog("Enter the manufacturer of the City vehicle"); // Get the manufacturer of the vehicle
                String location = JOptionPane.showInputDialog("Enter the location of the City vehicle"); // Get the location of the vehicle
                SmartCity vehicle = new SmartCity(id, model, regNo, manufacturer, LocalDate.now(), location, 1.0, 100); // Create a new vehicle object
                cityVehicles.add(vehicle); // Add the vehicle to the cityVehicles list
                JOptionPane.showMessageDialog(null, "City Vehicle added successfully"); // Display a message to confirm the vehicle has been added
                System.out.println(cityVehicles);
            }
            case 1 -> {
                JOptionPane.showMessageDialog(null, "Tripper selected");
                int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of the Tripper vehicle")); // Get the ID of the vehicle
                String model = JOptionPane.showInputDialog("Enter the model of the Tripper vehicle"); // Get the model of the vehicle
                String regNo = JOptionPane.showInputDialog("Enter the registration number of the Tripper vehicle"); // Get the registration number of the vehicle
                String manufacturer = JOptionPane.showInputDialog("Enter the manufacturer of the Tripper vehicle"); // Get the manufacturer of the vehicle
                String location = JOptionPane.showInputDialog("Enter the location of the Tripper vehicle"); // Get the location of the vehicle
                SmartTripper vehicle = new SmartTripper(id, model, regNo, manufacturer, LocalDate.now(), location, 1.0, 100); // Create a new vehicle object
                tripperVehicles.add(vehicle); // Add the vehicle to the tripperVehicles list
                JOptionPane.showMessageDialog(null, "Tripper Vehicle added successfully"); // Display a message to confirm the vehicle has been added
                System.out.println(tripperVehicles);
            }
            case 2 -> {
                JOptionPane.showMessageDialog(null, "Electric selected");
                int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of the Electric vehicle")); // Get the ID of the vehicle
                String model = JOptionPane.showInputDialog("Enter the model of the Electric vehicle"); // Get the model of the vehicle
                String regNo = JOptionPane.showInputDialog("Enter the registration number of the Electric vehicle"); // Get the registration number of the vehicle
                String manufacturer = JOptionPane.showInputDialog("Enter the manufacturer of the Electric vehicle"); // Get the manufacturer of the vehicle
                String location = JOptionPane.showInputDialog("Enter the location of the Electric vehicle"); // Get the location of the vehicle
                SmartElectric vehicle = new SmartElectric(id, regNo, manufacturer, model, LocalDate.now(), location, 1.0, 100, 100); // Create a new vehicle object
                electricVehicles.add(vehicle); // Add the vehicle to the electricVehicles list
                JOptionPane.showMessageDialog(null, "Electric Vehicle added successfully"); // Display a message to confirm the vehicle has been added
                System.out.println(electricVehicles);
            }
            case 3 -> {
                JOptionPane.showMessageDialog(null, "Van selected");
                int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of the Van vehicle")); // Get the ID of the vehicle
                String model = JOptionPane.showInputDialog("Enter the model of the Van vehicle"); // Get the model of the vehicle
                String regNo = JOptionPane.showInputDialog("Enter the registration number of the Van vehicle"); // Get the registration number of the vehicle
                String manufacturer = JOptionPane.showInputDialog("Enter the manufacturer of the Van vehicle"); // Get the manufacturer of the vehicle
                String location = JOptionPane.showInputDialog("Enter the location of the Van vehicle"); // Get the location of the vehicle
                SmartVan vehicle = new SmartVan(id, model, regNo, manufacturer, LocalDate.now(), location, 1.0, 100); // Create a new vehicle object
                vanVehicles.add(vehicle); // Add the vehicle to the vanVehicles list
                JOptionPane.showMessageDialog(null, "Van Vehicle added successfully"); // Display a message to confirm the vehicle has been added
                System.out.println(vanVehicles);
            }
            default -> JOptionPane.showMessageDialog(null, "Invalid option selected");
        }
    }
}


//
//int ID = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of the vehicle")); // Get the ID of the vehicle
//String model = JOptionPane.showInputDialog("Enter the model of the vehicle"); // Get the model of the vehicle
//String regNo = JOptionPane.showInputDialog("Enter the registration number of the vehicle"); // Get the registration number of the vehicle
//String manufacturer = JOptionPane.showInputDialog("Enter the manufacturer of the vehicle"); // Get the manufacturer of the vehicle
//String location = JOptionPane.showInputDialog("Enter the location of the vehicle"); // Get the location of the vehicle
//int vehicleId = fleet.size() + 1; // Generate a vehicle number
//        JOptionPane.showMessageDialog(null, "Vehicle added successfully"); // Display a message to confirm the vehicle has been added