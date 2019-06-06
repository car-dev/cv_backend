package backend.cv.activite.experience;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/Experiences")
@Slf4j
@RequiredArgsConstructor
public class ExperienceAPI {
    private final ExperienceService ExperienceService;

    @GetMapping
    public ResponseEntity<List<Experience>> findAll() {
        return ResponseEntity.ok(ExperienceService.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Experience Experience) {
        return ResponseEntity.ok(ExperienceService.save(Experience));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Experience> findById(@PathVariable Long id) {
        Optional<Experience> stock = ExperienceService.findById(id);
        if (!stock.isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(stock.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Experience> update(@PathVariable Long id, @Valid @RequestBody Experience Experience) {
        if (!ExperienceService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(ExperienceService.save(Experience));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!ExperienceService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        ExperienceService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}