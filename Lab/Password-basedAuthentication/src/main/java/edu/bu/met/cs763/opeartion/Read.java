package main.java.edu.bu.met.cs763.opeartion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Name: Donghang He
 * Date: 2021/3/29 10:39 下午
 * Course: CS-665
 * Assignment
 * Description:
 */
public class Read {

    public String readInfo() {

        StringBuilder info = new StringBuilder();

        try {
            BufferedReader in = new BufferedReader(new FileReader("database.txt"));
            String str;
            while ((str = in.readLine()) != null) {
                info.append(str);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return info.toString();
    }
}
