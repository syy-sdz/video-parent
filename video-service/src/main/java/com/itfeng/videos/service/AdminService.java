package com.itfeng.videos.service;

import com.itfeng.videos.pojo.Admin;

public interface AdminService {
    Admin selectAdminByUsernameAndPassword(Admin admin);
}
