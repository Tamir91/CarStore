package Core;

import java.util.HashSet;
import java.util.Objects;

public class Customer {
    private String idNumber;
    private String fName;
    private String lName;
    private String city;
    private String email;

    private HashSet<Car> customerCars;

    /**
     * Constructor with customer ID only
     * @param idNumber customer ID
     */
    public Customer(String idNumber) {
        this.idNumber = idNumber;
        customerCars = new HashSet<>();
    }

    /**
     * Constructor with all fields
     * @param idNumber customer ID
     * @param fName first name
     * @param lName last name
     * @param city customer city
     * @param email customer email
     */
    public Customer(String idNumber, String fName, String lName, String city, String email) {
        this.idNumber = idNumber;
        this.fName = fName;
        this.lName = lName;
        this.city = city;
        this.email = email;
        customerCars = new HashSet<>();
    }

    // *****************************************************************************************************************
    // GETTERS
    // *****************************************************************************************************************

    public String getIdNumber() {
        return idNumber;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }

    public HashSet<Car> getCarsBought() {
        return customerCars;
    }

    // *****************************************************************************************************************
    // SETTERS
    // *****************************************************************************************************************

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Customer customer = (Customer) o;
        return idNumber.equals(customer.idNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNumber, fName, lName);
    }

    @Override
    public String toString() {
        return "ID Number : " + idNumber + "\n" +
                "First Name : " + fName + "\n" +
                "Email : " + email;
    }

    /**
     * This function add car to customer owning cars.
     * @param c new customer car
     * @return true if added otherwise false
     */
    public boolean addCarToCustomer(Car c) {
        if (customerCars != null && c != null)
            return customerCars.add(c);

        return false;
    }

    /**
     * This function remove car from customer
     * @param c removing car from customer
     * @return true if car removed otherwise false
     */
    public boolean removeCarFromCustomer(Car c) {
        if (customerCars != null && c != null)
            return customerCars.remove(c);

        return false;
    }
}
