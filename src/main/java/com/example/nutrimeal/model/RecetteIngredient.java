package com.example.nutrimeal.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;


@IdClass(value = RecetteIngredient.class)
@Entity(name = "RECETTE_INGREDIENT")
@Getter
@Setter
public class RecetteIngredient implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_RECETTE")
	private Long idRecette;

	@Id
	@Column(name = "ID_INGREDIENT")
	private Long idIngredient;

	@ManyToOne
    @JoinColumn(name="ID_RECETTE", nullable=false, insertable= false, updatable=false)
	@JsonIgnore
    public Recette recette;
	
	@Column(name = "QUANTITE")
	private Double quantite;

	@ManyToOne
    @JoinColumn(name="ID_INGREDIENT", nullable=false, insertable= false, updatable=false)
    public Ingredient ingredients;
}
