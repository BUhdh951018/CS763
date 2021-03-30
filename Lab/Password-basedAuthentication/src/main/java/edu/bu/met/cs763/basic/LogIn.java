package main.java.edu.bu.met.cs763.basic;

import main.java.edu.bu.met.cs763.opeartion.Match;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Scanner;

/**
 * Name: Donghang He
 * Date: 2021/3/29 9:58 下午
 * Course: CS-763
 * Lab 3
 * Description:
 */
public class LogIn {

    public void logIn() throws InvalidKeySpecException, NoSuchAlgorithmException {
        System.out.println("Log in to the system.");
        System.out.print("Please enter the username:");
        Scanner in = new Scanner(System.in, "UTF-8");
        String username = in.next();
        System.out.println();

        System.out.print("Please enter the password:");
        String pwd = in.next();

        Match match = new Match();
        if (match.pwdMatch(username, pwd)) {
            System.out.println("Log in succeed!");
            System.out.println("Welcome " + username);
            LogOut lo = new LogOut();
            lo.logOut();
        } else {
            System.out.println("Your credential is incorrect!");
        }
    }
}
