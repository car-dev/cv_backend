package backend.cv.activite.objectif;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/Objectifs")
@Slf4j
@RequiredArgsConstructor
public class ObjectifAPI {
    private final ObjectifService ObjectifService;

    @GetMapping
    public ResponseEntity<List<Objectif>> findAll() {
        return ResponseEntity.ok(ObjectifService.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Objectif Objectif) {
        return ResponseEntity.ok(ObjectifService.save(Objectif));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Objectif> findById(@PathVariable Long id) {
        Optional<Objectif> stock = ObjectifService.findById(id);
        if (!stock.isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(stock.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Objectif> update(@PathVariable Long id, @Valid @RequestBody Objectif Objectif) {
        if (!ObjectifService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(ObjectifService.save(Objectif));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!ObjectifService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        ObjectifService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}