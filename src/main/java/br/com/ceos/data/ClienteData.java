package br.com.ceos.data;

import javafx.beans.property.SimpleStringProperty;
import lombok.Getter;
import lombok.Setter;

public class ClienteData {
  
  @Getter @Setter private SimpleStringProperty cnpj;
  @Getter @Setter private SimpleStringProperty cpf;
  @Getter @Setter private SimpleStringProperty razaoSocial;
  @Getter @Setter private SimpleStringProperty nome;
  @Getter @Setter private SimpleStringProperty telefone;
}
