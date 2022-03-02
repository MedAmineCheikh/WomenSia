package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.entities.Posts;

@Repository
public interface PostRepository extends JpaRepository<Posts, Integer>{

}
