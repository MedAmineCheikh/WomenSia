package tn.esprit.spring.entities;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comments implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdComment;
	private String Comment_field;
	private String Reply_to;
	private int NbrLikeComments;
	private String Emoji;
	private String Rating;
	
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	Posts posts;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="comment")
	private List<Like> like;
	

}
