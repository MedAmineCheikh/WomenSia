package tn.esprit.spring.services;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy.Provider;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.SmsRequest;
import tn.esprit.spring.TwilioConfiguration;
import tn.esprit.spring.TwilioSmsSender;
import tn.esprit.spring.config.Database;
import tn.esprit.spring.entities.Etat;
import tn.esprit.spring.entities.Pool;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.ParticipDonRepository;
import tn.esprit.spring.repository.PoolRepository;
import tn.esprit.spring.repository.UserRepository;
@Service
@Slf4j
public class PoolServiceImpl implements IPoolService {
	
	@Autowired
	UserRepository uRepository;
	@Autowired
	PoolRepository pRepository;
	@Autowired
	ParticipDonRepository pRepo;
	private TwilioSmsSender smsSender;

	@Override
	public List<Pool> retrieveAllPool() {
		List<Pool> listPool= (List<Pool>) pRepository.findAll();
		for(Pool c:listPool)
		{
			log.info("Pool:" + c.getNamePool()+ c.getNbDonateur());
		}
		return listPool;
	}

	@Override
	public Pool addPool(Pool c) {
		pRepository.save(c);
		return c;
	}

	@Override
	public void deletePool(Integer id) {
		pRepository.deleteById(id);

	}

	@Override
	public Pool updatePool(Pool c) {
		pRepository.save(c);
		return c;
	}

	@Override
	public Pool retrievePool(Integer id) {
		Pool c= pRepository.findById(id).get();
		return c;
	}
	
	@Override
	public void ManagePool(Integer id, boolean test) {
		Pool p= pRepository.findById(id).orElse(null);
		if (test==true ) {
		p.setEtat(Etat.Opened);	
		}
		else if (test==false) {
			p.setEtat(Etat.Locked);
		}
		
		else
		{System.out.println("Ok");}
		
		//vmRepository.save(vm);
	}
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

 			private static final String CONNECTION = "jdbc:mysql://localhostlocalhost:3308/pidev";

	@Override
	public void Donate(Integer idAccount, Integer idPool, Integer Montant,String CardNumber,String ccv) throws SQLException {
		
		Pool c= pRepository.findById(idPool).get();
		User u= uRepository.findById(idAccount).get();
		if (c.getEtat().equals("Opened")&&(u.getCardNumber().equals(CardNumber))&&(u.getCcv().equals(ccv)))
		{
 			 Integer Sum=Montant+pRepository.getsumpool();
 			 Integer NbD=pRepository.getnbdon()+1;
 			 c.setNbDonateur(NbD);
 			 c.setSum(Sum);
 			 u.setBalance(u.getBalance()-Montant);
 			 System.out.println("bravo");
 			 pRepository.save(c);
 			  	 
 	 
 			
 		 /*   try
 			    {
 			        Class.forName(DRIVER);
 			       Properties p = new Properties();
 			        p.put("user","root");
 			        p.put("password","");
 			        

 			        Connection c1 = DriverManager.getConnection(CONNECTION,p);

 			        Statement s = c1.createStatement();

 			     //   ResultSet rs = s.executeQuery("");
 			      //  int id = rs.getInt(1);

 			        PreparedStatement ps = c1.prepareStatement("UPDATE pool SET nb_donateur=?,sum=? WHERE id_pool=1");
 			        ps.setInt(1,NbD);
 			        ps.setInt(2,Sum);
 			     
 			        ps.executeUpdate();

 			        c1.close();
 			    }

 			    catch(Exception e)
 			    {
 			        try
 			        {
 			            PrintWriter out = new PrintWriter(new FileWriter("err", true));
 			            out.println("Error: "+ e);
 			            out.close();
 			        }
 			        catch(IOException e1)
 			        {}
 			        
 			        
 			    } */
 			 
 			}
}
}
		
	

