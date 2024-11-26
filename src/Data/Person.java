package Data;

public abstract class Person {
    private String firstname; // First name of the person
    private String lastname; // Last name of the person
    private String email; // Email address of the person
    private String address; // Address of the person

    public Person(String firstname, String lastname, String email, String address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
    }

    @Override
    public String toString() {
        return "firstname: " + firstname + "\n" +
                "lastname: " + lastname + "\n" +
                "email: " + email + "\n" +
                "address: " + address + "\n";
    }
}
