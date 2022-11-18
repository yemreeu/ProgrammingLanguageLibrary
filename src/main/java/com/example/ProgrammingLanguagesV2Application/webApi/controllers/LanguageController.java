package com.example.ProgrammingLanguagesV2Application.webApi.controllers;

import com.example.ProgrammingLanguagesV2Application.business.abstracts.LanguageService;
import com.example.ProgrammingLanguagesV2Application.business.requests.languageRequests.CreateLanguageRequest;
import com.example.ProgrammingLanguagesV2Application.business.requests.languageRequests.DeleteLanguageRequest;
import com.example.ProgrammingLanguagesV2Application.business.requests.languageRequests.UpdateLanguageRequest;
import com.example.ProgrammingLanguagesV2Application.business.responses.languageResponses.GetAllLanguagesResponse;
import com.example.ProgrammingLanguagesV2Application.business.responses.languageResponses.GetByIdLanguageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {
    private final LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/get-all")
    public List<GetAllLanguagesResponse> getAll(){
        return languageService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateLanguageRequest createLanguageRequest) throws Exception {
        languageService.add(createLanguageRequest);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateLanguageRequest updateLanguageRequest) throws Exception {
        languageService.update(updateLanguageRequest);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody DeleteLanguageRequest deleteLanguageRequest) throws Exception {
        languageService.delete(deleteLanguageRequest);
    }

    @GetMapping("/get-by-id")
    public GetByIdLanguageResponse getByIdLanguageResponse(@RequestParam int id) throws Exception {
        return languageService.getByIdLanguage(id);
    }
}
