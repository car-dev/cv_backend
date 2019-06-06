package backend.cv.activite.envtechnique;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

@RequiredArgsConstructor
public class EnvTechniqueService {
	
    private final EnvTechniqueRespository envTechniqueRespository;

    public List<EnvTechnique> findAll() {
        return envTechniqueRespository.findAll();
    }

    public Optional<EnvTechnique> findById(Long id) {
        return envTechniqueRespository.findById(id);
    }

    public EnvTechnique save(EnvTechnique stock) {
        return envTechniqueRespository.save(stock);
    }

    public void deleteById(Long id) {
        envTechniqueRespository.deleteById(id);
    }
}