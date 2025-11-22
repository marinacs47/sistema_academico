package modelo.sistema_academico;

import java.util.ArrayList;
import java.util.List;
        
public class Professor extends Pessoa {
    private int siape;
    private static List<Professor> professores = new ArrayList<>();

    public Professor(int siape,String nome){
        super(nome);
        this.siape = siape;
    }
    
    public int getSiape(){
        return siape;
    }
    
    public static List<Professor> getProfessores(){
        return professores;
    }
    
    public static void inserir(Professor professor){
        if(professor != null){
         professores.add(professor);   
        }
    }

    public static boolean remover(Professor professor){
        return professores.remove(professor);     
    }
    
    public static Professor obter(Professor professor) {
    for (Professor p : professores) {
        if (p.equals(professor)) {
            return p;
        }
    }
        return null;
    }
    
}
