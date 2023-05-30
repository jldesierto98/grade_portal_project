package com.ltp.gradesubmission.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AudioProcessRequest {
    private String audio_url;
    private String token;
}
