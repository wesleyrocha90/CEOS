package br.com.ceos.controller.flow;

import io.datafx.controller.flow.action.ActionTrigger;
import java.util.function.Supplier;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import lombok.Getter;

public abstract class AbstractListaController<E> {
  
  @FXML
  @ActionTrigger("editar")
  private TableView<E> tabela;
  
  @FXML
  @ActionTrigger("criar")
  private Button criar;
  
  @FXML
  @ActionTrigger("remover")
  private Button remover;
  
  @Inject
  @Getter private DataModelFlow<E> modelo;

  public abstract Supplier<ObservableList<E>> supplier(); // fornece a lista de dados para a tabela
  
  public void onBotaoCriarNovoAction(){
    tabela.getSelectionModel().clearSelection();
  };
  
  @PostConstruct
  public void initialize(){
    if(modelo != null){
      modelo.setSupplier(supplier());
      tabela.itemsProperty().bind(modelo.getData());
      modelo.selectedDataIndexProperty().bind(tabela.getSelectionModel().selectedIndexProperty());
    }
  }
}
