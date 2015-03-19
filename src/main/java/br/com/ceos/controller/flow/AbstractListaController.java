package br.com.ceos.controller.flow;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class AbstractListaController<E> {
  
  @Getter(AccessLevel.PROTECTED)
  @Setter(AccessLevel.PROTECTED)
  private ObservableList<E> dados = FXCollections.observableArrayList();
  
  @FXML
  private Button botaoCriarNovo;
  
  @FXML 
  private void onCriarNovoAction(ActionEvent event){
    System.out.println("Criando um item");
  }
  
  @FXML
  private void onEditarAction(ActionEvent event){
    System.out.println("Editando um item");
  }
}
