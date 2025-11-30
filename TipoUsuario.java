package sistema_academico.modelo;

import sistema_academico.modelo.TipoUsuario;
import java.util.List;
import java.util.ArrayList;

public class TipoUsuario {
private String nome;
private List<Funcionalidade> funcionalidades = new ArrayList<>();

public TipoUsuario(String nome) {
this.nome = nome;
definirFuncionalidades();
}

public String getNome(){
return nome;
}

public List<Funcionalidade> getFuncionalidades(){
return funcionalidades;
}

public void definirFuncionalidades(){
if(nome.equalsIgnoreCase("Administrador")){
funcionalidades.add(Funcionalidade.getFuncionalidade("CA"));
funcionalidades.add(Funcionalidade.getFuncionalidade("CP"));
funcionalidades.add(Funcionalidade.getFuncionalidade("CT"));
funcionalidades.add(Funcionalidade.getFuncionalidade("LA"));
funcionalidades.add(Funcionalidade.getFuncionalidade("LP"));
funcionalidades.add(Funcionalidade.getFuncionalidade("LT"));
funcionalidades.add(Funcionalidade.getFuncionalidade("RA"));
funcionalidades.add(Funcionalidade.getFuncionalidade("RP"));
funcionalidades.add(Funcionalidade.getFuncionalidade("RT"));
}
}
}