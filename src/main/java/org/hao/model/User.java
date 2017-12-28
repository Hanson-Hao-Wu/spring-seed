package org.hao.model;

import java.util.Collection;

import org.hao.enumerate.AccountRole;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Document
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails{


	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String username;
	private String email;
	private String password;
	private DateTime creationTime;
	private DateTime lastUpdatedTime;
	private AccountRole role;

	private boolean active;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthorityUtils.createAuthorityList(role.toString());
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


}
