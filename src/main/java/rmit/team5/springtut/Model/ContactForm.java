package rmit.team5.springtut.Model;

import rmit.team5.springtut.Validators.PhoneExistedConstraint;

import javax.validation.constraints.*;

// @PhoneExistedConstraint(message = "Server: This phone number is existed") // custom validation

public class ContactForm {


    private Long formID;

    @NotEmpty(message = "Server: Name field is required")
    @Size(max = 200, message = "Server: Name field should have 200 or less characters")
    private String name;

    @NotEmpty(message = "Server: Phone field number is required")
    @Digits(message = "Server: Age should be digits", integer = 10, fraction = 0)
    @PhoneExistedConstraint(message = "Server: This phone number is existed") // custom validation
    private String phoneNumber;

    @NotEmpty(message = "Server: Address field is required")
    private String address;

    @NotNull(message = "Server: Age field is required")
    @Max(message = "Server: Age should be from 0 to 200", value = 200)
    @Min(message = "Server: Age should be from 0 to 200", value = 0)
    private Integer age;

    // control + enter for auto generate getter and setter and constructors

    public ContactForm(String name,  String phoneNumber,  String address, Integer age) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.age = age;
    }

    public ContactForm(long contactID, String name,  String phoneNumber,  String address, Integer age) {
        this.formID = contactID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.age = age;
    }

    public ContactForm() {} // no - args constructor

    // Getter and setters


    public Long getFormID() {
        return formID;
    }

    public void setFormID(Long formID) {
        this.formID = formID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
