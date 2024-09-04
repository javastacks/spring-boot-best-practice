package cn.javastack.springboot.ds;

import cn.javastack.springboot.ds.dao.UserDao;
import cn.javastack.springboot.ds.entity.UserDO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 微信公众号：Java技术栈
 */
@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class Application {

    public final JdbcTemplate jdbcTemplate;

    public final JdbcClient jdbcClient;

    public final UserDao userDao;

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    @Transactional
    public CommandLineRunner commandLineRunner() {
        return useJdbcClient();
    }

    private CommandLineRunner useJdbcTemplate() {
        return (args) -> {
            log.info("using JdbcTemplate...");
            BeanPropertyRowMapper<UserDO> rowMapper = new BeanPropertyRowMapper<>(UserDO.class);
            UserDO userDO = jdbcTemplate.queryForObject("select * from t_user where id = 2",
                    rowMapper);
            log.info("user info : {}", userDO);

            List<UserDO> userDOList = jdbcTemplate.query("select * from t_user",
                    rowMapper);
            log.info("user list: {}", userDOList);

            // 测试事务回滚
//            userDao.update();
        };
    }

    private CommandLineRunner useJdbcClient() {
        return (args) -> {
            log.info("using JdbcClient...");
            UserDO userDO = jdbcClient.sql("select username from t_user where id = ?")
                    .param(2L)
                    .query(UserDO.class)
                    .single();
            log.info("user info : {}", userDO);

            List<UserDO> userDOList = jdbcClient.sql("select * from t_user")
                    .query(UserDO.class)
                    .list();
            log.info("user list: {}", userDOList);
        };
    }


}
