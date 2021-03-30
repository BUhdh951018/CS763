package main.java.edu.bu.met.cs763.opeartion;


/**
 * Name: Donghang He
 * Date: 2021/3/29 8:34 下午
 * Course: CS-763
 * Lab 3
 * Description:
 */
public class Check {

    public String checkName(String username) {
        String message = "OK";
        String checkResult = checkNameType(username);
        if (checkResult.length() != 0) {
            message = checkResult;
        }

        return message;
    }

    private String checkNameType(String username) {
        StringBuilder message = new StringBuilder();
        int letter = 0, digit = 0;

        for (Character c: username.toCharArray()) {
            if (Character.isLetter(c)) {
                letter = 1;
            } else if (Character.isDigit(c)) {
                digit = 1;
            }
        }

        if (letter == 0) {
            message.append("Username need contain letter.");
        }

        if (digit == 0) {
            message.append("Username need contain number.");
        }

        return message.toString();
    }
    public String checkPwd(String pwd) {
        String message = "OK";
        if (pwd == null || pwd.length() < 8) {
            return "Minimum length of the password is 8.";
        }
        String checkResult = checkCharType(pwd);
        if (checkResult.length() != 0) {
            message = checkResult;
        }
        return message;
    }

    private String checkCharType(String pwd) {
        StringBuilder message = new StringBuilder();
        int upperCase = 0, lowerCase = 0, digit = 0, other = 0;

        for (Character c : pwd.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperCase = 1;
            } else if (Character.isLowerCase(c)) {
                lowerCase = 1;
            } else if (Character.isDigit(c)) {
                digit = 1;
            } else {
                other = 1;
            }
        }

        if (upperCase == 0) {
            message.append("Password must include 1 upper case letter.\n");
        }

        if (lowerCase == 0) {
            message.append("Password must include 1 lower case letter.\n");
        }

        if (digit == 0) {
            message.append("Password must include 1 digit.\n");
        }

        if (other == 0) {
            message.append("Password must include 1 special character.\n");
        }

        return message.toString();
    }
}
