package sistema_academico.modelo;

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
        if(professor != null){ //verificando se a lista tá vazia
         professores.add(professor);   
        }
    }

    public static boolean remover(Professor professor){
        return professores.remove(professor);     
    }
    
    public static Professor obter(Professor professor) {
    for (Professor p : professores) { //to buscando um professor da lista de professores
        if (p.equals(professor)) { //aqui to comparando um professor p com o passado do método
            return p; //se for igual, retorna p
        }
    }
        return null; // se nao,retorna nulo
    }
    
}


