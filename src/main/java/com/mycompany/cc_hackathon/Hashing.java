/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cc_hackathon;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author User
 */
public class Hashing {
    public static String hash(String s) throws NoSuchAlgorithmException {
        MessageDigest msgDgst = MessageDigest.getInstance("SHA-256");
        byte[] hash = msgDgst.digest(s.getBytes(StandardCharsets.UTF_8));
        
        BigInteger no = new BigInteger(1, hash);
        StringBuilder hexStr = new StringBuilder(no.toString(16));
        
        while (hexStr.length() < 32) {
            hexStr.insert(0, '0');
        }
         
        return hexStr.toString().substring(0, 50);
    }
}
