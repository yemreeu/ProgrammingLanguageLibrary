package com.example.ProgrammingLanguagesV2Application.business.concretes;

import com.example.ProgrammingLanguagesV2Application.business.abstracts.LanguageService;
import com.example.ProgrammingLanguagesV2Application.business.requests.languageRequests.CreateLanguageRequest;
import com.example.ProgrammingLanguagesV2Application.business.requests.languageRequests.DeleteLanguageRequest;
import com.example.ProgrammingLanguagesV2Application.business.requests.languageRequests.UpdateLanguageRequest;
import com.example.ProgrammingLanguagesV2Application.business.responses.languageResponses.GetAllLanguagesResponse;
import com.example.ProgrammingLanguagesV2Application.business.responses.languageResponses.GetByIdLanguageResponse;
import com.example.ProgrammingLanguagesV2Application.dataAccess.abstracts.LanguageRepository;
import com.example.ProgrammingLanguagesV2Application.entities.concretes.Language;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LanguageManager implements LanguageService {
    public LanguageRepository languageRepository;

    public LanguageManager(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public void add(CreateLanguageRequest createLanguageRequest) throws Exception {
        if (createLanguageRequest.getName().isEmpty()){
            throw new IllegalStateException("Please provide a valid input!");
        }
        if(languageRepository.equals(createLanguageRequest)){
            throw new IllegalStateException("This one is already exists!");
        }
        Language language = new Language();
        language.setName(createLanguageRequest.getName());
        languageRepository.save(language);
    }

    @Override
    public void delete(DeleteLanguageRequest deleteLanguageRequest) throws Exception {
        if (!(languageRepository.equals(deleteLanguageRequest))){
            throw new IllegalStateException("This language is not exists because of that it cannot be deleted");
        }
        Language language = new Language();
        language.setId(deleteLanguageRequest.getId());
        languageRepository.delete(language);
    }

    @Override
    public void update(UpdateLanguageRequest updateLanguageRequest) throws Exception {
        if (!(languageRepository.existsById(updateLanguageRequest.getId()))){
            throw new Exception("The language you would like to update is not exists in the system!");
        }
        Language language = new Language();
        language.setId(updateLanguageRequest.getId());
        language.setName(updateLanguageRequest.getName());
        languageRepository.save(language);
    }

    @Override
    public List<GetAllLanguagesResponse> getAll() {
        List<Language> languages = languageRepository.findAll();
        List<GetAllLanguagesResponse> getAllLanguagesResponses = new ArrayList<>();
        for (Language l : languages){
            GetAllLanguagesResponse responseItem = new GetAllLanguagesResponse();
            responseItem.setId(l.getId());
            responseItem.setName(l.getName());

            getAllLanguagesResponses.add(responseItem);
        }
        return getAllLanguagesResponses;
    }

    @Override
    public GetByIdLanguageResponse getByIdLanguage(int id) throws Exception {
        if (!(languageRepository.existsById(id))){
            throw new Exception("There is no such an Id!");
        }
        Language item = this.languageRepository.findById(id).get();

        GetByIdLanguageResponse getByIdLanguageResponse = new GetByIdLanguageResponse();
        getByIdLanguageResponse.setId(item.getId());
        getByIdLanguageResponse.setName(item.getName());

        return getByIdLanguageResponse;
    }
}
