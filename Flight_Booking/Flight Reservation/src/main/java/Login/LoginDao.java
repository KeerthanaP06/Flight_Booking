

package Login;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {

   public boolean insert(User user) throws SQLException {
        Connection con = null;
        boolean result = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Flight", "root", "0602");
            String query = "INSERT INTO Login (UserName, Password) VALUES (?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, user.getUserName());
            pst.setString(2, user.getPassword());
            int rowsAffected = pst.executeUpdate(); // Use executeUpdate() for INSERT queries
            if (rowsAffected > 0) {
                result = true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close resources in the reverse order of acquisition
            if (con != null) {
                con.close();
            }
        }
        return result;
   
}
   public boolean insertDetails(User user) throws SQLException {
       Connection con = null;
       boolean result = false;
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Flight", "root", "0602");
           String query = "INSERT INTO booking (Name,phone,city_from ,destination ,num_seats ) VALUES (?,?,?,?,?)";
           PreparedStatement pst = con.prepareStatement(query);
           pst.setString(1, user.getName());
           pst.setString(2, user.getPhone());
           pst.setString(3, user.getCity_from());
           pst.setString(4, user.getDestination());
           pst.setString(5, user.getNum_seats());
           int rowsAffected = pst.executeUpdate(); // Use executeUpdate() for INSERT queries
           if (rowsAffected > 0) {
               result = true;
           }
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       } finally {
           // Close resources in the reverse order of acquisition
           if (con != null) {
               con.close();
           }
       }
       return result;
  
}
  

   
   
}
