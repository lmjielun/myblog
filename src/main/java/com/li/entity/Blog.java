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
@Entity // jpa注解，代表实体类
@Table(name = "t_blog") // jpa 注解 代表创建表名为
public class Blog {
    @Id // 主键
    @GeneratedValue // 自动生成
    private Long id;
    /** 博客标题*/
    private String title;
    /** 博客内容*/
    private String content;
    /** 博客首图*/
    private String firstPicture;
    /** 标记*/
    private String flag;
    /** 浏览次数*/
    private Integer looks;
    /** 赞赏是否开启*/
    private boolean appreciation;
    /** 转载声明是否开启*/
    private boolean shareStatement;
    /** 评论是否开启*/
    private boolean commentabled;
    /** 是否发布*/
    private boolean published;
    /** 是否推荐*/
    private boolean recommened;
    /** 创建时间*/
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    /** 更新时间*/
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @ManyToOne // 多对一
    private Type type;

    /** 设置级联关系 当你新增一个博客，如果需要连同新增一个标签，也进行新增*/
    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Tag> tags = new ArrayList<>();

    /** 多个博客 对应一个用户*/
    @ManyToOne
    private User user;

    /** 一个博客 可以后多个评论*/
    @OneToMany(mappedBy = "blog")
    private List<Comment> comments = new ArrayList<>();


}
