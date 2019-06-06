package backend.cv.activite.experience;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import backend.cv.activite.objectif.Objectif;
import backend.cv.activite.realisation.Realisation;
import lombok.Data;

@Entity

@Data
public class Experience {
	
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String entreprise;
    private String descriptionEntreprise;
    private String poste;

    private String moisEntree;
    private String anneeEntree;

    private String moisSortie;
    private String anneeSortie;
    
    private int duree;

    private String type;
    
    @OneToMany(mappedBy="experience")
    @JsonManagedReference
    private Collection<Objectif> objectifs;
        
    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;
    
}