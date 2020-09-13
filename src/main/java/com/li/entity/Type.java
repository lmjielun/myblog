package com.li.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "t_type")
public class Type {
    @Id
    @GeneratedValue
    private Long id;
    /** 类型名称*/
    private String name ;

    /** 一对多，一方作为被维护关系方*/
    /** 维护关系，为Blog类中的 type 属性*/
    @OneToMany(mappedBy = "type")
    private List<Blog> blogs = new ArrayList<>();
}
