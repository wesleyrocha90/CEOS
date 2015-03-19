package br.com.ceos.controller;

import br.com.ceos.controller.flow.ListViewController;
import br.com.ceos.entity.MenuItem;
import br.com.ceos.entity.MenuPainel;
import br.com.ceos.util.BundleUtil;
import br.com.ceos.util.Maps;
import br.com.ceos.util.QueryUtil;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class PrincipalController implements Initializable {

  @FXML
  private Accordion accordion;

  @FXML
  private TabPane tabPane;

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    List<MenuPainel> menus = QueryUtil.selectListByNamedQuery("MenuPainel.findAll");
    menus.stream().map(menuPainel -> {
      TitledPane titledPane = new TitledPane();
      titledPane.setText(BundleUtil.getString(menuPainel.getTitulo()));
      VBox vbox = new VBox();
      List<MenuItem> itens = QueryUtil.selectListByNamedQuery("MenuItem.findAllByMenu", 
              Maps.asMap("pai", menuPainel));
      itens.stream().map(menuItem -> {
        Button button = new Button();
        button.setMaxWidth(Double.MAX_VALUE);
        button.setText(BundleUtil.getString(menuItem.getTitulo()));
        ImageView image = new ImageView(getClass().getResource("/icons/" + menuItem.getImagem() + ".png").toString());
        image.setFitHeight(16);
        image.setFitWidth(16);
        image.setPreserveRatio(true);
        button.setGraphic(image);
        button.setOnAction(event -> {
          Tab tab = new Tab(BundleUtil.getString(menuItem.getTitulo()));
          boolean temTabua = false;
          for (Tab tabua : tabPane.getTabs()) {
            if(tabua.getText().equals(tab.getText())){
              tabPane.getSelectionModel().select(tabua);
              temTabua = true;
            }
          }
          if(!temTabua){
            tab.setContent(new ListViewController(menuItem.getFxmlTela()).getContainer());
            tabPane.getTabs().add(tab);
            tabPane.getSelectionModel().select(tab);
          }
        });
        return button;
      }).forEach(button -> vbox.getChildren().add(button));
      titledPane.setContent(vbox);
      return titledPane;
    }).forEach(titledPane -> accordion.getPanes().addAll(titledPane));
    accordion.setExpandedPane(accordion.getPanes().get(0));
  }
}
