package com.tobeto.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tobeto.entities.concretes.Tech;

public interface TechDao extends JpaRepository<Tech, Integer>{

}
