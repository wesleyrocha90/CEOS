package br.com.ceos.controller;

import br.com.ceos.controller.flow.AbstractCadastroController;
import br.com.ceos.entity.GrupoUsuario;
import io.datafx.controller.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

@ViewController("/fxml/GrupoUsuarioCadastro.fxml")
public class GrupoUsuarioCadastroController extends AbstractCadastroController<GrupoUsuario>{
  
  @FXML
  private TextField descricao;
  
  @Override
  public void telaParaObjeto(GrupoUsuario objeto) {
    objeto.setDescricao(descricao.getText());
  }

  @Override
  public void objetoParaTela(GrupoUsuario objeto) {
    descricao.setText(objeto.getDescricao());
  }
}
