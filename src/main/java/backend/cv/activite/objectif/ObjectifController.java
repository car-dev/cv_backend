package backend.cv.activite.objectif;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class ObjectifController {

    private final ObjectifService objectifService;
    
    @RequestMapping("/objectifs")
    public ResponseEntity<List<Objectif>> findAll() {
        return ResponseEntity.ok(objectifService.findAll());
    }
}