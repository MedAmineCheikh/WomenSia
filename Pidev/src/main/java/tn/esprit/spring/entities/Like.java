package tn.esprit.spring.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Like {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int like_id;
	@ManyToOne
	@JoinColumn(name="IdAccount")
	private User user;
	@Column
	private boolean isLiked;
	@JsonIgnore
	@ManyToOne
	private Posts post;
	@ManyToOne
	@JoinColumn(name="IdComment")
	private Comments comment;
	@Enumerated(EnumType.STRING)
	private Emojis interactionType;
	

}
