package com.dtalavera.ejerciciosoa.crudaws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dtalavera.ejerciciosoa.crudaws.entity.Contact;
import com.dtalavera.ejerciciosoa.crudaws.services.*;

@RestController
public class Endpoints {

	@Autowired
	private ServiceAll serviceAll;
	
	@Autowired
	private ServiceRN serviceRN;
	
	@Autowired
	private ServiceEloqua serviceEl;
	
	@Autowired
	private ServiceOSC serviceOSC;
	
//////////////////////////////////////Operaciones simultaneas para las tres plataformas
	
	//Endpoint Delete para las tres apis simultáneas
	@RequestMapping(value = "all/contacts/{email}", method = RequestMethod.DELETE)
	public ResponseEntity<Void>  deleteFromAll(@PathVariable("email") String email) {
		return new ResponseEntity<Void>(serviceAll.deleteFromAll(email), HttpStatus.OK);
	}
	
	//Endpoint Post para las tres apis simultáneas
	@RequestMapping(value = "all/contacts", method = RequestMethod.POST)
	public ResponseEntity<List<Contact>> createAtAll(@RequestBody String c) {
		return new ResponseEntity<List<Contact>>(serviceAll.createAtAll(c), HttpStatus.OK);
	}
	
//////////////////////////////////////Right Now
	
	//Endpoint Delete de RN
	@RequestMapping(value = "rn/contacts/{email}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteRNContact(@PathVariable("email") String email) {
		return new ResponseEntity<Void>(serviceRN.deleteRNContact(email), HttpStatus.OK);
	}
	
	//Endpoint Get de RN
	@RequestMapping(value = "rn/contacts/{email}", method = RequestMethod.GET)
	public ResponseEntity<Contact> getRNContact(@PathVariable("email") String email) {
		return new ResponseEntity<Contact>(serviceRN.getContact(email), HttpStatus.OK);
	}
	
	//Endpoint Post de RN
	@RequestMapping(value = "rn/contacts", method = RequestMethod.POST)
	public ResponseEntity<Contact> createRNContact(@RequestBody String jsonContact) {
		return new ResponseEntity<Contact>(serviceRN.serializarObjecto(jsonContact), HttpStatus.OK);
	}
	
//////////////////////////////////////Eloqua
	
	//Endpoint Delete de Eloqua
	@RequestMapping(value = "el/contacts/{email}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteElContact(@PathVariable("email") String email) {
		return new ResponseEntity<Void>(serviceEl.deleteElContact(email), HttpStatus.OK);
	}

	//Endpoint Get de Eloqua
	@RequestMapping(value = "el/contacts/{email}", method = RequestMethod.GET)
	public ResponseEntity<Contact> getElContact(@PathVariable("email") String email) {
		return new ResponseEntity<Contact>(serviceEl.getContact(email), HttpStatus.OK);
	}
	
	//Endpoint Post de Eloqua
	@RequestMapping(value = "el/contacts", method = RequestMethod.POST)
	public ResponseEntity<Contact> createElContact(@RequestBody String jsonContact) {
		return new ResponseEntity<Contact>(serviceEl.serializarObjecto(jsonContact), HttpStatus.OK);
	}
	
//////////////////////////////////////Oracle Sales Cloud

	//Endpoint Delete de OSC
	@RequestMapping(value = "os/contacts/{email}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteOSContact(@PathVariable("email") String email) {
		return new ResponseEntity<Void>(serviceOSC.deleteOSContact(email), HttpStatus.OK);
	}
	
	//Endpoint Get de OSC
	@RequestMapping(value = "os/contacts/{email}", method = RequestMethod.GET)
	public ResponseEntity<Contact> getOSContact(@PathVariable("email") String email) {
		return new ResponseEntity<Contact>(serviceOSC.getContact(email), HttpStatus.OK);
	}

	//Endpoint Post de OSC
	@RequestMapping(value = "os/contacts", method = RequestMethod.POST)
	public ResponseEntity<Contact> createOSContact(@RequestBody String jsonContact) {
		return new ResponseEntity<Contact>(serviceOSC.serializarObjectoContact(jsonContact), HttpStatus.OK);
	}
}
