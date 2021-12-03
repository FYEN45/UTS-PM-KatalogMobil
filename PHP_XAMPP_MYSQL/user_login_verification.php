<?php
    require_once __DIR__. '/connect.php';
    $db = new DB_CONNECT;

    header("Content-Type:application/json");

    $user_login_data = array(
        'username' => $_POST['username'],
        'password' => $_POST['password']
    );

    $response = array(
        'error' => FALSE,
        'error_text' => ""
    );

    $query = mysqli_query($db->connect_DB(), "SELECT * FROM user WHERE username='$username' AND password='".$password."'");
    if(mysqli_num_rows($query) > 0){
        header("HTTP/1.1.200");
        $response['error'] = FALSE;
        $response['error_text'] = "Login Berhasil";
    } else {
        $response['error'] = TRUE;
        $response['error_text'] = "Login Gagal";
    }

    echo json_encode($response);
?>