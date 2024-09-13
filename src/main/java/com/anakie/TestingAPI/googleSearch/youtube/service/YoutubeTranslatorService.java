package com.anakie.TestingAPI.backend.googleSearch.youtube.service;

import com.anakie.TestingAPI.backend.googleSearch.model.youtubeModel.Transcript;

import java.util.List;

public interface YoutubeTranslatorService {

    String getFullVideoText(List<Transcript> transcriptList);
//    double getVideoDuration();

    double getVideoDuration(List<Transcript> transcriptList);
}
