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

	

//	public String bodyCliente() {
//		
//		json = new JSONObject();
//
//		json.put("nome", this.nomeCompleto());
//		json.put("cpf", this.getCpf());
//		json.put("email", this.getEmail());
//		json.put("valor", this.getValor());
//		json.put("parcelas", this.getParcelas());
//		json.put("seguro", this.getSeguro());
//		
//		
//		return json.toString();
//	}
		

}
