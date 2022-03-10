package tn.esprit.spring.controller;
 

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.web.bind.annotation.PathVariable;
 
import org.springframework.web.bind.annotation.PutMapping;
 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.WriterException;

import io.swagger.annotations.Api;
 
import tn.esprit.spring.services.IEventService;
 import tn.esprit.spring.services.IUserService;
import tn.esprit.spring.services.PDFGeneratorService;
@RestController
@Api(tags = "Gestion des evenements")
@RequestMapping("/User")
public class UserRestController {

	@Autowired
	IEventService EService;
	@Autowired
	IUserService uService;
	
	// http://localhost:8085/app/User/particip_event/{Id-user}/{Id-Event}
			@PutMapping("/particip_event/{Id-user}/{Id-Event}")
			public void affecterSponsEvent(@PathVariable("Id-user") int IdAccount,@PathVariable("Id-Event") int IdEvent,HttpServletResponse response ) throws WriterException, IOException, MessagingException{
				uService.ParticipEvent(IdAccount,IdEvent );
				PDFGeneratorService exporter = new PDFGeneratorService();
				exporter.export(response);
			
			
			}

			 
	}
	