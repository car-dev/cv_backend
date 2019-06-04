package backend.cv.formation;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class FormationController {

    private final FormationService formationService;
    
    @RequestMapping("/formations")
    public ResponseEntity<List<Formation>> findAll() {
        return ResponseEntity.ok(formationService.findAll());
    }
}