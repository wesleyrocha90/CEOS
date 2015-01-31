package br.com.srsolutions.softwarefx.controller;

import br.com.srsolutions.softwarefx.data.UsuarioData;
import br.com.srsolutions.softwarefx.entity.Usuario;
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

public class UsuarioListaController implements Initializable {
  
  @FXML private TableView<UsuarioData> tableUsuario;  
  @FXML private TableColumn columnId;
  @FXML private TableColumn columnLogin;
  @FXML private TableColumn columnAtivo;
  @FXML private TableColumn columnDataCadastro;
  @FXML private TableColumn columnDataExpiracao;
  private ObservableList dados;
  
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    columnId.setCellValueFactory(new PropertyValueFactory<UsuarioData, Integer>("id"));
    columnLogin.setCellValueFactory(new PropertyValueFactory<UsuarioData, String>("login"));
    columnAtivo.setCellValueFactory(new PropertyValueFactory<UsuarioData, String>("ativo"));
    columnDataCadastro.setCellValueFactory(new PropertyValueFactory<UsuarioData, Date>("dataCadastro"));
    columnDataExpiracao.setCellValueFactory(new PropertyValueFactory<UsuarioData, Date>("dataExpiracao"));
    dados = FXCollections.observableArrayList();
    tableUsuario.setItems(dados);
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    EntityManager em = emf.createEntityManager();
    Query query = em.createNamedQuery("Usuario.findAll");
    List<Usuario> usuarioLista = query.getResultList();
    
    dados.addAll(usuarioLista);
  }
}
