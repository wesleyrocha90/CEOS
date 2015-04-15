package br.com.ceos.controller.flow;

import br.com.ceos.entity.EntidadeBase;
import io.datafx.controller.flow.action.ActionTrigger;
import java.util.function.Supplier;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javax.inject.Inject;
import lombok.Getter;

public abstract class AbstractCadastroController<E extends EntidadeBase> {

  @FXML
  @ActionTrigger("salvar")
  private Button salvar;
  
  @FXML
  @ActionTrigger("salvarEFechar")
  private Button salvarEFechar;
  
  @FXML
  @ActionTrigger("cancelar")
  private Button cancelar;
  
  @Inject
  @Getter private DataModelFlow<E> modelo;
  
  public abstract Supplier<E> filler();
  
  public void onSaveAction(){
    getModelo().setEditedData(filler().get());
  }
}
