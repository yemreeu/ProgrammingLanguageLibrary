package com.example.ProgrammingLanguagesV2Application.business.responses.languageResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class GetAllLanguagesResponse {
    private int id;
    private String name;
}
