package backend.cv.activite.objectif;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

@RequiredArgsConstructor
public class ObjectifService {
	
    private final ObjectifRespository objectifRespository;

    public List<Objectif> findAll() {
        return objectifRespository.findAll();
    }

    public Optional<Objectif> findById(Long id) {
        return objectifRespository.findById(id);
    }

    public Objectif save(Objectif stock) {
        return objectifRespository.save(stock);
    }

    public void deleteById(Long id) {
        objectifRespository.deleteById(id);
    }
}