package br.com.ceos.controller.flow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public abstract class AbstractListaController<E> {
  
  @FXML
  private Button botaoCriarNovo;
  
  @FXML 
  private void onCriarNovoAction(ActionEvent event){
  }
  
  @FXML
  private void onEditarAction(ActionEvent event){
  }
}
