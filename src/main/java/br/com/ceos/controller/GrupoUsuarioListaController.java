package br.com.ceos.controller;

import br.com.ceos.controller.flow.DataModelFlow;
import br.com.ceos.entity.GrupoUsuario;
import io.datafx.controller.ViewController;
import io.datafx.controller.flow.action.ActionMethod;
import io.datafx.controller.flow.action.ActionTrigger;
import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

@ViewController("/fxml/GrupoUsuarioLista.fxml")
public class GrupoUsuarioListaController {

  @FXML
  @ActionTrigger("editar")
  private TableView<GrupoUsuario> tableGrupoUsuario;
  @FXML
  private TableColumn<GrupoUsuario, Integer> columnId;
  @FXML
  private TableColumn<GrupoUsuario, String> columnDescricao;
  @FXML
  private TableColumn<GrupoUsuario, LocalDate> columnDataCadastro;
  
  @FXML
  @ActionTrigger("criar")
  private Button botaoCriarNovo;
  
  @FXML
  @ActionTrigger("excluir")
  private Button botaoExcluir;
  
  @Inject
  private DataModelFlow model;
  
  public void onBotaoCriarNovoAction(){
    tableGrupoUsuario.getSelectionModel().clearSelection();
  };
  
  @PostConstruct
  public void init() {
    columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
    columnDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
    columnDataCadastro.setCellValueFactory(new PropertyValueFactory<>("dataCriacao"));
    
    tableGrupoUsuario.itemsProperty().bind(model.getData());
    model.selecteDataIndexProperty().bind(tableGrupoUsuario.getSelectionModel().selectedIndexProperty());
  }
  
  Runnable runnable = () -> tableGrupoUsuario.getSelectionModel().clearSelection();
}
