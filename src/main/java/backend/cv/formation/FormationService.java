package backend.cv.formation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

@RequiredArgsConstructor
public class FormationService {
	
    private final FormationRespository formationRespository;

    public List<Formation> findAll() {
        return formationRespository.findAll();
    }

    public Optional<Formation> findById(Long id) {
        return formationRespository.findById(id);
    }

    public Formation save(Formation stock) {
        return formationRespository.save(stock);
    }

    public void deleteById(Long id) {
        formationRespository.deleteById(id);
    }
}