package br.com.ceos.controller;

import br.com.ceos.controller.flow.AbstractCadastroController;
import br.com.ceos.entity.GrupoUsuario;
import io.datafx.controller.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javax.annotation.PostConstruct;

@ViewController("/fxml/GrupoUsuarioCadastro.fxml")
public class GrupoUsuarioCadastroController extends AbstractCadastroController<GrupoUsuario>{
  
  @FXML
  private TextField descricao;
  
  private GrupoUsuario grupoUsuario;
  
  @PostConstruct
  public void init(){
//    if(getModelo().getIndiceDado() >= 0){
//      grupoUsuario = getModelo().getDados().get(getModelo().getIndiceDado());
//    }else{
//      grupoUsuario = new GrupoUsuario();
//    }
//    objetoParaTela(grupoUsuario);
    System.out.println(getModelo().getDado());
  }
  
  @Override
  public GrupoUsuario telaParaObjeto() {
    grupoUsuario.setDescricao(descricao.getText());
    return grupoUsuario;
  }

  @Override
  public void objetoParaTela(GrupoUsuario objeto) {
    descricao.setText(objeto.getDescricao());
  }
}
