package sistema_academico.modelo

import java.util.List;
import java.util.ArrayList;

public class TipoUsuario {
	private String nome;
	private List<Funcionalidade> funcionalidades = new ArrayList<>();

	public TipoUsuario(String nome) {
		this.nome = nome;
	}

	public String getNome(){
		return nome;
	}

	public List<Funcionalidade> getFuncionalidades(){
		return funcionalidades;
	}

	public void definirFuncionalidades(){
		//definir funcionalidades
	}

}