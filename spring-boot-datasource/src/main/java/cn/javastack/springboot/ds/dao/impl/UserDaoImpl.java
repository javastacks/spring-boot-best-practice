package cn.javastack.springboot.ds.dao.impl;

import cn.javastack.springboot.ds.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserDaoImpl implements UserDao {

    public final JdbcTemplate jdbcTemplate;

    @Transactional
    @Override
    public void update() {
        jdbcTemplate.execute("update t_user set username = 'Petty' where id = 1");
        jdbcTemplate.execute("update t_user set username = 'Yoga' where id = 2");
        throw new RuntimeException("test exception");
    }

}
