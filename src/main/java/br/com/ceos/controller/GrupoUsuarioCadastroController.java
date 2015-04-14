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
    if(getModelo().getSelectedDataIndex() >= 0){
      grupoUsuario = getModelo().getData().get(getModelo().getSelectedDataIndex());
    }else{
      grupoUsuario = new GrupoUsuario();
    }
    descricao.setText(grupoUsuario.getDescricao());
  }
  
  public void onSaveAction(){
    grupoUsuario.setDescricao(descricao.getText());
    getModelo().setEditedData(grupoUsuario);
  }
}
