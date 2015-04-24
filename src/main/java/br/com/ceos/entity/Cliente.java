package br.com.ceos.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
public class Cliente extends EntidadeBase implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  @Getter @Setter private Long id;

  @Column(name = "ATIVO")
  @Getter @Setter private Boolean ativo;

  @Column(name = "EMAIL")
  @Getter @Setter private String email;

  @Column(name = "EMAIL_COMERCIAL")
  @Getter @Setter private String emailComercial;

  @OneToMany
  @JoinColumn(name = "FK_ENDERECOS", referencedColumnName = "ID")
  @Setter private Collection<Endereco> enderecos;

  @OneToMany
  @JoinColumn(name = "FK_TELEFONES", referencedColumnName = "ID")
  @Setter private Collection<Telefone> telefones;

  public Cliente() {
    super.setDataCriacao(LocalDate.now());
  }

  public Collection<Endereco> getEnderecos() {
    if (enderecos == null) {
      enderecos = new ArrayList<>();
    }
    return enderecos;
  }

  public Collection<Telefone> getTelefones() {
    if (telefones == null) {
      telefones = new ArrayList<>();
    }
    return telefones;
  }
}
