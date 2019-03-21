package com.accp.demo.dao;

import com.accp.demo.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Administrator
 * @describe
 * @company 晟源科技有限公司
 * @create 2019-03-07 14:00
 */
public interface UserDaoJpaRepository extends JpaRepository<User,Integer> {
}
