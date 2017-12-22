package jp.co.gyosei.botlog.domain.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="custinfo")
public class CustinfoEntityImpl implements Serializable {

	private static final long serialVersionUID = 1L;
	public final String auth = null;
	@Id
	@Column
	public String custid;
	@Column
	public String password;
	@Column
	public String role;

	public CustinfoEntityImpl() {
	}

	public CustinfoEntityImpl(String custid, String password, String role) {
 
		this.custid = custid;
		this.password = password;
		this.role = role;
	}

	public String getCustid() {
		return this.custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	/*
	public static CustinfoEntityImpl custinfoRepositoryCustom(String custid, String password,
			Collection<? extends GrantedAuthority> role) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}
*/
}
