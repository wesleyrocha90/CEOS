package br.com.ceos.controller;

import br.com.ceos.controller.flow.AbstractListaController;
import br.com.ceos.entity.GrupoUsuario;
import br.com.ceos.util.QueryUtil;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class GrupoUsuarioListaController extends AbstractListaController<GrupoUsuario> implements Initializable {

  @FXML
  private TableView<GrupoUsuario> tableGrupoUsuario;
  @FXML
  private TableColumn<GrupoUsuario, Integer> columnId;
  @FXML
  private TableColumn<GrupoUsuario, String> columnDescricao;
  @FXML
  private TableColumn<GrupoUsuario, LocalDate> columnDataCadastro;
  
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
    columnDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
    columnDataCadastro.setCellValueFactory(new PropertyValueFactory<>("dataCriacao"));
    tableGrupoUsuario.setItems(getDados());

    List<GrupoUsuario> grupoUsuarioLista = QueryUtil.selectListByNamedQuery("GrupoUsuario.findAll");
    getDados().addAll(grupoUsuarioLista);
  }
}
