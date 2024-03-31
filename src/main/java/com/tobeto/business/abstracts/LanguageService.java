package com.tobeto.business.abstracts;

import java.util.List;

import com.tobeto.business.dto.language.requests.AddLanguageRequest;
import com.tobeto.business.dto.language.requests.UpdateLanguageRequest;
import com.tobeto.business.dto.language.responces.GetAllLanguageResponse;
import com.tobeto.business.dto.language.responces.GetByIdLanguageResponse;

public interface LanguageService{
	List<GetAllLanguageResponse> getAll();
    
	GetByIdLanguageResponse getById(int id);
	
	void add(AddLanguageRequest request);
	
	void update(int id, UpdateLanguageRequest request);
	
	void delete(int id);
}
