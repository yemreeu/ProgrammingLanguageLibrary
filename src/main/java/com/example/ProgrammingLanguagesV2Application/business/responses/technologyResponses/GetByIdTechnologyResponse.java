package com.example.ProgrammingLanguagesV2Application.business.responses.technologyResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class GetByIdTechnologyResponse {
    private int id;
    private String name;
}
