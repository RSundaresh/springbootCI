package com.samples.jwtauth.security;

public class SecurityConstants {
	
    public static final String JWT_SECRET = "SecretKeyToGenJWTs";
    public static final long JWT_EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users/sign-up";
 
}
