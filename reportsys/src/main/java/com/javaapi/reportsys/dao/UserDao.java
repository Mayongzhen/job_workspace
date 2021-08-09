package com.javaapi.reportsys.dao;

import com.javaapi.reportsys.entity.User;

public interface UserDao {
         public void Save (User user);
         public void update (User user);
         public void delete (int userid);
         public  User finduser (String username, String password);
}
