package br.com.ceos.controller;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import lombok.Getter;
import lombok.Setter;

public class ControllerBase {
  
  @Getter @Setter private TabPane tabPanePrincipal;
  @Getter @Setter private Tab tabPrincipal;
}
