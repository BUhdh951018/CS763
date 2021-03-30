package main.java.edu.bu.met.cs763;

import main.java.edu.bu.met.cs763.basic.LogIn;
import main.java.edu.bu.met.cs763.basic.SignUp;

import java.util.Scanner;

/**
 * Name: Donghang He
 * Date: 2021/3/29 8:08 下午
 * Course: CS-763
 * LAB 3
 * Description:
 */
public class PasswordApplication {

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        try {
            System.out.println("Password authentication");
            System.out.println("Main menu:");
            System.out.println("1. Sign up\n2. Log in");
            Scanner in = new Scanner(System.in, "UTF-8");

            int type = in.nextInt();
            if (type == 1) {
                SignUp su = new SignUp();
                su.signUp();
                menu();
            } else if (type == 2) {
                LogIn li = new LogIn();
                li.logIn();
            } else {
                System.out.println("Invalid input! Please try again");
                menu();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
