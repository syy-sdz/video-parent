package com.itfeng.videos.service;

import com.itfeng.videos.pojo.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> selectAll();

    Subject selectSubjectById(String id);
}
