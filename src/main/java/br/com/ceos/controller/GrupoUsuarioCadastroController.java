package br.com.ceos.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.datafx.controller.FXMLController;
import org.datafx.controller.flow.action.ActionTrigger;

@FXMLController("/fxml/GrupoUsuarioCadastro.fxml")
public class GrupoUsuarioCadastroController implements Initializable {
  
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
  
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    descricao.requestFocus();
  }
}
