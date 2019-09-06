package com.tang.dao;

import com.tang.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author tang
 * @Date 2019-07-04 21:19
 * @Version 1.0
 **/
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
