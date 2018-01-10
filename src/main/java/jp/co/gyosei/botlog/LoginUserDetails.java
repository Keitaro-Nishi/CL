package jp.co.gyosei.botlog;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
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

    public LoginUserDetails(String custid, String password,
           Collection<GrantedAuthority> role) {
        super();
        this.custid = custid;
        this.password = password;
        this.role = role;
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
        return new LoginUserDetails(entity.getCustid(), entity.getPassword(), entity.getRole());
    }

	@Override
	public String getUsername() {
		return this.custid;
	}
	
	@Override
	public String getPassword() {
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.role;
	}

}