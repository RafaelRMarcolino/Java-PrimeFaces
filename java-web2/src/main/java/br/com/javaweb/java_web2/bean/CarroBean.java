package br.com.javaweb.java_web2.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.javaweb.java_web2.dao.CarroDAO;
import br.com.javaweb.java_web2.entity.Carro;

@ManagedBean
@SessionScoped
public class CarroBean {
	
	private Carro carro = new Carro();
	
	private List<Carro> carros = new ArrayList<>();
	
	public void adicionar() {
		
		carros.add(carro);
		new CarroDAO().salvar(carro);
		carro =  new Carro();
		
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}
	
	
	

}
