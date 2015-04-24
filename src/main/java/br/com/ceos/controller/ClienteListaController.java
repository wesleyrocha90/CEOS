package br.com.ceos.controller;

import br.com.ceos.entity.Cliente;
import br.com.ceos.manager.ClienteManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ClienteListaController implements Initializable {

  @FXML
  private TableView<Cliente> tableCliente;
  @FXML
  private TableColumn columnCnpjCpf;
  @FXML
  private TableColumn columnRazaoSocial;
  @FXML
  private TableColumn columnTelefone;
  private ObservableList result;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    columnCnpjCpf.setCellValueFactory(new PropertyValueFactory<>("cnpjCpf"));
    columnRazaoSocial.setCellValueFactory(new PropertyValueFactory<>("razaoSocial"));
    columnTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
    result = FXCollections.observableArrayList();
    tableCliente.setItems(result);
    
    ClienteManager manager = new ClienteManager();
    result.addAll(manager.findAll());
  }
}
