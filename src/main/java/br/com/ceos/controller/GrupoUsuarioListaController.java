package br.com.ceos.controller;

import br.com.ceos.entity.GrupoUsuario;
import br.com.ceos.util.QueryUtil;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class GrupoUsuarioListaController implements Initializable {

  @FXML
  private TableView<GrupoUsuario> tableGrupoUsuario;
  @FXML
  private TableColumn<GrupoUsuario, Integer> columnId;
  @FXML
  private TableColumn<GrupoUsuario, String> columnDescricao;
  @FXML
  private TableColumn<GrupoUsuario, LocalDate> columnDataCadastro;
  private ObservableList dados;

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
    columnDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
    columnDataCadastro.setCellValueFactory(new PropertyValueFactory<>("dataCriacao"));
    dados = FXCollections.observableArrayList();
    tableGrupoUsuario.setItems(dados);

    List<GrupoUsuario> grupoUsuarioLista = QueryUtil.selectListByNamedQuery("GrupoUsuario.findAll");
    dados.addAll(grupoUsuarioLista);
    
    tableGrupoUsuario.onMouseClickedProperty().set(event -> {
      if(event.getClickCount() >= 2){
        GrupoUsuario grupoUsuario = tableGrupoUsuario.getSelectionModel().getSelectedItem();
        System.out.println(grupoUsuario);
      }
    });
  }
}
