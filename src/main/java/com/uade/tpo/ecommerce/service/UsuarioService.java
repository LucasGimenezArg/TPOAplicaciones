package com.uade.tpo.ecommerce.service;

import com.uade.tpo.ecommerce.dto.AutenticacionDto;
import com.uade.tpo.ecommerce.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.uade.tpo.ecommerce.model.Usuario;
import com.uade.tpo.ecommerce.model.UsuarioAdmin;
import com.uade.tpo.ecommerce.model.UsuarioNormal;
import com.uade.tpo.ecommerce.repository.UsuarioRepository;

import java.util.Date;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    private AutenticacionDto autenticar(Usuario usuario) {
        var jwtToken = jwtService.generateToken(usuario);
        return new AutenticacionDto(jwtToken);
    }

    //Crea usuario normal

    public AutenticacionDto crearCliente(String nombreUsuario, String mail, String contrasena, String nombre, String apellido, Date fechaNacimiento) {

        UsuarioNormal cliente = new UsuarioNormal(nombreUsuario, mail, passwordEncoder.encode(contrasena), nombre, apellido, fechaNacimiento);

        usuarioRepository.save(cliente); //guarda en la base de datos

        return autenticar(cliente);
    }

    //Crea usuario admin

    public AutenticacionDto crearAdministrador(String nombreUsuario, String mail, String contrasena, String nombre, String apellido, Date fechaNacimiento) {

        UsuarioAdmin administrador = new UsuarioAdmin(nombreUsuario, mail, passwordEncoder.encode(contrasena), nombre, apellido, fechaNacimiento);

        usuarioRepository.save(administrador); //guarda en la base de datos

        return autenticar(administrador);
    }

    //parte login

    public AutenticacionDto autenticarUsuario(String credencial, String contrasena) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(credencial, contrasena));

        Usuario usuario = usuarioRepository.findByNombreUsuario(credencial);
        return autenticar(usuario);
    }

}


