package com.accp.demo.pojo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Administrator
 * @describe    角色
 * @company 晟源科技有限公司
 * @create 2019-03-07 17:15
 */
@Entity
@Table(name="roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rolesid")
    private Integer rolesid;
    @Column(name="rolesname")
    private String rolesname;
    /**
     * 一对多
     */
    @OneToMany(mappedBy = "roles")
    private Set<User> userList=null;

    /**
     * 多对多
     * @JoinTable 中间表 roles_menus 中间表名
     * joinColumns 其中一张表的外键 roles_id外键名
     * inverseJoinColumns另一张表的外键  menus_id外键名
     * fetch = FetchType.EAGER  立即加载，取消延迟
     */
    @ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinTable(name="roles_menus",joinColumns = @JoinColumn(name="roles_id"),inverseJoinColumns = @JoinColumn(name = "menus_id"))
    private List<Menus> menus=new ArrayList<>();

    public Roles(){

    }

    public List<Menus> getMenus() {
        return menus;
    }

    public void setMenus(List<Menus> menus) {
        this.menus = menus;
    }

    public Roles(Integer rolesid, String rolesname) {
        this.rolesid=rolesid;
        this.rolesname = rolesname;
    }

    public Integer getRolesid() {
        return rolesid;
    }

    public void setRolesid(Integer rolesid) {
        this.rolesid = rolesid;
    }

    public String getRolesname() {
        return rolesname;
    }

    public void setRolesname(String rolesname) {
        this.rolesname = rolesname;
    }

    public Set<User> getUserList() {
        return userList;
    }

    public void setUserList(Set<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "rolesid=" + rolesid +
                ", rolesname='" + rolesname +
                '}';
    }
}
