package backend.cv.activite.envtechnique;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/EnvTechniques")
@Slf4j
@RequiredArgsConstructor
public class EnvTechniqueAPI {
    private final EnvTechniqueService EnvTechniqueService;

    @GetMapping
    public ResponseEntity<List<EnvTechnique>> findAll() {
        return ResponseEntity.ok(EnvTechniqueService.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody EnvTechnique EnvTechnique) {
        return ResponseEntity.ok(EnvTechniqueService.save(EnvTechnique));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnvTechnique> findById(@PathVariable Long id) {
        Optional<EnvTechnique> stock = EnvTechniqueService.findById(id);
        if (!stock.isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(stock.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnvTechnique> update(@PathVariable Long id, @Valid @RequestBody EnvTechnique EnvTechnique) {
        if (!EnvTechniqueService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(EnvTechniqueService.save(EnvTechnique));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!EnvTechniqueService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        EnvTechniqueService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}