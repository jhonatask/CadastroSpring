package br.com.develcode.cadastro.usuario.dto;

import lombok.Data;

import java.util.Date;

@Data
public class IncluirUsuarioResponse {
    private Long codigo;
    private String nome;
    private Date dataNascimento;
}
