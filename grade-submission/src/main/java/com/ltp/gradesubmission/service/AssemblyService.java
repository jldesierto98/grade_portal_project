package com.ltp.gradesubmission.service;

import com.ltp.gradesubmission.request.AudioProcessRequest;
import com.ltp.gradesubmission.response.AssemblyResponse;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URISyntaxException;

public interface AssemblyService {

    AssemblyResponse processAudio(AudioProcessRequest request, HttpServletRequest servletRequest) throws URISyntaxException, IOException, InterruptedException;
    AssemblyResponse getProcessedAudio(@PathVariable String id, HttpServletRequest servletRequest) throws IOException, InterruptedException, URISyntaxException;
}
