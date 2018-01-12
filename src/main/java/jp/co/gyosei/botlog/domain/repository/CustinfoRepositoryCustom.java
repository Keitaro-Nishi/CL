package jp.co.gyosei.botlog.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.gyosei.botlog.impl.CustinfoEntityImpl;

public interface CustinfoRepositoryCustom extends JpaRepository<CustinfoEntityImpl, Long> {
	
	public CustinfoEntityImpl findByUsername(String custid);
	
}
