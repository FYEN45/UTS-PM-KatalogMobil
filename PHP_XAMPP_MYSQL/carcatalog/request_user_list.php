<?php
    require __DIR__. '/connect.php';
    $db = new DB_CONNECT;
    header("Content-Type:application/json");

    $response = array(
        'error' => FALSE,
        'error_text' => "",
        'data' => array(),
    );

    $result = mysqli_query($db->connect_DB(), "SELECT * FROM users");
    if(mysqli_num_rows($result) > 0){
        $hasil = array();
        while($col = mysqli_fetch_assoc($result)){
            $product = array(
                'id' => $col['id'],
                'name' => $col['name'],
                'email' => $col['email'],
                'phoneNumber' => $col['phoneNumber'],
                'username' => $col['username'],
                'password' => $col['password']
            );
            $hasil[$col['id']] = $product;

            header("HTTP/1.1.200");
            $response['error'] = FALSE;
            $response['error_text'] = "Berhasil";
            $response['data'] = $hasil;
        } 
    } else {
        $response['error'] = TRUE;
        $response['error_text'] = "No User is found";
    }

    echo json_encode($response);
?>