package com.li.service;

import com.li.entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/**
 *  博客分类
 */
public interface ITypeService {
    /** 新增一个博客分类*/
    Type saveType(Type type);

    /** 查找一个博客分类*/
    Type getType(Long id);

    /** 查找博客分类列表*/
    Page<Type> listType(Pageable pageable);

    /** 修改博客分类*/
    Type updateType(Long id,Type type);

    /** 删除博客分类*/
    void deleteType(Long id);

}
