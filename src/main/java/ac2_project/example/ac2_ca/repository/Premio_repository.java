package ac2_project.example.ac2_ca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ac2_project.example.ac2_ca.entity.*;

@Repository
public interface Premio_repository extends JpaRepository<Premio, Long> {

}
