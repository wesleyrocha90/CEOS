package br.com.ceos.data;

import java.time.LocalDate;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import lombok.Getter;
import lombok.Setter;

public class GrupoUsuarioData {

  @Getter @Setter private SimpleIntegerProperty id;
  @Getter @Setter private SimpleStringProperty descricao;
  @Getter @Setter private SimpleObjectProperty<LocalDate> dataCadastro;

}
