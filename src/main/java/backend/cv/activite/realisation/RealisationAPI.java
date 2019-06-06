package backend.cv.activite.realisation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/Realisations")
@Slf4j
@RequiredArgsConstructor
public class RealisationAPI {
    private final RealisationService RealisationService;

    @GetMapping
    public ResponseEntity<List<Realisation>> findAll() {
        return ResponseEntity.ok(RealisationService.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Realisation Realisation) {
        return ResponseEntity.ok(RealisationService.save(Realisation));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Realisation> findById(@PathVariable Long id) {
        Optional<Realisation> stock = RealisationService.findById(id);
        if (!stock.isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(stock.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Realisation> update(@PathVariable Long id, @Valid @RequestBody Realisation Realisation) {
        if (!RealisationService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(RealisationService.save(Realisation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!RealisationService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        RealisationService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}