package Login;
import java.sql.*;
import java.util.*;


public class Dijkstra {
    public static class DijkstraResult {
        private int distance;
        private List<String> path;

        public DijkstraResult(int distance, List<String> path) {
            this.distance = distance;
            this.path = path;
        }

        public int getDistance() {
            return distance;
        }

        public List<String> getPath() {
            return path;
        }
    }

    public static DijkstraResult dijkstra(Map<String, Map<String, Integer>> graph, String startNode, String destination) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previousNodes = new HashMap<>();
        Set<String> visitedNodes = new HashSet<>();

        // Initialize distances with infinity
        for (String node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }

        distances.put(startNode, 0);

        while (!visitedNodes.containsAll(graph.keySet())) {
            String currentNode = getClosestNode(distances, visitedNodes);
            visitedNodes.add(currentNode);

            Map<String, Integer> neighbors = graph.get(currentNode);

            for (String neighbor : neighbors.keySet()) {
                int distance = distances.get(currentNode) + neighbors.get(neighbor);

                if (distance < distances.get(neighbor)) {
                    distances.put(neighbor, distance);
                    previousNodes.put(neighbor, currentNode);
                }
            }
        }

        // Build the path from startNode to destination
        List<String> path = buildPath(previousNodes, destination);

        int shortestDistance = distances.get(destination);

        return new DijkstraResult(shortestDistance, path);
    }

    private static String getClosestNode(Map<String, Integer> distances, Set<String> visitedNodes) {
        String closestNode = null;
        int shortestDistance = Integer.MAX_VALUE;

        for (String node : distances.keySet()) {
            int distance = distances.get(node);

            if (distance < shortestDistance && !visitedNodes.contains(node)) {
                closestNode = node;
                shortestDistance = distance;
            }
        }

        return closestNode;
    }

    private static List<String> buildPath(Map<String, String> previousNodes, String destination) {
        List<String> path = new ArrayList<>();
        String currentNode = destination;

        while (currentNode != null) {
            path.add(currentNode);
            currentNode = previousNodes.get(currentNode);
        }

        Collections.reverse(path);

        return path;
    }

    // ... Rest of your code remains the same


/*public class Dijkstra {
    public static int dijkstra(Map<String, Map<String, Integer>> graph, String startNode, String destination) {
        Map<String, Integer> distances = new HashMap<>();
        Set<String> visitedNodes = new HashSet<>();

        // Initialize distances with infinity
        for (String node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }

        distances.put(startNode, 0);

        while (!visitedNodes.containsAll(graph.keySet())) {
            String currentNode = getClosestNode(distances, visitedNodes);
            visitedNodes.add(currentNode);

            Map<String, Integer> neighbors = graph.get(currentNode);

            for (String neighbor : neighbors.keySet()) {
                int distance = distances.get(currentNode) + neighbors.get(neighbor);

                if (distance < distances.get(neighbor)) {
                    distances.put(neighbor, distance);
                }
            }
        }

        return distances.get(destination);
    }

    private static String getClosestNode(Map<String, Integer> distances, Set<String> visitedNodes) {
        String closestNode = null;
        int shortestDistance = Integer.MAX_VALUE;

        for (String node : distances.keySet()) {
            int distance = distances.get(node);

            if (distance < shortestDistance && !visitedNodes.contains(node)) {
                closestNode = node;
                shortestDistance = distance;
            }
        }

        return closestNode;
    }

   /* public static void main(String[] args) {
        // Replace these values with your actual database connection information
        String jdbcUrl = "jdbc:mysql://localhost:3306/Flight";
        String username = "root";
        String password = "0602";
        String startCity = "Salem"; // Replace with the actual start city
        String destinationCity = "Coimbatore"; // Replace with the actual destination city

        // Build the graph from the database
        Map<String, Map<String, Integer>> graph = buildGraphFromDatabase(jdbcUrl, username, password);

        // Calculate the shortest distance
        int shortestDistance = dijkstra(graph, startCity, destinationCity);

        System.out.println("Shortest distance from " + startCity + " to " + destinationCity + ": " + shortestDistance);
    }*/

  public static Map<String, Map<String, Integer>> buildGraphFromDatabase(String jdbcUrl, String username, String password) {
        Map<String, Map<String, Integer>> graph = new HashMap<>();

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password)) {
            String sql = "SELECT city_from, destination, distance FROM flight_details";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String fromCity = rs.getString("city_from");
                String toCity = rs.getString("destination");
                int distance = rs.getInt("distance");

                graph.computeIfAbsent(fromCity, k -> new HashMap<>()).put(toCity, distance);
                graph.computeIfAbsent(toCity, k -> new HashMap<>()).put(fromCity, distance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return graph;
    }
}
