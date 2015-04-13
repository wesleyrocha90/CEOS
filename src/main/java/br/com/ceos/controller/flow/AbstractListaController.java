package br.com.ceos.controller.flow;

import br.com.ceos.controller.component.ButtonCell;
import io.datafx.controller.flow.action.ActionTrigger;
import java.util.function.Supplier;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

public abstract class AbstractListaController<E> {
  
  @FXML
  @ActionTrigger("editar")
  private TableView<E> tabela;
  @FXML
  private TableColumn<E, Boolean> colunaSelecionar;
  @FXML
  private TableColumn<E, Boolean> colunaEditar;
  @FXML
  private TableColumn<E, Boolean> colunaExcluir;
  
  @Inject
  private DataModelFlow<E> modelo;

  public abstract Supplier<ObservableList<E>> supplier(); // fornece a lista de dados para a tabela
  
  @PostConstruct
  public void initialize(){
    colunaEditar.setCellValueFactory( param -> new SimpleBooleanProperty(param.getValue() != null));
    colunaEditar.setCellFactory( param -> new ButtonCell("edit_16"));
    colunaExcluir.setCellValueFactory( param -> new SimpleBooleanProperty(param.getValue() != null));
    colunaExcluir.setCellFactory( param -> new ButtonCell("delete_16"));
    colunaSelecionar.setCellFactory( param -> new CheckBoxTableCell<>() );
    
    if(modelo != null){
      modelo.setSupplier(supplier());
      tabela.itemsProperty().bind(modelo.getData());
      modelo.selectedDataIndexProperty().bind(tabela.getSelectionModel().selectedIndexProperty());
    }
    System.out.println("AbstractListaController " + modelo);
  }
}
