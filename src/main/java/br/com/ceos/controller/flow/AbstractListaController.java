package br.com.ceos.controller.flow;

import io.datafx.controller.flow.action.ActionTrigger;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public abstract class AbstractListaController {
  
  @FXML
  @ActionTrigger("criar")
  private Button botaoCriarNovo;
  
}
