package net.sf.libgrowl.internal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class Encryption {
  /**
   * get MD5 hash of input value
   * 
   * @param input
   * @return MD5 hash as byte array or <code>null</code>
   */
  public static String md5(final byte[] input) {
    MessageDigest md5;
    try {
      md5 = MessageDigest.getInstance("MD5");
      md5.reset();
      md5.update(input);
      final byte[] result = md5.digest();

      final StringBuilder hexString = new StringBuilder();
      for (int i = 0; i < result.length; i++) {
        hexString.append(Integer.toHexString(0xFF & result[i]));
      }
      // System.out.println("MD5: " + hexString.toString());
      return hexString.toString();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return null;
  }
}
