package com.tobeto.entities.concretes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "languages")
public class Language {
           @Id
           @GeneratedValue(strategy = GenerationType.IDENTITY)
           @Column(name ="id")
           private int id;
           
           @Column(name = "name")
           private String name;
           
           @OneToMany(mappedBy = "language")
           private List<Tech> Techs;
}
