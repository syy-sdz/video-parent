package com.itfeng.videos.mapper;

import com.itfeng.videos.pojo.Subject;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectMapper {
    List<Subject> selectAll();

    Subject selectSubjectById(String id);
}
