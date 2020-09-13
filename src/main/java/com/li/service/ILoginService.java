package com.li.service;

import com.li.entity.User;

public interface ILoginService {
     User checkUser(String username,String password);
}
