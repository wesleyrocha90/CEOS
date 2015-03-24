package br.com.ceos.controller.flow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public abstract class AbstractCadastroController<E> {
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
  }
}
