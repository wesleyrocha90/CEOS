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
  
  @PostConstruct
  public void init(){
    GrupoUsuario grupoUsuario = null;
    if(getModelo().getSelectedDataIndex() >= 0){
      grupoUsuario = getModelo().getData().get(getModelo().getSelectedDataIndex());
      descricao.setText(grupoUsuario.getDescricao());
    }
  }
  
  public void onSaveAction(){
    GrupoUsuario grupoUsuario = new GrupoUsuario(descricao.getText());
    getModelo().setEditedData(grupoUsuario);
  }
}
