package backend.cv.module;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/Modules")
@Slf4j
@RequiredArgsConstructor
public class ModuleAPI {
    private final ModuleService ModuleService;

    @GetMapping
    public ResponseEntity<List<Module>> findAll() {
        return ResponseEntity.ok(ModuleService.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Module Module) {
        return ResponseEntity.ok(ModuleService.save(Module));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Module> findById(@PathVariable Long id) {
        Optional<Module> stock = ModuleService.findById(id);
        if (!stock.isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(stock.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Module> update(@PathVariable Long id, @Valid @RequestBody Module Module) {
        if (!ModuleService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(ModuleService.save(Module));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!ModuleService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        ModuleService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}