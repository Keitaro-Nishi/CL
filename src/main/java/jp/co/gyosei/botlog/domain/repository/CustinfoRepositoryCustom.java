package jp.co.gyosei.botlog.domain.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;

import jp.co.gyosei.botlog.domain.entity.CustinfoEntity;

@Repository
public interface CustinfoRepositoryCustom extends JpaRepository<CustinfoEntity, String>{

	static CustinfoEntity custinfoRepositoryCustom(String custid, String password, String role) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}
}
