package com.dtalavera.ejerciciosoa.crudaws.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dtalavera.ejerciciosoa.crudaws.entity.Contact;

@org.springframework.stereotype.Service
public class ServiceAll {
	
	@Autowired
	private ServiceRN serviceRn;

	@Autowired
	private ServiceEloqua serviceEl;
	
	@Autowired
	private ServiceOS serviceOs;
	
	//Llama a los métidos de eliminar de cada api para eliminarlos a la vez con el mismo email
	public Void deleteFromAll(String email) {
		
		serviceRn.deleteRNContact(email);
		serviceEl.deleteElContact(email);
		serviceOs.deleteOSContact(email);
		
		return null;
		
	}
	
	//Llama a los métidos de crear en cada api para crearlos a la vez con el mismo email
	public List<Contact> createAtAll(String json) {

		List<Contact> contactos = new ArrayList<Contact>();
		Contact c;
		c = serviceRn.serializarObjecto(json);
		System.out.println("createAtAll RN " + c);
		contactos.add(c);
		c = serviceEl.serializarObjecto(json);
		System.out.println("createAtAll El " + c);
		contactos.add(c);
		c = serviceOs.serializarObjectoContact(json);
		System.out.println("createAtAll OS " + c);
		contactos.add(c);
		
		return contactos;
	}

}
