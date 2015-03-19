package br.com.ceos.controller;

import br.com.ceos.entity.Usuario;
import br.com.ceos.util.BundleUtil;
import br.com.ceos.util.Maps;
import br.com.ceos.util.QueryUtil;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javax.persistence.NoResultException;

public class LoginController implements Initializable {

  @FXML
  private TextField textField;

  @FXML
  private PasswordField passwordField;

  @FXML
  private Label erro;

  private boolean loginValido;

  @FXML
  private void buttonEntrarOnAction(ActionEvent event) {
    erro.setText("");
    String login = textField.getText();
    String senha = passwordField.getText();
    if ("".equals(login)) {
      erro.setText(BundleUtil.getString("usuarioNaoInformado"));
    } else if ("".equals(senha)) {
      erro.setText(BundleUtil.getString("senhaNaoInformada"));
    } else {
      try {
        Usuario usuario = QueryUtil.selectSingleByNamedQuery("Usuario.findByLoginSenha",
                Maps.asMap("login", login, "senha", senha));
        if (usuario.getAtivo()&& usuario.getDataExpiracao().isAfter(LocalDate.now())) {
          loginValido = true;
          erro.getScene().getWindow().hide();
        } else {
          erro.setText(BundleUtil.getString("usuarioOuSenhaIncorretos"));
        }
      } catch (NoResultException ex) {
        erro.setText(BundleUtil.getString("usuarioOuSenhaIncorretos"));
      }
    }
  }

  @FXML
  private void textFieldUSuarioOnKeyPressed(KeyEvent event) {
    if (event.getCode() == KeyCode.ENTER) {
      if ("".equals(passwordField.getText())) {
        passwordField.requestFocus();
      } else {
        buttonEntrarOnAction(null);
      }
    }
  }

  @FXML
  private void textFieldSenhaOnKeyPressed(KeyEvent event) {
    if (event.getCode() == KeyCode.ENTER) {
      if ("".equals(textField.getText())) {
        textField.requestFocus();
      } else {
        buttonEntrarOnAction(null);
      }
    }
  }

  public boolean isLoginValido() {
    return loginValido;
  }

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    erro.setText("");
    loginValido = false;
  }
}
