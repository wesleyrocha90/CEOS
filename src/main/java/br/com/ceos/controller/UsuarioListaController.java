package br.com.ceos.controller;

import br.com.ceos.data.UsuarioData;
import br.com.ceos.entity.Usuario;
import java.net.URL;
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

public class UsuarioListaController implements Initializable {

  @FXML
  private TableView<UsuarioData> tableUsuario;
  @FXML
  private TableColumn columnId;
  @FXML
  private TableColumn columnLogin;
  @FXML
  private TableColumn columnAtivo;
  @FXML
  private TableColumn columnDataCadastro;
  @FXML
  private TableColumn columnDataExpiracao;
  private ObservableList dados;

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
    columnLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
    columnAtivo.setCellValueFactory(new PropertyValueFactory<>("ativo"));
    columnDataCadastro.setCellValueFactory(new PropertyValueFactory<>("dataCriacao"));
    columnDataExpiracao.setCellValueFactory(new PropertyValueFactory<>("dataExpiracao"));
    dados = FXCollections.observableArrayList();
    tableUsuario.setItems(dados);

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    EntityManager em = emf.createEntityManager();
    Query query = em.createNamedQuery("Usuario.findAll");
    List<Usuario> usuarioLista = query.getResultList();

    dados.addAll(usuarioLista);
  }
}
