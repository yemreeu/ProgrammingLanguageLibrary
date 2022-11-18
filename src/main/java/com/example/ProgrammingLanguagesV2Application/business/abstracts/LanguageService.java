package com.example.ProgrammingLanguagesV2Application.business.abstracts;

import com.example.ProgrammingLanguagesV2Application.business.requests.languageRequests.CreateLanguageRequest;
import com.example.ProgrammingLanguagesV2Application.business.requests.languageRequests.DeleteLanguageRequest;
import com.example.ProgrammingLanguagesV2Application.business.requests.languageRequests.UpdateLanguageRequest;
import com.example.ProgrammingLanguagesV2Application.business.responses.languageResponses.GetAllLanguagesResponse;
import com.example.ProgrammingLanguagesV2Application.business.responses.languageResponses.GetByIdLanguageResponse;

import java.util.List;

public interface LanguageService {

    void add(CreateLanguageRequest createLanguageRequest) throws Exception;
    void delete(DeleteLanguageRequest deleteLanguageRequest) throws Exception;
    void update(UpdateLanguageRequest updateLanguageRequest) throws Exception;
    List<GetAllLanguagesResponse> getAll();
    GetByIdLanguageResponse getByIdLanguage(int id) throws Exception;
}
