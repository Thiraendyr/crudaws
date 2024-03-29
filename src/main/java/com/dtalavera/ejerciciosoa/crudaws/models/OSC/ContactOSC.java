package com.dtalavera.ejerciciosoa.crudaws.models.OSC;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"PartyId",
    "PartyNumber",
    "FirstName",
    "LastName",
    "EmailAddress"
})
public class ContactOSC {
	@JsonProperty("PartyId")
	@JsonIgnore
	private long PartyId;
	
	@JsonProperty("PartyNumber")
	private Object PartyNumber;
	
	@JsonProperty("FirstName")
	private String FirstName;
	
	@JsonProperty("LastName")
	private String LastName;
	
	@JsonProperty("EmailAddress")
	private String EmailAddress;
	
	public ContactOSC() {
		// TODO Auto-generated constructor stub
	}
	
	public ContactOSC(long partyId, Object partyNumber, String firstName, String lastName, String emailAddress) {
		super();
		PartyId = partyId;
		PartyNumber = partyNumber;
		FirstName = firstName;
		LastName = lastName;
		EmailAddress = emailAddress;
	}
	
	@JsonProperty("PartyId")
	@JsonIgnore
	public long getPartyId() {
		return PartyId;
	}

	@JsonProperty("PartyId")
	public void setPartyId(long partyId) {
		PartyId = partyId;
	}

	@JsonProperty("PartyNumber")
	public Object getPartyNumber() {
		return PartyNumber;
	}
	@JsonProperty("PartyNumber")
	public void setPartyNumber(Object PartyNumber) {
		this.PartyNumber = PartyNumber;
	}
	
	@JsonProperty("FirstName")
	public String getFirstName() {
		return FirstName;
	}
	@JsonProperty("FirstName")
	public void setFirstName(String firstName) {
		this.FirstName = firstName;
	}
	
	@JsonProperty("LastName")
	public String getLastName() {
		return LastName;
	}
	@JsonProperty("LastName")
	public void setLastName(String lastName) {
		this.LastName = lastName;
	}
	
	@JsonProperty("EmailAddress")
	public String getEmailAddress() {
		return EmailAddress;
	}
	@JsonProperty("EmailAddress")
	public void setEmailAddress(String emailAddress) {
		this.EmailAddress = emailAddress;
	}
	
	
}
