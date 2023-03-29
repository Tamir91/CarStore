package Core;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Customer {
    private String idNumber;
    private String fName;
    private String lName;
    private String city;
    private String email;

    private HashSet<Car> customer_cars;

    /**
     * Constructor with customer ID only
     * @param idNumber customer ID
     */
    public Customer(String idNumber) {
        this.idNumber = idNumber;
        customer_cars = new HashSet<>();
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
        customer_cars = new HashSet<>();
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
        return "ID Number : " + idNumber +
                "First Name : " + fName +
                "Last Name : " + lName +
                "City : " + city +
                "Email : " + email;
    }

    /**
     * This function adding car to customer owning cars.
     * @param c new customer car
     * @return true if added otherwise false
     */
    public boolean addCarToCustomer(Car c) {
//        if (customer_cars != null && c != null)
//            if (!customer_cars.contains(c) && )
            // TODO remove car from store
        return false;
    }

    /**
     * This function remove car from customer
     * @param c removing car from customer
     * @return true if car removed otherwise false
     */
    public boolean removeCarFromCustomer(Car c) {
        if (customer_cars != null && c != null)
            return customer_cars.remove(c);

        return false;
    }
}
