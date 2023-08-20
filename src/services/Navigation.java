package services;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.authenticate.UserAuthentication;
import util.utility.AlertPopUp;

import java.io.IOException;

public class Navigation {
    public void logout(AnchorPane baseAnchorpane) {
        try{
            UserAuthentication.setAuthenticatedUser(null);
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/appHome/login.fxml"));
            baseAnchorpane.getChildren().setAll(pane);
        }catch(IOException ex){
        }
    }
    public void loadHomeStage(AnchorPane baseAnchorpane) {
        try{
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/appHome/desktopStage.fxml"));
            baseAnchorpane.getChildren().setAll(pane);

        }catch(IOException ex){
        }
    }
    public void loadHomeDetail(AnchorPane detailAnchorpane) {
        try{
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/appHome/homeDetail.fxml"));
            detailAnchorpane.getChildren().setAll(pane);
        }catch(IOException ex){
        }
    }
    public void loadVehicleDetail(AnchorPane detailAnchorpane) {
        try{
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/vehicleManagement/vehicleDetails.fxml"));
            detailAnchorpane.getChildren().setAll(pane);
        }catch(IOException ex){
        }
    }

    public void loadSparePartsDetail(AnchorPane detailAnchorpane) {
        try{
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/vehicleManagement/sparepartsDetails.fxml"));
            detailAnchorpane.getChildren().setAll(pane);
        }catch(IOException ex){
        }
    }

    public void loaduserDetail(AnchorPane detailAnchorpane) {
        try{
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/userManagement/userDetails.fxml"));
            detailAnchorpane.getChildren().setAll(pane);
        }catch(IOException ex){
            //AlertPopUp.generalError(ex);
        }
    }

    public void loadFeedbackDetail(AnchorPane detailAnchorpane) {
        try{
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/feedbackManagement/feedbackDetails.fxml"));
            detailAnchorpane.getChildren().setAll(pane);
        }catch(IOException ex){
        }
    }

    public void loadRequestDetail(AnchorPane detailAnchorpane) {
        try{
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/requestManagement/requestDetails.fxml"));
            detailAnchorpane.getChildren().setAll(pane);
        }catch(IOException ex){
        }
    }
    public void loadNewArrivalsDetail(AnchorPane detailAnchorpane) {
        try{
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/vehicleManagement/newArrivalsDetails.fxml"));
            detailAnchorpane.getChildren().setAll(pane);
        }catch(IOException ex){
        }
    }


}
