package br.com.ceos.controller;

import br.com.ceos.entity.GrupoUsuario;
import br.com.ceos.util.QueryUtil;
import io.datafx.controller.FXMLController;
import io.datafx.controller.flow.action.ActionTrigger;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

@FXMLController("/fxml/GrupoUsuarioLista.fxml")
public class GrupoUsuarioListaController implements Initializable {

  @FXML
  private TableView<GrupoUsuario> tableGrupoUsuario;
  @FXML
  private TableColumn<GrupoUsuario, Integer> columnId;
  @FXML
  private TableColumn<GrupoUsuario, String> columnDescricao;
  @FXML
  private TableColumn<GrupoUsuario, LocalDate> columnDataCadastro;
  
  @FXML
  @ActionTrigger("criarNovo")
  private Button botaoCriarNovo;
  
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
    columnDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
    columnDataCadastro.setCellValueFactory(new PropertyValueFactory<>("dataCriacao"));
    ObservableList<GrupoUsuario> dados = FXCollections.observableArrayList();
    tableGrupoUsuario.setItems(dados);

    List<GrupoUsuario> grupoUsuarioLista = QueryUtil.selectListByNamedQuery("GrupoUsuario.findAll");
    dados.addAll(grupoUsuarioLista);
  }
}
