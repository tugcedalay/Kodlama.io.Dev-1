package com.tobeto.webApi.controllers;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.business.abstracts.TechService;
import com.tobeto.business.dto.tech.requests.AddTechRequest;
import com.tobeto.business.dto.tech.requests.UpdateTechRequest;
import com.tobeto.business.dto.tech.responces.GetAllTechResponse;
import com.tobeto.business.dto.tech.responces.GetByIdTechResponse;


@RestController 
@RequestMapping("/api/v1/tech")
public class TechsController {
	@Autowired
	private TechService techService;
	JSONObject result = new JSONObject();

	@GetMapping(path = ("/getall"), produces = MediaType.APPLICATION_JSON_VALUE)
	public List<GetAllTechResponse> getAll() {
		return this.techService.getAll();
	}

	@GetMapping(path = ("/{id}"), produces = MediaType.APPLICATION_JSON_VALUE)
	public GetByIdTechResponse getById(@PathVariable int id) {
		return this.techService.getById(id);
	}

	@PostMapping(path= ("/add"), produces = MediaType.APPLICATION_JSON_VALUE)
	public String add(@RequestBody AddTechRequest request) {
		result.put("Message", request.getName() + " is added to language id: " + request.getLanguageId());
		this.techService.add(request);
		return result.toString();
	}

	@PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String update(int id, UpdateTechRequest request) {
		result.put("Messsage", "Technology is updated: " + id);
		this.techService.update(id, request);
		return result.toString();
	}

	@DeleteMapping(path = ("/{id}"), produces = MediaType.APPLICATION_JSON_VALUE)
	public String delete(@PathVariable int id) {
		result.put("Message", "Technology is deleted: " + id);
		this.techService.delete(id);
		return result.toString();
	}
}
