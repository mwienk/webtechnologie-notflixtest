package model;

import java.math.BigInteger;
import java.security.SecureRandom;

public final class Token {
	
	private static final SecureRandom RANDOM = new SecureRandom();
	
	public static String createToken() {
		return new BigInteger(130, RANDOM).toString(32);
	}
	
	public static boolean isAuthenticated(String token) {
		return Repository.getUserByToken(token) != null;
	}
}
