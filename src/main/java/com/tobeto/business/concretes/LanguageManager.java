package com.tobeto.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobeto.business.abstracts.LanguageService;
import com.tobeto.business.dto.language.requests.AddLanguageRequest;
import com.tobeto.business.dto.language.requests.UpdateLanguageRequest;
import com.tobeto.business.dto.language.responces.GetAllLanguageResponse;
import com.tobeto.business.dto.language.responces.GetByIdLanguageResponse;
import com.tobeto.core.utilities.mapper.ModelMapperService;
import com.tobeto.dataAccess.abstracts.LanguageDao;
import com.tobeto.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {
    
	@Autowired
	private LanguageDao languageDao;
	
	@Autowired
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllLanguageResponse> getAll() {
		List<Language> languages = languageDao.findAll();
		
		List<GetAllLanguageResponse> languageResponse =  languages.stream()
				.map(language -> modelMapperService.forResponse().map(language, GetAllLanguageResponse.class))
				.toList();
		  return languageResponse;           //ilk map streamin ikincisi Modelmapperin
	}

	@Override
	public GetByIdLanguageResponse getById(int id) {
		Language language = languageDao.findById(id).orElseThrow();
		GetByIdLanguageResponse languageResponse = this.modelMapperService.forResponse().map(language,
				GetByIdLanguageResponse.class);
		return languageResponse;
	}

	@Override
	public void add(AddLanguageRequest request) {
		Language language = this.modelMapperService.forRequest().map(request, Language.class);
		this.languageDao.save(language);
		
	}

	@Override
	public void update(int id, UpdateLanguageRequest request) {
		Language language = languageDao.findById(id).orElseThrow();
		this.modelMapperService.forRequest().map(request, language);
		this.languageDao.save(language);
		
	}

	@Override
	public void delete(int id) {
		Language language = languageDao.findById(id).orElseThrow();
		this.languageDao.delete(language);
		
	}

}
