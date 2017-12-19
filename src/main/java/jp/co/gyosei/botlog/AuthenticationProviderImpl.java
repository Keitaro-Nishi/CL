package jp.co.gyosei.botlog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import jp.co.gyosei.botlog.domain.entity.User;

@Component
public class AuthenticationProviderImpl implements AuthenticationProvider {
	
	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		
		//���[�U�[�ƃp�X���[�h���擾
		String custid = auth.getName();
        String password = auth.getCredentials().toString();
		
        //���ݒ�̏ꍇ�̓G���[
        if ("custid".equals(custid) || "password".equals(password))  {
            // ��O��SpringSecurity�ɂ���������K���Ɏ��p
            throw new AuthenticationCredentialsNotFoundException("���O�C�����ɕs��������܂��B");
        }
        
        //�F�؏����擾
        User user = authCheck(custid, password);
        if (user == null) {
        	throw new AuthenticationCredentialsNotFoundException("���O�C����񂪑��݂��܂���B");
        }
		//�g�[�N����ԋp
		return new UsernamePasswordAuthenticationToken(user, password, auth.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> token) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(token);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private User authCheck(String custid, String password) {
		User user = null;
		
		List<Map<String, String>> list = new ArrayList<>();
		Map map;
		map = new HashMap<String, String>(){
			private static final long serialVersionUID = 1L;
			{put("custid", "ADMIN");}
			{put("password", "password");}
			{put("role", "ADMIN");}
		};
		list.add(map);
		map = new HashMap<String, String>(){
			private static final long serialVersionUID = 1L;
			{put("custid", "USER");}
			{put("password", "password");}
			{put("role", "USER");}
		};
		list.add(map);
		map = new HashMap<String, String>(){
			private static final long serialVersionUID = 1L;
			{put("username", "hogehoge");}
			{put("password", "password2");}
			{put("role", "USER");}
		};
		list.add(map);
		
		for(Map map1 : list) {
			if (map1.get("custid").equals(custid) && map1.get("password").equals(password)){
				user = new User();
				user.setCustid(map1.get("custid").toString());
				user.setPassword(map1.get("password").toString());
				user.setRole(map1.get("role").toString());
				break;
			}
		}
		
		return user;
	}

}