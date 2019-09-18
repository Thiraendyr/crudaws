package com.dtalavera.ejerciciosoa.crudaws.config;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

public class Auth {

	//Devuelve un HttpPost con la autorización y la url necesaria para crear en una de las 3 apis
	public static HttpPost setPostContactHeaders(String api, String json) throws UnsupportedEncodingException {
		HttpPost hp = null;
		switch(api) {
		case "rn":
			hp = new HttpPost(ConfigRN.getUrl().concat(ConfigRN.getEndpt()));
			hp.setHeader(HttpHeaders.AUTHORIZATION, new String(Config.getBasic().concat(Base64.getEncoder().encodeToString((ConfigRN.getUsr().concat(Config.getPuntos()).concat(ConfigRN.getPwd())).getBytes()))));
			break;
		case "el":
			hp = new HttpPost(ConfigEl.getUrl().concat(ConfigEl.getEndpt()));
			hp.setHeader(HttpHeaders.AUTHORIZATION, new String(Config.getBasic().concat(Base64.getEncoder().encodeToString((ConfigEl.getUsr().concat(Config.getPuntos()).concat(ConfigEl.getPwd())).getBytes()))));
			break;
		case "os":
			hp = new HttpPost(ConfigOSC.getUrl().concat(ConfigOSC.getEndptCnt()));
			hp.setHeader(HttpHeaders.AUTHORIZATION, new String(Config.getBasic().concat(Base64.getEncoder().encodeToString((ConfigOSC.getUsr().concat(Config.getPuntos()).concat(ConfigOSC.getPwd())).getBytes()))));
			break;
		case "osLead":
			hp = new HttpPost(ConfigOSC.getUrl().concat(ConfigOSC.getEndptLead()));
			hp.setHeader(HttpHeaders.AUTHORIZATION, new String(Config.getBasic().concat(Base64.getEncoder().encodeToString((ConfigOSC.getUsr().concat(Config.getPuntos()).concat(ConfigOSC.getPwd())).getBytes()))));
			break;
		}
		hp.setEntity(new StringEntity(json));
		hp.setHeader(Config.getAccept(), Config.getApplicationJson());
		hp.setHeader(Config.getContent(), Config.getApplicationJson());
	    return hp;
	}
	
	//Devuelve un HttpDelete con la autorización y la url necesaria para eliminar desde una de las 3 apis
	public static HttpDelete setDeleteContactHeaders(String api, long id) {
		HttpDelete hd = null;
		switch(api) {
		case "rn":
			hd = new HttpDelete(ConfigRN.getUrl().concat(ConfigRN.getEndpt()).concat(Config.getSlash()).concat(String.valueOf(id)));
			hd.setHeader(HttpHeaders.AUTHORIZATION, new String(Config.getBasic().concat(Base64.getEncoder().encodeToString((ConfigRN.getUsr().concat(Config.getPuntos()).concat(ConfigRN.getPwd())).getBytes()))));
			break;
		case "el":
			hd = new HttpDelete(ConfigEl.getUrl().concat(ConfigEl.getEndpt()).concat(Config.getSlash()).concat(String.valueOf(id)));
			hd.setHeader(HttpHeaders.AUTHORIZATION, new String(Config.getBasic().concat(Base64.getEncoder().encodeToString((ConfigEl.getUsr().concat(Config.getPuntos()).concat(ConfigEl.getPwd())).getBytes()))));
			break;
		case "os":
			hd = new HttpDelete(ConfigOSC.getUrl().concat(ConfigOSC.getEndptCnt()).concat(Config.getSlash()).concat(String.valueOf(id)));
			hd.setHeader(HttpHeaders.AUTHORIZATION, new String(Config.getBasic().concat(Base64.getEncoder().encodeToString((ConfigOSC.getUsr().concat(Config.getPuntos()).concat(ConfigOSC.getPwd())).getBytes()))));
			break;
		case "osLead":
			hd = new HttpDelete(ConfigOSC.getUrl().concat(ConfigOSC.getEndptLead()).concat(Config.getSlash()).concat(String.valueOf(id)));
			hd.setHeader(HttpHeaders.AUTHORIZATION, new String(Config.getBasic().concat(Base64.getEncoder().encodeToString((ConfigOSC.getUsr().concat(Config.getPuntos()).concat(ConfigOSC.getPwd())).getBytes()))));
			break;
		}
	    return hd;
	}
	
	//Devuelve un HttpGet con la autorización y la url necesaria para obtener por email desde una de las 3 apis
	public static HttpGet setGetContactHeaders(String api, String email) {
		HttpGet hg = null;
		switch(api) {
		case "rn":
			hg = new HttpGet(ConfigRN.getUrl().concat(ConfigRN.getEndpt()).concat(ConfigRN.getQuery()).concat(email).concat(Config.getComilla()));
			hg.setHeader(HttpHeaders.AUTHORIZATION, new String(Config.getBasic().concat(Base64.getEncoder().encodeToString((ConfigRN.getUsr().concat(Config.getPuntos()).concat(ConfigRN.getPwd())).getBytes()))));
			break;
		case "el":
			hg = new HttpGet(ConfigEl.getUrl().concat(ConfigEl.getEndpt()).concat(ConfigEl.getQuery()).concat(email).concat(Config.getComilla()));
			hg.setHeader(HttpHeaders.AUTHORIZATION, new String(Config.getBasic().concat(Base64.getEncoder().encodeToString((ConfigEl.getUsr().concat(Config.getPuntos()).concat(ConfigEl.getPwd())).getBytes()))));
			break;
		case "os":
			hg = new HttpGet(ConfigOSC.getUrl().concat(ConfigOSC.getEndptCnt()).concat(ConfigOSC.getQueryCnt()).concat(email).concat(Config.getComilla()));
			hg.setHeader(HttpHeaders.AUTHORIZATION, new String(Config.getBasic().concat(Base64.getEncoder().encodeToString((ConfigOSC.getUsr().concat(Config.getPuntos()).concat(ConfigOSC.getPwd())).getBytes()))));
			break;
		case "osLead":
			hg = new HttpGet(ConfigOSC.getUrl().concat(ConfigOSC.getEndptLead()).concat(ConfigOSC.getQueryLead()).concat(email).concat(Config.getComilla()));
			hg.setHeader(HttpHeaders.AUTHORIZATION, new String(Config.getBasic().concat(Base64.getEncoder().encodeToString((ConfigOSC.getUsr().concat(Config.getPuntos()).concat(ConfigOSC.getPwd())).getBytes()))));
			break;
		}
		hg.addHeader(Config.getAccept(), Config.getApplicationJson());
	    return hg;
	}
	
	private static void setAuthorizationHeader(String user, String password) {
		
	}
}
