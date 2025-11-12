package sistema_academico.modelo;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Pessoa{
	private int siape;
	private List<Professor> professores = new ArrayList<>(); 

	public Professor(int siape, String nome){
		super(nome);
		this.siape = siape;
	}

	public int getSiape(){
		return siape;
	}

	public List<Professor> getProfessores(){
		return professores;
	}

	public void inserir(Professor professor){
		professores.add(professor);
	}

	public void remover(Professor professor){
		professores.remove(professor);
	}

	public Professor obter(Professor professor){
		professores.get(professor);
	}

}