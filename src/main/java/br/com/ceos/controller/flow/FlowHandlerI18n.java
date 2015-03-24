package br.com.ceos.controller.flow;

import io.datafx.controller.ViewConfiguration;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.context.ViewFlowContext;

/**
 * Classe usada para configurar o recurso da internacionalização no FlowAPI
 */
public class FlowHandlerI18n extends FlowHandler{

  public FlowHandlerI18n(Flow flow, ViewFlowContext flowContext, ViewConfiguration viewConfiguration) {
    super(flow, flowContext, viewConfiguration);
  }
}
