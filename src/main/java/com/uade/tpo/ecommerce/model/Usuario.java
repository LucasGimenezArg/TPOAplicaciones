package com.uade.tpo.ecommerce.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_usuario", discriminatorType = DiscriminatorType.STRING)
public abstract class Usuario implements UserDetails {
    public static final String ROL_ADMIN = "admin";
    public static final String ROL_NORMAL = "normal";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true)
    private String nombreUsuario;
    @Column(nullable = false, unique = true)
    private String mail;
    @Column(nullable = false)
    private String contrasena;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;


    public Usuario(String nombreUsuario, String mail, String contrasena,
                   String nombre, String apellido, Date fechaNacimiento) {
        this.nombreUsuario = nombreUsuario;
        this.mail = mail;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;

    }

    public Usuario() {

    }

    // Getter para nombreUsuario
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    // Getter para mail
    public String getMail() {
        return mail;
    }

    // Getter para contrasena
    public String getContrasena() {
        return contrasena;
    }

    // Getter para nombre
    public String getNombre() {
        return nombre;
    }

    // Getter para apellido
    public String getApellido() {
        return apellido;
    }

    // Getter para fechaNacimiento
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    // Getter para id
    public long getId() {
        return id;
    }

    public abstract String getRol();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(getRol()));
    }

    @Override
    public String getPassword() {
        return this.getContrasena();
    }

    @Override
    public String getUsername() {
        return this.getMail();
    }
}
