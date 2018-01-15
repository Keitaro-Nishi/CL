package jp.co.gyosei.botlog.domain.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jp.co.gyosei.botlog.impl.CustinfoEntityImpl;
import jp.co.gyosei.botlog.domain.repository.CustinfoRepositoryCustom;

@Service
public class LoginServiceImpl implements UserDetailsService
{
    private CustinfoRepositoryCustom custinfoRepositoryCustom;

    @Override
    public UserDetails loadUserByUsername(String custid) throws UsernameNotFoundException
    {
        if (StringUtils.isEmpty(custid))
        {
            throw new UsernameNotFoundException("");
        }

        CustinfoEntityImpl custinfoEntityImpl = custinfoRepositoryCustom.findByUsername(custid);
        if (custinfoEntityImpl == null)
        {
            throw new UsernameNotFoundException("");
        }

        return custinfoEntityImpl;
    }

    @Autowired
    public void setMemberRepository(CustinfoRepositoryCustom custinfoRepositoryCustom)
    {
        this.custinfoRepositoryCustom = custinfoRepositoryCustom;
    }
}