package br.com.ceos.controller;

import br.com.ceos.controller.flow.AbstractCadastroController;
import br.com.ceos.entity.GrupoUsuario;
import br.com.ceos.entity.Usuario;
import br.com.ceos.util.BundleUtil;
import br.com.ceos.util.QueryUtil;
import io.datafx.controller.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javax.annotation.PostConstruct;

@ViewController("/fxml/UsuarioCadastro.fxml")
public class UsuarioCadastroController extends AbstractCadastroController<Usuario>{
  
  @FXML private CheckBox ativo;
  @FXML private ChoiceBox grupo;
  @FXML private DatePicker dataDeExpiracao;
  @FXML private TextField login;
  @FXML private Label labelSenha;
  @FXML private TextField senha;
  @FXML private Label labelConfirmarSenha;
  @FXML private TextField confirmarSenha;
  @FXML private Button alterarSenha;
  
  @PostConstruct
  public void init(){
    final ObservableList<GrupoUsuario> gruposUsuarios =
        FXCollections.observableArrayList(QueryUtil.selectListByNamedQuery("GrupoUsuario.findAll"));
    grupo.setItems(gruposUsuarios);
    grupo.setConverter(new StringConverter<GrupoUsuario>() {
      @Override public String toString(GrupoUsuario object) {
        return object.getDescricao();
      }
      @Override public GrupoUsuario fromString(String string) {
        return gruposUsuarios.filtered(grupoUsuario -> grupoUsuario.getDescricao().equals(string)).get(0);
      }
    });
    
    ativo.selectedProperty().addListener( (observable, oldValue, newValue) -> {
        ativo.setText( (newValue ? BundleUtil.getString("sim") : BundleUtil.getString("nao")) );
      }
    );
    
    alterarSenha.setOnAction((event) -> {
      alterarSenha.setVisible(false);
      labelSenha.setVisible(true);
      senha.setVisible(true);
      senha.setText(null);
      confirmarSenha.setVisible(true);
      confirmarSenha.setText(null);
      labelConfirmarSenha.setVisible(true);
    });
  }

  @Override
  public void telaParaObjeto(Usuario objeto) {
    objeto.setAtivo(ativo.isSelected());
    objeto.setGrupoUsuario((GrupoUsuario) grupo.getValue());
    objeto.setDataExpiracao(dataDeExpiracao.getValue());
    objeto.setLogin(login.getText());
    objeto.setSenha(senha.getText());
  }

  @Override
  public void objetoParaTela(Usuario objeto) {
    ativo.setSelected(objeto.isAtivo());
    grupo.setValue(objeto.getGrupoUsuario());
    dataDeExpiracao.setValue(objeto.getDataExpiracao());
    login.setText(objeto.getLogin());
    senha.setText(objeto.getSenha());
    confirmarSenha.setText(objeto.getSenha());
    
    if(objeto.getId() != null){
      alterarSenha.setVisible(true);
      labelSenha.setVisible(false);
      senha.setVisible(false);
      confirmarSenha.setVisible(false);
      labelConfirmarSenha.setVisible(false);
    }else{
      alterarSenha.setVisible(false);
      labelSenha.setVisible(true);
      senha.setVisible(true);
      confirmarSenha.setVisible(true);
      labelConfirmarSenha.setVisible(true);
    }
  }
}
