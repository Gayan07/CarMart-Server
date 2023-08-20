package util.querry;

public class RequestQuerry {
    public static final String LOAD_ALL_REQUEST = "SELECT * FROM request";
    public static final String LOAD_SPECIFIC_REQUEST  = "SELECT * FROM request WHERE rID = ?";
    public static final String INSERT_REQUEST_DATA_QUERY = "INSERT INTO request (rBrandName, rModel, rColor, rCusName, rCusEmail, rContactNo) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_REQUEST_DATA_QUERY = "UPDATE request SET rBrandName = ?, rModel = ?, rColor = ?, rCusName = ?, rCusEmail = ?, rContactNo = ? WHERE  rID = ?";
    public static final String DELETE_REQUEST_DATA_QUERY = "DELETE request WHERE rID = ?";


    //public static final String
}
