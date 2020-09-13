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
@Table(name = "t_comment")
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    /** 昵称*/
    private String nickname;

    private String email;

    /** 评论内容*/
    private String content;

    /** 头像*/
    private String avatar;

    /** 创建时间*/
    @Temporal(TemporalType.TIMESTAMP) // jpa注解，对应数据库时间类型
    private Date createTime;

    /** 一个评论对应一个博客*/
    @ManyToOne
    private Blog blog;

    /** 一个评论下 可以有多个子评论*/
    @OneToMany(mappedBy = "parentComment")
    private List<Comment> replyComments = new ArrayList<>();

    /** 评论的父类 一个子评论只能有一个父类*/
    @ManyToOne
    private Comment parentComment;
}
