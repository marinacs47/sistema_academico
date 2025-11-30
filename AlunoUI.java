/*package sistema_academico.visao;

import javax.swing.JOptionPane;
import sistema_academico.modelo.Aluno;
import java.util.List;

public class AlunoUI {

public Aluno criar() {
String matricula = JOptionPane.showInputDialog("Matrícula:");
if (matricula == null) return null;

String nome = JOptionPane.showInputDialog("Nome:");
if (nome == null) return null;

Aluno aluno = new Aluno(matricula, nome);
Aluno.inserir(aluno);
return aluno;
}

public void listar() {
List<Aluno> alunos = Aluno.getAlunos();
StringBuilder sb = new StringBuilder();

for (Aluno a : alunos)
sb.append(a.toString()).append("\n");

JOptionPane.showMessageDialog(null, sb.length() == 0 ? "Nenhum aluno." : sb.toString());
}

public Aluno remover() {
String matricula = JOptionPane.showInputDialog("Matrícula para remover:");
if (matricula == null) return null;

Aluno a = new Aluno(matricula, "");
boolean ok = Aluno.remover(a);

if(ok){
JOptionPane.showMessageDialog(null, "Aluno removido");
return a;
}else{
JOptionPane.showMessageDialog(null, "Aluno não encontrado");
return null;
}
}
}*/

package sistema_academico.visao;

import java.util.Scanner;
import sistema_academico.modelo.Aluno;
import java.util.List;

public class AlunoUI {

    private Scanner sc = new Scanner(System.in);

    public Aluno criar() {
        System.out.print("Matrícula: ");
        String matricula = sc.nextLine();
        if (matricula.isEmpty()) return null;

        System.out.print("Nome: ");
        String nome = sc.nextLine();
        if (nome.isEmpty()) return null;

        Aluno aluno = new Aluno(matricula, nome);
        Aluno.inserir(aluno);
        return aluno;
    }

    public void listar() {
        List<Aluno> alunos = Aluno.getAlunos();

        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno.");
            return;
        }

        for (Aluno a : alunos) {
            System.out.println(a);
        }
    }

    public Aluno remover() {
        System.out.print("Matrícula para remover: ");
        String matricula = sc.nextLine();
        if (matricula.isEmpty()) return null;

        Aluno a = new Aluno(matricula, "");
        boolean ok = Aluno.remover(a);

        System.out.println(ok ? "Aluno removido." : "Aluno não encontrado.");
        return ok ? a : null;
    }
}