package br.com.ceos.controller;

import br.com.ceos.controller.flow.AbstractListaController;
import br.com.ceos.entity.Usuario;
import br.com.ceos.util.BundleUtil;
import br.com.ceos.util.QueryUtil;
import io.datafx.controller.ViewController;
import java.time.format.FormatStyle;
import java.util.function.Supplier;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.converter.LocalDateStringConverter;
import javax.annotation.PostConstruct;

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
    colunaAtivo.setCellValueFactory((e) -> 
        new SimpleStringProperty((e.getValue().isAtivo() ? BundleUtil.getString("sim") : BundleUtil.getString("nao"))));
    colunaGrupo.setCellValueFactory((e) ->
        new SimpleStringProperty(e.getValue().getGrupoUsuario().getDescricao()));
    colunaUsuario.setCellValueFactory(new PropertyValueFactory<>("login"));
    colunaDataDeExpiracao.setCellValueFactory((e) ->
        new SimpleStringProperty(
        new LocalDateStringConverter(FormatStyle.SHORT).toString(e.getValue().getDataExpiracao())));
  }
  
  @Override
  public Supplier<ObservableList<Usuario>> supplier() {
    return () -> FXCollections.observableArrayList(QueryUtil.selectListByNamedQuery("Usuario.findAll"));
  }
}
