package jp.co.gyosei.botlog;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jp.co.gyosei.botlog.impl.CustinfoEntityImpl;

public class LoginUserDetails implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Collection<GrantedAuthority> role;

	public LoginUserDetails(String custid, String password, Collection<GrantedAuthority> role) {
		super();
		this.role = role;
	}


	public static UserDetails create(CustinfoEntityImpl cust) {
		List<GrantedAuthority> role = new ArrayList<GrantedAuthority>();
		return new LoginUserDetails(cust.getCustid(), cust.getPassword(), role);
	}
	
	@SuppressWarnings("unused")
	private static GrantedAuthority getCustid() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}

	/* (�� Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
	 */
	public Collection<? extends GrantedAuthority> getRole() {
		return this.role;
	}

	@Override
	public String getPassword() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}

	@Override
	public String getUsername() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return false;
	}

	public void setCustid(String custid) {
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}
}