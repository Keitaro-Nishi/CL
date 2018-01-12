package jp.co.gyosei.botlog.domain.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.GrantedAuthority;

import jp.co.gyosei.botlog.impl.CustinfoEntityImpl;

public interface CustinfoRepositoryCustom extends JpaRepository<CustinfoEntityImpl, Long> {
	
	public CustinfoEntityImpl findByUsername(String custid);

	public static CustinfoEntityImpl custinfoRepositoryCustom(String custid, String password) {
		// TODO 自動生成されたメソッド・スタブ
		return new CustinfoEntityImpl(custid, password);
	}
	
}
