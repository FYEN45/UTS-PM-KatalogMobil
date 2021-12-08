<?php
    require __DIR__. '/connect.php';
    $db = new DB_CONNECT;

    header("Content-Type:application/json");

    $name = $_POST['name'];
    $email = $_POST['email'];
    $phoneNumber = $_POST['phoneNumber'];
    $username = $_POST['username'];
    $password = $_POST['password'];

    $query = mysqli_query($db->connect_DB(), "SELECT * FROM users WHERE username='$username'");
    if(mysqli_num_rows($query) > 0) {
        echo "Registrasi Gagal! Username sudah terdaftar.";
    } else {        
        $query = mysqli_query($db->connect_DB(), "SELECT * FROM users WHERE email='$email'");
        if(mysqli_num_rows($query) > 0) {
            echo "Registrasi Gagal! Email sudah terdaftar.";
        } else {        
            $insert = "INSERT INTO users (`name`, `email`, `phoneNumber`, `username`, `password`) VALUES ('$name', '$email', '$phoneNumber', '$username', '$password')";
            mysqli_query($db->connect_DB(), $insert);
            echo "Registrasi Berhasil!";
        }
    }
    $db->close_DB();
?>