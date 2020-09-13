package com.li.dao;
import com.li.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

// 博客分类接口
public interface ITypeRepository extends JpaRepository<Type,Long> {

}
