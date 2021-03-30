package main.java.edu.bu.met.cs763.basic;

import java.util.Scanner;

/**
 * Name: Donghang He
 * Date: 2021/3/29 10:49 下午
 * Course: CS-665
 * Assignment
 * Description:
 */
public class LogOut {

    public void logOut() {
        System.out.println("Enter exit to log out");
        Scanner in = new Scanner(System.in, "UTF-8");
        if (in.next().equalsIgnoreCase("exit")) {
            System.out.println("Bye");
        }
    }
}
