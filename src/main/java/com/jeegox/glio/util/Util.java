package com.jeegox.glio.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author j2esus <jesus.vargas@jeegox.com>
 */
public class Util {

    public static String encodeSha256(String cadena) {
        StringBuilder sb = new StringBuilder();
        for (byte b : sha256(cadena.getBytes())) {
            sb.append(Integer.toHexString(0x100 + (b & 0xff)).substring(1));
        }
        return sb.toString();
    }

    private static byte[] sha256(byte[] data) {
        MessageDigest sha;
        try {
            sha = MessageDigest.getInstance("SHA-256");
            sha.update(data);
            return sha.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

}
