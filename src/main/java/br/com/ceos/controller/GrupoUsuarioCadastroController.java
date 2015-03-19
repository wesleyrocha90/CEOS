package br.com.ceos.controller;

import br.com.ceos.controller.flow.AbstractCadastroController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class GrupoUsuarioCadastroController extends AbstractCadastroController implements Initializable {
  
  @FXML
  private TextField codigo;
  @FXML
  private TextField descricao;
  
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    descricao.requestFocus();
  }
}
