package view.appHome;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import services.Navigation;
import util.authenticate.UserAuthentication;

import java.net.URL;
import java.util.ResourceBundle;

public class DesktopStageController implements Initializable {

    @FXML
    private AnchorPane baseAnchorpane;

    @FXML
    private AnchorPane detailAnchorpane;

    @FXML
    private Label userNameLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setStageData();
    }

    @FXML
    private void logout(ActionEvent actionEvent){
        Navigation navigation = new Navigation();
        navigation.logout(baseAnchorpane);
    }
    public void loadHomeDetail(){
        Navigation navigation = new Navigation();
        navigation.loadHomeDetail(detailAnchorpane);
    }

    @FXML
    public void loadHomeDetail(ActionEvent actionEvent){
        loadHomeDetail();
    }
    @FXML
    public void loadVehicleDetail(ActionEvent actionEvent){
        Navigation navigation = new Navigation();
        navigation.loadVehicleDetail(detailAnchorpane);
    }
    @FXML
    public void loadSparePartsDetail(ActionEvent actionEvent){
        Navigation navigation = new Navigation();
        navigation.loadSparePartsDetail(detailAnchorpane);
    }

    @FXML
    public void loaduserDetail(ActionEvent actionEvent){
        Navigation navigation = new Navigation();
        navigation.loaduserDetail(detailAnchorpane);
    }
    @FXML
    public void loadFeedbackDetail(ActionEvent actionEvent){
        Navigation navigation = new Navigation();
        navigation.loadFeedbackDetail(detailAnchorpane);
    }

    @FXML
    public void loadRequestDetail(ActionEvent actionEvent){
        Navigation navigation = new Navigation();
        navigation.loadRequestDetail(detailAnchorpane);
    }

    @FXML
    public void loadNewArrivalsDetail(ActionEvent actionEvent){
        Navigation navigation = new Navigation();
        navigation.loadNewArrivalsDetail(detailAnchorpane);
    }

    private void setStageData(){
        loadHomeDetail();
        userNameLabel.setText("  "+UserAuthentication.getAuthenticatedUser().getuUserName());

    }

}
