package com.tobeto.business.dto.tech.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTechRequest {
    private String name;
    private int languageId;
}
