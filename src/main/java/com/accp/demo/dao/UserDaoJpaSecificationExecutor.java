package com.accp.demo.dao;

import com.accp.demo.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Administrator
 * @describe
 * @company 晟源科技有限公司
 * @create 2019-03-07 14:55
 */
public interface UserDaoJpaSecificationExecutor extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {

}
