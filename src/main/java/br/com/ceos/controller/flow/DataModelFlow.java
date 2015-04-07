package br.com.ceos.controller.flow;

import br.com.ceos.entity.GrupoUsuario;
import br.com.ceos.util.QueryUtil;
import io.datafx.controller.injection.scopes.FlowScoped;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@FlowScoped
public class DataModelFlow {

  private ListProperty<GrupoUsuario> data;
  private ObjectProperty<GrupoUsuario> editedData;
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
    return selectedDataIndexProperty().get();
  }

  public void setSelectedDataIndex(int selectedDataIndex) {
    selectedDataIndexProperty().set(selectedDataIndex);
  }

  public IntegerProperty selectedDataIndexProperty() {
    if (selectedDataIndex == null) {
      selectedDataIndex = new SimpleIntegerProperty();
    }
    return selectedDataIndex;
  }
  
  public GrupoUsuario getEditedData(){
    return editedDataProperty().get();
  }
  
  public void setEditedData(GrupoUsuario editedData){
    editedDataProperty().set(editedData);
  }
  
  public ObjectProperty<GrupoUsuario> editedDataProperty() {
    if (editedData == null) {
      editedData = new SimpleObjectProperty<>();
    }
    return editedData;
  }
}
