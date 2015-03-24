package br.com.ceos.controller;

import br.com.ceos.controller.flow.DataModelFlow;
import br.com.ceos.entity.GrupoUsuario;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.datafx.controller.FXMLController;
import org.datafx.controller.flow.action.ActionTrigger;

@FXMLController("/fxml/GrupoUsuarioCadastro.fxml")
public class GrupoUsuarioCadastroController {
  
  @FXML
  private TextField codigo;
  @FXML
  private TextField descricao;
  
  @FXML
  private Button botaoSalvar;
  @FXML
  private Button botaoSalvarEFechar;
  
  @FXML
  @ActionTrigger("cancelar")
  private Button botaoCancelar;
  
  @Inject
  private DataModelFlow model;
  
  @PostConstruct
  public void init() {
    if(model.getSelectedDataIndex() >= 0){
      GrupoUsuario grupoUsuario = model.getData().get(model.getSelectedDataIndex());
      codigo.setText(grupoUsuario.getId().toString());
      descricao.setText(grupoUsuario.getDescricao());
    }
  }
}
