package br.com.ceos.controller;

import br.com.ceos.data.GrupoUsuarioData;
import br.com.ceos.entity.GrupoUsuario;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class GrupoUsuarioListaController implements Initializable {

  @FXML
  private TableView<GrupoUsuarioData> tableGrupoUsuario;
  @FXML
  private TableColumn columnId;
  @FXML
  private TableColumn columnDescricao;
  @FXML
  private TableColumn columnDataCadastro;
  private ObservableList dados;

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    columnId.setCellValueFactory(new PropertyValueFactory<GrupoUsuarioData, Integer>("id"));
    columnDescricao.setCellValueFactory(new PropertyValueFactory<GrupoUsuarioData, String>("descricao"));
    columnDataCadastro.setCellValueFactory(new PropertyValueFactory<GrupoUsuarioData, Date>("dataCadastro"));
    dados = FXCollections.observableArrayList();
    tableGrupoUsuario.setItems(dados);

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    EntityManager em = emf.createEntityManager();
    Query query = em.createQuery("SELECT g FROM GrupoUsuario g");
    List<GrupoUsuario> grupoUsuarioLista = query.getResultList();

    dados.addAll(grupoUsuarioLista);
  }
}
