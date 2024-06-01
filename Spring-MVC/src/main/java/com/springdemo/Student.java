package com.springdemo;

import com.springdemo.validation.CourseCode;
import jakarta.validation.constraints.*;

import java.util.HashMap;

public class Student {

    private String firstName;
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName;
    private String nationality;
    @Pattern(regexp = "^[A-Za-z0-9]{5}", message = "only 5 chars/digits")
    private String postalCode;
    private String favoriteLanguage;
    @NotNull
    @Min(value = 0, message = "should be greater than 0")
    @Max(value = 10, message = "should be less than 10")
    private Integer backlogs;

    @CourseCode(value = "MEC", message = "should start with MEC")
    private String courseCode;
    private String[] operatingSystem;
    private HashMap<String, String> countryList;

    public Student() {
        countryList = new HashMap<>();
        countryList.put("IN", "India");
        countryList.put("US", "USA");
        countryList.put("UK", "UK");
        countryList.put("CA", "Canada");
        countryList.put("GE", "Germany");
        countryList.put("FR", "France");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public String[] getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String[] operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public Integer getBacklogs() {
        return backlogs;
    }

    public void setBacklogs(Integer backlogs) {
        this.backlogs = backlogs;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public HashMap<String, String> getCountryList() {
        return countryList;
    }
}
