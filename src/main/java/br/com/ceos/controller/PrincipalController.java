package br.com.ceos.controller;

import br.com.ceos.entity.MenuItem;
import br.com.ceos.entity.MenuPainel;
import br.com.ceos.util.BundleUtil;
import br.com.ceos.util.JPAUtil;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PrincipalController implements Initializable {

  @FXML
  private Accordion accordion;

  @FXML
  private TabPane tabPane;

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    EntityManager em = JPAUtil.getEntityManager();
    Query query = em.createNamedQuery("MenuPainel.findAll");
    List<MenuPainel> menus = query.getResultList();
    menus.stream().map(menuPainel -> {
      TitledPane titledPane = new TitledPane();
      titledPane.setText(BundleUtil.getString(menuPainel.getTitulo()));
      VBox vbox = new VBox();
      Query queryItem = em.createNamedQuery("MenuItem.findAllByMenu");
      queryItem.setParameter("pai", menuPainel);
      List<MenuItem> itens = queryItem.getResultList();
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
          try {
            Tab tab = new Tab(BundleUtil.getString(menuItem.getTitulo()));
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/" + menuItem.getFxmlTela() + ".fxml"), BundleUtil.getBundle());
            Parent root = (Parent) fxmlLoader.load();
            root.setPickOnBounds(true);
            tab.setContent(root);
            tabPane.getTabs().add(tab);
          } catch (IOException ex) {
            System.out.println(ex);
          }
        });
        return button;
      }).forEach(button -> vbox.getChildren().add(button));
      titledPane.setContent(vbox);
      return titledPane;
    }).forEach(titledPane -> accordion.getPanes().addAll(titledPane));
    accordion.setExpandedPane(accordion.getPanes().get(0));
    em.close();
  }
}
