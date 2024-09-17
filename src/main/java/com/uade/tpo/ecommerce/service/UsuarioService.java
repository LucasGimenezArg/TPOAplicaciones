package com.uade.tpo.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uade.tpo.ecommerce.model.Usuario;
import com.uade.tpo.ecommerce.model.UsuarioAdmin;
import com.uade.tpo.ecommerce.model.UsuarioNormal;
import com.uade.tpo.ecommerce.repository.UsuarioRepository;

import java.util.Date;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //Crea usuario normal

    public UsuarioNormal crearCliente(String nombreUsuario, String mail, String contrasena, String nombre, String apellido, Date fechaNacimiento) {

        UsuarioNormal cliente = new UsuarioNormal(nombreUsuario, mail, contrasena, nombre, apellido, fechaNacimiento);

        return (UsuarioNormal) usuarioRepository.save(cliente); //guarda en la base de datos
    }

    //Crea usuario admin

    public UsuarioAdmin crearAdministrador(String nombreUsuario, String mail, String contrasena, String nombre, String apellido, Date fechaNacimiento) {

        UsuarioAdmin administrador = new UsuarioAdmin(nombreUsuario, mail, contrasena, nombre, apellido, fechaNacimiento);

        return (UsuarioAdmin) usuarioRepository.save(administrador); //guarda en la base de datos
    }

    //parte login

    public Usuario autenticarUsuario(String credencial, String contrasena) {

        Usuario usuario = usuarioRepository.findByNombreUsuario(credencial);

        if (usuario == null) {
            usuario = usuarioRepository.findByMail(credencial);
        }

        if (usuario != null && usuario.getContrasena().equals(contrasena)) {
            return usuario;
        }

        return null;
    }

}


