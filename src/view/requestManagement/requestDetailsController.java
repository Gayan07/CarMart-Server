package view.requestManagement;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import model.Request1;
import services.modelServices.RequestService;

import java.net.URL;
import java.util.ResourceBundle;

public class requestDetailsController implements Initializable {

    @FXML
    private AnchorPane detailAnchorpane;

    @FXML
    private TableView<Request1> requestTable;

    @FXML
    private TableColumn<Request1, Integer> rIDColumn;

    @FXML
    private TableColumn<Request1, String> rBrandColumn;

    @FXML
    private TableColumn<Request1, String> rModelColumn;

    @FXML
    private TableColumn<Request1, String> rColourColumn;

    @FXML
    private TableColumn<Request1, String> rCustomerNameColumn;

    @FXML
    private TableColumn<Request1, String> rCustomerEmailColumn;

    @FXML
    private TableColumn<Request1, Integer> rCustomerMobileNumberColumn;

    @FXML
    private TableColumn<Request1, String> rActionColumn;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadDataToTable();
    }

    private void loadDataToTable(){
        RequestService requestService = new RequestService();
        ObservableList<Request1> request1ObservableList = requestService.loadAllRequestData();

        rIDColumn.setCellValueFactory( new PropertyValueFactory<>("rID"));
        rBrandColumn.setCellValueFactory( new PropertyValueFactory<>("rBrandName"));
        rModelColumn.setCellValueFactory( new PropertyValueFactory<>("rModel"));
        rColourColumn.setCellValueFactory( new PropertyValueFactory<>("rColor"));
        rCustomerNameColumn.setCellValueFactory( new PropertyValueFactory<>("rCusName"));
        rCustomerEmailColumn.setCellValueFactory( new PropertyValueFactory<>("rCusEmail"));
        rCustomerMobileNumberColumn.setCellValueFactory( new PropertyValueFactory<>("rContactNo"));
        Callback<TableColumn<Request1, String>, TableCell<Request1, String>> parentCellFactory
                =
                new Callback<TableColumn<Request1, String>, TableCell<Request1, String>>() {
                    @Override
                    public TableCell call(final TableColumn<Request1, String> param) {
                        final TableCell<Request1, String> cell = new TableCell<Request1, String>() {

                            final Button actionBtn = new Button("Mark Read");

                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {
                                    actionBtn.setOnMouseClicked(event -> {
                                        // student = StudentTable.getSelectionModel().getSelectedItem();
                                        //String sID = student.getsID();
                                    });
                                    actionBtn.setOnAction(event -> {

                                    });
                                    setGraphic(actionBtn);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };
        rActionColumn.setCellFactory(parentCellFactory);
        requestTable.setItems(null);
        requestTable.setItems(request1ObservableList);
    }
}
