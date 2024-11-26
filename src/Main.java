import Data.*;

import javax.swing.*;
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
//                case 2 -> viewBookings();
                case 3 -> back = true;
                default -> JOptionPane.showMessageDialog(null, "Invalid option selected");
            }

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
            int vehicleId = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of the vehicle")); // Get the ID of the vehicle
            String date = JOptionPane.showInputDialog("Enter the date of the booking (yyyy-mm-dd)"); // Get the date of the booking
            String time = JOptionPane.showInputDialog("Enter the time of the booking (hh:mm)"); // Get the time of the booking
            String location = JOptionPane.showInputDialog("Enter the location of the booking"); // Get the location of the booking
            int km = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of km you will be travelling")); // Get the number of km the customer will be travelling
            int hours = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of hours you will be renting the vehicle")); // Get the number of hours the customer will be renting the vehicle
            int custNo = Integer.parseInt(JOptionPane.showInputDialog("Enter your customer number")); // Get the customer number
            int bookingId = bookings.size() + 1; // Generate a booking number
            JOptionPane.showMessageDialog(null, "Booking successful"); // Display a message to confirm the booking has been added

            Booking booking = new Booking(bookingId, vehicleId, custNo, null, null, null, null, location) {
                @Override
                public String toString() {
                    return super.toString();
                }
            }; // Create a new booking object




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
            String[] options = {"Add Vehicle", "View bookings", "view customers", "View vehicles", "View Employees", "Back"};// Menu options
            int choice = JOptionPane.showOptionDialog(null, "Select a option", "Employee Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]); // Display the menu

            switch (choice) {
                case 0 -> addVehicle();
//                case 1 -> removeVehicle();
//                case 2 -> viewbookings();
//                case 3 -> addEmployee();
//                case 4 -> removeEmployee();
//                case 5 -> viewEmployees();
                case 6 -> main(null);
                default -> JOptionPane.showMessageDialog(null, "Invalid option selected");
            }

        }


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
            default -> JOptionPane.showMessageDialog(null, "Invalid option selected");
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