package sistema_academico.modelo;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {
    private String matricula;
    private  List<Float> notas = new ArrayList<>();
    private static List<Aluno> alunos = new ArrayList<>();
    
    static{
        alunos.add(new Aluno("20242enel0335","Miguel"));
        alunos.add(new Aluno("20242enel0336","Luisa"));
        alunos.add(new Aluno("20242enel0337","Marina"));
        alunos.add(new Aluno("20242enel0338","Gabriel"));
        alunos.add(new Aluno("20242enel0339","Ana"));
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
        float soma = 0;
        for (float n : notas){
            soma += n;
        }
        return soma / notas.size();
    }
    
    public static List<Aluno> getAlunos(){
        return alunos;
    }
    
    public static void inserir(Aluno aluno){
        if(aluno != null){
         alunos.add(aluno);   
        }
    }
    
    public static boolean remover(Aluno aluno){
        return alunos.remove(aluno);     
    }
    
    public static Aluno obter(Aluno aluno) {
        for (Aluno a : alunos) {
            if (a.equals(aluno)) {
                return a;
            }
        }
        return null;
    }
}
