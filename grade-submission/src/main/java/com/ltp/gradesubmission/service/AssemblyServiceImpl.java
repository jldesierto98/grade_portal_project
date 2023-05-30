package com.ltp.gradesubmission.service;

import com.google.gson.Gson;
import com.ltp.gradesubmission.entity.Transcript;
import com.ltp.gradesubmission.request.AudioProcessRequest;
import com.ltp.gradesubmission.response.AssemblyResponse;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Service
public class AssemblyServiceImpl implements AssemblyService {

    private final String AUTHORIZATION = "Authorization";

    @Override
    public AssemblyResponse processAudio(AudioProcessRequest request, HttpServletRequest servletRequest) throws ServiceException, URISyntaxException, IOException, InterruptedException {
        Transcript transcript = new Transcript();
        transcript.setAudio_url(request.getAudio_url());
        String token = servletRequest.getHeader(AUTHORIZATION);
        Gson gson = new Gson();
        String jsonRequest = gson.toJson(transcript);

        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI("https://api.assemblyai.com/v2/transcript"))
                .header("Authorization", token)
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                .build();


        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> postResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
        transcript = gson.fromJson(postResponse.body(), Transcript.class);

        return buildAssemblyResponse(transcript);
    }

    @Override
    public AssemblyResponse getProcessedAudio(String id,  HttpServletRequest servletRequest) throws IOException, InterruptedException, URISyntaxException {
        Transcript transcript = new Transcript();

        Gson gson = new Gson();
        String jsonRequest = gson.toJson(transcript);
        String token = servletRequest.getHeader(AUTHORIZATION);

        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https://api.assemblyai.com/v2/transcript/" + id))
                .header("Authorization", token)
                .GET()
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
        transcript = gson.fromJson(getResponse.body(), Transcript.class);


         return buildAssemblyResponse(transcript);
    }

    private static AssemblyResponse buildAssemblyResponse(Transcript transcript) {
        AssemblyResponse assemblyResponse = new AssemblyResponse();
        assemblyResponse.setAudio_url(transcript.getAudio_url());
        assemblyResponse.setText(transcript.getText());
        assemblyResponse.setStatus(transcript.getStatus());
        assemblyResponse.setId(transcript.getId());
        return assemblyResponse;
    }
}
