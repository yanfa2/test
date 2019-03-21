package com.accp.demo.dao;

import com.accp.demo.pojo.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * @author Administrator
 * @describe
 * @company 晟源科技有限公司
 * @create 2019-03-06 10:01
 * Repository接口
 * 第一个参数要操作的实体类型
 * 第二个参数主键类型
 * 1.方法名称命名查询    方法名(驼峰)规则    findBy+属性名称+查询条件    查询条件不写默认按=查询
 * 2.@query注解查询   方法名随便
 */
public interface UserDaoRepository extends Repository<User,Integer> {
    /**
     *
     * @param name
     * @return
     */
    public List<User> findByName(String name);
    /**
     * 多条件查询 And,Or
     * @param name
     * @return
     */
    public List<User> findByNameAndEmail(String name,String email);
    /**
     * 模糊查询
     * @param name
     * @return
     */
    public List<User> findByNameLike(String name);

    /**
     *  ?1 ?2  占位符第一个，二个参数
     *  hibernate默认将HQL(写实体的字段名)转换成SQL(数据库字段名)
     * @param name
     * @return
     */
    @Query("from User where name = ?1")
    public List<User> queryByNameUseHQL(String name);

    /**
     *  nativeQuery = true    告诉hibernate执行的是SQL语句,不转换
     * @param name
     * @return
     */
    @Query(value="select * from user where name = ?1",nativeQuery = true)
    public List<User> queryByNameUseSQL(String name);

    /**
     *  Modifying  执行更新操作
     * @param name
     * @return
     */
    @Query(value="update User set name=?1 where id=?2")
    @Modifying
    public Integer updateUserNameById(String name,Integer id);
}
