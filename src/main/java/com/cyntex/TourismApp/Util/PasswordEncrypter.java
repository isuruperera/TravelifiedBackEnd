package com.cyntex.TourismApp.Util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Password encryption utility.
 */
public final class PasswordEncrypter {

    public static final String SERVER_KEY = "aafds2%#jk$%njh%b87JHV&^ghj*&nmb*&jhhgyu(&89&NMBui" +
            "dtgdrg(*&HJGknm,*" +
            "gfdfg(&:LK:MNBasgdjg";

    public static final String SERVER_ADMIN_KEY = "asd097-d7jbkhjad70mb*&jhhgyu(&89&NMBui" +
            "asd0sd7f070asdf70098ffasd09f6" +
            "gfdfg(&:LK:MNBasgdjg";

    private PasswordEncrypter() {

    }

    public static String getsha256Securepassword(String passwordToHash, byte[] salt) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    public static String getsha256Securepassword(String passwordToHash) {

        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
}
