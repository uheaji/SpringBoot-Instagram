package com.cos.costagram.config.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.cos.costagram.domain.user.User;

import lombok.Data;

@Data
public class PrincipalDetails implements UserDetails, OAuth2User{

	private User user;
	private Map<String, Object> attributes; // OAuth 제공자로 부터 받은 회원 정보
	private boolean isOauth = false;
	
	public PrincipalDetails(User user) {
		this.user = user;
	}
	public PrincipalDetails(User user, Map<String, Object> attributes, boolean isOauth) {
		this.user = user;
		this.attributes = attributes;
		this.isOauth = isOauth;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collectors = new ArrayList<>();
		collectors.add(()->"ROLE_"+user.getRole().toString());
		return collectors;
	}
	@Override
	public Map<String, Object> getAttributes() {
		return attributes;
	}
	
	@Override
	public String getPassword() {
		
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {	
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {	
		return true;
	}

	@Override
	public boolean isEnabled() {		
		return true;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}