package fr.walid.nazih.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JWTAuthorizationFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, DELETE");
		response.addHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers, authorization");
		response.addHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin, Access-Control-Allow-Credentials, authorization");
		
		if(request.getMethod().equals("OPTIONS")) {
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			String jwtToken = request.getHeader("Authorization");
			if(jwtToken == null || jwtToken.startsWith("Bearer")) {
				filterChain.doFilter(request, response);
				return;
			} else {
				Claims claims = Jwts.parser()
				.setSigningKey("w95.nazih@gmail.com")
				.parseClaimsJws(jwtToken.replace("Bearer ", ""))
				.getBody();
				
				String username = claims.getSubject();
				List<Map<String, String>> roles =  (List<Map<String, String>>) claims.get("roles");
				List<GrantedAuthority> authorities = new ArrayList<>(); 
				roles.forEach(role -> authorities.add(new SimpleGrantedAuthority(role.get("authority"))));
				
				SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(username, null, authorities));
				
				filterChain.doFilter(request, response);
			}
		}
		
	}

}
