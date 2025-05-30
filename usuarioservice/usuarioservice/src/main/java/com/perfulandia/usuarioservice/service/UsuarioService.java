package com.perfulandia.usuarioservice.service;

import com.perfulandia.usuarioservice.model.Usuario;
import com.perfulandia.usuarioservice.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UsuarioService {
    private final UsuarioRepository repo;

    //Constructor para poder consumir la interfaz
    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    //Listar
    public List<Usuario> listar() {
        return repo.findAll();
    }

    //Guardar
    public Usuario guardar(Usuario usuario) {
        return repo.save(usuario);
    }

    //Buscar por id
    public Usuario buscar(long id) {

        return repo.findById(id).orElse(null);
    }

    //Eliminar id
    public void eliminar(long id) {
        repo.deleteById(id);
    }

    //actualizar
    public Usuario actualizar(long id, Map<String, Object> campos) {
    //el id de usuario a actualizar, y el mapa con los campos o valores del objeto a cambiar
        Usuario usuario = repo.findById(id).orElse(null);
        //Busca en la base de datos el id ingresado en postman si no encuentra devuelve nulo
        if (usuario == null){ //si el usuario es null entonces termina el metodo devolviendo nulo
            return null;
        }
        //clave es el nombre del campo a actualizar "nombre" o "correo"
        //Valor es el nuevo valor para el campo
        campos.forEach((clave, valor) -> { //Recorre las diferentes claves en campos (que contiene el mapeo json)
                    switch (clave) { //Evalua que campo se actualizara segun la clave
                        case "nombre":
                            usuario.setNombre((String) valor); //transforma el valor (objeto) a String y le asigna el nuevo valor
                            break;
                        case "correo":
                            usuario.setCorreo((String) valor);
                            break;
                        case "rol":
                            usuario.setRol((String) valor);
                            break;
                    }
                }
        );
        return repo.save(usuario); //Guarda los campos modificados como un objeto usuario en la BD
    }
}
