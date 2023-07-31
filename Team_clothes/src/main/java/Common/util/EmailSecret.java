package Common.util;

import java.util.Random;

public class EmailSecret {

	    public static String generateRandomCode(int length) {
	        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	        StringBuilder randomCode = new StringBuilder();
	        Random random = new Random();
	        for (int i = 0; i < length; i++) {
	            randomCode.append(chars.charAt(random.nextInt(chars.length())));
	        }
	        return randomCode.toString();
	    }

	}

