package com.petcare.backend.proyectoIntegrador.service;

import com.petcare.backend.proyectoIntegrador.entity.ERole;
import com.petcare.backend.proyectoIntegrador.entity.Usuario;
import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    Usuario crear(Usuario usuario);
    Optional<Usuario> obtenerPorId(Short id);
    List<Usuario> listarTodos();
    List<Usuario> buscarPorNombre(String nombre);
    Optional<Usuario> buscarPorEmail(String email);
    Usuario actualizar(Usuario usuario);
    void eliminar(Short id);
    List<Usuario> listarPorRole(ERole role);
} 