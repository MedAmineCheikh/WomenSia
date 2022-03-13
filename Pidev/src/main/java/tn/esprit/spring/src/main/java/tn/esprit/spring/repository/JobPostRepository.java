package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Job_Post;


@Repository
public interface JobPostRepository extends JpaRepository<Job_Post,Integer> {
}
