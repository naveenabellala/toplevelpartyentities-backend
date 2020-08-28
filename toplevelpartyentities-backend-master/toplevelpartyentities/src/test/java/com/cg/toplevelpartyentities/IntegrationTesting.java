package com.cg.toplevelpartyentities;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.toplevelpartyentities.models.Party;




@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class IntegrationTesting {
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	/********All retriving requests******/
	
	@Test
	public void testGetAllParty() throws Exception {
		ResponseEntity<List> response = 
				this.restTemplate.getForEntity
				("http://localhost:" + port + "/party", 
				List.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}
	
	@Test
	public void testGetAllPartygroup() throws Exception {
		ResponseEntity<List> response = 
				this.restTemplate.getForEntity
				("http://localhost:" + port + "/partygroup", 
				List.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}
	
	@Test
	public void testGetAllPerson() throws Exception {
		ResponseEntity<List> response = 
				this.restTemplate.getForEntity
				("http://localhost:" + port + "/person", 
				List.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}
	
	@Test
	public void testGetAllUserlogin() throws Exception {
		ResponseEntity<List> response = 
				this.restTemplate.getForEntity
				("http://localhost:" + port + "/userlogin", 
				List.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}
	
	@Test
	public void testGetAllPartycontactmech() throws Exception {
		ResponseEntity<List> response = 
				this.restTemplate.getForEntity
				("http://localhost:" + port + "/partycontactmech", 
				List.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}
	
	@Test
	public void testGetAllContactmech() throws Exception {
		ResponseEntity<List> response = 
				this.restTemplate.getForEntity
				("http://localhost:" + port + "/contactmech", 
				List.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}
	
	@Test
	public void testGetAllPartyrole() throws Exception {
		ResponseEntity<List> response = 
				this.restTemplate.getForEntity
				("http://localhost:" + port + "/partyrole", 
				List.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}
	
	/*********All deleting requests**********/
	
	  @Test
	  
	  public void testDeleteParty() throws Exception {
	  
	  final String uri = "http://localhost:"+port+"/deleteparty/{partyId}";
	  
	  Map<String, String> params = new HashMap<String, String>();
	  
	  params.put("partyId", "12"); 
	  restTemplate.delete ( uri, params ); 
	  }
	 
	
	/*********All creating requests************/
	
	@Test
	
	public void testAddParty() throws Exception {
		final String baseUrl = "http://localhost:"+port+"/addparty";
		
		URI uri = new URI(baseUrl);
        Party party = new Party(10,103,	1003,	10003,	"superhero",	100003);      
 
        HttpHeaders headers = new HttpHeaders();
        //headers.set("X-COM-PERSIST", "true");      
 
        HttpEntity<Party> request = new HttpEntity<>(party, headers);
        
        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
        Assert.assertEquals(200, result.getStatusCodeValue());
	}
}
