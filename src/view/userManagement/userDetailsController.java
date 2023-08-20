package view.userManagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import model.User;
import services.modelServices.UserService;
import util.utility.AlertPopUp;
import util.validation.DataValidation;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

public class userDetailsController implements Initializable {

    @FXML
    private AnchorPane detailAnchorpane;

    @FXML
    private TableView<User> userTable;

    @FXML
    private TableColumn<User, String> uUserNameColumn;

    @FXML
    private TableColumn<User, String> uFirstNameColumn;

    @FXML
    private TableColumn<User, String> uLastNameColumn;

    @FXML
    private TableColumn<User, String> uPasswordColumn;

    @FXML
    private TableColumn<User, String> uAddressColumn;

    @FXML
    private TableColumn<User, String> uTypeColumn;

    @FXML
    private TableColumn<User, Integer> uMobileNoColumn;

    @FXML
    private TableColumn<User, String> uEmailAddress;

    @FXML
    private TextField userNameTextField;

    @FXML
    private TextField uLastNameTextField;

    @FXML
    private TextField uFirstNameTextField;

    @FXML
    private TextField uPasswordTextField;

    @FXML
    private TextField uAddressTextField;

    @FXML
    private TextField uMobileNumberTextField;

    @FXML
    private TextField uEmailAddressTextField;

    @FXML
    private ChoiceBox<String> uTypeChoiceBox;

    @FXML
    private Label uNameLabel;

    @FXML
    private Label uFirstNameLabel;

    @FXML
    private Label uLastNameLabel;

    @FXML
    private Label uMobileNoLabel;

    @FXML
    private Label uPasswordLabel;

    @FXML
    private Label uEmailAddressLabel;

    @FXML
    private Label uTypeLabel;

    @FXML
    private Label uAddressLabel;

    @FXML
    private Button addButton;

    private File staticFile;

    private  User userModel = new User();

    private ObservableList<String> choiceBoxList = FXCollections.observableArrayList("Admin", "Guest");
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        loadUserData();
        uTypeChoiceBox.setValue("Admin");
        uTypeChoiceBox.setItems(choiceBoxList);
    }

    @FXML
    private void imageChooser(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files","*.png"));
        File file = fileChooser.showOpenDialog(null);
        if(file != null){
            System.out.println(file.getAbsolutePath());
            //OMIImageView.setImage();
            staticFile = file;
            Image image = new Image(file.toURI().toString());
            //pictureImageView.setImage(image);
        }
    }

    private void loadUserData(){
        UserService userService = new UserService();
        ObservableList<User> userObservableList = userService.loadALLUserData();

        uUserNameColumn.setCellValueFactory(new PropertyValueFactory<>("uUserName"));
        uFirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("uFirstName"));
        uLastNameColumn.setCellValueFactory(new PropertyValueFactory<>("uLastName"));
        uPasswordColumn.setCellValueFactory(new PropertyValueFactory<>("uPassword"));
        uAddressColumn.setCellValueFactory(new PropertyValueFactory<>("uAddress"));
        uTypeColumn.setCellValueFactory(new PropertyValueFactory<>("uType"));
        uMobileNoColumn.setCellValueFactory(new PropertyValueFactory<>("uMobileNumber"));
        uEmailAddress.setCellValueFactory(new PropertyValueFactory<>("uEmailAddress"));
        userTable.setItems(null);
        userTable.setItems(userObservableList);
    }

    @FXML
    private void loadSelectedUser(){
        try{
            userModel = userTable.getSelectionModel().getSelectedItem();
            userNameTextField.setText(userModel.getuUserName());
            userNameTextField.setEditable(false);
            addButton.setVisible(false);
            uFirstNameTextField.setText(userModel.getuFirstName());
            uLastNameTextField.setText(userModel.getuLastName());
            uPasswordTextField.setText(userModel.getuPassword());
            uMobileNumberTextField.setText("0"+String.valueOf(userModel.getuMobileNumber()));
            uAddressTextField.setText(userModel.getuAddress());
            uEmailAddressTextField.setText(userModel.getuEmailAddress());
        }catch (NullPointerException exception){
        }
    }

    @FXML
    private void addUser(ActionEvent actionEvent){
        clearLabels();
        UserService userService = new UserService();
        User user = new User();
        if(validateData()){
            user.setuFirstName(uFirstNameTextField.getText());
            user.setuLastName(uLastNameTextField.getText());
            user.setuUserName(userNameTextField.getText());
            user.setuPassword(uPasswordTextField.getText());
            user.setuType(uTypeChoiceBox.getValue().toString());
            user.setuAddress(uAddressTextField.getText());
            user.setuMobileNumber(Integer.parseInt(uMobileNumberTextField.getText()));
            user.setuEmailAddress(uEmailAddressTextField.getText());

            if(userService.addUser(user)){
                AlertPopUp.insertSuccesfully("User Added Successfully!");
                clearFields();
                loadUserData();
            }else
                AlertPopUp.insertionFailed("Failed to add User");
        }else{
            validateDataMessage();
        }
    }

    @FXML
    private void updateUser(ActionEvent actionEvent){
        clearLabels();
        UserService userService = new UserService();
        User user = new User();
        if(validateData()){
            user.setuFirstName(uFirstNameTextField.getText());
            user.setuLastName(uLastNameTextField.getText());
            user.setuUserName(userNameTextField.getText());
            user.setuPassword(uPasswordTextField.getText());
            user.setuType(uTypeChoiceBox.getValue().toString());
            user.setuAddress(uAddressTextField.getText());
            user.setuMobileNumber(Integer.parseInt(uMobileNumberTextField.getText()));
            user.setuEmailAddress(uEmailAddressTextField.getText());

            if(userService.updateUser(user)){
                AlertPopUp.insertSuccesfully("User Updated Successfully!");
                clearFields();
                loadUserData();
            }else
                AlertPopUp.insertionFailed("Failed to update User");
        }else{
            validateDataMessage();
        }
    }

    @FXML
    private void deleteUser(){
        if(!(userModel.getuUserName().isEmpty())){
            UserService userService = new UserService();
            Optional<ButtonType> action = AlertPopUp.deleteConfirmation("User");
            if(action.get() == ButtonType.OK){
                if(userService.deleteUser(userModel.getuUserName())){
                    AlertPopUp.deleteSuccesfull("User");
                    loadUserData();
                }else
                    AlertPopUp.deleteFailed("User");
            }else
                loadUserData();

        }
    }

    @FXML
    private void checkUserNameAvailability(){
        ObservableList<User> modelList = userTable.getItems();
        ArrayList<String> userList = new ArrayList<>();
        for(User user: modelList){
            userList.add(user.getuUserName().toLowerCase());
        }
        if(userNameTextField.getText().isEmpty()){
            uNameLabel.setStyle("-fx-text-fill: #ff0000 ");
            uNameLabel.setText("User Name Cannot be empty");
        } else if(userList.contains(userNameTextField.getText().toLowerCase())){
            uNameLabel.setStyle("-fx-text-fill: #ff0000 ");
            uNameLabel.setText("User Name Already Taken!!");
        }else {
            uNameLabel.setStyle("-fx-text-fill: #00B605 ");
            uNameLabel.setText("User Name Available");
        }
    }
    private boolean validateData(){
            if(DataValidation.TextFieldNotEmpty(uFirstNameTextField.getText())
                && DataValidation.TextFieldNotEmpty(uLastNameTextField.getText())
                && DataValidation.TextFieldNotEmpty(userNameTextField.getText())
                && DataValidation.TextFieldNotEmpty(uPasswordTextField.getText())
                && DataValidation.TextFieldNotEmpty(uAddressTextField.getText())
                && DataValidation.TextFieldNotEmpty(String.valueOf(uTypeChoiceBox.getValue()))

                //checking for maximum character limit
                && DataValidation.isValidMaximumLength(uFirstNameTextField.getText(), 45)
                && DataValidation.isValidMaximumLength(uLastNameTextField.getText(), 45)
                && DataValidation.isValidMaximumLength(userNameTextField.getText(), 45)
                && DataValidation.isValidMaximumLength(uPasswordTextField.getText(), 20)
                && DataValidation.isValidMaximumLength(uAddressTextField.getText(), 45)
                && DataValidation.isValidMaximumLength(uEmailAddressTextField.getText(), 45)

                //check for special Data
                && DataValidation.isValidEmail(uEmailAddressTextField.getText())
                && DataValidation.isValidPhoneNo(uMobileNumberTextField.getText())){
                return true;
            }else
                return false;
    }
    private void validateDataMessage(){
        if(!(DataValidation.TextFieldNotEmpty(uFirstNameTextField.getText())
                && DataValidation.TextFieldNotEmpty(uLastNameTextField.getText())
                && DataValidation.TextFieldNotEmpty(userNameTextField.getText())
                && DataValidation.TextFieldNotEmpty(uPasswordTextField.getText())
                && DataValidation.TextFieldNotEmpty(uAddressTextField.getText())
                && DataValidation.TextFieldNotEmpty(String.valueOf(uTypeChoiceBox.getValue())))){

            DataValidation.TextFieldNotEmpty(uFirstNameTextField, uFirstNameLabel, "First Name Cannot be Empty!");
            DataValidation.TextFieldNotEmpty(uLastNameTextField, uLastNameLabel, "Last Name Cannot be Empty!");
            DataValidation.TextFieldNotEmpty(userNameTextField,uNameLabel,"User Name Cannot be empty");
            DataValidation.TextFieldNotEmpty(uPasswordTextField,uPasswordLabel,"Password Cannot be empty");
            DataValidation.TextFieldNotEmpty(uAddressTextField,uAddressLabel,"Address Cannot be empty");
            DataValidation.TextFieldNotEmpty(String.valueOf(uTypeChoiceBox),uTypeLabel,"Type Cannot be empty");
        }

        //checking for maximum character limit
        if (DataValidation.isValidMaximumLength(uFirstNameTextField.getText(), 45)
                && DataValidation.isValidMaximumLength(uLastNameTextField.getText(), 45)
                && DataValidation.isValidMaximumLength(userNameTextField.getText(), 45)
                && DataValidation.isValidMaximumLength(uPasswordTextField.getText(), 20)
                && DataValidation.isValidMaximumLength(uAddressTextField.getText(), 45)
                && DataValidation.isValidMaximumLength(uEmailAddressTextField.getText(), 45)) {

            DataValidation.isValidMaximumLength(uFirstNameTextField.getText(), 45, uFirstNameLabel, "Maximum length exceeded. Character LIMIT45" );
            DataValidation.isValidMaximumLength(uLastNameTextField.getText(), 45, uLastNameLabel, "Maximum length exceeded. Character LIMIT45");
            DataValidation.isValidMaximumLength(userNameTextField.getText(), 45,uNameLabel,"Maximum length exceeded. Character LIMIT45");
            DataValidation.isValidMaximumLength(uPasswordTextField.getText(), 20,uPasswordLabel,"Maximum length exceeded. Character LIMIT20");
            DataValidation.isValidMaximumLength(uAddressTextField.getText(), 45,uAddressLabel,"Maximum length exceeded. Character LIMIT45");
            DataValidation.isValidMaximumLength(uEmailAddressTextField.getText(), 45, uEmailAddressLabel,"Maximum length exceeded. Character LIMIT45");
        }

        //check for special Data
        if (DataValidation.isValidEmail(uEmailAddressTextField.getText())
                && DataValidation.isValidPhoneNo(uMobileNumberTextField.getText())) {

            DataValidation.isValidEmail(uEmailAddressTextField.getText(), uEmailAddressLabel, "Invalid email address");
            DataValidation.isValidPhoneNo(uMobileNumberTextField.getText(), uMobileNoLabel, "Invalid mobile number");
        }
    }

    @FXML
    private void clearFields(){
        uFirstNameTextField.setText("");
        uLastNameTextField.setText("");
        userNameTextField.setText("");
        userNameTextField.setEditable(true);
        addButton.setVisible(true);
        uPasswordTextField.setText("");
        uAddressTextField.setText("");
        uMobileNumberTextField.setText("");
        uEmailAddressTextField.setText("");
        userModel = null;
        clearLabels();
    }

    @FXML
    private void clearLabels(){
        uFirstNameLabel.setText("");
        uLastNameLabel.setText("");
        uNameLabel.setText("");
        uPasswordLabel.setText("");
        uAddressLabel.setText("");
        uMobileNoLabel.setText("");
        uEmailAddressLabel.setText("");
    }

}
