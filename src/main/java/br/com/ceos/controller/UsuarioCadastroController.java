package br.com.ceos.controller;

import br.com.ceos.controller.flow.AbstractCadastroController;
import br.com.ceos.entity.GrupoUsuario;
import br.com.ceos.entity.Usuario;
import br.com.ceos.util.QueryUtil;
import io.datafx.controller.ViewController;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.function.Supplier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javax.annotation.PostConstruct;

@ViewController("/fxml/UsuarioCadastro.fxml")
public class UsuarioCadastroController extends AbstractCadastroController<Usuario>{
  
  @FXML
  private CheckBox ativo;
  @FXML
  private ChoiceBox grupo;
  @FXML
  private DatePicker dataDeExpiracao;
  @FXML
  private TextField login;
  @FXML
  private TextField senha;
  @FXML
  private TextField confirmarSenha;
  
  private Usuario usuario;
  
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
    
    if(getModelo().getIndiceDado() >= 0){
      usuario = getModelo().getDados().get(getModelo().getIndiceDado());
    }else{
      usuario = new Usuario();
    }
    objetoParaTela(usuario);
  }

  @Override
  public Usuario telaParaObjeto() {
    usuario.setAtivo(ativo.isSelected());
    usuario.setGrupoUsuario((GrupoUsuario) grupo.getValue());
    usuario.setDataExpiracao(dataDeExpiracao.getValue());
    usuario.setLogin(login.getText());
    usuario.setSenha(senha.getText());
    return usuario;
  }

  @Override
  public void objetoParaTela(Usuario objeto) {
    ativo.setSelected(objeto.isAtivo());
    grupo.setValue(objeto.getGrupoUsuario());
    dataDeExpiracao.setValue(objeto.getDataExpiracao());
    login.setText(objeto.getLogin());
    senha.setText(objeto.getSenha());
    confirmarSenha.setText(objeto.getSenha());
  }
}
