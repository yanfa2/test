package com.accp.demo.dao;

import com.accp.demo.pojo.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Administrator
 * @describe
 * @company 晟源科技有限公司
 * @create 2019-03-06 15:31
 */
public interface UserDaoCrudRepository extends CrudRepository<User,Integer> {

}
