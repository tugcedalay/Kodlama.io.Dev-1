package com.tobeto.business.dto.tech.responces;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllTechResponse {
    private int id;
    private String name;
    private int languageId;
    private String languageName;
}
