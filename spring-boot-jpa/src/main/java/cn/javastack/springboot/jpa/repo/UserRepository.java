package cn.javastack.springboot.jpa.repo;

import cn.javastack.springboot.jpa.entity.UserDO;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserDO, Long> {

}

