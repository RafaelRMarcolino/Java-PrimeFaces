package br.com.javaweb.java_web2.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "nomeBean")
public class NomeBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String sobrenome;
	
	private String message;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void enviar() {
		System.out.println("Enviado ");
		message = "nome" + nome + " " + sobrenome;
		
	}

}
