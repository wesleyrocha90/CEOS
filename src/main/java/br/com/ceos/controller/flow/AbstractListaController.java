package br.com.ceos.controller.flow;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import lombok.AccessLevel;
import lombok.Setter;

public abstract class AbstractListaController<E> {
  
  @Setter(AccessLevel.PACKAGE)
  private ListViewController controller;
  
  private ListViewDataModel<E> dataModel;
  
  @FXML
  private Button botaoCriarNovo;
  
  @FXML 
  private void onCriarNovoAction(ActionEvent event){
    controller.changeToEdit();
  }
  
  @FXML
  private void onEditarAction(ActionEvent event){
    System.out.println(event.getSource());
    controller.changeToEdit();
  }
  
  public ObservableList<E> getDados(){
    return dataModel.getDados();
  }
}
