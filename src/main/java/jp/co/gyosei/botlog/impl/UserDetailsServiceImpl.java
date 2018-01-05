package jp.co.gyosei.botlog.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import jp.co.gyosei.botlog.LoginUserDetails;
import jp.co.gyosei.botlog.domain.repository.CustinfoRepositoryCustom;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CustinfoRepositoryCustom custinfoRepositoryCustom;

    @Override
    public LoginUserDetails loadUserByUsername(String custid)
            throws UsernameNotFoundException {

    	CustinfoEntityImpl cust = custinfoRepositoryCustom.findOne(custid);
		if (cust == null) {
            throw new UsernameNotFoundException("ユーザーが見つかりませんでした。");
        }

        return new LoginUserDetails(cust);
    }
	@SuppressWarnings("unused")
	private Collection<GrantedAuthority> getAuthorities(LoginUserDetails role){
		if(role.getAuthorities().equals("ADMIN")){
			return AuthorityUtils.createAuthorityList("USER","ADMIN");
		} else {
			return AuthorityUtils.createAuthorityList("USER");
		}
	}
}