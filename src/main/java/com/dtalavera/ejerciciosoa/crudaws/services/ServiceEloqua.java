package com.dtalavera.ejerciciosoa.crudaws.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import com.dtalavera.ejerciciosoa.crudaws.config.Auth;
import com.dtalavera.ejerciciosoa.crudaws.entity.Contact;
import com.dtalavera.ejerciciosoa.crudaws.methods.GetMethods;
import com.dtalavera.ejerciciosoa.crudaws.methods.ReplaceChars;
import com.dtalavera.ejerciciosoa.crudaws.models.El.ContactEl;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

@org.springframework.stereotype.Service
public class ServiceEloqua{
	
	public ServiceEloqua() {
		// TODO Auto-generated constructor stub
	}

//////////////////////////////////////Eloqua	
	
	//Devuelve el Contact recibiendo el email
	public Contact getContact(String email) {
		try {
			return GetMethods.getElContactByEmail(ReplaceChars.transFormarLetras(email));

		} catch (IOException | JSONException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	//Elimina un Contact recibiendo un email
	public Void deleteElContact(String email) {
		try {
			Contact contacto = GetMethods.getElContactByEmail(email);
			if(contacto != null) {
				CloseableHttpClient httpclient = HttpClientBuilder.create().build();
				HttpDelete httpDelete = Auth.setDeleteContactHeaders("el", contacto.getId());

				httpclient.execute(httpDelete);

				httpclient.close();
			}

		} catch (IOException | JSONException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	//Crea un Contact recibiendo el json de ContactEl serializado y su email
	public Contact createElContact(String json, String email) {
		try {
			Contact contacto = GetMethods.getElContactByEmail(email);
			if (contacto == null) {

				CloseableHttpClient client = HttpClients.createDefault();
				HttpPost httpPost = Auth.setPostContactHeaders("el", json);

				HttpResponse response = client.execute(httpPost);
				if (response.getStatusLine().getStatusCode() == 201) {
					client.close();
					return GetMethods.getElContactByEmail(email);
				}

			}

		} catch(IOException | JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//Serializa un contacto recibido por post a un ContactEl
	public Contact serializarObjecto(String jsonSend){
		try {
			JSONObject jsonObject = new JSONObject(jsonSend);
			
			ContactEl contactEl = new ContactEl();
			contactEl.setId(null);;
			contactEl.setFirstName(ReplaceChars.transFormarLetras(jsonObject.getString("firstName")));
			contactEl.setLastName(ReplaceChars.transFormarLetras(jsonObject.getString("lastName")));
			contactEl.setEmailAddress(ReplaceChars.transFormarLetras(jsonObject.getString("emailAddress")));
				
			return createElContact(new ObjectMapper().writeValueAsString(contactEl), ReplaceChars.transFormarLetras(jsonObject.getString("emailAddress")));

		} catch (JSONException | JsonProcessingException e) {
			e.printStackTrace();
		}

		return null;
	}
}
