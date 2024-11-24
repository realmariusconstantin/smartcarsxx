package Data;
// Customer class is a subclass of Person class
public class Customer extends Person{
    private int custNo; // Customer number

    public Customer(String firstname, String lastname, String email, String address, int custNo) {
        super(firstname, lastname, email, address);
        this.custNo = custNo; // Set the customer number
    }
}
