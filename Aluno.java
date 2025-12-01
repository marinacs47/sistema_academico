package sistema_academico.modelo;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {
    private String matricula;
    private  List<Float> notas = new ArrayList<>();
    private static List<Aluno> alunos;
   
    static{
        alunos = new ArrayList<>();
    }
   
    public Aluno(String matricula,String nome) {
        super(nome);
        this.matricula = matricula;
    }
   
    public String getMatricula(){
        return matricula;
    }
   
    public List<Float> getNotas(){
        return notas;
    }
   
    public void setNota(float valor){
        notas.add(valor);
    }
   
    public float obterMedia(){
        if(notas.isEmpty()){
            return 0.0f;
        }
        float soma = 0.0f;
        for (float nota : notas){
            soma += nota;
        }
        return soma / notas.size();
    }
   
    public static List<Aluno> getAlunos(){
        return alunos;
    }
   
    public static void inserirAluno(Aluno aluno){
        if(aluno != null){
         alunos.add(aluno);  
        }
    }
   
    public static boolean removerAluno(Aluno aluno){
        return alunos.remove(aluno);    
    }
   
    public static Aluno obterAluno(String matricula) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                return aluno;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
    return "Matrícula: " + matricula + " | Nome: " + getNome();
}
}
