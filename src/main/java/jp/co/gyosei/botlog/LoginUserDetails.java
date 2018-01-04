package jp.co.gyosei.botlog;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import  jp.co.gyosei.botlog.impl.CustinfoEntityImpl;

public class LoginUserDetails implements UserDetails{

	private static final long serialVersionUID = 1L;

	private CustinfoEntityImpl custinfoEntityImpl;

	//��������ۑ����܂�
	private Collection<GrantedAuthority> role;

	//�R���X�g���N�^�ł��B
	public LoginUserDetails(
			CustinfoEntityImpl custid, Collection<GrantedAuthority> role
			){
		this.setCustid(custid);
		this.role = role;
	}

	public Collection<GrantedAuthority> getRole() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return role;
	}

	//�����p�ɁA�ǂ̗���p�X���[�h�Ƃ��Ďg���̂��ς��܂��傤�B
	@Override
	public String getPassword() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return custinfoEntityImpl.getPassword();
	}

	//�����p�ɁA�ǂ̗�����[�U�[���Ƃ��Ďg���̂���ς��܂��傤
	public String getCustid() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return custinfoEntityImpl.getCustid();
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

	public CustinfoEntityImpl getCustinfoEntityImpl() {
		return custinfoEntityImpl;
	}

	public void setCustinfoEntityImpl(CustinfoEntityImpl custinfoEntityImpl) {
		this.custinfoEntityImpl = custinfoEntityImpl;
	}

	public void setRole(Collection<GrantedAuthority> role) {
		this.role = role;
	}

	public void setCustid(CustinfoEntityImpl custid) {
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}

	@Override
	public String getUsername() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}
}