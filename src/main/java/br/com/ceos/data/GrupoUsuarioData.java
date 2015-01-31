package br.com.ceos.data;

import java.util.Date;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class GrupoUsuarioData {

  private SimpleIntegerProperty id;
  private SimpleStringProperty descricao;
  private SimpleObjectProperty<Date> dataCadastro;

  public SimpleIntegerProperty getId() {
    return id;
  }

  public void setId(SimpleIntegerProperty id) {
    this.id = id;
  }

  public SimpleStringProperty getDescricao() {
    return descricao;
  }

  public void setDescricao(SimpleStringProperty descricao) {
    this.descricao = descricao;
  }

  public SimpleObjectProperty<Date> getDataCadastro() {
    return dataCadastro;
  }

  public void setDataCadastro(SimpleObjectProperty<Date> dataCadastro) {
    this.dataCadastro = dataCadastro;
  }
}
