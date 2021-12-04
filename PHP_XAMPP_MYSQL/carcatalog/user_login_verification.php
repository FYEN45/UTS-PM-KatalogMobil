<?php
    require __DIR__. '/connect.php';
    $db = new DB_CONNECT;

    header("Content-Type:application/json");

    $username = $_POST['username'];
    $password = $_POST['password'];

    $query = mysqli_query($db->connect_DB(), "SELECT * FROM users WHERE username='$username' AND password='$password'");

    if(mysqli_num_rows($query) > 0){
        header('HTTP/1.1.200');
        $text = "Login Berhasil!";

    } else {
        header('HTTP/1.1.500');
        $text = "Login Gagal!";

    }
    $db->close_DB();
    echo $text;

?>