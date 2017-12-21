package jp.co.gyosei.botlog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import jp.co.gyosei.botlog.domain.entity.CustinfoEntity;
import jp.co.gyosei.botlog.LoginCust;
import jp.co.gyosei.botlog.domain.repository.CustinfoRepositoryCustom;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CustinfoRepositoryCustom custinfoRepositoryCustom;

    @Override
    public UserDetails loadUserByUsername(String custid)
            throws UsernameNotFoundException {

        CustinfoEntity auth = custinfoRepositoryCustom.findOne(custid);
		if (auth == null) {
            throw new UsernameNotFoundException("���[�U�[��������܂���ł����B");
        }

        return new LoginCust(auth);
    }
}