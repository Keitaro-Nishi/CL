package jp.co.gyosei.botlog;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Value("${spring.datasource.url}")
	private String dbUrl;
	@Autowired
	@Qualifier("custinfo")
	private javax.sql.DataSource dataSource;
	
	private static final String USER_QUERY = "SELECT custid, password, effect FROM custinfo WHERE custid = ?";
	private static final String ROLE_QUERY = "SELECT cid, role FROM custinfo WHERE custid = ?";
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery(USER_QUERY)
		.authoritiesByUsernameQuery(ROLE_QUERY);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/", "/login", "/loginerror").permitAll()
		//.antMatchers("/**").hasAnyAuthority("ADMIN","USER")
		.and()
		.formLogin()
		.loginProcessingUrl("/loading")
		.loginPage("/")
		//.failureUrl("?error")
		.defaultSuccessUrl("/Customer", true)
		//.usernameParameter("username")
		.usernameParameter("custid")
		.passwordParameter("password");

		http
		.rememberMe()
		.tokenValiditySeconds(86400); 

		http
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/")
		.deleteCookies("JSESSIONID")
		.invalidateHttpSession(true)
		.permitAll();

	}
	
/*
 	@Autowired
 	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
 		auth
 		.inMemoryAuthentication()
 		.withUser("user").password("password").roles("USER");
 	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
		//.authenticationProvider(authenticationProvider)
		//.userDetailsService(userDetailsService)
		.passwordEncoder(new BCryptPasswordEncoder());
	}
*/
}