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

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Event implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdEvent;
 	private String Eventname;
	private String Organizername;

	private Date DateEvent;
    private String Duration;
    private String Files;
    private String Description ;
    private int NbPlace;
   
    @OneToOne
    private Pool pool;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<User> users;
    @ManyToMany 
    private  List <Sponsors> sponsors;
    //@ManyToOne
	//Sponsors sponsors;
   // @OneToMany(mappedBy="event")
	//private List<Sponsors> sponsors;
	public void setSponsors() {
		// TODO Auto-generated method stub
		
	}
}
	