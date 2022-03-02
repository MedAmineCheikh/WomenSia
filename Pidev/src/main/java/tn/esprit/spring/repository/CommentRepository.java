package tn.esprit.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Comments;
import tn.esprit.spring.entities.Posts;



@Repository
public interface CommentRepository extends JpaRepository<Comments, Integer>{

	@Query(value = "select comments from comments c join user on user.IdAccount = c.IdAccount where user.IdAccount = ?1 )",nativeQuery =true)
	List<Comments> findByuser_id(int id);
	
	
//	List<Comments> findByUser(int IdComment);
	
	/**@Query(value="SELECT comments.* from comments join like on comments.IdComment = like.IdComment where pub_id_id = :publicationId GROUP by like_comments.com_id order by COUNT(like_comments.com_id) DESC",nativeQuery=true)
	List<Comments> RelevantComments(@Param("publicationId") int id);**/
	
	
	//Optional<Comments> findByUserAndId (int IdComment,int IdAccount);


}
