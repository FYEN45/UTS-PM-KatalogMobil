<?php
    require __DIR__. '/connect.php';
    $db = new DB_CONNECT;
    header("Content-Type:application/json");

    $parameter = array(
        'id' => $_POST['id'],
        'name' => $_POST['name'],
        'email' => $_POST['email'],
        'phoneNumber' => $_POST['phoneNumber'],
        'username' => $_POST['username'],
        'password' => $_POST['password'],
        'action' => $_POST['action']
    );

    if($parameter['action']=="edit"){
        $query = "UPDATE `users` SET 
            `name`='".$parameter['name']."',
            `email`='".$parameter['email']."',
            `phoneNumber`='".$parameter['phoneNumber']."',
            `password`='".$parameter['password']."' 
            WHERE `id`='".$parameter['id']."'";
        if(mysqli_query($db->connect_DB(), $query)){
            header("HTTP/1.1.200");
            echo "Berhasil menambahkan ".$parameter['name'];
        } else {
            echo "Gagal menambahkan ".$parameter['name'];
        }

    } else if ($parameter['action']=="delete"){
        $query = "DELETE FROM `users` WHERE `id`=".$parameter['id'];
        if(mysqli_query($db->connect_DB(),$query)){
            header("HTTP/1.1.200");
            echo "Berhasil menghapus ".$parameter['name'];
        } else {
            header("HTTP/1.1.500");
            echo "Gagal menghapus ".$parameter['name'];
        }
    }
    $db->close_DB();
?>