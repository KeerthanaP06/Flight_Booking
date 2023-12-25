
package Login;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.Statement;




		public class FlightBooking {
			
			       public static String getFlightDetails() {
			           String htmlTable = "<table><tr><th>Flight Number</th><th>From</th><th>Destination</th><th>Distance</th></tr>";

			           try {
			               Class.forName("com.mysql.cj.jdbc.Driver");
			               Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Flight", "root", "0602");
			               Statement stmt = conn.createStatement();
			               ResultSet rs = stmt.executeQuery("SELECT * FROM flight_details");

			               while (rs.next()) {
			                   String flightNumber = rs.getString("flight_number");
			                   String from = rs.getString("city_from");
			                   String destination = rs.getString("destination");
			                   float distance = rs.getFloat("distance");

			                   htmlTable += "<tr><td>" + flightNumber + "</td><td>" + from + "</td><td>" + destination + "</td><td>" + distance + "</td></tr>";
			               }

			               htmlTable += "</table>";

			               rs.close();
			               stmt.close();
			               conn.close();
			           } catch (Exception e) {
			               e.printStackTrace();
			           }

			           return htmlTable;
			       }
		}

