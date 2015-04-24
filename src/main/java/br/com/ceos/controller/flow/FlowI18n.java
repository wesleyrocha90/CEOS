package br.com.ceos.controller.flow;

import io.datafx.controller.ViewConfiguration;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.context.ViewFlowContext;

/**
 * Classe que configura o recurso da internacionalização na FlowAPI
 */
public class FlowI18n extends Flow{
  
  ViewConfiguration viewConfiguration;
  
  public FlowI18n(Class<?> startViewControllerClass, ViewConfiguration viewConfiguration) {
    super(startViewControllerClass);
    this.viewConfiguration = viewConfiguration;
  }

  @Override
  public FlowHandler createHandler(ViewFlowContext flowContext) {
    return new FlowHandlerI18n(this, flowContext, viewConfiguration);
  }
}
