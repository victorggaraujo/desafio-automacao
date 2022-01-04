package app;

public class CustomerFormData {
    private String name;
    private String lastName;
    private String contactFirstName;
    private String phoneNumber;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String employeeNumber;
    private String creditLimit;

    public CustomerFormData(String name, String lastName, String contactFirstName, String phoneNumber, String addressLine1, String addressLine2, String city,
                            String state, String postalCode, String country, String employeeNumber, String creditLimit) {
        this.name = name;
        this.lastName = lastName;
        this.contactFirstName = contactFirstName;
        this.phoneNumber = phoneNumber;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.employeeNumber = employeeNumber;
        this.creditLimit = creditLimit;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public String getCreditLimit() {
        return creditLimit;
    }
}