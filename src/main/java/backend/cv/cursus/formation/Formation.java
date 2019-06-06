package backend.cv.cursus.formation;
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

import backend.cv.cursus.module.Module;
import lombok.Data;

@Entity

@Data
public class Formation {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    private int niveau;

    private int bac;
    
    private String ecole;
    
    private String sitewebecole;
    
    private String sitewebformation;

    private String ville;
    
    private Boolean result;

    private String anneeobtention;
    
    private String moisobtention;

    @OneToMany(mappedBy="formation")
    @JsonManagedReference
    private Collection<Module> modules;
    
    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;
    
}