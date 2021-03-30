package main.java.edu.bu.met.cs763.basic;

import main.java.edu.bu.met.cs763.opeartion.Encryption;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Name: Donghang He
 * Date: 2021/3/29 9:21 下午
 * Course: CS-763
 * Lab 3
 * Description:
 */
public class Save {

    public void saveInfo(String username, String password) throws InvalidKeySpecException, NoSuchAlgorithmException {

        // encryption the password using PBKDF2
        Encryption encrypt = new Encryption();
        String[] encryptPwd = encrypt.generateStrongPwdHash(password).split("\\:");

        // get salt and password hex type
        String salt = encryptPwd[0];
        String hashPassword = encryptPwd[1];

        // save to file
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("database.txt"));
            String info = username + "," + salt + "," + hashPassword;
            out.write(info);
            out.close();
            System.out.println("Save succeed!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
