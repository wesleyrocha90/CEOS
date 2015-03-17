package br.com.ceos.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypter {

  public static String encrypt(String word) {
    String encryptedWord = word;
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
      byte[] hash = messageDigest.digest(word.getBytes());
      StringBuilder hexString = new StringBuilder();
      for (byte b : hash) {
        hexString.append(String.format("%02X", 0xFF & b));
      }
      encryptedWord = hexString.toString();
    } catch (NoSuchAlgorithmException ex) {
      ex.getMessage();
    }
    return encryptedWord;
  }
}
