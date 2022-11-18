package com.example.ProgrammingLanguagesV2Application.business.responses.technologyResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class GetAllTechnologiesResponse {
    private int id;
    private String name;
}
