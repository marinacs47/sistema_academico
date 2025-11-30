/*
package sistema_academico.visao;

import javax.swing.JOptionPane;
import sistema_academico.modelo.Professor;
import java.util.List;

public class ProfessorUI {

public Professor criar() {
String siapeStr = JOptionPane.showInputDialog("SIAPE:");
if (siapeStr == null) return null;
int siape;
try {
siape = Integer.parseInt(siapeStr);
} catch (NumberFormatException e){
JOptionPane.showInputDialog(null, "SIAPE inválido");
return null;
}

String nome = JOptionPane.showInputDialog("Nome:");
if (nome == null) return null;

Professor professor = new Professor(siape, nome);
Professor.inserir(professor);
return professor;
}

public void listar() {
List<Professor> professores = Professor.getProfessores();
StringBuilder sb = new StringBuilder();

for (Professor p : professores){
sb.append(p.toString()).append("\n");
}
JOptionPane.showMessageDialog(null, sb.length() == 0 ? "Nenhum professor cadastrado." : sb.toString());
}

public Professor remover() {
String siapeStr = JOptionPane.showInputDialog("SIAPE para remover:");
if (siapeStr == null) return null;
int siape;
try {
siape = Integer.parseInt(siapeStr);
}catch (NumberFormatException e){
JOptionPane.showInputDialog(null, "SIAPE inválido");
return null;
}

Professor b = new Professor(siape, "");
boolean ok = Professor.remover(b);
JOptionPane.showMessageDialog(null, ok ? "Professor removido." : "Professor não encontrado.");

return ok ? b : null;
}
}*/

package sistema_academico.visao;

import java.util.Scanner;
import sistema_academico.modelo.Professor;
import java.util.List;

public class ProfessorUI {

    private Scanner sc = new Scanner(System.in);

    public Professor criar() {
        System.out.print("SIAPE: ");
        String siapeStr = sc.nextLine();
        if (siapeStr.isEmpty()) return null;

        int siape;
        try {
            siape = Integer.parseInt(siapeStr);
        } catch (NumberFormatException e) {
            System.out.println("SIAPE inválido.");
            return null;
        }

        System.out.print("Nome: ");
        String nome = sc.nextLine();
        if (nome.isEmpty()) return null;

        Professor professor = new Professor(siape, nome);
        Professor.inserir(professor);
        return professor;
    }

    public void listar() {
        List<Professor> professores = Professor.getProfessores();

        if (professores.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
            return;
        }

        for (Professor p : professores) {
            System.out.println(p);
        }
    }

    public Professor remover() {
        System.out.print("SIAPE para remover: ");
        String siapeStr = sc.nextLine();
        if (siapeStr.isEmpty()) return null;

        int siape;
        try {
            siape = Integer.parseInt(siapeStr);
        } catch (NumberFormatException e) {
            System.out.println("SIAPE inválido.");
            return null;
        }

        Professor p = new Professor(siape, "");
        boolean ok = Professor.remover(p);

        System.out.println(ok ? "Professor removido." : "Professor não encontrado.");
        return ok ? p : null;
    }
}