package view.appHome;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.User;
import services.Navigation;
import services.modelServices.UserService;
import util.authenticate.UserAuthentication;
import util.validation.DataValidation;

import java.io.IOException;

public class LoginController {

    @FXML
    private AnchorPane baseAnchorpane;

    @FXML
    private TextField uNameTextField;

    @FXML
    private TextField uPasswordTextField;

    @FXML
    private Label uValidationLabel;

    @FXML
    private void showData(ActionEvent event){
        uValidationLabel.setText(uNameTextField.getText()+" is invalid");
    }


    public void loadHome(){
        Navigation navigation = new Navigation();
        navigation.loadHomeStage(baseAnchorpane);
    }

    @FXML
    public void loginUser(ActionEvent actionEvent){
        if(fieldValidation()){
            String authenticateMessage = UserAuthentication.authenticateUser(uNameTextField.getText(), uPasswordTextField.getText());
            if(authenticateMessage.equals("success"))
                loadHome();
            else
                uValidationLabel.setText(authenticateMessage);
        }else
            fieldValidationMessage();
    }
    private boolean fieldValidation(){
        return DataValidation.TextFieldNotEmpty(uNameTextField.getText())
                && DataValidation.TextFieldNotEmpty(uPasswordTextField.getText());
    }
    private void fieldValidationMessage(){
         if(!(DataValidation.TextFieldNotEmpty(uNameTextField.getText())
                 && DataValidation.TextFieldNotEmpty(uPasswordTextField.getText()))){
             DataValidation.TextFieldNotEmpty(uNameTextField.getText(),uValidationLabel, "User Name or Password Fields Cannot be Empty");
                      DataValidation.TextFieldNotEmpty(uPasswordTextField.getText(), uValidationLabel, "User Name or Password Fields Cannot be Empty");
         }
    }
}
