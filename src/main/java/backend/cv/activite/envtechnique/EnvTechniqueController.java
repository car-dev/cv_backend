package backend.cv.activite.envtechnique;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class EnvTechniqueController {

    private final EnvTechniqueService envTechniqueService;
    
    @RequestMapping("/envTechniques")
    public ResponseEntity<List<EnvTechnique>> findAll() {
        return ResponseEntity.ok(envTechniqueService.findAll());
    }
}