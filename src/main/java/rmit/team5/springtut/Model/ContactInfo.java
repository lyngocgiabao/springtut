package rmit.team5.springtut.Model;


import rmit.team5.springtut.Validators.PhoneExistedConstraint;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "contact")
public class ContactInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contactID") // the name here should be the same with the name in databse
    private Long contactID;


    @Column(name = "name")
    private String name;

    @Column(name="phoneNumber")
    private String phoneNumber;

    @Column(name="address")
    private String address;

    @Column(name="age")
    private int age;

    // control + enter for auto generate getter and setter and constructors
    public ContactInfo(String name, String phoneNumber, String address, int age) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.age = age;
    }

    public ContactInfo(long contactID,String name, String phoneNumber, String address, int age) {
        this.contactID = contactID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.age = age;
    }


    public ContactInfo() {} // non-args constructors

    public Long getContactID() {
        return contactID;
    }

    public void setContactID(Long contactID) {
        this.contactID = contactID;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
