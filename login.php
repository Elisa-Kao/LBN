<?php

// Include the registration script to access the arrays
include('register.php');

// Function to authenticate a user
function authenticateUser($email, $password) {
    global $emails, $passwords;

    // Check if the email exists
    $index = array_search($email, $emails);

    if ($index !== false) {
        // Check if the password matches (in a real-world scenario, this should involve password hashing)
        if ($password === $passwords[$index]) {
            // Redirect to Player.html
            header("Location: Player.html");
            exit();
        } else {
            echo "Incorrect password. Please try again.";
        }
    } else {
        echo "Email not found. Please register first.";
    }
}

// Example usage
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Assuming you are submitting the form with POST method

    // Check if the necessary POST data is set
    if (isset($_POST['email']) && isset($_POST['password'])) {
        // Get user input
        $enteredEmail = $_POST['email'];
        $enteredPassword = $_POST['password'];

        // Validate input (you should perform more thorough validation)
        if (empty($enteredEmail) || empty($enteredPassword)) {
            echo "Both email and password are required.";
        } else {
            // Authenticate the user
            authenticateUser($enteredEmail, $enteredPassword);
        }
    } else {
        echo "Invalid form submission.";
    }
}}
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Form</title>
</head>
<body>

    <h1>Login Form</h1>

    <form method="post" action="">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>

        <button type="submit">Login</button>
    </form>

</body>
</html>
