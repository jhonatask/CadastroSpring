package br.com.develcode.cadastro.usuario.repository;

import br.com.develcode.cadastro.usuario.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
