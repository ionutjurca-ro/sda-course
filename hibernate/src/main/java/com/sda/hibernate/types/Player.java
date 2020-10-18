package com.sda.hibernate.types;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

//POJO - plain old java object
@Entity(name = "Player")
@Table(name = "player")
public class Player {

    //variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String username;

    //temporal
    @Column(name = "registration_time")
    private LocalDateTime registrationTime;

    //temporal
    private LocalDate birthDate;

    //primitive
    private int age;

    //enum
    @Enumerated(EnumType.STRING)
    private Status status;

    @Embedded
    private Address address;

    //constructor - needed by hibernate
    public Player() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(LocalDateTime registrationTime) {
        this.registrationTime = registrationTime;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", registrationTime=" + registrationTime +
                ", birthDate=" + birthDate +
                ", age=" + age +
                ", status=" + status +
                ", address=" + address +
                '}';
    }
}
