package com.ltp.gradesubmission.controller;

import com.ltp.gradesubmission.request.AudioProcessRequest;
import com.ltp.gradesubmission.response.AssemblyResponse;
import com.ltp.gradesubmission.service.AssemblyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URISyntaxException;

@Controller
@RequestMapping("/audio")
@AllArgsConstructor
public class ProcessAudioController {

    private final AssemblyService assemblyService;

    @PostMapping("/processAudio")
    public ResponseEntity<AssemblyResponse> processAudio(@RequestBody AudioProcessRequest request, HttpServletRequest servletRequest) throws URISyntaxException, IOException, InterruptedException {
        return new ResponseEntity<>(assemblyService.processAudio(request, servletRequest), HttpStatus.OK);
    }

    @GetMapping("/audioToText/{id}")
    public ResponseEntity<AssemblyResponse> getAudioToText(@PathVariable String id, HttpServletRequest servletRequest) throws IOException, URISyntaxException, InterruptedException {
        return new ResponseEntity<>(assemblyService.getProcessedAudio(id, servletRequest), HttpStatus.OK);
    }
}
