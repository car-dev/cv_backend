package backend.cv.cursus.module;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class ModuleController {

    private final ModuleService moduleService;
    
    @RequestMapping("/modules")
    public ResponseEntity<List<Module>> findAll() {
        return ResponseEntity.ok(moduleService.findAll());
    }
}