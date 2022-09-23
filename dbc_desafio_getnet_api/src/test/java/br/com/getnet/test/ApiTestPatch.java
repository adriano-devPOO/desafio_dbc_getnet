package br.com.getnet.test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.getnet.usuario.Usuario;

public class ApiTestPatch {

	private Usuario usuario;

	@BeforeClass
	public static void setup() {
		baseURI = ("https://reqres.in/api/");
	}

	@Test
	public void atualizarParcialUsuarioPeloId() {

		usuario = new Usuario();
		usuario.setId(2);
		usuario.setNome("morpheus");
		usuario.setJob("zion resident");

		given()
			.auth().basic("eve.holt@reqres.in", "cityslicka")
			.contentType("application/json")
			.body(usuario.bodyJobUsuario())
		.when()
			.patch("users" + usuario.getId())
		.then()
		
			.body(is(not(nullValue())))
			
			.log().all()
			.statusCode(200)
			
			.header("Content-Type", "application/json; charset=utf-8")

			.body("name", is(usuario.getNome()))
			.body("job", is(usuario.getJob()))
			;
			
	}
		
}