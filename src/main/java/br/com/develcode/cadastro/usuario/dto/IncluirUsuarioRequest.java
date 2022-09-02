package br.com.develcode.cadastro.usuario.dto;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class IncluirUsuarioRequest {
    private Long codigo;
    private String nome;
    private Date dataNascimento;
    private byte[] foto;
}
