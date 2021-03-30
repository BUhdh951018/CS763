package main.java.edu.bu.met.cs763.basic;

import main.java.edu.bu.met.cs763.opeartion.Check;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Scanner;

/**
 * Name: Donghang He
 * Date: 2021/3/29 8:55 下午
 * Course: CS-763
 * Lab 3
 * Description:
 */
public class SignUp {
    public void signUp() throws InvalidKeySpecException, NoSuchAlgorithmException {
        Check check = new Check();
        System.out.println("Sign up new account");
        System.out.println("Please enter username (include letter and number):");
        Scanner in = new Scanner(System.in, "UTF-8");
        String username = in.next();

        // check username
        String checkUsername = check.checkName(username);
        if (!checkUsername.equalsIgnoreCase("OK")) {
            System.out.println(checkUsername);
            signUp();
        }

        System.out.print("Please enter password (min length 8):");
        String pwdFirst = in.next();
        System.out.println();
//        Console con = System.console();
//        String pwdFirst = new String(con.readPassword());

        System.out.print("Please enter password again:");
        String pwdSecond = in.next();
//        String pwdSecond = new String(con.readPassword());
        System.out.println();

        // check password
        if (pwdFirst.equals(pwdSecond)) {
            String result = check.checkPwd(pwdFirst);
            if (!result.equalsIgnoreCase("OK")) {
                System.out.println(result);
                signUp();
            } else {
                System.out.println("Sign up succeed!");
                Save save = new Save();
                save.saveInfo(username, pwdFirst);
            }
        } else {
            System.out.println("Two password entries are not the same");
            signUp();
        }
    }
}
