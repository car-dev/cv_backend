package backend.cv.activite.objectif;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import backend.cv.activite.envtechnique.EnvTechnique;
import backend.cv.activite.experience.Experience;
import backend.cv.activite.realisation.Realisation;
import lombok.Data;

@Entity

@Data
public class Objectif {
	
	/*
	 * Experience > objectif = 
	 * - description : Création d’une application mobile d’imputation du temps de travail 
	 * - contexte : Agile - 2 personnes
	 */
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    
    private String contexte;

    @ManyToOne
    @JsonBackReference
    private Experience experience;
    
    @OneToMany(mappedBy="objectif")
    @JsonManagedReference
    private Collection<Realisation> realisations;
    
    @OneToOne(mappedBy="objectif")
    @JsonManagedReference
    private EnvTechnique envTechniques;
    
    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;
    
}