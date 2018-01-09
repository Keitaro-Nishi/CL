package jp.co.gyosei.botlog.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import jp.co.gyosei.botlog.LoginCust;
//import jp.co.gyosei.botlog.domain.entity.CustinfoEntityImnpls;
import jp.co.gyosei.botlog.domain.repository.CustinfoRepositoryCustom;

@Component
public class AuthenticationProviderImpl implements AuthenticationProvider {

	@Autowired
	private CustinfoRepositoryCustom custinfoRepositoryCustom;

	@Override
	public Authentication authenticate(Authentication auth)
			throws AuthenticationException {

		String custid = auth.getName();
		String password = auth.getCredentials().toString();
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();

		if ("".equals(custid) || "".equals(password)) {
			// ��O��SpringSecurity�ɂ��������̂�K���Ɏg�p
			throw new AuthenticationCredentialsNotFoundException("���O�C�����ɕs��������܂��B");
		}

		CustinfoEntity cust = CustinfoRepositoryCustom.custinfoRepositoryCustom(custid, password, role);
		if (cust == null) {
			// ��O��SpringSecurity�ɂ��������̂�K���Ɏg�p
			throw new AuthenticationCredentialsNotFoundException("���O�C����񂪑��݂��܂���B");
		}

		return new UsernamePasswordAuthenticationToken(new LoginCust(cust), password, auth.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> token) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(token);
	}

	public CustinfoRepositoryCustom getCustinfoRepositoryCustom() {
		return custinfoRepositoryCustom;
	}

	public void setCustinfoRepository(CustinfoRepositoryCustom custinfoRepositoryCustom) {
		this.custinfoRepositoryCustom = custinfoRepositoryCustom;
	}
}