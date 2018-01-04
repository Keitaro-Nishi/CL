package jp.co.gyosei.botlog;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jp.co.gyosei.botlog.impl.CustinfoEntityImpl;

public class LoginUserDetails implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CustinfoEntityImpl custinfoEntityImpl;

	//��������ۑ����܂�
	@Autowired
	private Collection<GrantedAuthority> authorities;

	//�R���X�g���N�^�ł��B
	public LoginUserDetails(
			CustinfoEntityImpl x_custinfoEntityImpl, Collection<GrantedAuthority> role
			){
		this.custinfoEntityImpl = x_custinfoEntityImpl;
		this.authorities = role;
	}

	public LoginUserDetails(LoginCust role, Collection<GrantedAuthority> authorities2) {
		// TODO �����������ꂽ�R���X�g���N�^�[�E�X�^�u
	}

	//�����p�ɁA�ǂ̗���p�X���[�h�Ƃ��Ďg���̂��ς��܂��傤�B
	@Override
	public String getPassword() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return custinfoEntityImpl.getPassword();
	}

	//�����p�ɁA�ǂ̗�����[�U�[���Ƃ��Ďg���̂���ς��܂��傤
	@Override
	public String getUsername() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return custinfoEntityImpl.getCustid();
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

}