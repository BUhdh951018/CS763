package main.java.edu.bu.met.cs763.opeartion;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Name: Donghang He
 * Date: 2021/3/29 10:04 下午
 * Course: CS-665
 * Assignment
 * Description:
 */
public class Match {

    public boolean pwdMatch(String username, String password) throws InvalidKeySpecException, NoSuchAlgorithmException {
        boolean temp = false;
        Read read = new Read();
        String info = read.readInfo();
        String[] storedPwd = info.split("\\,");
        Encryption encryption = new Encryption();
        if (username.equals(storedPwd[0])) {
            if (encryption.validatePassword(password, storedPwd[2], storedPwd[1])) {
                temp = true;
            }
        }

        return temp;
    }
}
