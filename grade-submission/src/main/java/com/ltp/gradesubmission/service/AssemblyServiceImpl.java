package com.ltp.gradesubmission.service;

import com.google.gson.Gson;
import com.ltp.gradesubmission.constant.ProjectConstant;
import com.ltp.gradesubmission.entity.Transcript;
import com.ltp.gradesubmission.request.AudioProcessRequest;
import com.ltp.gradesubmission.response.AssemblyResponse;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;


@Service
public class AssemblyServiceImpl implements AssemblyService {

    @Override
    public AssemblyResponse processAudio(AudioProcessRequest request) throws ServiceException {
        Transcript transcript = new Transcript();
        transcript.setAudio_url(request.getAudio_url());

        Gson gson = new Gson();
        String jsonRequest = gson.toJson(transcript);
        System.out.println(jsonRequest);

//        HttpRequest httpRequest = HttpRequest.newBuilder()
//                .uri(new URI(ProjectConstant.ASSEMBLY_AI_URI))
//                .header("Authorization", ProjectConstant.TOKEN)
//                .POST()
//                .build();


        return null;
    }

}
