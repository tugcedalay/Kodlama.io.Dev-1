package com.tobeto.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobeto.business.abstracts.TechService;
import com.tobeto.business.dto.tech.requests.AddTechRequest;
import com.tobeto.business.dto.tech.requests.UpdateTechRequest;
import com.tobeto.business.dto.tech.responces.GetAllTechResponse;
import com.tobeto.business.dto.tech.responces.GetByIdTechResponse;
import com.tobeto.core.utilities.mapper.ModelMapperService;
import com.tobeto.dataAccess.abstracts.TechDao;
import com.tobeto.entities.concretes.Tech;

@Service
public class TechManager implements TechService{
    
	@Autowired
	private final TechDao techDao;
	
	@Autowired
	private ModelMapperService modelMapperService;


    TechManager(TechDao techDao) {
        this.techDao = techDao;
    }
		
	@Override
	public List<GetAllTechResponse> getAll() {
		List<Tech> techs = techDao.findAll();
		List<GetAllTechResponse> techResponse = techs.stream().map(
				tech -> this.modelMapperService.forResponse().map(tech, GetAllTechResponse.class))
				.toList();
		return techResponse;
	}

	@Override
	public GetByIdTechResponse getById(int id) {
		Tech tech = techDao.findById(id).orElseThrow();
		GetByIdTechResponse techResponse = this.modelMapperService.forResponse().map(tech,
				GetByIdTechResponse.class);
		return techResponse;
	}

	@Override
	public void add(AddTechRequest request) {
		Tech tech = this.modelMapperService.forRequest().map(request, Tech.class);
		this.techDao.save(tech);
		
	}

	@Override
	public void update(int id, UpdateTechRequest request) {
		Tech tech = techDao.findById(id).orElseThrow();
		this.modelMapperService.forRequest().map(request, tech);
		this.techDao.save(tech);
		
	}

	@Override
	public void delete(int id) {
		Tech tech = techDao.findById(id).orElseThrow();
		this.techDao.delete(tech);
		
	}

}
