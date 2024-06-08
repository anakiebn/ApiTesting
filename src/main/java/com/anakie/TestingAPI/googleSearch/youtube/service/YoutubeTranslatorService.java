package com.anakie.TestingAPI.googleSearch.youtube.service;

import com.anakie.TestingAPI.googleSearch.model.youtubeModel.Transcript;

import java.util.List;

public interface YoutubeTranslatorService {

    String getFullVideoText(List<Transcript> transcriptList);
//    double getVideoDuration();

    double getVideoDuration(List<Transcript> transcriptList);
}
