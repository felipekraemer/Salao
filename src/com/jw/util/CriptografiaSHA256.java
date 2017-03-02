package com.jw.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author fkraemer
 */
public class CriptografiaSHA256 {

    public static String criptografar(String senha) {
        try {
            if (!senha.equals("")) {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                md.update(senha.getBytes());

                byte byteData[] = md.digest();

                //Converte cada byte da senha para formato hexadecimal
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < byteData.length; i++) {
                    sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
                }

                return sb.toString();
            } else {
                return "";
            }
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(ex.getMessage());
        }
        return "";
    }

}