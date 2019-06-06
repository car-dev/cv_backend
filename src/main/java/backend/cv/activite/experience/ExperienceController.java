package backend.cv.activite.experience;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class ExperienceController {

    private final ExperienceService experienceService;
    
    @RequestMapping("/experiences")
    public ResponseEntity<List<Experience>> findAll() {
        return ResponseEntity.ok(experienceService.findAll());
    }
}