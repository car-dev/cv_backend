package backend.cv.formation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/Formations")
@Slf4j
@RequiredArgsConstructor
public class FormationAPI {
    private final FormationService FormationService;

    @GetMapping
    public ResponseEntity<List<Formation>> findAll() {
        return ResponseEntity.ok(FormationService.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Formation Formation) {
        return ResponseEntity.ok(FormationService.save(Formation));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Formation> findById(@PathVariable Long id) {
        Optional<Formation> stock = FormationService.findById(id);
        if (!stock.isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(stock.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Formation> update(@PathVariable Long id, @Valid @RequestBody Formation Formation) {
        if (!FormationService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(FormationService.save(Formation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!FormationService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        FormationService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}