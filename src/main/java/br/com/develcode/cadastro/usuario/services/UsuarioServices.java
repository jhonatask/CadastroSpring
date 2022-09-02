package br.com.develcode.cadastro.usuario.services;

import br.com.develcode.cadastro.usuario.dto.IncluirUsuarioRequest;
import br.com.develcode.cadastro.usuario.entities.Usuario;
import br.com.develcode.cadastro.usuario.repository.UsuarioRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class UsuarioServices {

    private final UsuarioRepository usuarioRepository;


    public UsuarioServices(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    public Usuario incluir(IncluirUsuarioRequest usuarioRequest) {
        var usario = new Usuario();
        BeanUtils.copyProperties(usuarioRequest, usario);
        usuarioRepository.save(usario);
        return usario;
    }
}
