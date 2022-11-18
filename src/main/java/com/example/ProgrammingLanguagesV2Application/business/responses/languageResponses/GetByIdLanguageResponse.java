package com.example.ProgrammingLanguagesV2Application.business.responses.languageResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class GetByIdLanguageResponse {
    private int id;
    private String name;
}
