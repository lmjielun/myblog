package com.li.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    /** 用户昵称*/
    private String nickname;

    /** 用户名*/
    private String username;

    private String password;

    private String email;

    /** 用户类型*/
    private Integer type;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    // 被维护方
    @OneToMany(mappedBy = "user")
    private List<Blog> blogs = new ArrayList<>();
}
