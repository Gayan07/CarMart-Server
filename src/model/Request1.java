package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;

public class Request1 implements Serializable {
    private Integer rID = null;
    private String rBrandName = null;
    private String rModel = null;
    private String rColor = null;
    private String rCusName = null;
    private String rCusEmail = null;
    private Integer rContactNo = null;

    public Request1() {
    }

    public Request1(Integer rID, String rBrandName, String rModel, String rColor, String rCusName, String rCusEmail, Integer rContactNo) {
        this.rID = rID;
        this.rBrandName = rBrandName;
        this.rModel = rModel;
        this.rColor = rColor;
        this.rCusName = rCusName;
        this.rCusEmail = rCusEmail;
        this.rContactNo = rContactNo;
    }

    public Integer getrID() {
        return rID;
    }

    public IntegerProperty rIDProperty() {
        return new SimpleIntegerProperty(rID);
    }

    public void setrID(Integer rID) {
        this.rID = rID;
    }

    public String getrBrandName() {
        return rBrandName;
    }

    public StringProperty rBrandNameProperty() {
        return new SimpleStringProperty(rBrandName);
    }

    public void setrBrandName(String rBrandName) {
        this.rBrandName = rBrandName;
    }

    public String getrModel() {
        return rModel;
    }

    public StringProperty rModelProperty() {
        return new SimpleStringProperty(rModel);
    }

    public void setrModel(String rModel) {
        this.rModel = rModel;
    }

    public String getrColor() {
        return rColor;
    }

    public StringProperty rColorProperty() {
        return new SimpleStringProperty(rColor);
    }

    public void setrColor(String rColor) {
        this.rColor = rColor;
    }

    public String getrCusName() {
        return rCusName;
    }

    public StringProperty rCusNameProperty() {
        return new SimpleStringProperty(rCusName);
    }

    public void setrCusName(String rCusName) {
        this.rCusName = rCusName;
    }

    public String getrCusEmail() {
        return rCusEmail;
    }

    public StringProperty rCusEmailProperty() {
        return new SimpleStringProperty(rCusEmail);
    }

    public void setrCusEmail(String rCusEmail) {
        this.rCusEmail = rCusEmail;
    }

    public Integer getrContactNo() {
        return rContactNo;
    }

    public IntegerProperty rContactNoProperty() {
        return new SimpleIntegerProperty(rContactNo);
    }

   public void setrContactNo(Integer rContactNo) {
        this.rContactNo = rContactNo;
    }


}
