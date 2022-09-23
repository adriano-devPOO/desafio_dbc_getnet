package br.com.getnet.test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.getnet.usuario.Usuario;

public class ApiTestDelete {

	private Usuario usuario;

	@BeforeClass
	public static void setup() {
		baseURI = ("https://reqres.in/api/");
	}

	@Test
	public void apagarUsuarioPeloId() {

		usuario = new Usuario();
		usuario.setId(2);

		given()
		.when()
			.delete("users" + usuario.getId())
		.then()
			
			.log().all()
			
			.statusCode(204)
			;
			
	}
		
}