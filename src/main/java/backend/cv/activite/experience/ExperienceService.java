package backend.cv.activite.experience;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

@RequiredArgsConstructor
public class ExperienceService {
	
    private final ExperienceRespository experienceRespository;

    public List<Experience> findAll() {
        return experienceRespository.findAll();
    }

    public Optional<Experience> findById(Long id) {
        return experienceRespository.findById(id);
    }

    public Experience save(Experience stock) {
        return experienceRespository.save(stock);
    }

    public void deleteById(Long id) {
        experienceRespository.deleteById(id);
    }
}