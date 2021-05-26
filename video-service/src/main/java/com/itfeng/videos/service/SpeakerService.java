package com.itfeng.videos.service;

import com.itfeng.videos.pojo.QueryVo;
import com.itfeng.videos.pojo.Speaker;
import com.itfeng.videos.utils.Page;

import java.util.List;

public interface SpeakerService {
    List<Speaker> selectAll();

    Page<Speaker> selectSpeakerByQueryVo(QueryVo queryVo);

    Boolean deleteById(String id);

    Speaker selectSpeakerById(String id);

    Boolean saveOrUpdate(Speaker speaker);
}
