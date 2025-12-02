package sistema_academico.visao;

import javax.swing.JOptionPane;
import java.util.List;
import sistema_academico.modelo.Professor;
import sistema_academico.modelo.SiapeJaExisteException; 

public class ProfessorUI {

    private static boolean isEntradaInvalida(String entrada) {
        return entrada == null || entrada.trim().isEmpty(); 
    }

    public static Professor cadastrar() {
        String siapeStr = JOptionPane.showInputDialog("Digite o SIAPE do Professor:");
        
        if (isEntradaInvalida(siapeStr)) {
            UsuarioUI.exibirMensagem("Cadastro cancelado ou SIAPE Inválido (não pode ser vazio).");
            return null;
        }

        int siape;
        try {
            siape = Integer.parseInt(siapeStr.trim()); 
        } catch (NumberFormatException e) {
            UsuarioUI.exibirMensagem("SIAPE inválido. Deve ser um número inteiro.");
            return null;
        }

        String nome = JOptionPane.showInputDialog("Digite o Nome do Professor:");
        
        if (isEntradaInvalida(nome)) {
            UsuarioUI.exibirMensagem("Cadastro cancelado ou Nome Inválido (não pode ser vazio).");
            return null;
        }

        Professor novoProf = new Professor(siape, nome.trim());
        
        try {
            Professor.inserirProfessor(novoProf);
            UsuarioUI.exibirMensagem("Professor cadastrado com sucesso!");
            return novoProf;
        } catch (SiapeJaExisteException e) {
            UsuarioUI.exibirMensagem("ERRO: O SIAPE " + siape + " já está cadastrado.");
            return null;
        } catch (Exception e) {
             UsuarioUI.exibirMensagem("ERRO INESPERADO ao cadastrar professor: " + e.getMessage());
            return null;
        }
    }

    public static void listar() {
        List<Professor> professores = Professor.getProfessores();
        StringBuilder sb = new StringBuilder("--- LISTA DE PROFESSORES ---\n");

        if (professores.isEmpty()) {
            sb.append("Nenhum professor cadastrado.");
        } else {
            for (Professor p : professores) {
                sb.append("SIAPE: ").append(p.getSiape())
                  .append(" | Nome: ").append(p.getNome()).append("\n");
            }
        }
        UsuarioUI.exibirMensagem(sb.toString());
    }

    public static void remover() {
        String siapeStr = JOptionPane.showInputDialog("Digite o SIAPE do professor a remover:");
        
        if (isEntradaInvalida(siapeStr)) {
             UsuarioUI.exibirMensagem("Remoção cancelada ou SIAPE Inválido.");
            return;
        }
        
        try {
            int siape = Integer.parseInt(siapeStr.trim()); 
            Professor prof = Professor.obterProfessor(siape);
            
            if (prof != null) {
                Professor.removerProfessor(prof);
                UsuarioUI.exibirMensagem("Professor removido com sucesso!");
            } else {
                UsuarioUI.exibirMensagem("Professor não encontrado. Verifique o SIAPE.");
            }
        } catch (NumberFormatException e) {
            UsuarioUI.exibirMensagem("SIAPE inválido. Deve ser um número.");
        }
    }
}
