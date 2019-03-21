package com.accp.demo.pojo;

import javax.persistence.*;


/**
 * @author Administrator
 * @describe
 * @company 晟源科技有限公司
 * @create 2019-03-05 22:37
 */
@Entity//实体
@Table(name = "user")//数据库表名
public class User {
    //主键
    //生成策略，IDENTITY自动增长
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;
    /**
     * ManyToOne多对一，cascade = CascadeType.PERSIST开启集联操作
     * JoinColumn外键名
     */
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="roles_id")
    private Roles roles;

    public User() {
    }

    public User(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                '}';
    }
}
