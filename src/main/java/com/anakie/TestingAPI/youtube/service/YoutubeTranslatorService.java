package com.anakie.TestingAPI.youtube.service;

import com.anakie.TestingAPI.model.youtubeModel.Transcript;

import java.util.List;

public interface YoutubeTranslatorService {

    String getFullVideoText(List<Transcript> transcriptList);
//    double getVideoDuration();

    double getVideoDuration(List<Transcript> transcriptList);
}
