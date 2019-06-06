package backend.cv.activite.realisation;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class RealisationController {

    private final RealisationService realisationService;
    
    @RequestMapping("/realisations")
    public ResponseEntity<List<Realisation>> findAll() {
        return ResponseEntity.ok(realisationService.findAll());
    }
}