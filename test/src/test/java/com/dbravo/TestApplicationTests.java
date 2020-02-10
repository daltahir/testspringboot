package com.dbravo;

import java.util.Date;
import java.util.UUID;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.dbravo.Entity.Usuario;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestApplicationTests {
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testCreateUser() {
		Usuario user = new Usuario();
		user.setEmail("admin@gmail.com");
		user.setId(UUID.randomUUID().toString());
		user.setCreated(new Date());
		user.setIsactive(true);
		user.setLast_login(new Date());
		user.setModified(new Date());
		user.setName("admin");
		user.setPassword("Aa11");
		

		ResponseEntity<Usuario> postResponse = restTemplate.postForEntity(getRootUrl() + "/Registro", user, Usuario.class);
		Assert.assertNotNull(postResponse);
		Assert.assertNotNull(postResponse.getBody());
	}

}
