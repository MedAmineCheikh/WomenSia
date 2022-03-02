package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Comments;
import tn.esprit.spring.repository.CommentRepository;
import tn.esprit.spring.repository.PostRepository;

import tn.esprit.spring.repository.UserRepository;

@Service
public class CommentServiceImpl implements ICommentService {
@Autowired
CommentRepository commentRepo;
@Autowired
UserRepository userRepo;
@Autowired
PostRepository postsRepo;

	@Override
	public Comments AddComment(Comments comment, int id_user,int id_pub) {
		userRepo.findById(id_user).map(user -> {
			comment.setUser(user);
			return commentRepo.save(comment);
		}).get();
		return postsRepo.findById(id_pub).map(pub -> {
			comment.setPosts(pub);
			return commentRepo.save(comment);
		}).get();
	}

	@Override
	public void DeleteComment(int id_comment) {
		commentRepo.deleteById(id_comment);
		
		
	}

	@Override
	public List<Comments> RetrieveAllComments(int user_id) {
		return commentRepo.findByuser_id(user_id);
		
	}

	@Override
	public void DeletePostsWithoutInteraction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Comments GetCommentById(int id) {
		return commentRepo.getById(id);
	}

	@Override
	public Comments UpdateComment(int id, Comments comment) {
		return commentRepo.save(comment);
	}

	@Override
	public String Hello() {
		return "HEllO there";
	}

}
