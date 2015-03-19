package br.com.ceos.controller.flow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import lombok.AccessLevel;
import lombok.Setter;

public abstract class AbstractCadastroController<E> {

  @Setter(AccessLevel.PACKAGE)
  private ListViewController controller;
  
  private ListViewDataModel<E> dataModel;

  @FXML
  private Button botaoSalvar;
  @FXML
  private Button botaoSalvarEFechar;
  @FXML
  private Button botaoCancelar;

  public abstract void salvar();

  @FXML
  public void onSalvarAction(ActionEvent event) {
    salvar();
  }

  @FXML
  public void onSalvarEFecharAction(ActionEvent event) {
    salvar();
    onCancelarAction(event);
  }

  @FXML
  public void onCancelarAction(ActionEvent event) {
    controller.changeToList();
  }
}
