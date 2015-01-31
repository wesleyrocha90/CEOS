package br.com.ceos.controller;

import br.com.ceos.entity.Usuario;
import br.com.ceos.util.BundleUtil;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
      // TODO: fazer uma classe que providencie o gerenciamento do banco de dados, para evitar código repetido
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
      EntityManager em = emf.createEntityManager();
      Query query = em.createNamedQuery("Usuario.findByLoginSenha");
      query.setParameter("login", login);
      query.setParameter("senha", senha);
      try {
        Usuario usuario = (Usuario) query.getSingleResult();
        if (usuario.isAtivo() && usuario.getDataExpiração().after(new Date())) {
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
