package com.accp.demo.biz;

import com.accp.demo.dao.UserDaoJpaRepository;
import com.accp.demo.pojo.Roles;
import com.accp.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Administrator
 * @describe
 * @company 晟源科技有限公司
 * @create 2019-03-07 14:02
 */
@Service
public class UserBizJpaRepository {
    @Autowired
    private UserDaoJpaRepository dao;

    /**
     * findAll(sort)只能查询全部排序
     * @return
     */
    public List<User> findAllSort(){
        //定义排序规则
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        return dao.findAll(sort);
    }
    public User findById(Integer id){
        return dao.findById(id).get();
    }

}
