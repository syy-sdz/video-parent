package com.itfeng.videos.service;

import com.itfeng.videos.pojo.QueryVo;
import com.itfeng.videos.pojo.Video;
import com.itfeng.videos.utils.Page;

public interface VideoService {
    Video selectVideoById(String id);

    Boolean updateVideo(Video video);

    Page<Video> selectVideoByQueryVo(QueryVo queryVo);

    Boolean deleteById(String[] ids);
}
