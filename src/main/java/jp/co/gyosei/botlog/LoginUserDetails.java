/*
package jp.co.gyosei.botlog;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
public abstract class LoginUserDetails implements UserDetails {
	private String custid;
	private String password;
	private Collection<GrantedAuthority> role;

	public LoginUserDetails(String custid, String password, Collection<GrantedAuthority> role) {
		super();
		this.custid = custid;
		this.password = password;
		this.role = role;
	}

	public static UserDetails create(LoginCust cust) {
		List<GrantedAuthority> role = new ArrayList<GrantedAuthority>();
		for(LoginCust auth: cust.getRole()){
			role.add(new SimpleGrantedAuthority(auth.getCustid().getRole()));
		}
		return new LoginUserDetails(cust.getCustid(), cust.getPassword(), role);
	}
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return role();
	}

	private Collection<GrantedAuthority> role() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}

	//�����p�ɁA�ǂ̗�����[�U�[���Ƃ��Ďg���̂���ς��܂��傤
	public String getCustid() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return cust.getCustid();
	}

	//�����p�ɁA�ǂ̗���p�X���[�h�Ƃ��Ďg���̂��ς��܂��傤�B
	@Override
	public String getPassword() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return cust.getPassword();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return true;
	}

	public Collection<GrantedAuthority> getRole() {
		return role;
	}

	public void setRole(Collection<GrantedAuthority> role) {
		this.role = role;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}
}
*/