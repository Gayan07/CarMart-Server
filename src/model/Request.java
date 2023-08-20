package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;

public class Request implements Serializable {
    private String name = null;

    public Request(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private transient IntegerProperty rID = null;
    private transient StringProperty rBrandName = null;
    private transient StringProperty rModel = null;
    private transient StringProperty rColor = null;
    private transient StringProperty rCusName = null;
    private transient StringProperty rCusEmail = null;
    private transient IntegerProperty rContactNo = null;

    public Request() {

    }

    public Request(Integer rID, String rBrandName, String rModel, String rColor, String rCusName, String rCusEmail, Integer rContactNo) {
        this.rID = new SimpleIntegerProperty(rID);
        this.rBrandName = new SimpleStringProperty(rBrandName);
        this.rModel = new SimpleStringProperty(rModel);
        this.rColor = new SimpleStringProperty(rColor);
        this.rCusName = new SimpleStringProperty(rCusName);
        this.rCusEmail = new SimpleStringProperty(rCusEmail);
        this.rContactNo = new SimpleIntegerProperty(rContactNo);
    }

    public int getrID() {
        return rID.get();
    }

    public IntegerProperty rIDProperty() {
        return rID;
    }

    public void setrID(int rID) {
        this.rID = new SimpleIntegerProperty(rID);
    }

    public String getrBrandName() {
        return rBrandName.get();
    }

    public StringProperty rBrandNameProperty() {
        return rBrandName;
    }

    public void setrBrandName(String rBrandName) {
        this.rBrandName = new SimpleStringProperty(rBrandName);
    }

    public String getrModel() {
        return rModel.get();
    }

    public StringProperty rModelProperty() {
        return rModel;
    }

    public void setrModel(String rModel) {
        this.rModel = new SimpleStringProperty(rModel);
    }

    public String getrColor() {
        return rColor.get();
    }

    public StringProperty rColorProperty() {
        return rColor;
    }

    public void setrColor(String rColor) {
        this.rColor = new SimpleStringProperty(rColor);
    }

    public String getrCusName() {
        return rCusName.get();
    }

    public StringProperty rCusNameProperty() {
        return rCusName;
    }

    public void setrCusName(String rCusName) {
        this.rCusName = new SimpleStringProperty(rCusName);
    }

    public String getrCusEmail() {
        return rCusEmail.get();
    }

    public StringProperty rCusEmailProperty() {
        return rCusEmail;
    }

    public void setrCusEmail(String rCusEmail) {
        this.rCusEmail = new SimpleStringProperty(rCusEmail);
    }

    public int getrContactNo() {
        return rContactNo.get();
    }

    public IntegerProperty rContactNoProperty() {
        return rContactNo;
    }

    public void setrContactNo(int rContactNo) {
        this.rContactNo = new SimpleIntegerProperty(rContactNo);
    }
}
