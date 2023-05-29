package com.ltp.gradesubmission.service;

import com.ltp.gradesubmission.request.AudioProcessRequest;
import com.ltp.gradesubmission.response.AssemblyResponse;

import java.io.IOException;
import java.net.URISyntaxException;

public interface AssemblyService {

    AssemblyResponse processAudio(AudioProcessRequest request) throws URISyntaxException, IOException, InterruptedException;
}
