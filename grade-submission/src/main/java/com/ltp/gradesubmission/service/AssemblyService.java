package com.ltp.gradesubmission.service;

import com.ltp.gradesubmission.request.AudioProcessRequest;
import com.ltp.gradesubmission.response.AssemblyResponse;

public interface AssemblyService {

    AssemblyResponse processAudio(AudioProcessRequest request);
}
