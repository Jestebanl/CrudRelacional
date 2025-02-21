package nebrija.crudrelacional.service;

import nebrija.crudrelacional.model.Usuario;
import nebrija.crudrelacional.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) { this.usuarioRepository = usuarioRepository; }

    public List<Usuario> listarUsuarios() { return this.usuarioRepository.findAll(); }

    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public Usuario obtenerUsuarioPorNombre(String nombre) {
        return usuarioRepository.findByNombre(nombre).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public void agregarUsuario(Usuario usuario) {
        if(usuario.getId() == null)
            usuarioRepository.save(usuario);
    }

    public void eliminarUsuario(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

    public void modificarUsuario(Long id, Usuario usuarioActualizado) {
        Usuario usuario = obtenerUsuarioPorId(id);
        usuario.setNombre(usuarioActualizado.getNombre());
        usuario.setContrasena(usuarioActualizado.getContrasena());
        usuario.setRol(usuarioActualizado.getRol());
        usuarioRepository.save(usuario);
    }
}
