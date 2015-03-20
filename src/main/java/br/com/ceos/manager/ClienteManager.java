package br.com.ceos.manager;

import br.com.ceos.entity.Cliente;
import br.com.ceos.entity.ClienteFisico;
import br.com.ceos.entity.ClienteJuridico;
import br.com.ceos.util.QueryUtil;
import com.uaihebert.uaicriteria.UaiCriteria;
import java.util.List;

public class ClienteManager {

  public Cliente findByCnpjCpf(String cnpjCpf) {
    UaiCriteria<Cliente> criteria = QueryUtil.getCriteriaClienteFisico();
    criteria.andEquals("cnpjCpf", cnpjCpf);
    return criteria.getSingleResult();
  }

  public List<Cliente> findByRazaoSocial(String razaoSocial) {
    UaiCriteria<Cliente> criteria = QueryUtil.getCriteriaClienteFisico();
    criteria.andStringLike("razaoSocial", razaoSocial);
    return criteria.getResultList();
  }

  public List<ClienteFisico> findAllClienteFisico() {
    UaiCriteria<ClienteFisico> criteria = QueryUtil.getCriteriaClienteFisico();
    return criteria.getResultList();
  }
  
    public List<ClienteJuridico> findAllClienteJuridico() {
    UaiCriteria<ClienteJuridico> criteria = QueryUtil.getCriteriaClienteJuridico();
    return criteria.getResultList();
  }

}
