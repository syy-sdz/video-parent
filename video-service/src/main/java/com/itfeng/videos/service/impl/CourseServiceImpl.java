package com.itfeng.videos.service.impl;

import com.itfeng.videos.mapper.CourseMapper;
import com.itfeng.videos.pojo.Course;
import com.itfeng.videos.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;


    @Override
    public Course selectCourseById(String id) {
        return courseMapper.selectCourseById(id);
    }

    @Override
    public List<Course> selectAll() {
        return courseMapper.selectAll();
    }
}
