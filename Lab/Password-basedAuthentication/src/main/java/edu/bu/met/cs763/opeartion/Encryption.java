package main.java.edu.bu.met.cs763.opeartion;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

/**
 * Name: Donghang He
 * Date: 2021/3/29 9:23 下午
 * Course: CS-763
 * Lab 3
 * Description:
 */
public class Encryption {

    public String generateStrongPwdHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {

        int iterations = 1000;
        char[] chars = password.toCharArray();
        byte[] salt = getSalt();

        PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = skf.generateSecret(spec).getEncoded();
        return toHex(salt) + ":" + toHex(hash);
    }

    public boolean validatePassword(String originalPwd, String storedPwd, String saltO) throws InvalidKeySpecException, NoSuchAlgorithmException {

        int iterations = 1000;
        byte[] salt = fromHex(saltO);
        byte[] hash = fromHex(storedPwd);

        PBEKeySpec spec = new PBEKeySpec(originalPwd.toCharArray(), salt, iterations, hash.length * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] testHash = skf.generateSecret(spec).getEncoded();

//        int diff = hash.length ^ testHash.length;
//        for (int i = 0; i < hash.length && i < testHash.length; i++) {
//            diff |= hash[i] ^ testHash[i];
//        }

        return Arrays.equals(hash, testHash);
    }

    public byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }

    public String toHex(byte[] array) {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if (paddingLength > 0) {
            return String.format("%0" + paddingLength + "d", 0) + hex;
        } else {
            return hex;
        }
    }

    public byte[] fromHex(String hex) {
        byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte)Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }

        return bytes;
    }
}
