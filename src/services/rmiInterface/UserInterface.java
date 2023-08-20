package services.rmiInterface;

import javafx.collections.ObservableList;
import model.User;

public interface UserInterface {
    ObservableList<User> loadALLUserData();
    User loadSpecificUser(String userID);
    Boolean addUser(User user);
    Boolean updateUser(User user);
    Boolean deleteUser(String userID);
}
