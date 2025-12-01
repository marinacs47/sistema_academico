package sistema_academico.modelo;

import java.util.ArrayList;
import java.util.List;
       
public class Professor extends Pessoa {
    private int siape;
    private static List<Professor> professores;
    
    static{
        professores = new ArrayList<>();
    }

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
   
    public static void inserirProfessor(Professor professor){
        if(professor != null){
         professores.add(professor);  
        }
    }

    public static boolean removerProfessor(Professor professor){
        return professores.remove(professor);    
    }
   
    public static Professor obter(int siape) {
    for (Professor professor : professores) { 
        if (professor.getSiape() == siape) { 
            return professor; 
        }
    }
    return null;
    }

    @Override
    public String toString() {
    return "SIAPE: " + siape + " | Nome: " + getNome();
    }   
}
