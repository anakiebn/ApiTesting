package com.anakie.TestingAPI.googleSearch.youtube.service;

import com.anakie.TestingAPI.googleSearch.model.youtubeModel.Transcript;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class YoutubeTranslatorServiceImpl implements YoutubeTranslatorService{

    @Override
    public String getFullVideoText(List<Transcript> transcriptList) {
        return transcriptList.stream().map(transcript -> transcript.text).collect(Collectors.joining(" "));
    }

    @Override
    public double getVideoDuration(List<Transcript> transcriptList) {
        return transcriptList.stream().map(transcript -> (Double)transcript.duration).reduce(Double::sum).orElse(0.0);
    }
}
