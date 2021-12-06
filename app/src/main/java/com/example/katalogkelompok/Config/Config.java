package com.example.katalogkelompok.Config;

public interface Config {
    //TODO : Ganti IP
    public String alamatIP = "192.168.137.1";

    public String userLoginVerification = "http://"+alamatIP+"/carcatalog/user_login_verification.php/";
    public String userRegister = "http://"+alamatIP+"/carcatalog/user_register.php/";
    public String requestUserList = "http://"+alamatIP+"/carcatalog/request_user_list.php/";
    public String requestUpdateData = "http://"+alamatIP+"/carcatalog/request_user_update.php/";
}
