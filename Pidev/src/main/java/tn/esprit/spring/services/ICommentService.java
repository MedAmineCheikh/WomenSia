package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Comments;


public interface ICommentService {
	
	public Comments AddComment(Comments comment, int id_user,int id_pub);
	public void DeleteComment(int id_comment);
	public List<Comments> RetrieveAllComments(int user_id);
	public void DeletePostsWithoutInteraction();
    public Comments GetCommentById(int id);
    public Comments UpdateComment(int id,Comments comment);
 public String Hello();
}
