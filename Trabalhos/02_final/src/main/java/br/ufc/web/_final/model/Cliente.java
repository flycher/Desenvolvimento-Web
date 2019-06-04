package br.ufc.web._final.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;

    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    private String email;
    private String senha;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public Date getDataNascimento() { return dataNascimento; }

    public void setDataNascimento(Date dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }

    public void setSenha(String senha) { this.senha = senha; }

}
