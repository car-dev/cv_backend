package backend.cv.activite.envtechnique;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import backend.cv.activite.objectif.Objectif;
import lombok.Data;

@Entity

@Data
public class EnvTechnique {
	
	/*
	 * Experience > Objectif > envTechnique = Visual Paradigm, UML
	 */
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @OneToOne
    @JsonBackReference
    private Objectif objectif;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;
    
}