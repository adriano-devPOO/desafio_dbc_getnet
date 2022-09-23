package br.com.getnet.test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.getnet.usuario.Usuario;

public class ApiTestPosts {

	private Usuario usuario;

	@BeforeClass
	public static void setup() {
		baseURI = ("https://reqres.in/api/");
	}

	@Test
	public void criarUsuario() {

		usuario = new Usuario("Adriano", "Olimpio", "adriano@email.com");

		given()
			.contentType("application/json")
			.body(usuario.bodyUsuario())
		.when()
			.post("users")
		.then()
		
			.body(is(not(nullValue())))
			
			.log().all()
			.statusCode(201)
			
			.header("Content-Type", "application/json; charset=utf-8")

			.body("email", is(usuario.getEmail()))
			.body("first_name", is(usuario.getNome()))
			.body("last_name", is(usuario.getSobrenome()))
			;
			
	}
	
	@Test
	public void criarJobUsuario() {

		usuario = new Usuario("Adriano", "tester");

		given()
			.contentType("application/json")
			.body(usuario.bodyJobUsuario())
		.when()
			.post("users")
		.then()
		
			.body(is(not(nullValue())))
			
			.log().all()
			.statusCode(201)
			
			.header("Content-Type", "application/json; charset=utf-8")

			.body("name", is(usuario.getNome()))
			.body("job", is(usuario.getJob()))
			;
			
	}
	
	@Test
	public void criarTokenRegistroUsuario() {

		usuario = new Usuario();
		usuario.setEmail("eve.holt@reqres.in");
		usuario.setPassword("pistol");

		given()
			.contentType("application/json")
			.body(usuario.bodyRegistrarUsuario())
		.when()
			.post("register")
		.then()
		
			.body(is(not(nullValue())))
			
			.log().all()
			.statusCode(200)
			
			.header("Content-Type", "application/json; charset=utf-8")

			.body("id", is(4))
			.body("token", is("QpwL5tke4Pnpja7X4"))
			;
			
	}
	
	@Test
	public void erroCriarTokenRegistroUsuario() {

		usuario = new Usuario();
		usuario.setEmail("adriano@email.com");

		given()
			.contentType("application/json")
			.body(usuario.bodyRegistrarUsuario())
		.when()
			.post("register")
		.then()
		
			.body(is(not(nullValue())))
			
			.log().all()
			.statusCode(400)
			
			.header("Content-Type", "application/json; charset=utf-8")

			.body("error", is("Missing password"))
			;
			
	}
	
	@Test
	public void criarTokenLoginUsuario() {

		usuario = new Usuario();
		usuario.setEmail("eve.holt@reqres.in");
		usuario.setPassword("cityslicka");

		given()
			.contentType("application/json")
			.body(usuario.bodyRegistrarUsuario())
		.when()
			.post("login")
		.then()
		
			.body(is(not(nullValue())))
			
			.log().all()
			.statusCode(200)
			
			.header("Content-Type", "application/json; charset=utf-8")

			.body("token", is("QpwL5tke4Pnpja7X4"))
			;
			
	}
	
	@Test
	public void erroCriarTokenLoginUsuario() {

		usuario = new Usuario();
		usuario.setEmail("adriano@email.com");
		
		given()
			.contentType("application/json")
			.body(usuario.bodyRegistrarUsuario())
		.when()
			.post("login")
		.then()
		
			.body(is(not(nullValue())))
			
			.log().all()
			.statusCode(400)
			
			.header("Content-Type", "application/json; charset=utf-8")

			.body("error", is("Missing password"))
			;
			
	}
	
}