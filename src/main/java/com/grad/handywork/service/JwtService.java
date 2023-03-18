package com.grad.handywork.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	private static final String SIGN_IN_KEY = "7436773979244226452948404D635166546A576E5A7234753778214125432A46";

	public String extractUsername(String jwtToken) {
		return extractClaim(jwtToken, Claims::getSubject);
	}
	
	public <T> T extractClaim(String jwtToken, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(jwtToken);
		return claimsResolver.apply(claims);
	}
	
	public String generateToken(UserDetails userDetails) {
		return generateToken(new HashMap<>(), userDetails);
	}
	
	public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
		return Jwts
				.builder()
				.setClaims(extraClaims)
				.setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(Long.MAX_VALUE))
				.signWith(getSignInKey(), SignatureAlgorithm.HS256)
				.compact();				
	}
	
	public boolean isTokenValid(String jwToken, UserDetails userDetails) {
		final String username = extractUsername(jwToken);
		return username.equals(userDetails.getUsername()) && !isTokenExpired(jwToken);
	}
	
	private boolean isTokenExpired(String jwToken) {
		return extractExpiration(jwToken).before(new Date());
	}

	private Date extractExpiration(String jwToken) {
		return extractClaim(jwToken, Claims::getExpiration);
	}

	private Claims extractAllClaims(String jwtToken) {
		return Jwts
				.parserBuilder()
				.setSigningKey(getSignInKey())
				.build()
				.parseClaimsJws(jwtToken)
				.getBody();
	}

	private Key getSignInKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SIGN_IN_KEY);
		return Keys.hmacShaKeyFor(keyBytes);
	}
	
}
