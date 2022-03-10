package tn.esprit.spring.services;


import java.sql.Connection;
import java.util.List;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.mail.MessagingException;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.config.Database;
import tn.esprit.spring.entities.Event;
import tn.esprit.spring.entities.Reclamation;
 

import tn.esprit.spring.repository.ReclamRepository;
import tn.esprit.spring.repository.UserRepository;
@Service
@Slf4j
public class ReclamServiceImpl implements IReclamService {
	@Autowired
	JavaMailSenderImpl e;
	@Autowired
	ReclamRepository rRepository;
	@Autowired 
	UserRepository uRepository;

	@Override
	public List<Reclamation> retrieveAllReclamation() {
		List<Reclamation> listReclamation= (List<Reclamation>) rRepository.findAll();
		for(Reclamation c:listReclamation)
		{
			log.info("Reclamation:" + c.getNomReclamation());
		}
		return listReclamation;
	}

	@Override
	public Reclamation addReclamation(Reclamation c) {
		rRepository.save(c);
		return c;
	}

	@Override
	public void deleteReclamation(Integer id) {
		rRepository.deleteById(id);

	}

	@Override
	public Reclamation updateReclamation(Reclamation c) {
		rRepository.save(c);
		return c;
	}

	@Override
	public Reclamation retrieveReclamation(Integer id) {
		Reclamation c= rRepository.findById(id).get();
		return c;
	}
	
	public void traiterReclam (Boolean bool ,Integer idrec) throws MessagingException {
		
	 
		Reclamation c= rRepository.findById(idrec).get();
		 

		if (bool==true) {
			 Connection connection3 = null;
			Statement statement3 = null;
			ResultSet resultSet3 = null;
			
			
			String dbUrl = "jdbc:mysql://localhost:3308/pidev";
			String user = "root";
			String password = "";
			try {
			 connection3 = Database.getConnection(dbUrl, user, password);
		       statement3 = connection3.createStatement(); 
		       java.sql.PreparedStatement pr= connection3.prepareStatement("UPDATE reclamation SET users_id_account=1 WHERE id_reclamation=5 ");
		       pr.setString(1,"Oui");
				 			resultSet3 =pr.executeQuery();
				 			
 				 			
				 		} catch (Exception e) {
				 			System.out.println(e.getStackTrace());
				 		} finally {
				 			Database.closeResultSet(resultSet3);
				 			Database.closeStatement(statement3);
				 			Database.closeConnection(connection3);
				 		} 
		 
			 

			String to=c.getEmail();
			String att="A PROPOS VOTRE RECLAMATION";
			String sub="Bonjou"+c.getNom()+c.getPrenom()+"Par le présent courrier nous vous informons que votre reclamation a été bien traité";
			String chem="C:\\\\Users\\\\moham\\\\Desktop\\\\PI-DOUBLEU\\\\src\\\\main\\\\resources\\\\QRCd.png";
			  
				//JavaMailSenderImpl sender =new JavaMailSenderImpl();
				//   sender.sendSimpleEmail(to,sub,att);
				   //sendEmailWithAttachment(to,sub,att,chem);
				e.sendEmailWithAttachment(to, sub, att, chem);
		}
		}

		
 
	 
	 
 
	 @Override 
	public void StatComplainer() {
		 int nb= rRepository.getNbComplainer();
		 int nbreclam =rRepository.getNbReclam();
		 int nbRT=rRepository.getNbReclamtraited();
		//int nbuser=uRepository.getNbUser();
		 log.info("le pourcentage des plaignant est egale à " + nb*100/10 +"%" );
		 log.info("le pourcentage des reclamation traité est egale à " + nbRT*100/nbreclam +"%"  );
	  String MostType=rRepository.getTypeReclamation();
		 log.info("le type reclamation le plus utilisé est :"+MostType );
		  String Lesstype=rRepository.getTypeReclamation2();
		 log.info("le type reclamation le moins utilisé est :"+Lesstype );
 
		 Connection connection = null;
			Statement statement = null;
			ResultSet resultSet = null; 
			Connection connection1 = null;
			Statement statement1 = null;
			ResultSet resultSet1 = null;
			
			
			

			String dbUrl = "jdbc:mysql://localhost:3308/pidev";
			String user = "root";
			String password = "";
			
			try {
				connection = Database.getConnection(dbUrl, user, password);
				connection1 = Database.getConnection(dbUrl, user, password);
		       
				statement = connection.createStatement();
				statement1 = connection1.createStatement();
				
				
				String sql = "SELECT reclamation.type_reclamation , COUNT(reclamation.type_reclamation) FROM reclamation GROUP BY reclamation.type_reclamation ORDER BY COUNT(reclamation.type_reclamation) DESC";
				 String sql1="SELECT reclamation.nom ,reclamation.prenom, COUNT(reclamation.type_reclamation) FROM reclamation GROUP BY reclamation.type_reclamation ORDER BY COUNT(reclamation.type_reclamation) DESC";
				resultSet = statement.executeQuery(sql);
				resultSet1 = statement1.executeQuery(sql1);
			
				while ((resultSet.next())&&(resultSet1.next()) ) {
				 
					String typestring = resultSet.getString("type_reclamation");
					Integer nbocc = resultSet.getInt("COUNT(reclamation.type_reclamation)");
					System.out.println(typestring + " " + nbocc );

					String Nom=resultSet1.getString("nom");
					String Prenom=resultSet1.getString("prenom");
				    Integer nboccc=resultSet1.getInt("COUNT(reclamation.type_reclamation)");
			 
				    System.out.println("l'utilisateur" +Nom + " " + Prenom +" "+"a plus que "+nboccc+" " +"reclamation" );

					
				}
				
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
			} finally {
				Database.closeResultSet(resultSet);
				Database.closeStatement(statement);
				Database.closeConnection(connection);
			} 
		 
		 
	
}

	
	 
	

	 @Override 
		public void retrieveByDate (String  DateDeb, String DateFin) {

	 Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		String dbUrl = "jdbc:mysql://localhost:3308/pidev";
		String user = "root";
		String password = "";
		
		try {
			connection = Database.getConnection(dbUrl, user, password);
			
			statement = connection.createStatement();
		 
			
			String sql = "SELECT reclamation.id_reclamation  , reclamation.traité, reclamation.date  FROM reclamation WHERE reclamation.date BETWEEN '" + DateDeb + "' AND '" + DateFin + "' ";
			 
			 
			resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
			 
				String id = resultSet.getString("id_reclamation");
				String trai =resultSet.getString("traité");
				Date date = resultSet.getDate("date");
				System.out.println(id + " " +trai+" " + date );
			}
			
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		} finally {
			Database.closeResultSet(resultSet);
			Database.closeStatement(statement);
			Database.closeConnection(connection);
		}
		
		
		
	
}
}
 
 