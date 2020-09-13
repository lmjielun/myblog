package com.li.service.impl;

import com.li.dao.ITypeRepository;
import com.li.entity.Type;
import com.li.handler.NotFoundException;
import com.li.service.ITypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Id;

@Service
public class TypeServiceImpl implements ITypeService {

    @Autowired
    private ITypeRepository repository;

    @Transactional
    @Override
    public Type saveType(Type type) {
        return repository.save(type);
    }

    @Transactional(readOnly = true)
    @Override
    public Type getType(Long id) {
        return repository.getOne(id);
    }

    /**
     * 分页查询，jpa已经封装好了方法，直接用
     * @param pageable
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public Page<Type> listType(Pageable pageable) {
        repository.findAll(pageable);
        return null;
    }

    /**
     *  更新 修改
     * @param id
     * @param type
     * @return
     */
    @Transactional
    @Override
    public Type updateType(Long id, Type type) {
        // 先查询
        Type typeRs = repository.getOne(id);

       if(typeRs == null){
        throw new NotFoundException("博客分类不存在");
       }
        // 在修改
        // 修改先把 传递过来的实体类属性，赋值给根据id查询到的实体类
        BeanUtils.copyProperties(type,typeRs);
       // 然后再将赋值后的实体类，进行保存，就是修改了
        Type result = repository.save(typeRs);
        return result;
    }

    @Transactional
    @Override
    public void deleteType(Long id) {
        repository.deleteById(id);
    }
}
