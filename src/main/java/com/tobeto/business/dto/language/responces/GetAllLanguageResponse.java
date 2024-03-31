package com.tobeto.business.dto.language.responces;

import java.util.List;

import com.tobeto.business.dto.tech.responces.GetAllTechName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllLanguageResponse {
	private int id;
    private String name;
    private List<GetAllTechName> techs;
}
