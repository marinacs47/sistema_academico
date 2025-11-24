package sistema_academico.modelo;

import java.util.ArrayList;
import java.util.List;

public class Funcionalidade{
	private String codigo;
	private String descricao;
	private static List<Funcionalidade> funcionalidades = new ArrayList<>();


	static{
		funcionalidades.add(new Funcionalidade("CA", "Cadastrar Aluno");
		funcionalidades.add(new Funcionalidade("CP", "Cadastrar Professor");
		funcionalidades.add(new Funcionalidade("CT", "Cadastrar Turma");
		funcionalidades.add(new Funcionalidade("LA", "Listar Alunos");
		funcionalidades.add(new Funcionalidade("LP", "Listra Professores");
		funcionalidades.add(new Funcionalidade("LT", "Listar Turmas");
		funcionalidades.add(new Funcionalidade("RA", "Remover Aluno");
		funcionalidades.add(new Funcionalidade("RP", "Remover Professor");
		funcionalidades.add(new Funcionalidade("RT", "Remover Turma");

	} 

	public Funcionalidades(String codigo, String descricao){
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public Funcionalidade getFuncionalidade(String codigo) { 
		for (Funcionalidade f : funcionalidades)
			if(f.getCodigo().equals(codigo)){
				return f;
			}
			return null;
	}
}