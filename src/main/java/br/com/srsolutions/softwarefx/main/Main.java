package br.com.srsolutions.softwarefx.main;

import br.com.srsolutions.softwarefx.controller.LoginController;
import br.com.srsolutions.softwarefx.util.BundleUtil;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage stage) throws Exception {
    if (verificaLogin(new Stage())){
      exibirPrincipal(new Stage());
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
  
  public boolean verificaLogin(Stage stage) throws Exception {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"), BundleUtil.getBundle());
    Parent root = (Parent) fxmlLoader.load();
    Scene scene = new Scene(root);
    stage.setTitle(BundleUtil.getString("login"));
    stage.setResizable(false);
    stage.setScene(scene);
    stage.showAndWait();
    
    LoginController loginController = (LoginController)fxmlLoader.getController();
    stage.close();
    return loginController.isLoginValido();
  }
  
  public void exibirPrincipal(Stage stage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/fxml/Principal.fxml"), BundleUtil.getBundle());
    Scene scene = new Scene(root);
    stage.setTitle(BundleUtil.getString("principal"));
//    stage.setMaximized(true);
    stage.setScene(scene);
    stage.show();
  }
}
