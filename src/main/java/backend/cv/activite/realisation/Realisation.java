package backend.cv.activite.realisation;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import backend.cv.activite.objectif.Objectif;
import backend.cv.cursus.module.Module;
import lombok.Data;

@Entity

@Data
public class Realisation {
	
	/*
	 * 
	Experience > Objectif > Realisation =  Recueil du besoin métier auprès du client interne
	 */
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    @ManyToOne
    @JsonBackReference
    private Objectif objectif;
    
    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;
    
}