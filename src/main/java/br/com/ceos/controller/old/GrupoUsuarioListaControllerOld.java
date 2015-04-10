package br.com.ceos.controller.old;

import br.com.ceos.controller.component.ButtonCell;
import br.com.ceos.controller.flow.AbstractListaController;
import br.com.ceos.controller.flow.DataModelFlow;
import br.com.ceos.entity.GrupoUsuario;
import io.datafx.controller.ViewController;
import io.datafx.controller.flow.action.ActionTrigger;
import java.util.function.Supplier;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

@ViewController("/fxml/GrupoUsuarioLista.fxml")
public class GrupoUsuarioListaControllerOld {

  @FXML
  @ActionTrigger("editar")
  private TableView<GrupoUsuario> tabela;
  @FXML
  private TableColumn<GrupoUsuario, String> colunaDescricao;
  @FXML
  private TableColumn<GrupoUsuario, Boolean> colunaSelecionar;
  @FXML
  private TableColumn<GrupoUsuario, Boolean> colunaEditar;
  @FXML
  private TableColumn<GrupoUsuario, Boolean> colunaExcluir;
  
  @Inject
  private DataModelFlow model;
  
  public void onBotaoCriarNovoAction(){
    tabela.getSelectionModel().clearSelection();
  };
  
  @PostConstruct
  public void init() {
    colunaEditar.setCellValueFactory( param -> new SimpleBooleanProperty(param.getValue() != null));
    colunaEditar.setCellFactory( param -> new ButtonCell("edit_16"));
    colunaExcluir.setCellValueFactory( param -> new SimpleBooleanProperty(param.getValue() != null));
    colunaExcluir.setCellFactory( param -> new ButtonCell("delete_16"));
    colunaSelecionar.setCellFactory( param -> new CheckBoxTableCell<>() );
    
    colunaDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
    
    tabela.itemsProperty().bind(model.getData());
    model.selectedDataIndexProperty().bind(tabela.getSelectionModel().selectedIndexProperty());
  }
}
