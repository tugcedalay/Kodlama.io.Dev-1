package com.tobeto.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tobeto.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, Integer> {
       
}
