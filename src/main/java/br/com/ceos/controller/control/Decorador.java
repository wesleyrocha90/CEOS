package br.com.ceos.controller.control;

import javafx.scene.Node;
import javafx.scene.control.TextInputControl;

public class Decorador {
  
  public static void decorarNos(Decorador.Tipo type, Node... nos){
    for (Node no : nos) {
      if (no instanceof TextInputControl){
        ((TextInputControl)no).textProperty().addListener((observable, oldValue, newValue) -> {
          if (newValue == null || "".equals(newValue)){
            no.getStyleClass().add("campoObrigatorio");
          }else{
            no.getStyleClass().removeAll("campoObrigatorio");
          }
        });
      }
    }
  }

  public enum Tipo {
    OBRIGATORIO;
  }
}
