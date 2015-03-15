package br.com.ceos.data;

import javafx.beans.property.SimpleStringProperty;
import lombok.Getter;
import lombok.Setter;

public class ClienteData {
  
  @Getter @Setter private SimpleStringProperty cnpjCpf;
  @Getter @Setter private SimpleStringProperty razaoSocial;
  @Getter @Setter private SimpleStringProperty telefone;
}
