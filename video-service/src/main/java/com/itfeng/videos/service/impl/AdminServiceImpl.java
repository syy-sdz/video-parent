package com.itfeng.videos.service.impl;

import com.itfeng.videos.mapper.AdminMapper;
import com.itfeng.videos.pojo.Admin;
import com.itfeng.videos.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin selectAdminByUsernameAndPassword(Admin admin) {
        return adminMapper.selectAdminByUsernameAndPassword(admin);
    }
}
