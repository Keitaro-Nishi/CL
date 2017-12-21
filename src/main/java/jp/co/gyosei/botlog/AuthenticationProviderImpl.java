package jp.co.gyosei.botlog;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import jp.co.gyosei.botlog.domain.entity.CustinfoEntity;
import jp.co.gyosei.botlog.domain.repository.CustinfoRepositoryCustom;

@Component
public class AuthenticationProviderImpl implements AuthenticationProvider {

	@Autowired
	private CustinfoRepositoryCustom custinfoRepositoryCustom;

	@SuppressWarnings("unused")
	@Override
	public Authentication authenticate(Authentication auth)
			throws AuthenticationException {

		String custid = auth.getName();
		String password = auth.getCredentials().toString();
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();

		if ("".equals(custid) || "".equals(password)) {
			// 例外はSpringSecurityにあったものを適当に使用
			throw new AuthenticationCredentialsNotFoundException("ログイン情報に不備があります。");
		}

		CustinfoRepositoryCustom UserRepository = custinfoRepositoryCustom.custinfoRepositoryCustom(custid, password, role);
		if (custid == null) {
			// 例外はSpringSecurityにあったものを適当に使用
			throw new AuthenticationCredentialsNotFoundException("ログイン情報が存在しません。");
		}

		return new UsernamePasswordAuthenticationToken(new CustinfoEntity(), password, auth.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> token) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(token);
	}

	public CustinfoRepositoryCustom getCustinfoRepositoryCustom() {
		return custinfoRepositoryCustom;
	}

	public void setCustinfoRepositoryCustom(CustinfoRepositoryCustom custinfoRepositoryCustom) {
		this.custinfoRepositoryCustom = custinfoRepositoryCustom;
	}
}