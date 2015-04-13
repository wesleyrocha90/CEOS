package br.com.ceos.controller.flow;

import io.datafx.controller.flow.action.ActionTrigger;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import lombok.Getter;

public abstract class AbstractCadastroController<E> {

  @FXML
  @ActionTrigger("salvar")
  private Button salvar;
  @FXML
  private Button salvarEFechar;
  @FXML
  @ActionTrigger("cancelar")
  private Button cancelar;
  
  @Inject
  @Getter public DataModelFlow<E> modelo;
  
  @PostConstruct
  public void initialize(){
//    System.out.println("AbstractCadastroController " + modelo);
  }
}
