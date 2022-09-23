package br.com.getnet.test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

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
	public void consultarListaUsuarioPagina1() {

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
	public void consultarListaUsuarioPagina2() {

		usuario = new Usuario(11, "George", "Edwards", "george.edwards@reqres.in", "https://reqres.in/img/faces/11-image.jpg");

		given()
		.when()
			.get("users?page=4&per_page=3")
		.then()
			.log().all()
			.statusCode(200)
			
			.header("Content-Type", "application/json; charset=utf-8")

			.body("data.id", hasItem(usuario.getId()))
			.body("data.email", hasItem(usuario.getEmail()))
			.body("data.first_name", hasItem(usuario.getNome()))
			.body("data.last_name", hasItem(usuario.getSobrenome()))
			.body("data.avatar", hasItem(usuario.getAvatar()))
			;
			
	}
	
	
	@Test
	public void consultarUsuarioPeloId() {

		usuario = new Usuario(2, "Janet", "Weaver", "janet.weaver@reqres.in", "https://reqres.in/img/faces/2-image.jpg");
		
		given()
		.when()
			.get("users/" + usuario.getId())
		.then()
			.log().all()
			.statusCode(200)
			
			.header("Content-Type", "application/json; charset=utf-8")

			.body("data.id", is(usuario.getId()))
			.body("data.email", is(usuario.getEmail()))
			.body("data.first_name", is(usuario.getNome()))
			.body("data.last_name", is(usuario.getSobrenome()))
			.body("data.avatar", is(usuario.getAvatar()))
			;
			
	}
	
	@Test
	public void consultarUsuarioComDelay() {

		usuario = new Usuario(2, "Janet", "Weaver", "janet.weaver@reqres.in", "https://reqres.in/img/faces/2-image.jpg");

		given()
		.when()
			.get("users?delay=3")
		.then()
			.log().all()
			.statusCode(200)
			
			.header("Content-Type", "application/json; charset=utf-8")

			.body("data.id", hasItem(usuario.getId()))
			.body("data.email", hasItem(usuario.getEmail()))
			.body("data.first_name", hasItem(usuario.getNome()))
			.body("data.last_name", hasItem(usuario.getSobrenome()))
			.body("data.avatar", hasItem(usuario.getAvatar()))
			;
			
	}
	
	@Test
	public void erroConsultarUsuarioPeloId() {

		given()
		.when()
			.get("users/120")
		.then()
			.log().all()
			.statusCode(404)
			
			.header("Content-Type", "application/json; charset=utf-8")
			;
			
	}

	@Test
	public void listarRecursos() {

		given()
		.when()
			.get("unknown")
		.then()
			.log().all()
			.statusCode(200)
			
			.header("Content-Type", "application/json; charset=utf-8")
			
			.body("data.id", hasItem(5))
			.body("data.name", hasItem("tigerlily"))
			.body("data.year", hasItem(2004))
			.body("data.color", hasItem("#E2583E"))
			.body("data.pantone_value", hasItem("17-1456"))
			;
			
	}
	
	@Test
	public void listarRecursosPeloId() {

		given()
		.when()
			.get("unknown/2")
		.then()
			.log().all()
			.statusCode(200)
			
			.header("Content-Type", "application/json; charset=utf-8")
			
			.body("data.id", is(2))
			.body("data.name", is("fuchsia rose"))
			.body("data.year", is(2001))
			.body("data.color", is("#C74375"))
			.body("data.pantone_value", is("17-2031"))
			;
			
	}
	
	@Test
	public void erroListarRecursosPeloId() {

		given()
		.when()
			.get("unknown/200")
		.then()
			.log().all()
			.statusCode(404)
			
			.header("Content-Type", "application/json; charset=utf-8")
			;
			
	}
	
}