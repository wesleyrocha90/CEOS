package br.com.ceos.controller;

import br.com.ceos.util.BundleUtil;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class GrupoUsuarioCadastroController extends ControllerBase implements Initializable {
  
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
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/GrupoUsuarioLista.fxml"), BundleUtil.getBundle());
      Parent root = (Parent) fxmlLoader.load();
      root.setPickOnBounds(true);
      getTabPrincipal().setContent(root);
    } catch (IOException ex) {
      System.out.println(ex);
    }
  }
  
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    descricao.requestFocus();
  }
}
