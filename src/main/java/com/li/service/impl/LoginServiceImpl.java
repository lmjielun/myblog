package com.li.service.impl;
import cn.hutool.crypto.SecureUtil;
import com.li.dao.ILoginRepository;
import com.li.entity.User;
import com.li.service.ILoginService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private ILoginRepository loginRepository;

    @Override
    public User checkUser(String username,String password) {
        String pwd = SecureUtil.md5(password);
        User user = loginRepository.findByUsernameAndPassword(username, pwd);
        return user;
    }
}
