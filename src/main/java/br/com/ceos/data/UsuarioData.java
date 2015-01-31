package br.com.ceos.data;

import java.util.Date;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class UsuarioData {

  private SimpleIntegerProperty id;
  private SimpleStringProperty login;
  private SimpleBooleanProperty ativo;
  private SimpleObjectProperty<Date> dataCadastro;
  private SimpleObjectProperty<Date> dataExpiracao;

  public SimpleIntegerProperty getId() {
    return id;
  }

  public void setId(SimpleIntegerProperty id) {
    this.id = id;
  }

  public SimpleStringProperty getLogin() {
    return login;
  }

  public void setLogin(SimpleStringProperty login) {
    this.login = login;
  }

  public SimpleBooleanProperty getAtivo() {
    return ativo;
  }

  public void setAtivo(SimpleBooleanProperty ativo) {
    this.ativo = ativo;
  }

  public SimpleObjectProperty<Date> getDataCadastro() {
    return dataCadastro;
  }

  public void setDataCadastro(SimpleObjectProperty<Date> dataCadastro) {
    this.dataCadastro = dataCadastro;
  }

  public SimpleObjectProperty<Date> getDataExpiracao() {
    return dataExpiracao;
  }

  public void setDataExpiracao(SimpleObjectProperty<Date> dataExpiracao) {
    this.dataExpiracao = dataExpiracao;
  }
}
