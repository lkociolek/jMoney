package dev.kociolek.jmoney.config;

import dev.kociolek.jmoney.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.access.expression.SecurityExpressionOperations;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.WebSecurityExpressionRoot;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@Profile({"thymeleaf", "vaadin"})
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String ROLE_ADMIN = Role.ADMIN.toString();
    public static final String H2_CONSOLE = "/h2-console/**";
    private static final String[] INDEX = {"/", "/home"};
    private static final String USERS_BY_USERNAME_QUERY = "SELECT name, password, enabled " +
            "FROM user " +
            "WHERE name=?";
    private static final String AUTHORITIES_BY_USERNAME_QUERY = "SELECT user.name, user_roles.roles " +
            "FROM user " +
            "INNER JOIN user_roles " +
            "ON (user_roles.user_id=user.id) " +
            "WHERE user.name=?";

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(INDEX)
                                    .permitAll().anyRequest().authenticated().and()
            .authorizeRequests().antMatchers(H2_CONSOLE).authenticated().anyRequest().authenticated().and()
            .formLogin().permitAll().and()
            .logout().logoutSuccessUrl("/").permitAll().and()
            .httpBasic().and()
            .rememberMe().tokenValiditySeconds(2419200);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.expressionHandler(new DefaultWebSecurityExpressionHandler() {
            @Override
            protected SecurityExpressionOperations createSecurityExpressionRoot(Authentication authentication, FilterInvocation fi) {
                WebSecurityExpressionRoot root = (WebSecurityExpressionRoot) super.createSecurityExpressionRoot(authentication, fi);
                root.setDefaultRolePrefix("");
                return root;
            }
        });
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(USERS_BY_USERNAME_QUERY)
                .authoritiesByUsernameQuery(AUTHORITIES_BY_USERNAME_QUERY)
                .passwordEncoder(passwordEncoder());
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}