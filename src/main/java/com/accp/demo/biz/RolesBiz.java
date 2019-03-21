package com.accp.demo.biz;

import com.accp.demo.dao.RolesDao;
import com.accp.demo.pojo.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @describe
 * @company 晟源科技有限公司
 * @create 2019-03-07 19:59
 */
@Service
public class RolesBiz {
    @Autowired
    private RolesDao dao;

    public void save(Roles roles){
        dao.save(roles);
    }
    public Roles findT(Integer id){
        return dao.findById(id).get();
    }
}
