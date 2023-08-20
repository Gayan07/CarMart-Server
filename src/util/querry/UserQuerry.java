package util.querry;

public class UserQuerry {
    public static final String LOAD_ALL_USERS = "SELECT * FROM user";
    public static final String LOAD_SPECIFIC_USER = "SELECT * FROM user WHERE uUserName = ?";
    public static final String INSERT_USER_DATA_QUERY = "INSERT INTO user (uFirstName, uLastName, uUserName, uPassword, uAddress, uType, uMobileNumber, uEmailAddress) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_USER_DATA_QUERY = "UPDATE user SET uPassword = ?, uFirstName = ?, uLastName = ?, uAddress = ?, uType = ?, uMobileNumber = ?, uEmailAddress = ? WHERE uUserName = ?";
    public static final String DELETE_USER_DATA_QUERY = "DELETE FROM user WHERE uUserName = ?";
}
