package jp.co.gyosei.botlog;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jp.co.gyosei.botlog.impl.CustinfoEntityImpl;

public class LoginUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	private String custid;
    private String password;
    private Collection<? extends GrantedAuthority> role;

    public LoginUserDetails(String custid, String password,
           Collection<? extends GrantedAuthority> role) {
        super();
        this.custid = custid;
        this.password = password;
        this.role = role;
    }

	public LoginUserDetails(CustinfoEntityImpl custinfoEntityImpl) {
	}

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
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.role;
	}

}