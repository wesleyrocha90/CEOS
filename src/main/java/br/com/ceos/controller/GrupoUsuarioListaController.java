package br.com.ceos.controller;

import br.com.ceos.controller.flow.AbstractListaController;
import br.com.ceos.entity.GrupoUsuario;
import br.com.ceos.util.QueryUtil;
import io.datafx.controller.ViewController;
import java.util.function.Supplier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.annotation.PostConstruct;

@ViewController("/fxml/GrupoUsuarioLista.fxml")
public class GrupoUsuarioListaController extends AbstractListaController<GrupoUsuario> {
  
  @FXML
  private TableColumn<GrupoUsuario, String> colunaDescricao;
  
  @PostConstruct
  public void init(){
    colunaDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
  }
  
  @Override
  public Supplier<ObservableList<GrupoUsuario>> supplier() {
    return () -> FXCollections.observableArrayList(QueryUtil.selectListByNamedQuery("GrupoUsuario.findAll"));
  }
}
