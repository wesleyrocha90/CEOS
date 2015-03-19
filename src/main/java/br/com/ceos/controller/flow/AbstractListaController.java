package br.com.ceos.controller.flow;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public abstract class AbstractListaController<E> {
  
  @Setter(AccessLevel.PACKAGE)
  ListViewController controller;
  
  @Getter(AccessLevel.PROTECTED)
  @Setter(AccessLevel.PROTECTED)
  private ObservableList<E> dados = FXCollections.observableArrayList();
  
  @FXML
  private Button botaoCriarNovo;
  
  @FXML 
  private void onCriarNovoAction(ActionEvent event){
    controller.changeToEdit();
  }
  
  @FXML
  private void onEditarAction(ActionEvent event){
    System.out.println("Editando um item");
  }
}
