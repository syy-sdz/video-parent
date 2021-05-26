package com.itfeng.videos.mapper;

import com.itfeng.videos.pojo.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMapper {
    Course selectCourseById(String id);

    List<Course> selectAll();
}
