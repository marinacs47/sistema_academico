package sistema_academico.controle;

import sistema_academico.modelo.Funcionalidade;
import sistema_academico.modelo.Usuario;
import sistema_academico.visao.AlunoUI;
import sistema_academico.visao.ProfessorUI;
import sistema_academico.visao.TurmaUI;
import sistema_academico.visao.UsuarioUI;

public class AcademicoControlador {

    public void inicializar() {
        Usuario usuarioLogado = UsuarioUI.autenticar();
        UsuarioUI.exibirMensagem("Bem-vindo, " + usuarioLogado.getLogin());

        boolean executando = true;
        while (executando) {
            int opcao = UsuarioUI.exibirMenu(usuarioLogado);
            processarMenu(usuarioLogado, opcao);
        }
    }

    public void processarMenu(Usuario usuario, int opcao) {
        var funcionalidades = usuario.getTipoUsuario().getFuncionalidades();
        int index = opcao - 1;

        if (index >= 0 && index < funcionalidades.size()) {
            Funcionalidade func = funcionalidades.get(index);
            String codigo = func.getCodigo();

            switch (codigo) {
                case "CA":
                    AlunoUI.criar();
                    break;
                case "LA":
                    AlunoUI.listar();
                    break;
                case "RA":
                    AlunoUI.remover();
                    break;
                case "CP":
                    ProfessorUI.criar();
                    break;
                case "LP":
                    ProfessorUI.listar();
                    break;
                case "RP":
                    ProfessorUI.remover();
                    break;
                case "CT":
                    TurmaUI.criar();
                    break;
                case "LT":
                    TurmaUI.listar();
                    break;
                case "RT":
                    TurmaUI.remover();
                    break;
                case "SAIR":
                    UsuarioUI.exibirMensagem("Encerrando o sistema...");
                    System.exit(0);
                    break;
                default:
                    UsuarioUI.exibirMensagem("Funcionalidade nao implementada.");
            }
        } else {
            UsuarioUI.exibirMensagem("Opcao invalida!");
        }
    }
}
