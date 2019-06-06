package backend.cv.activite.realisation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

@RequiredArgsConstructor
public class RealisationService {
	
    private final RealisationRespository realisationRespository;

    public List<Realisation> findAll() {
        return realisationRespository.findAll();
    }

    public Optional<Realisation> findById(Long id) {
        return realisationRespository.findById(id);
    }

    public Realisation save(Realisation stock) {
        return realisationRespository.save(stock);
    }

    public void deleteById(Long id) {
        realisationRespository.deleteById(id);
    }
}