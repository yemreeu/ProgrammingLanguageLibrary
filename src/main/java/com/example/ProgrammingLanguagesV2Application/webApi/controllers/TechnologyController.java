package com.example.ProgrammingLanguagesV2Application.webApi.controllers;

import com.example.ProgrammingLanguagesV2Application.business.abstracts.TechnologyService;
import com.example.ProgrammingLanguagesV2Application.business.requests.technologyRequests.CreateTechnologyRequest;
import com.example.ProgrammingLanguagesV2Application.business.requests.technologyRequests.DeleteTechnologyRequest;
import com.example.ProgrammingLanguagesV2Application.business.requests.technologyRequests.UpdateTechnologyRequest;
import com.example.ProgrammingLanguagesV2Application.business.responses.technologyResponses.GetAllTechnologiesResponse;
import com.example.ProgrammingLanguagesV2Application.business.responses.technologyResponses.GetByIdTechnologyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {

    private final TechnologyService technologyService;

    @Autowired
    public TechnologyController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @GetMapping("/get-all")
    public List<GetAllTechnologiesResponse> getAllTechnologiesResponses(){
        return technologyService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateTechnologyRequest createTechnologyRequest) throws Exception {
        technologyService.add(createTechnologyRequest);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody DeleteTechnologyRequest deleteTechnologyRequest) throws Exception {
        technologyService.delete(deleteTechnologyRequest);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateTechnologyRequest updateTechnologyRequest) throws Exception {
        technologyService.update(updateTechnologyRequest);
    }

    @GetMapping("/get-by-id")
    public GetByIdTechnologyResponse getByIdTechnologyResponse(@RequestParam int id) throws Exception {
        return technologyService.getById(id);
    }

}
