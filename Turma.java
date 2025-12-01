package sistema_academico.modelo;

import java.util.ArrayList;
import java.util.List;

public class Turma {
  private String codigo;
  private Professor professor;
  private List<Aluno> alunos;
  private static List<Turma> turmas;
 
 static{
     turmas = new ArrayList<>();
 }
 
  public Turma(String codigo, Professor professor, List<Aluno> alunos) {
        this.codigo = codigo;
        this.professor = professor;
        this.alunos = alunos;
    }
 
  public String getCodigo() {
        return codigo;
    }

  public Professor getProfessor() {
        return professor;
    }

  public List<Aluno> getAlunos() {
        return alunos;
    }
 
  public void inserirAluno(Aluno aluno) {
        alunos.add(aluno);
    }

  public void removerAluno(Aluno aluno) {
        alunos.remove(aluno);
    }
 
  public String listarAlunos() {
        StringBuilder sb = new StringBuilder();
        for (Aluno aluno : alunos) {
            sb.append(aluno.getNome()).append("\n");
        }
        return sb.toString();
    }
 
  public float obterMedia() {
        if (alunos.isEmpty()){
          return 0.0f;
        } 
          

        float soma = 0.0f;
        for (Aluno aluno : alunos) {
            soma += aluno.obterMedia();
        }
        return soma / alunos.size();
    }
 
  public static List<Turma> getTurmas() {
        return turmas;
    }
 
  public static void inserirTurma(Turma turma) {
        turmas.add(turma);
    }
 
  public static boolean removerTurma(Turma turma) {
        return turmas.remove(turma);
    }
 
  public static Turma obterTurma(String codigo) {
        for (Turma turma : turmas) {
            if (turma.getCodigo().equals(codigo) {
                return turma;
            }
        }
        return null;
    }
    @Override
    public String toString() {
    return "Turma " + codigo + " - Professor: " + professor.getNome();
}
}
