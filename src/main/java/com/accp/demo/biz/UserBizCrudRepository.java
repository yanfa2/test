package com.accp.demo.biz;

import com.accp.demo.dao.UserDaoCrudRepository;
import com.accp.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Administrator
 * @describe
 * @company 晟源科技有限公司
 * @create 2019-03-06 23:57
 *
 * 增删改默认开启事务
 */
@Service
public class UserBizCrudRepository {
    @Autowired
    private UserDaoCrudRepository dao;

    /**
     * save()既是新增也是修改，执行前会先判断是否存在该数据，不存在就新增，否则更新
     * @param user
     */
    public void save1(User user){
        dao.save(user);
    }

    /**
     * save()修改
     * @param user
     */
    public void save2(User user){
        dao.save(user);
    }
    /**
     * findById()根据id查询,返回optional(可以为null)对象
     */
    public Optional<User> findById(Integer id){
        return  dao.findById(id);
    }

    /**
     * findAll()查询全部，返回Iterale集合(array,map,set)
     * @return
     */
    public Iterable<User> findAll(){
        return  dao.findAll();
    }

    /**
     * deleteById()根据id删除
     * @param id
     */
    public void deleteById(Integer id){
        dao.deleteById(id);
    }
}
