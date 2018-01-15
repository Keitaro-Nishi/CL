package jp.co.gyosei.botlog.impl;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jp.co.gyosei.botlog.LoginUserDetails;

@Entity
@Table(name = "custinfo")
public class CustinfoEntityImpl implements UserDetails
{
    private static final long serialVersionUID = 1667698003975566301L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long no;

    @Column(nullable = false, unique = true)
    private String custid;

    @Column(nullable = false)
    private String password;
    
    @Column(nullable = false)
    private Collection<? extends GrantedAuthority> role;

    public CustinfoEntityImpl(String custid, String password) {
	}

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return this.role;
    }

    @Override
    public String getPassword(){
        return this.password;
    }

    @Override
    public String getUsername(){
        return this.custid;
    }

    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled(){
        return true;
    }

	public UserDetails toLoginUserDetails() {
		return LoginUserDetails.create(this);
	}
}