package com.accp.demo.pojo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @describe
 * @company 晟源科技有限公司
 * @create 2019-03-07 19:28
 */
@Entity
@Table(name="menus")
public class Menus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="menusid")
    private  Integer menusid;
    @Column(name="menusname")
    private  String menusname;
    @Column(name="menusurl")
    private String menusurl;
    @Column(name="fatherid")
    private Integer fatherid;
    /**
     * 关联另一张表的对象
     */
    @ManyToMany(mappedBy = "menus")
    private List<Roles> roles=new ArrayList<>();

    public Menus(){

    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    public Menus(Integer menusid, String menusname, String menusurl, Integer fatherid) {
        this.menusid=menusid;
        this.menusname = menusname;
        this.menusurl = menusurl;
        this.fatherid = fatherid;
    }

    public Integer getMenusid() {
        return menusid;
    }

    public void setMenusid(Integer menusid) {
        this.menusid = menusid;
    }

    public String getMenusname() {
        return menusname;
    }

    public void setMenusname(String menusname) {
        this.menusname = menusname;
    }

    public String getMenusurl() {
        return menusurl;
    }

    public void setMenusurl(String menusurl) {
        this.menusurl = menusurl;
    }

    public Integer getFatherid() {
        return fatherid;
    }

    public void setFatherid(Integer fatherid) {
        this.fatherid = fatherid;
    }

    @Override
    public String toString() {
        return "Menus{" +
                "menusid=" + menusid +
                ", menusname='" + menusname + '\'' +
                ", menusurl='" + menusurl + '\'' +
                ", fatherid=" + fatherid +
                '}';
    }
}
