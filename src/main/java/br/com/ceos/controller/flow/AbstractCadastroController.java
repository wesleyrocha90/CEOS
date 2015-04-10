package br.com.ceos.controller.flow;

import io.datafx.controller.flow.action.ActionTrigger;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public abstract class AbstractCadastroController<E> {

  @FXML
  private Button salvar;
  @FXML
  private Button salvarEFechar;
  @FXML
  @ActionTrigger("cancelar")
  private Button cancelar;
}
