package com.tobeto.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "Techs")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tech {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //veri eklendıgınde otomatik artması için sadece integerda (identite)
	@Column(name = "id")
	private int id;
   
	@Column(name ="name")
   private String name;
   
   @ManyToOne
   @JoinColumn(name="language_id") //veritabınan language id diye kolon olusturuldu
   private Language language;
}
