package com.ltp.gradesubmission.service;

import com.google.gson.Gson;
import com.ltp.gradesubmission.constant.ProjectConstant;
import com.ltp.gradesubmission.entity.Transcript;
import com.ltp.gradesubmission.request.AudioProcessRequest;
import com.ltp.gradesubmission.response.AssemblyResponse;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Service
public class AssemblyServiceImpl implements AssemblyService {

    @Override
    public AssemblyResponse processAudio(AudioProcessRequest request) throws ServiceException, URISyntaxException, IOException, InterruptedException {
        Transcript transcript = new Transcript();
        transcript.setAudio_url(request.getAudio_url());

        Gson gson = new Gson();
        String jsonRequest = gson.toJson(transcript);


        HttpResponse<String> response =  sendPostRequest(jsonRequest);

        //convert JSON to entity
        transcript = gson.fromJson(response.body(), Transcript.class);
        AssemblyResponse assemblyResponse = new AssemblyResponse();
        assemblyResponse.setText(transcript.getText());
        assemblyResponse.setStatus(transcript.getStatus());
        assemblyResponse.setAudio_url(transcript.getAudio_url());

        return assemblyResponse;
    }

    private HttpResponse<String> sendPostRequest(String jsonRequest) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI(ProjectConstant.ASSEMBLY_AI_URI))
                .header("Authorization", ProjectConstant.TOKEN)
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        return httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
    }



}
