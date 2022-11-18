package com.example.ProgrammingLanguagesV2Application.business.abstracts;

import com.example.ProgrammingLanguagesV2Application.business.requests.technologyRequests.CreateTechnologyRequest;
import com.example.ProgrammingLanguagesV2Application.business.requests.technologyRequests.DeleteTechnologyRequest;
import com.example.ProgrammingLanguagesV2Application.business.requests.technologyRequests.UpdateTechnologyRequest;
import com.example.ProgrammingLanguagesV2Application.business.responses.technologyResponses.GetAllTechnologiesResponse;
import com.example.ProgrammingLanguagesV2Application.business.responses.technologyResponses.GetByIdTechnologyResponse;

import java.util.List;

public interface TechnologyService {
    void add(CreateTechnologyRequest createTechnologyRequest) throws Exception;
    void update(UpdateTechnologyRequest updateTechnologyRequest) throws  Exception;
    void delete(DeleteTechnologyRequest deleteTechnologyRequest) throws  Exception;
    List<GetAllTechnologiesResponse> getAll();
    GetByIdTechnologyResponse getById(int id) throws Exception;
}
