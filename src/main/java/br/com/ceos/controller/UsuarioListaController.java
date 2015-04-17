package br.com.ceos.controller;

import br.com.ceos.controller.flow.AbstractListaController;
import br.com.ceos.data.UsuarioData;
import br.com.ceos.entity.Usuario;
import br.com.ceos.util.QueryUtil;
import io.datafx.controller.ViewController;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Supplier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@ViewController("/fxml/UsuarioLista.fxml")
public class UsuarioListaController extends AbstractListaController<Usuario>{

  @FXML
  private TableColumn<Usuario, String> colunaAtivo;
  @FXML
  private TableColumn<Usuario, String> colunaGrupo;
  @FXML
  private TableColumn<Usuario, String> colunaUsuario;
  @FXML
  private TableColumn<Usuario, String> colunaDataDeExpiracao;
  
  @PostConstruct
  public void init(){
    colunaAtivo.setCellValueFactory(new PropertyValueFactory<>("ativo"));
    colunaGrupo.setCellValueFactory(new PropertyValueFactory<>("grupoUsuario"));
    colunaUsuario.setCellValueFactory(new PropertyValueFactory<>("login"));
    colunaDataDeExpiracao.setCellValueFactory(new PropertyValueFactory<>("dataExpiracao"));
  }
  
  @Override
  public Supplier<ObservableList<Usuario>> supplier() {
    return () -> FXCollections.observableArrayList(QueryUtil.selectListByNamedQuery("Usuario.findAll"));
  }
}
