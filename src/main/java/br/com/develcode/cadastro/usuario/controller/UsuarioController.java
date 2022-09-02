package br.com.develcode.cadastro.usuario.controller;

import br.com.develcode.cadastro.usuario.dto.IncluirUsuarioRequest;
import br.com.develcode.cadastro.usuario.dto.IncluirUsuarioResponse;
import br.com.develcode.cadastro.usuario.services.UsuarioServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    private final ObjectMapper mapper = new ObjectMapper();

    private final UsuarioServices usuarioServices;

    public UsuarioController(UsuarioServices usuarioServices) {
        this.usuarioServices = usuarioServices;
    }

    @PostMapping
    public ResponseEntity<IncluirUsuarioResponse> salvarUsuario(@RequestParam String usuarioData, @RequestParam("file") final MultipartFile file) throws IOException {
        final var incluirUsuarioRequest = mapper.readValue(usuarioData, IncluirUsuarioRequest.class);
        incluirUsuarioRequest.setFoto(file.getInputStream().readAllBytes());
        var usuario = usuarioServices.incluir(incluirUsuarioRequest);
        var usuarioResponse = new IncluirUsuarioResponse();
        BeanUtils.copyProperties(usuario, usuarioResponse);
        return new ResponseEntity<>(usuarioResponse, HttpStatus.CREATED);
    }
}
