package com.tang.multidatasource.dao;

import com.tang.multidatasource.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author tang
 * @Date 2019-07-06 17:28
 * @Version 1.0
 **/
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
