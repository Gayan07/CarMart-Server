package services.modelServices;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.ImageView;
import model.User;
import services.rmiInterface.UserInterface;
import util.dbConnection.DBConnection;
import util.querry.UserQuerry;
import util.utility.AlertPopUp;
import util.utility.DataEncryption;
import util.utility.UtilityMethod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService implements UserInterface {
    private ObservableList<User> userObservableList = null;

    public ObservableList<User> loadALLUserData(){

        Connection connection = DBConnection.Connect();
        ResultSet resultSet = null;
        try{
            userObservableList = FXCollections.observableArrayList();
            resultSet = connection.createStatement().executeQuery(UserQuerry.LOAD_ALL_USERS);
            while (resultSet.next()){
                userObservableList.add(new User( resultSet.getString(1),
                        resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),
                        resultSet.getString(5),resultSet.getString(6),resultSet.getInt(7),
                        resultSet.getString(8)));
            }
        }catch(Exception exception){
            //AlertPopUp.generalError(exception);
        }finally {
            try{
                resultSet.close();
            }catch (SQLException ex) {

            }
        }
        return userObservableList;
    }

    @Override
    public User loadSpecificUser(String userID) {
        User user = null;
        Connection connection = DBConnection.Connect();

        try{
            PreparedStatement preparedStatement  = connection.prepareStatement(UserQuerry.LOAD_SPECIFIC_USER);
            preparedStatement.setString(1, userID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user = new User( resultSet.getString(1),
                        resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),
                        resultSet.getString(5),resultSet.getString(6),resultSet.getInt(7),
                        resultSet.getString(8));
            }
        }catch(Exception exception){
            //System.out.println(exception);
        }
        return user;
    }

    @Override
    public Boolean addUser(User user) {
        PreparedStatement psUser = null;
        Connection conn = DBConnection.Connect();
        try{
            psUser = conn.prepareStatement(UserQuerry.INSERT_USER_DATA_QUERY);
            psUser.setString(1,user.getuFirstName());
            psUser.setString(2,user.getuLastName());
            psUser.setString(3, user.getuUserName());
            psUser.setString(4, DataEncryption.passwordEncryption(user.getuPassword()));
            psUser.setString(5, user.getuAddress());
            psUser.setString(6, user.getuType());
            psUser.setInt(7, user.getuMobileNumber());
            psUser.setString(8, user.getuEmailAddress());
            psUser.execute();
             return true;
        }catch(Exception exception){
//            AlertPopUp.generalError(exception);
            return false;
        }finally {
            try{
                psUser.close();
            }catch (SQLException ex) {
                AlertPopUp.sqlQueryError(ex);
            }
        }
    }

    @Override
    public Boolean updateUser(User user) {
        PreparedStatement psUser = null;
        Connection conn = DBConnection.Connect();
        try{
            psUser = conn.prepareStatement(UserQuerry.UPDATE_USER_DATA_QUERY);
            psUser.setString(1, DataEncryption.passwordEncryption(user.getuPassword()));
            psUser.setString(2,user.getuFirstName());
            psUser.setString(3,user.getuLastName());
            psUser.setString(4, user.getuAddress());
            psUser.setString(5, user.getuType());
            psUser.setInt(6, user.getuMobileNumber());
            psUser.setString(7, user.getuEmailAddress());
            psUser.setString(8, user.getuUserName());
            psUser.execute();
            return true;
        }catch(Exception exception){
            System.out.println(exception);
            return false;
        }finally {
            try{
                psUser.close();
            }catch (SQLException ex) {

            }
        }
    }

    @Override
    public Boolean deleteUser(String userID) {

        PreparedStatement psUser = null;
        Connection conn = DBConnection.Connect();
        try{
            psUser = conn.prepareStatement(UserQuerry.DELETE_USER_DATA_QUERY);
            psUser.setString(1, userID);
            psUser.execute();
            return true;
        }catch(Exception exception){
            return false;
        }finally {
            try{
                psUser.close();
            }catch (SQLException ex) {

            }
        }
    }
}
