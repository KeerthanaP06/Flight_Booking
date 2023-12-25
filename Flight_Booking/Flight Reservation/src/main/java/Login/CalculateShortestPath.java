package Login;
import Login.Dijkstra; // Import the Dijkstra class
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet("/CalculateShortestPath")
public class CalculateShortestPath extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CalculateShortestPath() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jdbcUrl = "jdbc:mysql://localhost:3306/Flight";
        String username = "root";
        String password = "0602";

        // Access the graph from the Dijkstra class
        Map<String, Map<String, Integer>> graph = Dijkstra.buildGraphFromDatabase(jdbcUrl, username, password);

        String cityFrom = request.getParameter("city_from");
        String destination = request.getParameter("destination");

        // Perform Dijkstra's algorithm to calculate the shortest path
        Dijkstra.DijkstraResult result = Dijkstra.dijkstra(graph, cityFrom, destination);

        int shortestDistance = result.getDistance();
        List<String> path = result.getPath();

        // Send the shortest path result as a response
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("Shortest Distance: " + shortestDistance);
            out.println("Shortest Path: " + String.join(" -> ", path));
        }
    }

}
