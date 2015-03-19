package br.com.ceos.controller.flow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import lombok.AccessLevel;
import lombok.Setter;

public class AbstractCadastroController {
  
  @Setter(AccessLevel.PACKAGE)
  ListViewController controller;
  
  @FXML
  private Button botaoSalvar;
  @FXML
  private Button botaoSalvarEFechar;
  @FXML
  private Button botaoCancelar;
  
  @FXML
  public void onSalvarAction(ActionEvent event){
    System.out.println("Salvando um item");
  }
  
  @FXML
  public void onSalvarEFecharAction(ActionEvent event){
    System.out.println("Salvando um item e fechando");
  }
  
  @FXML
  public void onCancelarAction(ActionEvent event){
    System.out.println("Cancelando a edição");
  }
}
