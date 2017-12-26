package jp.co.gyosei.botlog;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
public abstract class LoginUserDetails implements UserDetails{

	private LoginCust cust;

	//��������ۑ����܂�
	private Collection<GrantedAuthority> role;

	//�R���X�g���N�^�ł��B
	public LoginUserDetails(
			LoginCust custid, Collection<GrantedAuthority> role
			){
		this.cust = custid;
		this.setRole(role);
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
}