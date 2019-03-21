package com.accp.demo.dao;

import com.accp.demo.pojo.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Administrator
 * @describe
 * @company 晟源科技有限公司
 * @create 2019-03-07 11:10
 */
public interface UserDaoPagingAndSortingRepository extends PagingAndSortingRepository<User,Integer> {

}
