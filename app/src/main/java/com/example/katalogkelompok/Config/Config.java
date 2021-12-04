package com.example.katalogkelompok.Config;

public interface Config {
    //TODO : entahlah ini buat paan
    public String alamatIP = "192.168.1.13";

    public String userLoginVerification = "http://"+alamatIP+"/carcatalog/user_login_verification.php/";
    public String userRegister = "http://"+alamatIP+"/carcatalog/user_register.php/";
}
