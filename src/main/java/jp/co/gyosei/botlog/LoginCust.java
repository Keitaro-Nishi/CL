/*
package jp.co.gyosei.botlog;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import jp.co.gyosei.botlog.impl.CustinfoEntityImpl;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class LoginCust extends User {

	public static UserDetails create( entity) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(Authorities auth: entity.getAuthorities()){
			authorities.add(new SimpleGrantedAuthority(auth.getId().getAuthority()));
		}
		return new MyUserDetail(entity.getId(), entity.getLoginId(), entity.getPassword(), entity.getName(), authorities);
	}

	// �ǉ�����i�e�[�u���Ń��[�U�[�̃L�[�ƂȂ�l��ݒ肷��j
	public String custid;

	// �ǉ�����
	public String password;

	// �ǉ�����
	public String role;

	public LoginCust(CustinfoEntityImpl cust) {
		super(cust.custid, cust.password, true, true, true, true, new ArrayList<GrantedAuthority>());
		custid = cust.custid;
		password = cust.password;
		role = cust.role;
		//role = "ADMIN";
	}
}
*/