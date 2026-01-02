package com.chinmayie;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Customer {

    @Id
    @SequenceGenerator(
            name = "cis",
            sequenceName = "cis",  // This should match the name of the sequence in the DB
            allocationSize = 1     // Optional: controls the batch size for IDs, usually set to 1 for sequential IDs
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cis"      // Using the defined sequence generator
    )
    private Long id;          // Unique identifier for each customer

    private String name;
    private Integer age;
    private String email;
    private String phone;     // Changed from Integer to String to handle phone numbers with special characters

    // Constructor with parameters
    public Customer(String name, Integer age, String email, String phone) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    // Default constructor (required by JPA)
    public Customer() {
    }

    // Getters and setters for each field
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Overriding equals and hashCode methods based on the business logic for equality
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) &&
                Objects.equals(age, customer.age) &&
                Objects.equals(email, customer.email) &&
                Objects.equals(phone, customer.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, email, phone);
    }

    // Overriding toString method for better readability of the object
    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
