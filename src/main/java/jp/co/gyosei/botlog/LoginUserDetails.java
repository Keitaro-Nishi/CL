/*
package jp.co.gyosei.botlog;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jp.co.gyosei.botlog.impl.CustinfoEntityImpl;

public class LoginUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private String custid;
	private String password;
    private Collection<GrantedAuthority> role;

    public LoginUserDetails(String custid, String password, Collection<GrantedAuthority> role) {
        super();
        this.custid = custid;
        this.password = password;
        this.role = role;
    }

	public LoginUserDetails(CustinfoEntityImpl cust) {
		// TODO �����������ꂽ�R���X�g���N�^�[�E�X�^�u
	}

	public LoginUserDetails(LoginCust role, Collection<GrantedAuthority> authorities) {
		// TODO �����������ꂽ�R���X�g���N�^�[�E�X�^�u
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
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
}
*/