package br.com.ceos.controller;

import br.com.ceos.data.ClienteData;
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
  private TableView<ClienteData> tableCliente;
  @FXML
  private TableColumn columnCnpj;
  @FXML
  private TableColumn columnCpf;
  @FXML
  private TableColumn columnRazaoSocial;
  @FXML
  private TableColumn columnNome;
  @FXML
  private TableColumn columnTelefone;
  private ObservableList result;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    columnCnpj.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
    columnCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
    columnRazaoSocial.setCellValueFactory(new PropertyValueFactory<>("razaoSocial"));
    columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    columnTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
    result = FXCollections.observableArrayList();
    tableCliente.setItems(result);
    
    ClienteManager manager = new ClienteManager();
    result.addAll(manager.findAllClienteFisico());
    result.addAll(manager.findAllClienteJuridico());
  }

}
