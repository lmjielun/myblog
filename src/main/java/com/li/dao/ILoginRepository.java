package com.li.dao;

import com.li.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *  登录操作，一般都是用户类的操作
 *  继承JpaRepository 可以使用里边基本的CRUD方法，不需要你自己在写了
 *  泛型 User 代表操作哪个类，Long 代表这个类的主键类型
 *
 */
public interface ILoginRepository extends JpaRepository<User,Long> {

    /**
     * 创建自己的方法
     * 这样，他会自己到数据库查找，你只需要定义方法就行，他自己会去实现
     */
    User findByUsernameAndPassword(String username,String password);
}
