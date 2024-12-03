import Data.*;

import javax.swing.*;
import java.sql.SQLOutput;
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
    private static ArrayList<SmartCity> cityVehicles = new ArrayList<>(); // Create an array list of city vehicles
    private static ArrayList<SmartTripper> tripperVehicles = new ArrayList<>(); // Create an array list of tripper vehicles
    private static ArrayList<SmartElectric> electricVehicles = new ArrayList<>(); // Create an array list of electric vehicles
    private static ArrayList<SmartVan> vanVehicles = new ArrayList<>(); // Create an array list of van vehicles

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
        if (bookings.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No bookings available"); // Display a message if there are no bookings
        }
        for (Vehicle booking : fleet) {
            JOptionPane.showMessageDialog(null, booking); // Display the booking
        }


    }

    private static void bookVehicle() {
        boolean back = false;
        while (!back) {

            String[] vehicleTypes = {"City", "Tripper", "Electric", "Van", "Back"}; // Vehicle types
            int choice = JOptionPane.showOptionDialog(null, "Select a vehicle type", "Book Vehicle",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, vehicleTypes, vehicleTypes[0]); // Display the vehicle types
            switch (choice) {
                case 0 -> JOptionPane.showMessageDialog(null, "City selected");
                case 1 -> JOptionPane.showMessageDialog(null, "Tripper selected");
                case 2 -> JOptionPane.showMessageDialog(null, "Electric selected");
                case 3 -> JOptionPane.showMessageDialog(null, "Van selected");
                case 4 -> back = true;
                default -> JOptionPane.showMessageDialog(null, "Invalid option selected");
            }

            if (choice == 0) {
                int vehicleId = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of the City vehicle you want to book")); // Get the ID of the vehicle
                for (SmartCity vehicle : cityVehicles) {
                    if (vehicle.getId() == vehicleId) {
                        try {
                            int custNo = Integer.parseInt(JOptionPane.showInputDialog("Enter your customer number")); // Get the customer number

                            LocalDate pickUpDate = LocalDate.parse(JOptionPane.showInputDialog("Enter the pick up date (yyyy-mm-dd)")); // Get the pick up date
                            LocalTime pickUpTime = LocalTime.parse(JOptionPane.showInputDialog("Enter the pick up time (hh:mm)")); // Get the pick up time
                            LocalDate returnDate = LocalDate.parse(JOptionPane.showInputDialog("Enter the return date (yyyy-mm-dd)")); // Get the return date
                            LocalTime returnTime = LocalTime.parse(JOptionPane.showInputDialog("Enter the return time (hh:mm)")); // Get the return time
                            int km = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of km you will be travelling")); // Get the number of km
                            String pickUpLocation = JOptionPane.showInputDialog("Enter the pick up location"); // Get the pick up location

                            int bookingId = bookings.size() + 1; // Generate a booking number
                            long hours = Duration.between(LocalDateTime.of(pickUpDate, pickUpTime), LocalDateTime.of(returnDate, returnTime)).toHours(); // Calculate the number of hours
                            double rate = vehicle.calculateRate((int) hours, km); // Calculate the rate
                            Booking booking = new Booking(bookingId, vehicleId, custNo, pickUpDate, pickUpTime, returnDate, returnTime, pickUpLocation, rate); // Create a new booking object
                            bookings.add(booking); // Add the booking to the array list
                            JOptionPane.showMessageDialog(null, "Booking successful. Rate " + rate); // Display a message to confirm the booking has been added
                            System.out.println(bookings);
                            System.out.println("hours " + hours + " km " + km);
                            return;
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "Vehicle not found"); // Display a message if the vehicle is not found
            } else if (choice == 1) {
                int vehicleId = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of the Tripper vehicle you want to book")); // Get the ID of the vehicle
                for (SmartTripper vehicle : tripperVehicles) {
                    if (vehicle.getId() == vehicleId) {
                        try {
                            int custNo = Integer.parseInt(JOptionPane.showInputDialog("Enter your customer number")); // Get the customer number
                            LocalDate pickUpDate = LocalDate.parse(JOptionPane.showInputDialog("Enter the pick up date (yyyy-mm-dd)")); // Get the pickup date
                            LocalTime pickUpTime = LocalTime.parse(JOptionPane.showInputDialog("Enter the pick up time (hh:mm)")); // Get the pickup time
                            LocalDate returnDate = LocalDate.parse(JOptionPane.showInputDialog("Enter the return date (yyyy-mm-dd)")); // Get the return date
                            LocalTime returnTime = LocalTime.parse(JOptionPane.showInputDialog("Enter the return time (hh:mm)")); // Get the return time
                            int km = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of km you will be travelling")); // Get the number of km
                            String pickUpLocation = JOptionPane.showInputDialog("Enter the pick up location"); // Get the pickup location
                            int bookingId = bookings.size() + 1; // Generate a booking number
                            long hours = Duration.between(LocalDateTime.of(pickUpDate, pickUpTime), LocalDateTime.of(returnDate, returnTime)).toHours(); // Calculate the number of hours
                            double rate = vehicle.calculateRate((int) hours, km); // Calculate the rate

                            Booking booking = new Booking(bookingId, vehicleId, custNo, pickUpDate, pickUpTime, returnDate, returnTime, pickUpLocation, rate); // Create a new booking object
                            bookings.add(booking); // Add the booking to the array list
                            JOptionPane.showMessageDialog(null, "Booking successful"); // Display a message to confirm the booking has been added
                            System.out.println(bookings);
                            return;
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                }


                JOptionPane.showMessageDialog(null, "Vehicle not found"); // Display a message if the vehicle is not found
            } else if (choice == 2) {
                int vehicleId = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of the Electric vehicle you want to book")); // Get the ID of the vehicle
                for (SmartElectric vehicle : electricVehicles) {
                    if (vehicle.getId() == vehicleId) {
                        try {
                            int custNo = Integer.parseInt(JOptionPane.showInputDialog("Enter your customer number")); // Get the customer number
                            LocalDate pickUpDate = LocalDate.parse(JOptionPane.showInputDialog("Enter the pick up date (yyyy-mm-dd)")); // Get the pick up date
                            LocalTime pickUpTime = LocalTime.parse(JOptionPane.showInputDialog("Enter the pick up time (hh:mm)")); // Get the pick up time
                            LocalDate returnDate = LocalDate.parse(JOptionPane.showInputDialog("Enter the return date (yyyy-mm-dd)")); // Get the return date
                            LocalTime returnTime = LocalTime.parse(JOptionPane.showInputDialog("Enter the return time (hh:mm)")); // Get the return time
                            int km = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of km you will be travelling")); // Get the number of km
                            String pickUpLocation = JOptionPane.showInputDialog("Enter the pick up location"); // Get the pick up location
                            int bookingId = bookings.size() + 1; // Generate a booking number
                            long hours = Duration.between(LocalDateTime.of(pickUpDate, pickUpTime), LocalDateTime.of(returnDate, returnTime)).toHours(); // Calculate the number of hours
                            double rate = vehicle.calculateRate((int) hours, km); // Calculate the rate
                            Booking booking = new Booking(bookingId, vehicleId, custNo, pickUpDate, pickUpTime, returnDate, returnTime, pickUpLocation, rate); // Create a new booking object
                            bookings.add(booking); // Add the booking to the array list
                            JOptionPane.showMessageDialog(null, "Booking successful"); // Display a message to confirm the booking has been added
                            System.out.println(bookings);
                            return;
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "Vehicle not found"); // Display a message if the vehicle is not found
            } else if (choice == 3) {
                int vehicleId = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of the Van vehicle you want to book")); // Get the ID of the vehicle
                for (SmartVan vehicle : vanVehicles) {
                    if (vehicle.getId() == vehicleId) {
                        int custNo = Integer.parseInt(JOptionPane.showInputDialog("Enter your customer number")); // Get the customer number
                        LocalDate pickUpDate = LocalDate.parse(JOptionPane.showInputDialog("Enter the pick up date (yyyy-mm-dd)")); // Get the pick up date
                        LocalTime pickUpTime = LocalTime.parse(JOptionPane.showInputDialog("Enter the pick up time (hh:mm)")); // Get the pick up time
                        LocalDate returnDate = LocalDate.parse(JOptionPane.showInputDialog("Enter the return date (yyyy-mm-dd)")); // Get the return date
                        LocalTime returnTime = LocalTime.parse(JOptionPane.showInputDialog("Enter the return time (hh:mm)")); // Get the return time
                        int km = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of km you will be travelling")); // Get the number of km
                        String pickUpLocation = JOptionPane.showInputDialog("Enter the pick up location"); // Get the pick up location
                        int bookingId = bookings.size() + 1; // Generate a booking number
                        long hours = Duration.between(LocalDateTime.of(pickUpDate, pickUpTime), LocalDateTime.of(returnDate, returnTime)).toHours(); // Calculate the number of hours
                        double rate = vehicle.calculateRate((int) hours, km); // Calculate the rate
                        Booking booking = new Booking(bookingId, vehicleId, custNo, pickUpDate, pickUpTime, returnDate, returnTime, pickUpLocation, rate); // Create a new booking object
                        bookings.add(booking); // Add the booking to the array list
                        JOptionPane.showMessageDialog(null, "Booking successful"); // Display a message to confirm the booking has been added
                        System.out.println(bookings);
                        return;

                    }
                }
                JOptionPane.showMessageDialog(null, "Vehicle not found"); // Display a message if the vehicle is not found
            }


        }


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
            String[] options = {"Add Vehicle", "RemoveVehicle", "View bookings", "Add Employee", "RemoveEmployee", "View Employees", "View Customers", "Back"};// Menu options
            int choice = JOptionPane.showOptionDialog(null, "Select a option", "Employee Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]); // Display the menu

            switch (choice) {
                case 0 -> addVehicle();
                case 1 -> removeVehicle();
                case 2 -> viewbookings();
                case 3 -> addEmployee();
                case 4 -> removeEmployee();
                case 5 -> viewEmployees();
                case 6 -> viewCustomers();
                case 7 -> back = true;
                default -> JOptionPane.showMessageDialog(null, "Invalid option selected");
            }

        }


    }

    private static void viewCustomers() {
        try {
            if (customers.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No customers listed"); // Display a message if there are no customers
            }

            for (Customer customer : customers) {
                JOptionPane.showMessageDialog(null, customer); // Display the customer
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid Input"); // Display a message if the customer is not found
        }

    }

    private static void viewEmployees() {

        if (employees.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No employees listed"); // Display a message if there are no employees
        }
        for (Employee employee : employees) {
            JOptionPane.showMessageDialog(null, employee); // Display the employee
        }

    }

    private static void removeEmployee() {
        try {
            if (employees.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No employees to remove"); // Display a message if there are no employees
            }
            int empNo = Integer.parseInt(JOptionPane.showInputDialog("Enter the employee number you want to remove")); // Get the employee number
            for (Employee employee : employees) {
                if (employee.getEmpNo() == empNo) {
                    employees.remove(employee); // Remove the employee from the array list
                    JOptionPane.showMessageDialog(null, "Employee removed successfully"); // Display a message to confirm the employee has been removed
                    System.out.println(employees);
                    return;

                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid Input"); // Display a message if the employee is not found
        }


        JOptionPane.showMessageDialog(null, "Employee not found"); // Display a message if the employee is not found
    }

    private static void addEmployee() {
        try {
            String firstname = JOptionPane.showInputDialog("Enter the first name of the employee"); // Get the first name of the employee
            String lastname = JOptionPane.showInputDialog("Enter the last name of the employee"); // Get the last name of the employee
            String email = JOptionPane.showInputDialog("Enter the email address of the employee"); // Get the email address of the employee
            String address = JOptionPane.showInputDialog("Enter the address of the employee"); // Get the address of the employee
            int empNo = employees.size() + 1; // Generate an employee number
            JOptionPane.showMessageDialog(null, "Employee added successfully"); // Display a message to confirm the employee has been added

            Employee employee = new Employee(firstname, lastname, email, address, empNo); // Create a new employee object
            employees.add(employee); // Add the employee to the array list
            System.out.println(employees);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid Input"); // Display a message if the employee is not found

        }
    }

    private static void viewbookings() {
        if (bookings.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No bookings available"); // Display a message if there are no bookings
        }
        for (Booking booking : bookings) {
            JOptionPane.showMessageDialog(null, booking); // Display the booking
        }
    }

    private static void removeVehicle() {
        if (fleet.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No vehicles to remove"); // Display a message if there are no vehicles
        }

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

    private static String addVehicle() {
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
                String[] locations = {"Nenagh", "Limerick", "Ennis", "Shannon", "Foynes"}; // Get the location of the vehicle
                String location = "";
                int LocationChoice = JOptionPane.showOptionDialog(null, "Select a location", "Add Vehicle",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, locations, locations[0]); // Display the vehicle types
                switch (LocationChoice) {

                    case 0 -> location += locations[0];

                    case 1 -> location += locations[1];

                    case 2 -> location += locations[2];

                    case 3 -> location += locations[3];

                    case 4 -> location += locations[4];

                    default -> JOptionPane.showMessageDialog(null, "Invalid option selected");
                }
                double engine = Double.parseDouble(JOptionPane.showInputDialog("Enter the engine size of the City vehicle")); // Get the engine size of the vehicle
                int co2 = Integer.parseInt(JOptionPane.showInputDialog("Enter the CO2 emissions of the City vehicle")); // Get the CO2 emissions of the vehicle
                SmartCity vehicle = new SmartCity(id, model, regNo, manufacturer, LocalDate.now(), new String[]{location}, engine, co2); // Create a new vehicle object
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
                String[] locations = {"Nenagh", "Limerick", "Ennis", "Shannon", "Foynes"}; // Get the location of the vehicle
                String location = "";
                int LocationChoice = JOptionPane.showOptionDialog(null, "Select a location", "Add Vehicle",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, locations, locations[0]); // Display the vehicle types
                switch (LocationChoice) {

                    case 0 -> location += locations[0];

                    case 1 -> location += locations[1];

                    case 2 -> location += locations[2];

                    case 3 -> location += locations[3];

                    case 4 -> location += locations[4];

                    default -> JOptionPane.showMessageDialog(null, "Invalid option selected");
                }
                double engine = Double.parseDouble(JOptionPane.showInputDialog("Enter the engine size of the City vehicle")); // Get the engine size of the vehicle
                int co2 = Integer.parseInt(JOptionPane.showInputDialog("Enter the CO2 emissions of the City vehicle")); // Get the CO2 emissions of the vehicle
                SmartTripper vehicle = new SmartTripper(id, model, regNo, manufacturer, LocalDate.now(), new String[]{location}, engine, co2); // Create a new vehicle object
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
                String[] locations = {"Nenagh", "Limerick", "Ennis", "Shannon", "Foynes"}; // Get the location of the vehicle
                int LocationChoice = JOptionPane.showOptionDialog(null, "Select a location", "Add Vehicle",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, locations, locations[0]); // Display the vehicle types
                String location = "";
                switch (LocationChoice) {

                    case 0 -> location += locations[0];

                    case 1 -> location += locations[1];

                    case 2 -> location += locations[2];

                    case 3 -> location += locations[3];

                    case 4 -> location += locations[4];

                    default -> JOptionPane.showMessageDialog(null, "Invalid option selected");
                }
                double battery = Double.parseDouble(JOptionPane.showInputDialog("Enter the battery size of the Electric vehicle")); // Get the battery size of the vehicle
                int range = Integer.parseInt(JOptionPane.showInputDialog("Enter the range of the Electric vehicle")); // Get the range of the vehicle
                int efficiency = Integer.parseInt(JOptionPane.showInputDialog("Enter the efficiency of the Electric vehicle")); // Get the efficiency of the vehicle
                SmartElectric vehicle = new SmartElectric(id, regNo, manufacturer, model, LocalDate.now(), new String[]{location}, battery, range, efficiency); // Create a new vehicle object
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
                String[] locations = {"Nenagh", "Limerick", "Ennis", "Shannon", "Foynes"}; // Get the location of the vehicle
                String location = "";
                int LocationChoice = JOptionPane.showOptionDialog(null, "Select a location", "Add Vehicle",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, locations, locations[0]); // Display the vehicle types
                switch (LocationChoice) {

                    case 0 -> location += locations[0];

                    case 1 -> location += locations[1];

                    case 2 -> location += locations[2];

                    case 3 -> location += locations[3];

                    case 4 -> location += locations[4];

                    default -> JOptionPane.showMessageDialog(null, "Invalid option selected");
                }
                double engine = Double.parseDouble(JOptionPane.showInputDialog("Enter the engine size of the City vehicle")); // Get the engine size of the vehicle
                int co2 = Integer.parseInt(JOptionPane.showInputDialog("Enter the CO2 emissions of the City vehicle")); // Get the CO2 emissions of the vehicle
                SmartVan vehicle = new SmartVan(id, model, regNo, manufacturer, LocalDate.now(), new String[]{location}, engine, co2); // Create a new vehicle object
                vanVehicles.add(vehicle); // Add the vehicle to the vanVehicles list
                JOptionPane.showMessageDialog(null, "Van Vehicle added successfully"); // Display a message to confirm the vehicle has been added
                System.out.println(vanVehicles);
            }
            default -> JOptionPane.showMessageDialog(null, "Invalid option selected");
        }
        return null;
    }
}
