package fr.walid.nazih.security;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.walid.nazih.models.AppUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	private AuthenticationManager authManager;
	
	public JWTAuthenticationFilter(AuthenticationManager authManager) {
		this.authManager = authManager;
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		AppUser user = null;
		
		try {
			user = new ObjectMapper().readValue(request.getInputStream(), AppUser.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		User user = (User) authResult.getPrincipal();
		
		if(user == null) {
			chain.doFilter(request, response);
			return;
		}
		
		String jwtToken = Jwts.builder()
								.setSubject(user.getUsername())
								.setExpiration(new Date(System.currentTimeMillis() + 8_000_000L))
								.signWith(SignatureAlgorithm.HS512, "w95.nazih@gmail.com")
								.claim("roles", user.getAuthorities())
								.compact();
		
		response.addHeader("Authorization", "Bearer " + jwtToken);
		
	}

}
