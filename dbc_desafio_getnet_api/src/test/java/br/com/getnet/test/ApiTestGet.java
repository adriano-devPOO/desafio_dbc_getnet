package br.com.getnet.test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.getnet.usuario.Usuario;

public class ApiTestGet {

	private Usuario usuario;

	@BeforeClass
	public static void setup() {
		baseURI = ("https://reqres.in/api/");
	}

	@Test
	public void consultarListaUsuariosPorPagina1() {

		usuario = new Usuario(4, "Eve", "Holt", "eve.holt@reqres.in", "https://reqres.in/img/faces/4-image.jpg");

		given()
		.when()
			.get("users?page=1")
		.then()
			.log().all()
			.statusCode(200)
			
			.header("Content-Type", "application/json; charset=utf-8")
			.header("Transfer-Encoding", "chunked")

			.body("data.id", hasItem(usuario.getId()))
			.body("data.email", hasItem(usuario.getEmail()))
			.body("data.first_name", hasItem(usuario.getNome()))
			.body("data.last_name", hasItem(usuario.getSobrenome()))
			.body("data.avatar", hasItem(usuario.getAvatar()))
			;
			
	}
	
	@Test
	public void consultarListaUsuariosPorPagina2() {

		usuario = new Usuario(11, "George", "Edwards", "george.edwards@reqres.in", "https://reqres.in/img/faces/11-image.jpg");

		given()
		.when()
			.get("users?page=2")
		.then()
			.log().all()
			.statusCode(200)
			
			.header("Content-Type", "application/json; charset=utf-8")
			.header("Transfer-Encoding", "chunked")

			.body("data.id", hasItem(usuario.getId()))
			.body("data.email", hasItem(usuario.getEmail()))
			.body("data.first_name", hasItem(usuario.getNome()))
			.body("data.last_name", hasItem(usuario.getSobrenome()))
			.body("data.avatar", hasItem(usuario.getAvatar()))
			;
			
	}



}