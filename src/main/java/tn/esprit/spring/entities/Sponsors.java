package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
public class Sponsors implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdSponsor;
	private String Name_Spons;
	private String Description;
	private String Pack;
	private int Sum;
	@Enumerated(EnumType.STRING)
	Domaine domaine;
	@ManyToMany(mappedBy="sponsors")
	private List<Event> event;
	//@OneToMany( mappedBy="sponsors")
	//private List<Event> event;
    //@ManyToOne
	//Event event;
	
}
