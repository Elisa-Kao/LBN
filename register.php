<?php

// Initialize arrays to store email and password information
$emails = [];
$passwords = [];

// Function to register a new user
function registerUser($email, $password) {
    global $emails, $passwords;

    // Check if the email already exists
    if (in_array($email, $emails)) {
        echo "Email already registered. Please choose a different email.";
        return;
    }

    // Add new user to the arrays
    $emails[] = $email;
    $passwords[] = $password;

    echo "Registration successful for email: $email";
}

// Example usage
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Assuming you are submitting the form with POST method

    // Get user input
    $newEmail = $_POST['email'];
    $newPassword = $_POST['password'];

    // Validate input (you should perform more thorough validation)
    if (empty($newEmail) || empty($newPassword)) {
        echo "Both email and password are required.";
    } else {
        // Register the user
        registerUser($newEmail, $newPassword);
    }
}

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Form</title>
</head>
<body>

    <h1>Registration Form</h1>

    <form method="post" action="">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>

        <button type="submit">Register</button>
    </form>

</body>
</html>
