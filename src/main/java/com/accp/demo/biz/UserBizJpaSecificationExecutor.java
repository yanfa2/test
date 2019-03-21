package com.accp.demo.biz;

import com.accp.demo.dao.UserDaoJpaSecificationExecutor;
import com.accp.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @describe
 * @company 晟源科技有限公司
 * @create 2019-03-07 15:22
 */
@Service
public class UserBizJpaSecificationExecutor {
    @Autowired
    private UserDaoJpaSecificationExecutor dao;

    /**
     * 单条件查询
     * @return
     */
    public List<User> findBy(){
        //内部类
        Specification<User> spec=new Specification<User>() {
            /**
             *  root:查询对象属性的fengz
             *  query:封装了查询中的信息 select from where.......
             *  cb:查询条件构造器
             */
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //参数1：查询条件属性；参数2：条件值
                Predicate pre=cb.equal(root.get("name"),"张三");
                return pre;
            }
        };
        return dao.findAll(spec);
    }

    /**
     * 多条件查询
     * @return
     */
    public List<User> findByT(){
        //内部类
        Specification<User> spec=new Specification<User>() {
            /**
             *  root:查询对象属性的fengz
             *  query:封装了查询中的信息 select from where.......
             *  cb:查询条件构造器
             */
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //and()要求为可变参数
                // (name='李四' and email='lisi@163.com') or id=1
                Predicate pre=cb.or(cb.and(cb.equal(root.get("name"),"李四"),cb.equal(root.get("email"),"lisi@163.com")),cb.equal(root.get("id"),"1"));
                return pre;
            }
        };
        //多条件排序
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        return dao.findAll(spec,sort);
        /*多条件分页排序
        Pageable pageable=new PageRequest(page-1,zize.sort);
        return dao.findAll(pageable);*/
    }
}
