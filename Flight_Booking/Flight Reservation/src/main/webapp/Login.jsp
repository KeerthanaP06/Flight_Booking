<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to Indian Airlines</title>
    <style>
        body {
            background-image: url('image2.jpg');
            background-size: cover;
            background-repeat: no-repeat;
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            color: #fff; /* Set text color to white */
        }

        h1 {
            margin-top: -5;
            color: #fff;
        }

        .form-container {
            background-color: rgba(255, 255, 255, 0.7); /* Transparent color */
            border-radius: 10px;
            padding: 20px;
            text-align: center;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin: 20px; /* Add margin to separate container from edges */
            align-self: flex-end; /* Align to the right */
        }

        .form-group {
            text-align: center;
            margin: 15px 0;
        }

        .form-group label {
            display: block;
            margin-bottom: 8px;
            color: #555;
        }

        .form-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            margin-bottom: 10px; /* Add margin between input elements */
        }

        .form-group input[type="text"],
        .form-group input[type="password"] {
            background-color: #f0f0f0; /* Light gray background */
            border: 1px solid #ddd; /* Light border */
            transition: border-color 0.3s; /* Smooth transition on hover/focus */
        }

        .form-group input[type="text"]:focus,
        .form-group input[type="password"]:focus {
            border-color: #007BFF; /* Border color on focus */
        }

        .form-group input[type="submit"] {
            background-color: #007BFF;
            color: #fff;
            border: none;
            padding: 12px 20px;
            border-radius: 4px;
            cursor: pointer;
        }

        .form-group input[type="submit"]:hover {
            background-color: #0056b3;
        }

        .about-us-container {
            background-color: #007BFF; /* Bold box color */
            border-radius: 10px;
            padding: 10px;
            align-self: flex-end; /* Align to the right */
            margin-top: 20px;
        }

        .about-us {
            color: #fff;
            text-decoration: none;
            font-size: 16px;
        }

        .about-us:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h1>Welcome to Indian Airlines</h1>
    <div class="form-container">
        <form action="login" method="post" class="form-group">
            <label for="UserName">Username:</label>
            <input type="text" id="UserName" name="UserName" required>

            <label for="Password">Password:</label>
            <input type="password" id="Password" name="Password" required>

            <input type="submit" value="Login">
        </form>
    </div>

    <div class="about-us-container">
        <a href="https://en.wikipedia.org/wiki/Indian_Airlines" class="about-us" target="_blank">About Us</a>
    </div>
</body>
</html>
