package com.itfeng.videos.service.impl;

import com.itfeng.videos.mapper.SubjectMapper;
import com.itfeng.videos.pojo.Subject;
import com.itfeng.videos.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public List<Subject> selectAll() {
        return subjectMapper.selectAll();
    }

    @Override
    public Subject selectSubjectById(String id) {
        return subjectMapper.selectSubjectById(id);
    }
}
