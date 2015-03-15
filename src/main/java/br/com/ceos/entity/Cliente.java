package br.com.ceos.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CLIENTE")
public class Cliente extends EntidadeBase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @Getter @Setter private Long id;
    
    @Column(name = "RAZAO_SOCIAL")
    @Getter @Setter private String razaoSocial;
    
    @Column(name = "NOME_FANTASIA")
    @Getter @Setter private String nomeFantasia;
    
    @Column(name = "CNPJ_CPF", unique = true)
    @Getter @Setter private String cnpjCpf;
    
    @Column(name = "IE")
    @Getter @Setter private String inscricaoEstadual;
    
    @Column(name = "IM")
    @Getter @Setter private String inscricaoMunicipal;
    
    @Column(name = "LOGRADOURO")
    @Getter @Setter private String logradouro;
    
    @Column(name = "COMPLEMENTO")
    @Getter @Setter private String complemento;
    
    @Column(name = "NUMERO")
    @Getter @Setter private String numero;
    
    @Column(name = "BAIRRO")
    @Getter @Setter private String bairro;
    
    @Column(name = "MUNICIPIO")
    @Getter @Setter private String municipio;
    
    @Column(name = "UF")
    @Getter @Setter private String uf;
    
    @Column(name = "TELEFONE")
    @Getter @Setter private String telefone;
    
    @Column(name = "CELULAR")
    @Getter @Setter private String celular;
    
    @Column(name = "TELEFONE_COMERCIAL")
    @Getter @Setter private String telefoneComercial;
    
    @Column(name = "EMAIL")
    @Getter @Setter private String email;
    
    @Column(name = "EMAIL_COMERCIAL")
    @Getter @Setter private String emailComercial;
    
    public Cliente() {
      super.setDataCriacao(LocalDate.now());
    }
}
