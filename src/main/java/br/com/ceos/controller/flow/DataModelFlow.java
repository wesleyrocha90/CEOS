package br.com.ceos.controller.flow;

import br.com.ceos.entity.EntidadeBase;
import io.datafx.controller.injection.scopes.FlowScoped;
import java.util.function.Supplier;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;

@FlowScoped
public class DataModelFlow<E extends EntidadeBase> {
  
  private Supplier<ObservableList<E>> supplier;
  private ListProperty<E> data;
  private ObjectProperty<E> editedData;
  private IntegerProperty selectedDataIndex;

  public void setSupplier(Supplier<ObservableList<E>> supplier){
    this.supplier = supplier;
    data = new SimpleListProperty<>(supplier.get());
  }
  
  public ListProperty<E> getData(){
    return data;
  }
  
  public E getEditedData(){
    return editedDataProperty().get();
  }
  
  public void setEditedData(E editedData){
    editedDataProperty().set(editedData);
  }
  
  public ObjectProperty<E> editedDataProperty() {
    return (editedData == null) ? editedData = new SimpleObjectProperty<>() : editedData;
  }
  
   public int getSelectedDataIndex() {
    return selectedDataIndexProperty().get();
  }

  public void setSelectedDataIndex(int selectedDataIndex) {
    selectedDataIndexProperty().set(selectedDataIndex);
  }

  public IntegerProperty selectedDataIndexProperty() {
    return (selectedDataIndex == null) ? selectedDataIndex = new SimpleIntegerProperty() : selectedDataIndex;
  }
}
