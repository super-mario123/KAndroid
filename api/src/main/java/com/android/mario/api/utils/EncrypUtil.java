package com.android.mario.api.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2015/7/10.
 */
public class EncrypUtil {

    public static String makeMD5(String password){

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());

            return new BigInteger(1,md.digest()).toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return password;
    }
}
