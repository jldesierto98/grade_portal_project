package com.ltp.gradesubmission.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transcript {
    private String id;
    private String status;
    private String audio_url;
    private String text;
}
