package com.itfeng.videos.mapper;

import com.itfeng.videos.pojo.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {
    Admin selectAdminByUsernameAndPassword(Admin admin);
}
