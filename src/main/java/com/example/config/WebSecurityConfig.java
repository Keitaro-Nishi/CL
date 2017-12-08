
package com.example.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Controller
@SpringBootApplication
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/webjars/**", "/css/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/login").permitAll()
		/*
		.antMatchers("/**").hasAnyAuthority("ADMIN","USER")
		.antMatchers("/Home").hasAnyAuthority("ADMIN","USER")
		.antMatchers("/signup").hasAnyAuthority("ADMIN","USER")
		.antMatchers("/userlist").hasAnyAuthority("ADMIN","USER")
		.antMatchers("/Account").hasAuthority("ADMIN")
		.antMatchers("/logout").hasAnyAuthority("ADMIN","USER")
		//.antMatchers("/User/**").hasAuthority("ADMIN")
		*/
		.anyRequest().authenticated(); 
		
        //���O�C���ݒ�
        http.formLogin()
            .loginProcessingUrl("processing")   //�F�؏����̃p�X
            .loginPage("/login")            //���O�C���t�H�[���̃p�X
            //.failureHandler(new SampleAuthenticationFailureHandler())       //�F�؎��s���ɌĂ΂��n���h���N���X
            .defaultSuccessUrl("/signup")     //�F�ؐ������̑J�ڐ�
            .usernameParameter("custid").passwordParameter("password")  //���[�U�A�p�X���[�h�̃p�����[�^��
            .and();
        
        // ���O�A�E�g�ݒ�
        http.logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout**"))       // ���O�A�E�g�����̃p�X
            .logoutSuccessUrl("/index");                                        // ���O�A�E�g�������̃p�X
    }
        
	/*
	@Bean
	PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	 */
}
