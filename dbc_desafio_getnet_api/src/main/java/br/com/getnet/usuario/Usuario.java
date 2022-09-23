package br.com.getnet.usuario;

import org.json.JSONObject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {

	private int id;
	private String nome;
	private String sobrenome;
	private String email;
	private String avatar;
	private String job;
	private String password;
	
	private JSONObject json;
	
	public Usuario() {}

	public Usuario(int id, String nome, String sobrenome, String email, String avatar) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.avatar = avatar;
	}

	public Usuario(String nome, String sobrenome, String email, String avatar) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.avatar = avatar;
	}
	
	public Usuario(String nome, String sobrenome, String email) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
	}
	
	public Usuario(String nome, String job) {
		super();
		this.nome = nome;
		this.job = job;
	}
	
	public Usuario(int id) {
		super();
		this.id = id;
	}

	public String bodyUsuario() {
		
		json = new JSONObject();

		json.put("first_name", this.getNome());
		json.put("last_name", this.getSobrenome());
		json.put("email", this.getEmail());	
		
		return json.toString();
	}
	
    public String bodyJobUsuario() {
		
		json = new JSONObject();

		json.put("name", this.getNome());
		json.put("job", this.getJob());	
		
		return json.toString();
	}
    
    public String bodyRegistrarUsuario() {
		
		json = new JSONObject();

		json.put("email", this.getEmail());
		json.put("password", this.getPassword());	
		
		return json.toString();
	}

}
