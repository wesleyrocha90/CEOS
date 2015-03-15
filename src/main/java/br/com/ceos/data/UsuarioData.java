package br.com.ceos.data;

import java.time.LocalDate;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import lombok.Getter;
import lombok.Setter;

public class UsuarioData {

  @Getter @Setter private SimpleIntegerProperty id;
  @Getter @Setter private SimpleStringProperty login;
  @Getter @Setter private SimpleBooleanProperty ativo;
  @Getter @Setter private SimpleObjectProperty<LocalDate> dataCadastro;
  @Getter @Setter private SimpleObjectProperty<LocalDate> dataExpiracao;
} 