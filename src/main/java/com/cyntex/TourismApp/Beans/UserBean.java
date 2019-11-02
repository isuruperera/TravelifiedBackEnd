package com.cyntex.TourismApp.Beans;

public class UserBean {
    private final String email;
    private final String firstName;
    private final String lastName;
    private final String phone;
    private final String country;
    private final String gender;
    private final String imageID;

    public UserBean(String email, String firstName, String lastName, String phone,
                    String country, String gender, String imageID) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.country = country;
        this.gender = gender;
        this.imageID = imageID;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getImageID() {
        return imageID;
    }

    public String getCountry() {
        return country;
    }

    public String getGender() {
        return gender;
    }

}
