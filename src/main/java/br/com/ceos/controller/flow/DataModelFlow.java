package br.com.ceos.controller.flow;

import br.com.ceos.entity.GrupoUsuario;
import br.com.ceos.util.QueryUtil;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.datafx.controller.flow.injection.FlowScoped;

@FlowScoped
public class DataModelFlow {

  private ListProperty<GrupoUsuario> data;
  private IntegerProperty selectedDataIndex;

  public DataModelFlow() {
    ObservableList<GrupoUsuario> innerList = FXCollections.observableArrayList(
        QueryUtil.selectListByNamedQuery("GrupoUsuario.findAll"));
    data = new SimpleListProperty<>(innerList);
  }

  public ListProperty<GrupoUsuario> getData() {
    return data;
  }

  public int getSelectedDataIndex() {
    return selecteDataIndexProperty().get();
  }

  public void setSelectedDataIndex(int selectedDataIndex) {
    selecteDataIndexProperty().set(selectedDataIndex);
  }

  public IntegerProperty selecteDataIndexProperty() {
    if (selectedDataIndex == null) {
      selectedDataIndex = new SimpleIntegerProperty();
    }
    return selectedDataIndex;
  }
}
