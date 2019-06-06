package backend.cv.cursus.module;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

@RequiredArgsConstructor
public class ModuleService {
	
    private final ModuleRespository formationRespository;

    public List<Module> findAll() {
        return formationRespository.findAll();
    }

    public Optional<Module> findById(Long id) {
        return formationRespository.findById(id);
    }

    public Module save(Module stock) {
        return formationRespository.save(stock);
    }

    public void deleteById(Long id) {
        formationRespository.deleteById(id);
    }
}