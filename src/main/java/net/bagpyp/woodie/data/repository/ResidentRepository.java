package net.bagpyp.woodie.data.repository;

import net.bagpyp.woodie.data.model.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResidentRepository extends JpaRepository<Resident, Long> {

//    @Query("SELECT r FROM Resident r WHERE r.email = ?1")
    Optional<Resident> findResidentByEmail(String email);
}
