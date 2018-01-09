package jp.co.gyosei.botlog;

import java.util.ArrayList;
import java.util.Collection;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import jp.co.gyosei.botlog.impl.CustinfoEntityImpl;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class LoginUserDetails extends User {

	public LoginUserDetails(String custid, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> role) {
		super(custid, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, role);
		// TODO �����������ꂽ�R���X�g���N�^�[�E�X�^�u
	}

	private static final long serialVersionUID = 1L;

	// �ǉ�����i�e�[�u���Ń��[�U�[�̃L�[�ƂȂ�l��ݒ肷��j
	public String custid;

	// �ǉ�����
	public String password;

	// �ǉ�����
	public Collection<? extends GrantedAuthority> role;
	
    public LoginUserDetails(CustinfoEntityImpl cust) {
    	super(cust.custid, cust.password, true, true, true, true, new ArrayList<GrantedAuthority>());
        custid = cust.custid;
        password = cust.password;
        role = cust.role;
    }
	
}
