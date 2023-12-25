<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking</title>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            text-align: center;
        }

        h1 {
            color: #333;
        }

        form {
            max-width: 400px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }

        label {
            display: block;
            text-align: left;
            margin-bottom: 8px;
        }

        input[type="text"],
        input[type="tel"],
        input[type="date"],
        input[type="number"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            background-color: #007BFF;
            color: #fff;
            border: none;
            padding: 12px 20px;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        body {
    background-image: url('flightBooking.jpg');
    background-size: cover;
    background-repeat: no-repeat;
    font-family: Arial, sans-serif;
  }
    </style>
</head>
<body>

<h1 align ="center">Indian Airlines!!!</h1>
<form action="NextPage" method="post">


   
 
        <h1>Flight Reservation</h1>
        <label for="Name">Name:</label>
        <input type="text" id="Name" name="Name" required><br>

        <label for="phone">Phone Number:</label>
        <input type="tel" id="phone" name="phone" pattern="[0-9]{10}" required><br>

        <label for="city_from">City From:</label>
        <input type="text" id="city_from" name="city_from" required><br>

        <label for="destination">destination:</label>
        <input type="text" id="destination" name="destination" required><br>


        <label for="num_seats">Number of Seats:</label>
        <input type="number" id="num_seats" name="num_seats" min="1" required><br>

    <input type="submit" value="Submit">
</form>

    
</body>
</html>