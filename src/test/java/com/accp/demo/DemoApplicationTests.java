package com.accp.demo;

import com.accp.demo.biz.*;
import com.accp.demo.pojo.Menus;
import com.accp.demo.pojo.Roles;
import com.accp.demo.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private UserBizRepository userBizRepository;
    @Autowired
    private UserBizCrudRepository userBizCrudRepository;
    @Autowired
    private UserBizPagingAndSortingRepository userBizPagingAndSortingRepository;
    @Autowired
    private UserBizJpaRepository userBizJpaRepository;
    @Autowired
    private UserBizJpaSecificationExecutor userBizJpaSecificationExecutor;
    @Autowired
    private RolesBiz rolesBiz;

    /**
     * UserDaoRepository接口(命名法)测试
     */
    @Test
    public void contextLoads2() {
      /*  for(User user:userBizRepository.findByName("张三")){
            System.out.println(user);
        }*/
       /* for(User user:userBizRepository.findByNameAndEmail("王五","12")){
            System.out.println(user);
        }*/
       //要自己加%
        for(User user:userBizRepository.findByNameLike("%张%")){
            System.out.println(user);
        }
    }

    /**
     * UserDaoRepository接口(@query)测试
     */
    @Test
    public void contextLoads3() {
        /*for(User user:userBizRepository.queryByNameUseHQL("张三")){
            System.out.println(user);
        }*/
        /*for(User user:userBizRepository.queryByNameUseSQL("张三")){
            System.out.println(user);
        }*/
        userBizRepository.updateUserNameById("李四1122",2);
    }

    /**
     * userDaoCrudRepository接口测试
     * 内部已添加了@Transactional
     */
    @Test
    public void contextLoads4() {
        //userBizCrudRepository.save(new User(null,"aaa","aaa.qq.com"));
        //userBizCrudRepository.save(new User(4,"bb","aaa.qq.com"));
        //System.out.println(userBizCrudRepository.findById(4).get());
        /*for (User user:userBizCrudRepository.findAll()){
            System.out.println(user);
        }*/
        //userBizCrudRepository.deleteById(5);
    }

    /**
     * userDaoPagingAndSortingRepository接口测试
     */
    @Test
    public void contextLoads5() {
        List<User> list= ( List<User>)userBizPagingAndSortingRepository.findAllSort();
        for (User user:list){
            System.out.println(user);
        }
        Page<User> page=userBizPagingAndSortingRepository.findAllPage(1,2);
        for(User user:page.getContent()){
            System.out.println(user);
        }
    }

    /**
     * userBizJpaRepository接口测试
     */
    @Test
    public void contextLoads6() {
        List<User> list= userBizJpaRepository.findAllSort();
        for (User user:list){
            System.out.println(user);
        }
    }

    /**
     * userBizJpaSecificationExecutor接口测试
     */
    @Test
    public void contextLoads7() {
        /*for (User user: userBizJpaSecificationExecutor.findBy()){
            System.out.println(user);
        }*/
        for (User user: userBizJpaSecificationExecutor.findByT()){
            System.out.println(user);
        }
    }

    /**
     * 一对多关系新增
     */
    @Test
    public void testSave(){
        //对象
        User user=new User(null,"aaa","aaa.163.com");
        Roles roles=new Roles(null,"游客");
        //关系
        roles.getUserList().add(user);
        user.setRoles(roles);
        //新增
        userBizCrudRepository.save1(user);
    }

    /**
     * 一对多关系查询
     */
    @Test
    public void testFind(){
        User user=userBizJpaRepository.findById(6);
        System.out.println(user);
        System.out.println(user.getRoles());
    }

    /**
     * 多对多关系新增
     */
    @Test
    public void testSaveT(){
        //对象
       Roles r=new Roles(null,"Boss");
       Menus menus1=new Menus(null,"xxx系统","www.123.com",0);
       Menus menus2=new Menus(null,"xxx系统","www.222.com",0);
       //关联
        r.getMenus().add(menus1);
        r.getMenus().add(menus2);
        menus1.getRoles().add(r);
        menus2.getRoles().add(r);
        //保存
        rolesBiz.save(r);
    }

    @Test
    public void testFindT(){
        Roles roles=rolesBiz.findT(5);
        System.out.println(roles.getRolesname());
        for (Menus menus:roles.getMenus()){
            System.out.println(menus);
        }
    }
}
