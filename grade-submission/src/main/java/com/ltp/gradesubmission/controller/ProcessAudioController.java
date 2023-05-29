package com.ltp.gradesubmission.controller;

import com.ltp.gradesubmission.request.AudioProcessRequest;
import com.ltp.gradesubmission.response.AssemblyResponse;
import com.ltp.gradesubmission.service.AssemblyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.net.URISyntaxException;

@Controller
@RequestMapping("/audio")
@AllArgsConstructor
public class ProcessAudioController {

    private final AssemblyService assemblyService;

    @PostMapping("/processAudio")
    public ResponseEntity<AssemblyResponse> processAudio(@RequestBody AudioProcessRequest request) throws URISyntaxException, IOException, InterruptedException {
        return new ResponseEntity<>(assemblyService.processAudio(request), HttpStatus.OK);
    }
}
