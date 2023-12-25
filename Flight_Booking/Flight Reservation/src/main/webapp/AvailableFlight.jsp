<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ page import="Login.FlightBooking" %>
<!DOCTYPE html>
<html>
<head>
    <title>Flight Details</title>
    <style>
        body {
            background-image: url('Availability.jpg');
            background-size: cover;
            background-repeat: no-repeat;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            color: #000; /* Set text color to black */
        }

        /* Style for the flight details box */
        .flight-details-box {
            background-color: rgba(255, 255, 255, 0.7); /* Transparent color */
            border-radius: 10px;
            padding: 20px;
            text-align: center;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin: 20px;
        }

        /* Style for the pop-up container */
        .popup-container {
            position: absolute;
            top: 50px; /* Adjust the top position as needed */
            right: 50px; /* Adjust the right position as needed */
            width: 300px;
            background-color: rgba(255, 255, 255, 0.7); /* Transparent color */
            padding: 20px;
            border: 1px solid #ccc;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
        }

        /* Style for the form inside the pop-up container */
        .popup-form {
            display: flex;
            flex-direction: column;
        }

        /* Style for the "Calculate" button */
        .calculate-button {
            margin-top: 10px;
            align-self: flex-end;
        }

        /* Style for the result div under "Calculate Shortest Path" pop-up */
        #shortestDistanceResult {
            margin-top: 10px;
            color: #000; /* Set text color to black */
        }

        /* Style for "Click to continue" text */
        .click-to-continue {
            margin-top: 10px;
            color: #000; /* Set text color to black */
        }

        /* Style for the continue button */
        .continue-button {
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="flight-details-box">
        <h1>Flight Details</h1>
        <p>These are the flights availability we have  </p>
        <% 
           try {
               String flightDetails = FlightBooking.getFlightDetails();
        %>
               <%= flightDetails %>
        <%
           } catch (Exception e) {
               out.println("An error occurred: " + e.getMessage());
           }
        %>
    </div>
    
    <!-- Pop-up container for city_from and destination form -->
    <div class="popup-container">
        <h2>Calculate Shortest Path</h2>
        <form class="popup-form" action="CalculateShortestPath" method="post">
            <label for="city_from">City From:</label>
            <input type="text" id="city_from" name="city_from" required><br>

            <label for="destination">Destination:</label>
            <input type="text" id="destination" name="destination" required><br>

            <input type="submit" class="calculate-button" value="Calculate">
        </form>
        
        <!-- Add a div to display the shortest distance result below the form -->
        <div id="shortestDistanceResult"></div>

        <!-- "Click to continue" text and "Continue" button -->
        <div class="click-to-continue">
            <p>Click to continue Booking!!</p>
            <form action="Booking.jsp" method="post">
                <input type="submit" class="continue-button" value="Continue">
            </form>
        </div>
    </div>

    <script>
        document.querySelector('.popup-form').addEventListener('submit', function (e) {
            e.preventDefault(); // Prevent the default form submission

            // Get city_from and destination values
            var cityFrom = document.getElementById('city_from').value;
            var destination = document.getElementById('destination').value;

            // Create an XMLHttpRequest
            var xhr = new XMLHttpRequest();
            xhr.open('POST', 'CalculateShortestPath', true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

            // Define a function to handle the response
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    // Handle the response from the servlet
                    var response = xhr.responseText;
                    // Display the shortest distance in the result div
                    document.getElementById('shortestDistanceResult').innerHTML = "<p>Shortest Distance: " + response + "</p>";
                }
            };

            // Send the XMLHttpRequest with form data
            xhr.send('city_from=' + cityFrom + '&destination=' + destination);
        });
    </script>
</body>
</html>
