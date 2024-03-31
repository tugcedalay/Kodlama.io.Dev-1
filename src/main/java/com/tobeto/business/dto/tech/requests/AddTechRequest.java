package com.tobeto.business.dto.tech.requests;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddTechRequest {
     private String name;
     
     @NotNull
     private int languageId;
}
