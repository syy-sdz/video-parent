package com.itfeng.videos.controller;

import com.itfeng.videos.pojo.Course;
import com.itfeng.videos.pojo.QueryVo;
import com.itfeng.videos.pojo.Speaker;
import com.itfeng.videos.pojo.Video;
import com.itfeng.videos.service.CourseService;
import com.itfeng.videos.service.SpeakerService;
import com.itfeng.videos.service.VideoService;
import com.itfeng.videos.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/video")
public class VideoController {
    @Autowired
    private VideoService videoService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private SpeakerService speakerService;

    @RequestMapping("/showVideo")
    public String showVideo(String videoId, String subjectName, Model model) {
        model.addAttribute("subjectName", subjectName);
        Video video = videoService.selectVideoById(videoId);
        model.addAttribute("video", video);
        Course course = courseService.selectCourseById(video.getCourseId().toString());
        model.addAttribute(course);
        return "/before/section";
    }

    @RequestMapping("/updatePlayNum")
    @ResponseBody
    public String updatePlayNum(Video video) {
        video.setPlayNum(video.getPlayNum() + 1);
        videoService.updateVideo(video);
        return "success";
    }

    @RequestMapping("/list")
    public String list(QueryVo queryVo, Model model) {
        model.addAttribute("queryVo", queryVo);
        Page<Video> page = videoService.selectVideoByQueryVo(queryVo);
        model.addAttribute("page", page);
        List<Course> courseList = courseService.selectAll();
        model.addAttribute("courseList", courseList);
        List<Speaker> speakerList = speakerService.selectAll();
        model.addAttribute("speakerList", speakerList);
        return "/behind/videoList";
    }

    @RequestMapping("/delBatchVideos")
    public String delBatchVideos(String[] ids) {
        videoService.deleteById(ids);
        return "redirect:list";
    }

    @RequestMapping("/videoDel")
    @ResponseBody
    public String videoDel(String id) {
        String[] ids = new String[1];
        ids[0] = id;
        if (videoService.deleteById(ids)) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping("/edit")
    public String edit(String id, Model model) {
        Video video = videoService.selectVideoById(id);
        model.addAttribute("video", video);
        List<Course> courseList = courseService.selectAll();
        model.addAttribute("courseList", courseList);
        List<Speaker> speakerList = speakerService.selectAll();
        model.addAttribute("speakerList", speakerList);
        return "/behind/addVideo";
    }

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Video video) {
        videoService.updateVideo(video);
        return "redirect:list";
    }

    @RequestMapping("/addVideo")
    public String addVideo(Model model) {
        List<Course> courseList = courseService.selectAll();
        model.addAttribute("courseList", courseList);
        List<Speaker> speakerList = speakerService.selectAll();
        model.addAttribute("speakerList", speakerList);
        return "/behind/addVideo";
    }
}
