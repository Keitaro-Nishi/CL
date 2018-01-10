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
	private String custid;
    private String password;
    private Collection<GrantedAuthority> role;

    public LoginUserDetails(String username, String password,
           Collection<GrantedAuthority> authorities) {
        super();
        this.custid = username;
        this.password = password;
        this.role = authorities;
    }

	public LoginUserDetails(CustinfoEntityImpl custinfoEntityImpl) {
		// TODO �����������ꂽ�R���X�g���N�^�[�E�X�^�u
	}

	/**
    * {@link Users}�����ɃC���X�^���X�𐶐����܂��B
    * @param user �������ɂȂ郆�[�U
    * @return
    */
    public static UserDetails create(CustinfoEntityImpl entity) {
        return new LoginUserDetails(entity.getUsername(), entity.getPassword(), entity.getAuthorities());
    }

	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return this.role;
	}

	@Override
	public String getUsername() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return this.custid;
	}
	
	@Override
	public String getPassword() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return this.password;
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