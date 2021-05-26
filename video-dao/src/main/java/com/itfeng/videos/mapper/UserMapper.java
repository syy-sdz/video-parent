package com.itfeng.videos.mapper;

import com.itfeng.videos.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User selectUserByEmailAndPassword(User user);

    User selectUserByEmail(String email);

    Boolean insertUser(User user);

    Boolean updateUser(User user);

}
