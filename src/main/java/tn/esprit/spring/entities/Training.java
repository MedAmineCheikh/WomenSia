package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Training implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdTrainning;
	private String TrainningName;
	private String TrainerName;
	private String Duration;
	private String Files;
	private Long Description;
	@Temporal(TemporalType.DATE)
	private Date TrainingDate;
	private int NbrofPlaces;
	@ManyToOne
	Certificats certificats;
	
	@ManyToOne
	User user;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<User> users;
	
}
