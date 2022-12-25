package br.com.javaweb.java_web.bean;

import java.io.Serializable;

import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

@SessionScoped
@ViewScoped
public class Bean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String sobrenome;
	
	private String mensagem;
	
	public void dezerOla() {

		System.out.println("nome " + nome + " sobrenome " + sobrenome);

		mensagem = "Ola " + nome + " " + sobrenome;
	}

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

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	

}
