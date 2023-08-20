package services.modelServices;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Request;
import model.Request1;
import model.User;
import util.dbConnection.DBConnection;
import util.querry.RequestQuerry;
import util.querry.UserQuerry;
import util.utility.AlertPopUp;
import util.utility.UtilityMethod;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestService implements Serializable {
    public ObservableList<Request1> loadAllRequestData(){
        Connection conn = DBConnection.Connect();
        ResultSet resultSet = null;
        ObservableList<Request1> request1ObservableList = FXCollections.observableArrayList();
        try{
            resultSet = conn.createStatement().executeQuery(RequestQuerry.LOAD_ALL_REQUEST);
            while(resultSet.next()){
                request1ObservableList.add(new Request1(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getInt(7)));
            }
        }catch (SQLException exception){
            AlertPopUp.sqlQueryError(exception);
        }
        return request1ObservableList;
    }
    public boolean addRequest(Request1 request) {
        System.out.println(request.getrBrandName());
        System.out.println(request.getrModel());
        System.out.println(request.getrColor());
        System.out.println(request.getrCusName());
        System.out.println(request.getrCusEmail());
        System.out.println(request.getrContactNo());

        PreparedStatement psUser = null;
        Connection conn = DBConnection.Connect();
        try {
            psUser = conn.prepareStatement(RequestQuerry.INSERT_REQUEST_DATA_QUERY);
            psUser.setString(1, request.getrBrandName());
            psUser.setString(2, request.getrModel());
            psUser.setString(3, request.getrColor());
            psUser.setString(4, request.getrCusName());
            psUser.setString(5, request.getrCusEmail());
            psUser.setInt(6, request.getrContactNo());
            psUser.execute();
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            AlertPopUp.generalError(exception);
            return false;
        } finally {
            try {
                psUser.close();
            } catch (SQLException ex) {
                AlertPopUp.sqlQueryError(ex);
            }
        }
    }

}
