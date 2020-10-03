package example.config;

import com.roger.common.security.authentication.userdetails.SGUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class HttpSecurityConfigurer extends WebSecurityConfigurerAdapter {
    //告诉系统我的密码不加密，输入账号和密码就可以登录上来
    @Bean
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Autowired
    private SGUserDetailsServiceImpl sgUserDetailsServiceImpl;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //可以将用户名密码存在内存中，也可以采用自定义Service从数据库中取
        //auth.inMemoryAuthentication().withUser("admin").password("12345").roles("ADMIN");
        //auth.inMemoryAuthentication().withUser("test").password("test").roles("USER");

        auth.userDetailsService(sgUserDetailsServiceImpl);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/hello").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                //.loginPage("/login")   //指定没有认证时跳转到的认证url
                //.loginProcessingUrl("/login")   //提交登录表单的url
                .and().csrf().disable();

    }
}
