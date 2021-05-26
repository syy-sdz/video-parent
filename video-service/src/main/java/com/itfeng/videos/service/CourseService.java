package com.itfeng.videos.service;

import com.itfeng.videos.pojo.Course;

import java.util.List;

public interface CourseService {
    Course selectCourseById(String id);

    List<Course> selectAll();
}
