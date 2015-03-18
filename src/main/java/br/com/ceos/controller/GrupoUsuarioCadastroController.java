package br.com.ceos.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class GrupoUsuarioCadastroController implements Initializable {
  
  @FXML
  private Button salvar;
  @FXML
  private Button salvarEFechar;
  @FXML
  private Button cancelar;
  @FXML
  private TextField codigo;
  @FXML
  private TextField descricao;
  
  @FXML
  public void onSalvarAction(ActionEvent event){
    
  }
  
  @FXML
  public void onSalvarEFecharAction(ActionEvent event){
    
  }
  
  @FXML
  public void onCancelarAction(ActionEvent event){
    
  }
  
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    descricao.requestFocus();
  }
}
