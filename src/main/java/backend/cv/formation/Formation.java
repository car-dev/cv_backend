package backend.cv.formation;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
    
    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;
}