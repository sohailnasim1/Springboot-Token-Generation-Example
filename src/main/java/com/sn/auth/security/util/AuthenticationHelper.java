package com.sn.auth.security.util;

import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.sn.auth.security.Token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class AuthenticationHelper {

	@Value("${secret.key}")
	private String secretKey;
	
	@Value("${signature.algorithm}")
	private String signatureAlgorithm;
	
	@Value("${key.expiration-in-seconds}")
	private String keyExpirationInSeconds;
	
	public static SecretKey getSecretKey(String encodedKey) {
    	return Keys.hmacShaKeyFor(Base64.getDecoder().decode(encodedKey));
    }
    
    public Token generateToken(UserDetails userDetails) {
    	Calendar calendar = Calendar.getInstance();
    	Date issueDate = calendar.getTime();
    	calendar.add(Calendar.SECOND, Integer.parseInt(keyExpirationInSeconds));
    	SecretKey key = getSecretKey(secretKey);
    	Claims claims = Jwts.claims().setSubject(userDetails.getUsername());
    	List<String> roles =  userDetails.getAuthorities().stream().map(ga->ga.getAuthority()).collect(Collectors.toList());
    	if (!roles.isEmpty()) {
    		claims.put("roles", roles);
    	}
    	String tokenId= UUID.randomUUID().toString();
    	String base64EncodedToken = Jwts.builder()
    		    .setIssuer("developer")
    		    .setClaims(claims)
    		    .setExpiration(calendar.getTime())
    		    .setIssuedAt(issueDate)
    		    .setId(tokenId)
    		    .signWith(key, SignatureAlgorithm.valueOf(signatureAlgorithm))
    		    .compact();
    	return new Token(tokenId, base64EncodedToken, issueDate.getTime(), Integer.parseInt(keyExpirationInSeconds));
    }
}
