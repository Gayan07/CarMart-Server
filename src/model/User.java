package model;

import javafx.beans.property.*;
import javafx.scene.image.ImageView;

public class User {

    private String uUserName = null;
    private String uPassword = null;
    private String uFirstName = null;
    private String uLastName = null;
    private String uAddress = null;
    private String uType = null;
    private Integer uMobileNumber = null;
    private String uEmailAddress = null;
    public User() {
    }

    public User(String uUserName, String uPassword, String uFirstName, String uLastName, String uAddress, String uType, Integer uMobileNumber, String uEmailAddress) {
        this.uUserName = uUserName;
        this.uPassword = uPassword;
        this.uFirstName = uFirstName;
        this.uLastName = uLastName;
        this.uAddress = uAddress;
        this.uType = uType;
        this.uMobileNumber = uMobileNumber;
        this.uEmailAddress = uEmailAddress;
    }

    public String getuUserName() {
        return uUserName;
    }

    public StringProperty uUserNameProperty() {

        return new SimpleStringProperty(uUserName);
    }

    public void setuUserName(String uUserName) {
        this.uUserName = uUserName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public StringProperty uPasswordProperty() {

        return new SimpleStringProperty(uPassword);
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getuFirstName() {
        return uFirstName;
    }

    public StringProperty uFirstNameProperty() {

        return new SimpleStringProperty(uFirstName);
    }

    public void setuFirstName(String uFirstName) {
        this.uFirstName = uFirstName;
    }

    public String getuLastName() {
        return uLastName;
    }

    public StringProperty uLastNameProperty() {

        return new SimpleStringProperty(uLastName);
    }

    public void setuLastName(String uLastName) {
        this.uLastName = uLastName;
    }

    public String getuAddress() {
        return uAddress;
    }

    public StringProperty uAddressProperty() {

        return new SimpleStringProperty(uAddress);
    }

    public void setuAddress(String uAddress) {
        this.uAddress = uAddress;
    }

    public String getuType() {
        return uType;
    }

    public StringProperty uTypeProperty() {

        return new SimpleStringProperty(uType);
    }

    public void setuType(String uType) {
        this.uType = uType;
    }

    public Integer getuMobileNumber() {
        return uMobileNumber;
    }

    public IntegerProperty uMobileNumberProperty() {

        return new SimpleIntegerProperty(uMobileNumber);
    }

    public void setuMobileNumber(Integer uMobileNumber) {
        this.uMobileNumber = uMobileNumber;
    }

    public String getuEmailAddress() {
        return uEmailAddress;
    }

    public StringProperty uEmailAddressProperty() {

        return new SimpleStringProperty(uEmailAddress);
    }

    public void setuEmailAddress(String uEmailAddress) {
        this.uEmailAddress = uEmailAddress;
    }
}