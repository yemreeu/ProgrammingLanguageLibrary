package com.example.ProgrammingLanguagesV2Application.business.concretes;

import com.example.ProgrammingLanguagesV2Application.business.abstracts.TechnologyService;
import com.example.ProgrammingLanguagesV2Application.business.requests.technologyRequests.CreateTechnologyRequest;
import com.example.ProgrammingLanguagesV2Application.business.requests.technologyRequests.DeleteTechnologyRequest;
import com.example.ProgrammingLanguagesV2Application.business.requests.technologyRequests.UpdateTechnologyRequest;
import com.example.ProgrammingLanguagesV2Application.business.responses.technologyResponses.GetAllTechnologiesResponse;
import com.example.ProgrammingLanguagesV2Application.business.responses.technologyResponses.GetByIdTechnologyResponse;
import com.example.ProgrammingLanguagesV2Application.dataAccess.abstracts.LanguageRepository;
import com.example.ProgrammingLanguagesV2Application.dataAccess.abstracts.TechnologyRepository;
import com.example.ProgrammingLanguagesV2Application.entities.concretes.Technology;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TechnologyManager implements TechnologyService {
    public TechnologyRepository technologyRepository;
    public LanguageRepository languageRepository;

    public TechnologyManager(TechnologyRepository technologyRepository, LanguageRepository languageRepository) {
        this.technologyRepository = technologyRepository;
        this.languageRepository = languageRepository;
    }

    @Override
    public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception {
        if (createTechnologyRequest.getName().isEmpty()){
            throw new IllegalStateException("Please provide a valid input!");
        }
        if(languageRepository.equals(createTechnologyRequest)){
            throw new IllegalStateException("This one is already exists!");
        }
        Technology technology = new Technology();
        technology.setName(createTechnologyRequest.getName());
        technologyRepository.save(technology);
    }

    @Override
    public void update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception {
        if (!(technologyRepository.existsById(updateTechnologyRequest.getId()))){
            throw new Exception("The technology you would like to update does not exists in the system!");
        }
        Technology technology = new Technology();
        technology.setName(updateTechnologyRequest.getName());
        technology.setId(updateTechnologyRequest.getId());
        technologyRepository.save(technology);
    }

    @Override
    public void delete(DeleteTechnologyRequest deleteTechnologyRequest) throws Exception {
        if (!(technologyRepository.equals(deleteTechnologyRequest))){
            throw new IllegalStateException("This language is not exists because of that it cannot be deleted");
        }
        Technology technology = new Technology();
        technology.setId(deleteTechnologyRequest.getId());
        technologyRepository.delete(technology);
    }

    @Override
    public List<GetAllTechnologiesResponse> getAll() {
        List<Technology> technologies = technologyRepository.findAll();
        List<GetAllTechnologiesResponse> getAllTechnologiesResponses = new ArrayList<>();
        for (Technology t: technologies){
            GetAllTechnologiesResponse response = new GetAllTechnologiesResponse();
            response.setId(t.getId());
            response.setName(t.getName());
            getAllTechnologiesResponses.add(response);
        }
        return getAllTechnologiesResponses;
    }

    @Override
    public GetByIdTechnologyResponse getById(int id) throws Exception {
        if (!(technologyRepository.existsById(id))){
            throw new Exception("There is no such an Id!");
        }
        Technology item = this.technologyRepository.findById(id).get();

        GetByIdTechnologyResponse getByIdTechnologyResponse = new GetByIdTechnologyResponse();
        getByIdTechnologyResponse.setId(item.getId());
        getByIdTechnologyResponse.setName(item.getName());

        return getByIdTechnologyResponse;
    }
}
