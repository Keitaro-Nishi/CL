package jp.co.gyosei.botlog;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jp.co.gyosei.botlog.impl.CustinfoEntityImpl;

public class LoginUserDetails implements UserDetails{

	private static final long serialVersionUID = 1L;

	private CustinfoEntityImpl custinfoEntityImpl;

	//��������ۑ����܂�
	@Autowired
	private Collection<GrantedAuthority> role;

	//�R���X�g���N�^�ł��B
	public LoginUserDetails(
			CustinfoEntityImpl x_custinfoEntityImpl, Collection<GrantedAuthority> role
			){
		this.custinfoEntityImpl = x_custinfoEntityImpl;
		this.role = role;
	}

	public LoginUserDetails(LoginCust role, Collection<GrantedAuthority> authorities) {
		// TODO �����������ꂽ�R���X�g���N�^�[�E�X�^�u
	}

	//�ǂ̗�����[�U�[���Ƃ��Ďg���̂�
	@Override
	public String getUsername() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return custinfoEntityImpl.getCustid();
	}
	
	//�ǂ̗���p�X���[�h�Ƃ��Ďg���̂�
	@Override
	public String getPassword() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return custinfoEntityImpl.getPassword();
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

	@Override
	public boolean isEnabled() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return false;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}

	public Collection<GrantedAuthority> getAuthority() {
		return role;
	}

	public void setAuthority(Collection<GrantedAuthority> role) {
		this.role = role;
	}

}