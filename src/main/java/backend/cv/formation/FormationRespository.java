package backend.cv.formation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FormationRespository extends JpaRepository<Formation, Long> {
}