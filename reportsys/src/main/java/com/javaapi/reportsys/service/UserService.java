package com.javaapi.reportsys.service;

import com.javaapi.reportsys.dao.UserDao;
import com.javaapi.reportsys.entity.User;
import com.javaapi.reportsys.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService  implements UserDao {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void Save(User user) {
     userMapper.insert(user);
    }

    @Override
    public void update(User user) {
      userMapper.updatebyId(user.getId());
    }

    @Override
    public void delete(int userid) {
     userMapper.deletebyId(userid);
    }

    @Override
    public User finduser(String username, String password) {
        return userMapper.findbyUser(username,password);
    }


}



