import Data.Booking;
import Data.Customer;
import Data.Employee;
import Data.Vehicle;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Vehicle> fleet = new ArrayList<Vehicle>(); // Create an array list of vehicles
    private static ArrayList<Booking> bookings = new ArrayList<Booking>(); // Create an array list of bookings
    private static ArrayList<Customer> customers = new ArrayList<Customer>(); // Create an array list of customers
    private static ArrayList<Employee> employees = new ArrayList<Employee>(); // Create an array list of employees

    public static void main(String[] args){

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

    private static void employeeMenu() {

    }

    private static void customerMenu() {
    }


}
