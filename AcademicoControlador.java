package sistema_academico.controle;

import sistema_academico.modelo.Usuario;
import sistema_academico.visao.UsuarioUI;
import sistema_academico.visao.AlunoUI;
import sistema_academico.visao.ProfessorUI;
import sistema_academico.visao.TurmaUI;
public class AcademicoControlador {

    public void inicializar() {
        UsuarioUI usuarioUI = new UsuarioUI();
        Usuario usuario = usuarioUI.autenticar();

        if (usuario != null) {
            processarMenu(usuarioUI, usuario);
        }
    }

    public void processarMenu(UsuarioUI usuarioUI, Usuario usuario) {

        AlunoUI alunoUI = new AlunoUI();
        ProfessorUI professorUI = new ProfessorUI();
        TurmaUI turmaUI = new TurmaUI();

        int opcao;

        do {
            opcao = usuarioUI.exibirMenu(usuario);

            switch (opcao) {
                case 1: alunoUI.criar(); break;
                case 2: professorUI.criar(); break;
                case 3: turmaUI.criar(); break;
                case 4: alunoUI.listar(); break;
                case 5: professorUI.listar(); break;
                case 6: turmaUI.listar(); break;
                case 7: alunoUI.remover(); break;
                case 8: professorUI.remover(); break;
                case 9: turmaUI.remover(); break;
                case 0: break;
                default:
                    usuarioUI.exibirMensagem("Opção inválida.");
                    break;
            }

        } while (opcao != 0);
    }
}