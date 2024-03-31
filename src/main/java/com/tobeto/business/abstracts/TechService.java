package com.tobeto.business.abstracts;

import java.util.List;

import com.tobeto.business.dto.tech.requests.AddTechRequest;
import com.tobeto.business.dto.tech.requests.UpdateTechRequest;
import com.tobeto.business.dto.tech.responces.GetAllTechResponse;
import com.tobeto.business.dto.tech.responces.GetByIdTechResponse;

public interface TechService {
   List<GetAllTechResponse> getAll();

	GetByIdTechResponse getById(int id);

	void add(AddTechRequest request);

	void update(int id, UpdateTechRequest request);

	void delete(int id);
}
