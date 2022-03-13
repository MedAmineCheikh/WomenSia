package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Job_Post implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdPost;
	private Long resumet;
	private String files;
	private String category;

	public Job_Post(Long resumet, String files,String category) {
		this.resumet = resumet;
		this.files =files;
		this.category = category;
	}

	@ManyToOne
	Job_Offer job_offer;
	
	@ManyToOne
	User user;
}