package com.accp.demo.biz;

import com.accp.demo.dao.UserDaoRepository;
import com.accp.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Administrator
 * @describe
 * @company 晟源科技有限公司
 * @create 2019-03-06 22:54
 */
@Service
public class UserBizRepository {
    @Autowired
    private UserDaoRepository dao;

    public List<User> findByName(String name){
        return dao.findByName(name);
    }

    public List<User> findByNameAndEmail(String name,String email){
        return dao.findByNameAndEmail(name,email);
    }

    public List<User> findByNameLike(String name){
        return  dao.findByNameLike(name);
    }

    public List<User> queryByNameUseHQL(String name){
        return  dao.queryByNameUseHQL(name);
    }

    public List<User> queryByNameUseSQL(String name){
        return  dao.queryByNameUseSQL(name);
    }

    /**
     *  添加事务回滚
     */
    @Transactional(rollbackOn = Exception.class)
    public void updateUserNameById(String name,Integer id){
            dao.updateUserNameById(name,id);
    }
}
