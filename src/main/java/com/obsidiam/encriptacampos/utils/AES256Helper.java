package com.obsidiam.encriptacampos.utils;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class AES256Helper implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(AES256Helper.class);
    private static final long serialVersionUID = -5522378640323921061L;
    private static final String SECRET = "p&k)Omw9!Mt}yUUt_o90CFeA{MOPOZ=]BTvaGJ3}(~(f'p1hr3gQo7Ef:<2Wb";
    private static final String CIPHER = "AES/ECB/PKCS5Padding";
    private static final String ALGORITHM = "AES";
    private static final String ENCODER = "SHA-1";
    private static final int KEY_LENGTH = 16;

    private AES256Helper() {
    }

    public static String encrypt(String valueToBeEncrypted) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            byte[] key = "p&k)Omw9!Mt}yUUt_o90CFeA{MOPOZ=]BTvaGJ3}(~(f'p1hr3gQo7Ef:<2Wb".getBytes(StandardCharsets.UTF_8);
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            cipher.init(1, new SecretKeySpec(key, "AES"));
            return Base64.getEncoder().encodeToString(cipher.doFinal(valueToBeEncrypted.getBytes(StandardCharsets.UTF_8)));
        } catch (IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException var4) {
            log.error(var4.getMessage());
            return null;
        }
    }

    public static String decrypt(String encryptedValue) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            byte[] key = "p&k)Omw9!Mt}yUUt_o90CFeA{MOPOZ=]BTvaGJ3}(~(f'p1hr3gQo7Ef:<2Wb".getBytes(StandardCharsets.UTF_8);
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            cipher.init(2, new SecretKeySpec(key, "AES"));
            return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedValue)), StandardCharsets.UTF_8);
        } catch (IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException var4) {
            log.error(var4.getMessage());
            return null;
        }
    }
}

