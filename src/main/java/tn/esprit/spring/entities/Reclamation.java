package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Reclamation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdReclamation;
	private String NomReclamation;
	@Enumerated(EnumType.STRING)
	TypeReclamation TypeReclam;

    private String Nom;
    private String Prenom ;
    private String Adresse;
    private String Email;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String Description ;
    private String Traité ; 
    @ManyToOne
	User users ;
 
    }
	