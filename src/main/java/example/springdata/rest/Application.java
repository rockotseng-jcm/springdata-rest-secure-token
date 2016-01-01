package example.springdata.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.savedrequest.NullRequestCache;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

@SpringBootApplication
public class Application {

    @EnableWebSecurity
    public static class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().anyRequest().authenticated().and().requestCache().requestCache(new NullRequestCache()).and()
                    .httpBasic().and().csrf().disable().logout().disable();
        }

    }

    @Configuration
    @EnableRedisHttpSession
    public static class HttpSessionConfig {

        @Bean
        public JedisConnectionFactory connectionFactory() {
            return new JedisConnectionFactory();
        }

        @Bean
        public HttpSessionStrategy httpSessionStrategy() {
            return new HeaderHttpSessionStrategy();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

}
