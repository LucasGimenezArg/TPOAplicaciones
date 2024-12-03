
    create table categoria (
        id bigint not null auto_increment,
        descripcion varchar(255),
        nombre varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table item_carrito (
        cantidad integer not null,
        id bigint not null auto_increment,
        orden_id bigint,
        producto_id bigint not null,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table orden (
        fecha datetime(6),
        id bigint not null auto_increment,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table producto (
        precio float(53) not null,
        stock integer not null,
        categoria_id bigint not null,
        id bigint not null auto_increment,
        descripcion varchar(255),
        informacion varchar(255),
        direccion_imagenes varbinary(255),
        primary key (id)
    ) engine=InnoDB;

    create table usuario (
        fecha_nacimiento datetime(6),
        id bigint not null auto_increment,
        tipo_usuario varchar(31) not null,
        apellido varchar(255),
        contrasena varchar(255) not null,
        mail varchar(255) not null,
        nombre varchar(255),
        nombre_usuario varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table usuario 
       add constraint UKics8o4kc1rvjcm04kqcj4mr9b unique (mail);

    alter table item_carrito 
       add constraint FKqy5dxh64r6jgqhkj8sx1yxf95 
       foreign key (orden_id) 
       references orden (id);

    alter table item_carrito 
       add constraint FKgarw89vvyxd65d4bqvwwmobud 
       foreign key (producto_id) 
       references producto (id);

    alter table item_carrito 
       add constraint FK95ruw8pskqrj0vdmi265vp41t 
       foreign key (usuario_id) 
       references usuario (id);

    alter table orden 
       add constraint FK3ixgmc0l9isf02alg7255pp5m 
       foreign key (usuario_id) 
       references usuario (id);

    alter table producto 
       add constraint FKodqr7965ok9rwquj1utiamt0m 
       foreign key (categoria_id) 
       references categoria (id);

    create table categoria (
        id bigint not null auto_increment,
        descripcion varchar(255),
        nombre varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table item_carrito (
        cantidad integer not null,
        id bigint not null auto_increment,
        orden_id bigint,
        producto_id bigint not null,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table orden (
        fecha datetime(6),
        id bigint not null auto_increment,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table producto (
        precio float(53) not null,
        stock integer not null,
        categoria_id bigint not null,
        id bigint not null auto_increment,
        descripcion varchar(255),
        informacion varchar(255),
        direccion_imagenes varbinary(255),
        primary key (id)
    ) engine=InnoDB;

    create table usuario (
        fecha_nacimiento datetime(6),
        id bigint not null auto_increment,
        tipo_usuario varchar(31) not null,
        apellido varchar(255),
        contrasena varchar(255) not null,
        mail varchar(255) not null,
        nombre varchar(255),
        nombre_usuario varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table usuario 
       add constraint UKics8o4kc1rvjcm04kqcj4mr9b unique (mail);

    alter table item_carrito 
       add constraint FKqy5dxh64r6jgqhkj8sx1yxf95 
       foreign key (orden_id) 
       references orden (id);

    alter table item_carrito 
       add constraint FKgarw89vvyxd65d4bqvwwmobud 
       foreign key (producto_id) 
       references producto (id);

    alter table item_carrito 
       add constraint FK95ruw8pskqrj0vdmi265vp41t 
       foreign key (usuario_id) 
       references usuario (id);

    alter table orden 
       add constraint FK3ixgmc0l9isf02alg7255pp5m 
       foreign key (usuario_id) 
       references usuario (id);

    alter table producto 
       add constraint FKodqr7965ok9rwquj1utiamt0m 
       foreign key (categoria_id) 
       references categoria (id);

    create table categoria (
        id bigint not null auto_increment,
        descripcion varchar(255),
        nombre varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table item_carrito (
        cantidad integer not null,
        id bigint not null auto_increment,
        orden_id bigint,
        producto_id bigint not null,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table orden (
        fecha datetime(6),
        id bigint not null auto_increment,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table producto (
        precio float(53) not null,
        stock integer not null,
        categoria_id bigint not null,
        id bigint not null auto_increment,
        descripcion varchar(255),
        informacion varchar(255),
        direccion_imagenes varbinary(255),
        primary key (id)
    ) engine=InnoDB;

    create table usuario (
        fecha_nacimiento datetime(6),
        id bigint not null auto_increment,
        tipo_usuario varchar(31) not null,
        apellido varchar(255),
        contrasena varchar(255) not null,
        mail varchar(255) not null,
        nombre varchar(255),
        nombre_usuario varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table usuario 
       add constraint UKics8o4kc1rvjcm04kqcj4mr9b unique (mail);

    alter table item_carrito 
       add constraint FKqy5dxh64r6jgqhkj8sx1yxf95 
       foreign key (orden_id) 
       references orden (id);

    alter table item_carrito 
       add constraint FKgarw89vvyxd65d4bqvwwmobud 
       foreign key (producto_id) 
       references producto (id);

    alter table item_carrito 
       add constraint FK95ruw8pskqrj0vdmi265vp41t 
       foreign key (usuario_id) 
       references usuario (id);

    alter table orden 
       add constraint FK3ixgmc0l9isf02alg7255pp5m 
       foreign key (usuario_id) 
       references usuario (id);

    alter table producto 
       add constraint FKodqr7965ok9rwquj1utiamt0m 
       foreign key (categoria_id) 
       references categoria (id);

    create table categoria (
        id bigint not null auto_increment,
        descripcion varchar(255),
        nombre varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table item_carrito (
        cantidad integer not null,
        id bigint not null auto_increment,
        orden_id bigint,
        producto_id bigint not null,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table orden (
        fecha datetime(6),
        id bigint not null auto_increment,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table producto (
        precio float(53) not null,
        stock integer not null,
        categoria_id bigint not null,
        id bigint not null auto_increment,
        descripcion varchar(255),
        informacion varchar(255),
        direccion_imagenes varbinary(255),
        primary key (id)
    ) engine=InnoDB;

    create table usuario (
        fecha_nacimiento datetime(6),
        id bigint not null auto_increment,
        tipo_usuario varchar(31) not null,
        apellido varchar(255),
        contrasena varchar(255) not null,
        mail varchar(255) not null,
        nombre varchar(255),
        nombre_usuario varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table usuario 
       add constraint UKics8o4kc1rvjcm04kqcj4mr9b unique (mail);

    alter table item_carrito 
       add constraint FKqy5dxh64r6jgqhkj8sx1yxf95 
       foreign key (orden_id) 
       references orden (id);

    alter table item_carrito 
       add constraint FKgarw89vvyxd65d4bqvwwmobud 
       foreign key (producto_id) 
       references producto (id);

    alter table item_carrito 
       add constraint FK95ruw8pskqrj0vdmi265vp41t 
       foreign key (usuario_id) 
       references usuario (id);

    alter table orden 
       add constraint FK3ixgmc0l9isf02alg7255pp5m 
       foreign key (usuario_id) 
       references usuario (id);

    alter table producto 
       add constraint FKodqr7965ok9rwquj1utiamt0m 
       foreign key (categoria_id) 
       references categoria (id);

    create table categoria (
        id bigint not null auto_increment,
        descripcion varchar(255),
        nombre varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table item_carrito (
        cantidad integer not null,
        id bigint not null auto_increment,
        orden_id bigint,
        producto_id bigint not null,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table orden (
        fecha datetime(6),
        id bigint not null auto_increment,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table producto (
        precio float(53) not null,
        stock integer not null,
        categoria_id bigint not null,
        id bigint not null auto_increment,
        descripcion varchar(255),
        informacion varchar(255),
        direccion_imagenes varbinary(255),
        primary key (id)
    ) engine=InnoDB;

    create table usuario (
        fecha_nacimiento datetime(6),
        id bigint not null auto_increment,
        tipo_usuario varchar(31) not null,
        apellido varchar(255),
        contrasena varchar(255) not null,
        mail varchar(255) not null,
        nombre varchar(255),
        nombre_usuario varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table usuario 
       add constraint UKics8o4kc1rvjcm04kqcj4mr9b unique (mail);

    alter table item_carrito 
       add constraint FKqy5dxh64r6jgqhkj8sx1yxf95 
       foreign key (orden_id) 
       references orden (id);

    alter table item_carrito 
       add constraint FKgarw89vvyxd65d4bqvwwmobud 
       foreign key (producto_id) 
       references producto (id);

    alter table item_carrito 
       add constraint FK95ruw8pskqrj0vdmi265vp41t 
       foreign key (usuario_id) 
       references usuario (id);

    alter table orden 
       add constraint FK3ixgmc0l9isf02alg7255pp5m 
       foreign key (usuario_id) 
       references usuario (id);

    alter table producto 
       add constraint FKodqr7965ok9rwquj1utiamt0m 
       foreign key (categoria_id) 
       references categoria (id);

    create table categoria (
        id bigint not null auto_increment,
        descripcion varchar(255),
        nombre varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table item_carrito (
        cantidad integer not null,
        id bigint not null auto_increment,
        orden_id bigint,
        producto_id bigint not null,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table orden (
        fecha datetime(6),
        id bigint not null auto_increment,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table producto (
        precio float(53) not null,
        stock integer not null,
        categoria_id bigint not null,
        id bigint not null auto_increment,
        descripcion varchar(255),
        informacion varchar(255),
        direccion_imagenes varbinary(255),
        primary key (id)
    ) engine=InnoDB;

    create table usuario (
        fecha_nacimiento datetime(6),
        id bigint not null auto_increment,
        tipo_usuario varchar(31) not null,
        apellido varchar(255),
        contrasena varchar(255) not null,
        mail varchar(255) not null,
        nombre varchar(255),
        nombre_usuario varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table usuario 
       add constraint UKics8o4kc1rvjcm04kqcj4mr9b unique (mail);

    alter table item_carrito 
       add constraint FKqy5dxh64r6jgqhkj8sx1yxf95 
       foreign key (orden_id) 
       references orden (id);

    alter table item_carrito 
       add constraint FKgarw89vvyxd65d4bqvwwmobud 
       foreign key (producto_id) 
       references producto (id);

    alter table item_carrito 
       add constraint FK95ruw8pskqrj0vdmi265vp41t 
       foreign key (usuario_id) 
       references usuario (id);

    alter table orden 
       add constraint FK3ixgmc0l9isf02alg7255pp5m 
       foreign key (usuario_id) 
       references usuario (id);

    alter table producto 
       add constraint FKodqr7965ok9rwquj1utiamt0m 
       foreign key (categoria_id) 
       references categoria (id);

    create table categoria (
        id bigint not null auto_increment,
        descripcion varchar(255),
        nombre varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table item_carrito (
        cantidad integer not null,
        id bigint not null auto_increment,
        orden_id bigint,
        producto_id bigint not null,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table orden (
        fecha datetime(6),
        id bigint not null auto_increment,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table producto (
        precio float(53) not null,
        stock integer not null,
        categoria_id bigint not null,
        id bigint not null auto_increment,
        descripcion varchar(255),
        informacion varchar(255),
        direccion_imagenes varbinary(255),
        primary key (id)
    ) engine=InnoDB;

    create table usuario (
        fecha_nacimiento datetime(6),
        id bigint not null auto_increment,
        tipo_usuario varchar(31) not null,
        apellido varchar(255),
        contrasena varchar(255) not null,
        mail varchar(255) not null,
        nombre varchar(255),
        nombre_usuario varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table usuario 
       add constraint UKics8o4kc1rvjcm04kqcj4mr9b unique (mail);

    alter table item_carrito 
       add constraint FKqy5dxh64r6jgqhkj8sx1yxf95 
       foreign key (orden_id) 
       references orden (id);

    alter table item_carrito 
       add constraint FKgarw89vvyxd65d4bqvwwmobud 
       foreign key (producto_id) 
       references producto (id);

    alter table item_carrito 
       add constraint FK95ruw8pskqrj0vdmi265vp41t 
       foreign key (usuario_id) 
       references usuario (id);

    alter table orden 
       add constraint FK3ixgmc0l9isf02alg7255pp5m 
       foreign key (usuario_id) 
       references usuario (id);

    alter table producto 
       add constraint FKodqr7965ok9rwquj1utiamt0m 
       foreign key (categoria_id) 
       references categoria (id);

    create table categoria (
        id bigint not null auto_increment,
        descripcion varchar(255),
        nombre varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table item_carrito (
        cantidad integer not null,
        id bigint not null auto_increment,
        orden_id bigint,
        producto_id bigint not null,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table orden (
        fecha datetime(6),
        id bigint not null auto_increment,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table producto (
        precio float(53) not null,
        stock integer not null,
        categoria_id bigint not null,
        id bigint not null auto_increment,
        descripcion varchar(255),
        informacion varchar(255),
        direccion_imagenes varbinary(255),
        primary key (id)
    ) engine=InnoDB;

    create table usuario (
        fecha_nacimiento datetime(6),
        id bigint not null auto_increment,
        tipo_usuario varchar(31) not null,
        apellido varchar(255),
        contrasena varchar(255) not null,
        mail varchar(255) not null,
        nombre varchar(255),
        nombre_usuario varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table usuario 
       add constraint UKics8o4kc1rvjcm04kqcj4mr9b unique (mail);

    alter table item_carrito 
       add constraint FKqy5dxh64r6jgqhkj8sx1yxf95 
       foreign key (orden_id) 
       references orden (id);

    alter table item_carrito 
       add constraint FKgarw89vvyxd65d4bqvwwmobud 
       foreign key (producto_id) 
       references producto (id);

    alter table item_carrito 
       add constraint FK95ruw8pskqrj0vdmi265vp41t 
       foreign key (usuario_id) 
       references usuario (id);

    alter table orden 
       add constraint FK3ixgmc0l9isf02alg7255pp5m 
       foreign key (usuario_id) 
       references usuario (id);

    alter table producto 
       add constraint FKodqr7965ok9rwquj1utiamt0m 
       foreign key (categoria_id) 
       references categoria (id);

    create table categoria (
        id bigint not null auto_increment,
        descripcion varchar(255),
        nombre varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table item_carrito (
        cantidad integer not null,
        id bigint not null auto_increment,
        orden_id bigint,
        producto_id bigint not null,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table orden (
        fecha datetime(6),
        id bigint not null auto_increment,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table producto (
        precio float(53) not null,
        stock integer not null,
        categoria_id bigint not null,
        id bigint not null auto_increment,
        descripcion varchar(255),
        informacion varchar(255),
        direccion_imagenes varbinary(255),
        primary key (id)
    ) engine=InnoDB;

    create table usuario (
        fecha_nacimiento datetime(6),
        id bigint not null auto_increment,
        tipo_usuario varchar(31) not null,
        apellido varchar(255),
        contrasena varchar(255) not null,
        mail varchar(255) not null,
        nombre varchar(255),
        nombre_usuario varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table usuario 
       add constraint UKics8o4kc1rvjcm04kqcj4mr9b unique (mail);

    alter table item_carrito 
       add constraint FKqy5dxh64r6jgqhkj8sx1yxf95 
       foreign key (orden_id) 
       references orden (id);

    alter table item_carrito 
       add constraint FKgarw89vvyxd65d4bqvwwmobud 
       foreign key (producto_id) 
       references producto (id);

    alter table item_carrito 
       add constraint FK95ruw8pskqrj0vdmi265vp41t 
       foreign key (usuario_id) 
       references usuario (id);

    alter table orden 
       add constraint FK3ixgmc0l9isf02alg7255pp5m 
       foreign key (usuario_id) 
       references usuario (id);

    alter table producto 
       add constraint FKodqr7965ok9rwquj1utiamt0m 
       foreign key (categoria_id) 
       references categoria (id);

    create table categoria (
        id bigint not null auto_increment,
        descripcion varchar(255),
        nombre varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table item_carrito (
        cantidad integer not null,
        id bigint not null auto_increment,
        orden_id bigint,
        producto_id bigint not null,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table orden (
        fecha datetime(6),
        id bigint not null auto_increment,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table producto (
        precio float(53) not null,
        stock integer not null,
        categoria_id bigint not null,
        id bigint not null auto_increment,
        descripcion varchar(255),
        informacion varchar(255),
        direccion_imagenes varbinary(255),
        primary key (id)
    ) engine=InnoDB;

    create table usuario (
        fecha_nacimiento datetime(6),
        id bigint not null auto_increment,
        tipo_usuario varchar(31) not null,
        apellido varchar(255),
        contrasena varchar(255) not null,
        mail varchar(255) not null,
        nombre varchar(255),
        nombre_usuario varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table usuario 
       add constraint UKics8o4kc1rvjcm04kqcj4mr9b unique (mail);

    alter table item_carrito 
       add constraint FKqy5dxh64r6jgqhkj8sx1yxf95 
       foreign key (orden_id) 
       references orden (id);

    alter table item_carrito 
       add constraint FKgarw89vvyxd65d4bqvwwmobud 
       foreign key (producto_id) 
       references producto (id);

    alter table item_carrito 
       add constraint FK95ruw8pskqrj0vdmi265vp41t 
       foreign key (usuario_id) 
       references usuario (id);

    alter table orden 
       add constraint FK3ixgmc0l9isf02alg7255pp5m 
       foreign key (usuario_id) 
       references usuario (id);

    alter table producto 
       add constraint FKodqr7965ok9rwquj1utiamt0m 
       foreign key (categoria_id) 
       references categoria (id);

    create table categoria (
        id bigint not null auto_increment,
        descripcion varchar(255),
        nombre varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table item_carrito (
        cantidad integer not null,
        id bigint not null auto_increment,
        orden_id bigint,
        producto_id bigint not null,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table orden (
        fecha datetime(6),
        id bigint not null auto_increment,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table producto (
        precio float(53) not null,
        stock integer not null,
        categoria_id bigint not null,
        id bigint not null auto_increment,
        descripcion varchar(255),
        informacion varchar(255),
        direccion_imagenes varbinary(255),
        primary key (id)
    ) engine=InnoDB;

    create table usuario (
        fecha_nacimiento datetime(6),
        id bigint not null auto_increment,
        tipo_usuario varchar(31) not null,
        apellido varchar(255),
        contrasena varchar(255) not null,
        mail varchar(255) not null,
        nombre varchar(255),
        nombre_usuario varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table usuario 
       add constraint UKics8o4kc1rvjcm04kqcj4mr9b unique (mail);

    alter table item_carrito 
       add constraint FKqy5dxh64r6jgqhkj8sx1yxf95 
       foreign key (orden_id) 
       references orden (id);

    alter table item_carrito 
       add constraint FKgarw89vvyxd65d4bqvwwmobud 
       foreign key (producto_id) 
       references producto (id);

    alter table item_carrito 
       add constraint FK95ruw8pskqrj0vdmi265vp41t 
       foreign key (usuario_id) 
       references usuario (id);

    alter table orden 
       add constraint FK3ixgmc0l9isf02alg7255pp5m 
       foreign key (usuario_id) 
       references usuario (id);

    alter table producto 
       add constraint FKodqr7965ok9rwquj1utiamt0m 
       foreign key (categoria_id) 
       references categoria (id);

    create table categoria (
        id bigint not null auto_increment,
        descripcion varchar(255),
        nombre varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table item_carrito (
        cantidad integer not null,
        id bigint not null auto_increment,
        orden_id bigint,
        producto_id bigint not null,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table orden (
        fecha datetime(6),
        id bigint not null auto_increment,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table producto (
        precio float(53) not null,
        stock integer not null,
        categoria_id bigint not null,
        id bigint not null auto_increment,
        descripcion varchar(255),
        informacion varchar(255),
        direccion_imagenes varbinary(255),
        primary key (id)
    ) engine=InnoDB;

    create table usuario (
        fecha_nacimiento datetime(6),
        id bigint not null auto_increment,
        tipo_usuario varchar(31) not null,
        apellido varchar(255),
        contrasena varchar(255) not null,
        mail varchar(255) not null,
        nombre varchar(255),
        nombre_usuario varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table usuario 
       add constraint UKics8o4kc1rvjcm04kqcj4mr9b unique (mail);

    alter table item_carrito 
       add constraint FKqy5dxh64r6jgqhkj8sx1yxf95 
       foreign key (orden_id) 
       references orden (id);

    alter table item_carrito 
       add constraint FKgarw89vvyxd65d4bqvwwmobud 
       foreign key (producto_id) 
       references producto (id);

    alter table item_carrito 
       add constraint FK95ruw8pskqrj0vdmi265vp41t 
       foreign key (usuario_id) 
       references usuario (id);

    alter table orden 
       add constraint FK3ixgmc0l9isf02alg7255pp5m 
       foreign key (usuario_id) 
       references usuario (id);

    alter table producto 
       add constraint FKodqr7965ok9rwquj1utiamt0m 
       foreign key (categoria_id) 
       references categoria (id);

    create table categoria (
        id bigint not null auto_increment,
        descripcion varchar(255),
        nombre varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table item_carrito (
        cantidad integer not null,
        id bigint not null auto_increment,
        orden_id bigint,
        producto_id bigint not null,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table orden (
        fecha datetime(6),
        id bigint not null auto_increment,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table producto (
        precio float(53) not null,
        stock integer not null,
        categoria_id bigint not null,
        id bigint not null auto_increment,
        descripcion varchar(255),
        informacion varchar(255),
        direccion_imagenes varbinary(255),
        primary key (id)
    ) engine=InnoDB;

    create table usuario (
        fecha_nacimiento datetime(6),
        id bigint not null auto_increment,
        tipo_usuario varchar(31) not null,
        apellido varchar(255),
        contrasena varchar(255) not null,
        mail varchar(255) not null,
        nombre varchar(255),
        nombre_usuario varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table usuario 
       add constraint UKics8o4kc1rvjcm04kqcj4mr9b unique (mail);

    alter table item_carrito 
       add constraint FKqy5dxh64r6jgqhkj8sx1yxf95 
       foreign key (orden_id) 
       references orden (id);

    alter table item_carrito 
       add constraint FKgarw89vvyxd65d4bqvwwmobud 
       foreign key (producto_id) 
       references producto (id);

    alter table item_carrito 
       add constraint FK95ruw8pskqrj0vdmi265vp41t 
       foreign key (usuario_id) 
       references usuario (id);

    alter table orden 
       add constraint FK3ixgmc0l9isf02alg7255pp5m 
       foreign key (usuario_id) 
       references usuario (id);

    alter table producto 
       add constraint FKodqr7965ok9rwquj1utiamt0m 
       foreign key (categoria_id) 
       references categoria (id);

    create table categoria (
        id bigint not null auto_increment,
        descripcion varchar(255),
        nombre varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table item_carrito (
        cantidad integer not null,
        id bigint not null auto_increment,
        orden_id bigint,
        producto_id bigint not null,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table orden (
        fecha datetime(6),
        id bigint not null auto_increment,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table producto (
        precio float(53) not null,
        stock integer not null,
        categoria_id bigint not null,
        id bigint not null auto_increment,
        descripcion varchar(255),
        informacion varchar(255),
        direccion_imagenes varbinary(255),
        primary key (id)
    ) engine=InnoDB;

    create table usuario (
        fecha_nacimiento datetime(6),
        id bigint not null auto_increment,
        tipo_usuario varchar(31) not null,
        apellido varchar(255),
        contrasena varchar(255) not null,
        mail varchar(255) not null,
        nombre varchar(255),
        nombre_usuario varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table usuario 
       add constraint UKics8o4kc1rvjcm04kqcj4mr9b unique (mail);

    alter table item_carrito 
       add constraint FKqy5dxh64r6jgqhkj8sx1yxf95 
       foreign key (orden_id) 
       references orden (id);

    alter table item_carrito 
       add constraint FKgarw89vvyxd65d4bqvwwmobud 
       foreign key (producto_id) 
       references producto (id);

    alter table item_carrito 
       add constraint FK95ruw8pskqrj0vdmi265vp41t 
       foreign key (usuario_id) 
       references usuario (id);

    alter table orden 
       add constraint FK3ixgmc0l9isf02alg7255pp5m 
       foreign key (usuario_id) 
       references usuario (id);

    alter table producto 
       add constraint FKodqr7965ok9rwquj1utiamt0m 
       foreign key (categoria_id) 
       references categoria (id);

    create table categoria (
        id bigint not null auto_increment,
        descripcion varchar(255),
        nombre varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table item_carrito (
        cantidad integer not null,
        id bigint not null auto_increment,
        orden_id bigint,
        producto_id bigint not null,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table orden (
        fecha datetime(6),
        id bigint not null auto_increment,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table producto (
        precio float(53) not null,
        stock integer not null,
        categoria_id bigint not null,
        id bigint not null auto_increment,
        descripcion varchar(255),
        informacion varchar(255),
        direccion_imagenes varbinary(255),
        primary key (id)
    ) engine=InnoDB;

    create table usuario (
        fecha_nacimiento datetime(6),
        id bigint not null auto_increment,
        tipo_usuario varchar(31) not null,
        apellido varchar(255),
        contrasena varchar(255) not null,
        mail varchar(255) not null,
        nombre varchar(255),
        nombre_usuario varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table usuario 
       add constraint UKics8o4kc1rvjcm04kqcj4mr9b unique (mail);

    alter table item_carrito 
       add constraint FKqy5dxh64r6jgqhkj8sx1yxf95 
       foreign key (orden_id) 
       references orden (id);

    alter table item_carrito 
       add constraint FKgarw89vvyxd65d4bqvwwmobud 
       foreign key (producto_id) 
       references producto (id);

    alter table item_carrito 
       add constraint FK95ruw8pskqrj0vdmi265vp41t 
       foreign key (usuario_id) 
       references usuario (id);

    alter table orden 
       add constraint FK3ixgmc0l9isf02alg7255pp5m 
       foreign key (usuario_id) 
       references usuario (id);

    alter table producto 
       add constraint FKodqr7965ok9rwquj1utiamt0m 
       foreign key (categoria_id) 
       references categoria (id);

    create table categoria (
        id bigint not null auto_increment,
        descripcion varchar(255),
        nombre varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table item_carrito (
        cantidad integer not null,
        id bigint not null auto_increment,
        orden_id bigint,
        producto_id bigint not null,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table orden (
        fecha datetime(6),
        id bigint not null auto_increment,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table producto (
        precio float(53) not null,
        stock integer not null,
        categoria_id bigint not null,
        id bigint not null auto_increment,
        descripcion varchar(255),
        informacion varchar(255),
        direccion_imagenes varbinary(255),
        primary key (id)
    ) engine=InnoDB;

    create table usuario (
        fecha_nacimiento datetime(6),
        id bigint not null auto_increment,
        tipo_usuario varchar(31) not null,
        apellido varchar(255),
        contrasena varchar(255) not null,
        mail varchar(255) not null,
        nombre varchar(255),
        nombre_usuario varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table usuario 
       add constraint UKics8o4kc1rvjcm04kqcj4mr9b unique (mail);

    alter table item_carrito 
       add constraint FKqy5dxh64r6jgqhkj8sx1yxf95 
       foreign key (orden_id) 
       references orden (id);

    alter table item_carrito 
       add constraint FKgarw89vvyxd65d4bqvwwmobud 
       foreign key (producto_id) 
       references producto (id);

    alter table item_carrito 
       add constraint FK95ruw8pskqrj0vdmi265vp41t 
       foreign key (usuario_id) 
       references usuario (id);

    alter table orden 
       add constraint FK3ixgmc0l9isf02alg7255pp5m 
       foreign key (usuario_id) 
       references usuario (id);

    alter table producto 
       add constraint FKodqr7965ok9rwquj1utiamt0m 
       foreign key (categoria_id) 
       references categoria (id);

    create table categoria (
        id bigint not null auto_increment,
        descripcion varchar(255),
        nombre varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table item_carrito (
        cantidad integer not null,
        id bigint not null auto_increment,
        orden_id bigint,
        producto_id bigint not null,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table orden (
        fecha datetime(6),
        id bigint not null auto_increment,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table producto (
        precio float(53) not null,
        stock integer not null,
        categoria_id bigint not null,
        id bigint not null auto_increment,
        descripcion varchar(255),
        informacion varchar(255),
        direccion_imagenes varbinary(255),
        primary key (id)
    ) engine=InnoDB;

    create table usuario (
        fecha_nacimiento datetime(6),
        id bigint not null auto_increment,
        tipo_usuario varchar(31) not null,
        apellido varchar(255),
        contrasena varchar(255) not null,
        mail varchar(255) not null,
        nombre varchar(255),
        nombre_usuario varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table usuario 
       add constraint UKics8o4kc1rvjcm04kqcj4mr9b unique (mail);

    alter table item_carrito 
       add constraint FKqy5dxh64r6jgqhkj8sx1yxf95 
       foreign key (orden_id) 
       references orden (id);

    alter table item_carrito 
       add constraint FKgarw89vvyxd65d4bqvwwmobud 
       foreign key (producto_id) 
       references producto (id);

    alter table item_carrito 
       add constraint FK95ruw8pskqrj0vdmi265vp41t 
       foreign key (usuario_id) 
       references usuario (id);

    alter table orden 
       add constraint FK3ixgmc0l9isf02alg7255pp5m 
       foreign key (usuario_id) 
       references usuario (id);

    alter table producto 
       add constraint FKodqr7965ok9rwquj1utiamt0m 
       foreign key (categoria_id) 
       references categoria (id);

    create table categoria (
        id bigint not null auto_increment,
        descripcion varchar(255),
        nombre varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table item_carrito (
        cantidad integer not null,
        id bigint not null auto_increment,
        orden_id bigint,
        producto_id bigint not null,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table orden (
        fecha datetime(6),
        id bigint not null auto_increment,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table producto (
        precio float(53) not null,
        stock integer not null,
        categoria_id bigint not null,
        id bigint not null auto_increment,
        descripcion varchar(255),
        informacion varchar(255),
        direccion_imagenes varbinary(255),
        primary key (id)
    ) engine=InnoDB;

    create table usuario (
        fecha_nacimiento datetime(6),
        id bigint not null auto_increment,
        tipo_usuario varchar(31) not null,
        apellido varchar(255),
        contrasena varchar(255) not null,
        mail varchar(255) not null,
        nombre varchar(255),
        nombre_usuario varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table usuario 
       add constraint UKics8o4kc1rvjcm04kqcj4mr9b unique (mail);

    alter table item_carrito 
       add constraint FKqy5dxh64r6jgqhkj8sx1yxf95 
       foreign key (orden_id) 
       references orden (id);

    alter table item_carrito 
       add constraint FKgarw89vvyxd65d4bqvwwmobud 
       foreign key (producto_id) 
       references producto (id);

    alter table item_carrito 
       add constraint FK95ruw8pskqrj0vdmi265vp41t 
       foreign key (usuario_id) 
       references usuario (id);

    alter table orden 
       add constraint FK3ixgmc0l9isf02alg7255pp5m 
       foreign key (usuario_id) 
       references usuario (id);

    alter table producto 
       add constraint FKodqr7965ok9rwquj1utiamt0m 
       foreign key (categoria_id) 
       references categoria (id);

    create table categoria (
        id bigint not null auto_increment,
        descripcion varchar(255),
        nombre varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table item_carrito (
        cantidad integer not null,
        id bigint not null auto_increment,
        orden_id bigint,
        producto_id bigint not null,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table orden (
        fecha datetime(6),
        id bigint not null auto_increment,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table producto (
        precio float(53) not null,
        stock integer not null,
        categoria_id bigint not null,
        id bigint not null auto_increment,
        descripcion varchar(255),
        informacion varchar(255),
        direccion_imagenes varbinary(255),
        primary key (id)
    ) engine=InnoDB;

    create table usuario (
        fecha_nacimiento datetime(6),
        id bigint not null auto_increment,
        tipo_usuario varchar(31) not null,
        apellido varchar(255),
        contrasena varchar(255) not null,
        mail varchar(255) not null,
        nombre varchar(255),
        nombre_usuario varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table usuario 
       add constraint UKics8o4kc1rvjcm04kqcj4mr9b unique (mail);

    alter table item_carrito 
       add constraint FKqy5dxh64r6jgqhkj8sx1yxf95 
       foreign key (orden_id) 
       references orden (id);

    alter table item_carrito 
       add constraint FKgarw89vvyxd65d4bqvwwmobud 
       foreign key (producto_id) 
       references producto (id);

    alter table item_carrito 
       add constraint FK95ruw8pskqrj0vdmi265vp41t 
       foreign key (usuario_id) 
       references usuario (id);

    alter table orden 
       add constraint FK3ixgmc0l9isf02alg7255pp5m 
       foreign key (usuario_id) 
       references usuario (id);

    alter table producto 
       add constraint FKodqr7965ok9rwquj1utiamt0m 
       foreign key (categoria_id) 
       references categoria (id);

    create table categoria (
        id bigint not null auto_increment,
        descripcion varchar(255),
        nombre varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table item_carrito (
        cantidad integer not null,
        id bigint not null auto_increment,
        orden_id bigint,
        producto_id bigint not null,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table orden (
        fecha datetime(6),
        id bigint not null auto_increment,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table producto (
        precio float(53) not null,
        stock integer not null,
        categoria_id bigint not null,
        id bigint not null auto_increment,
        descripcion varchar(255),
        informacion varchar(255),
        direccion_imagenes varbinary(255),
        primary key (id)
    ) engine=InnoDB;

    create table usuario (
        fecha_nacimiento datetime(6),
        id bigint not null auto_increment,
        tipo_usuario varchar(31) not null,
        apellido varchar(255),
        contrasena varchar(255) not null,
        mail varchar(255) not null,
        nombre varchar(255),
        nombre_usuario varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table usuario 
       add constraint UKics8o4kc1rvjcm04kqcj4mr9b unique (mail);

    alter table item_carrito 
       add constraint FKqy5dxh64r6jgqhkj8sx1yxf95 
       foreign key (orden_id) 
       references orden (id);

    alter table item_carrito 
       add constraint FKgarw89vvyxd65d4bqvwwmobud 
       foreign key (producto_id) 
       references producto (id);

    alter table item_carrito 
       add constraint FK95ruw8pskqrj0vdmi265vp41t 
       foreign key (usuario_id) 
       references usuario (id);

    alter table orden 
       add constraint FK3ixgmc0l9isf02alg7255pp5m 
       foreign key (usuario_id) 
       references usuario (id);

    alter table producto 
       add constraint FKodqr7965ok9rwquj1utiamt0m 
       foreign key (categoria_id) 
       references categoria (id);

    create table categoria (
        id bigint not null auto_increment,
        descripcion varchar(255),
        nombre varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table item_carrito (
        cantidad integer not null,
        id bigint not null auto_increment,
        orden_id bigint,
        producto_id bigint not null,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table orden (
        fecha datetime(6),
        id bigint not null auto_increment,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table producto (
        precio float(53) not null,
        stock integer not null,
        categoria_id bigint not null,
        id bigint not null auto_increment,
        descripcion varchar(255),
        informacion varchar(255),
        direccion_imagenes varbinary(255),
        primary key (id)
    ) engine=InnoDB;

    create table usuario (
        fecha_nacimiento datetime(6),
        id bigint not null auto_increment,
        tipo_usuario varchar(31) not null,
        apellido varchar(255),
        contrasena varchar(255) not null,
        mail varchar(255) not null,
        nombre varchar(255),
        nombre_usuario varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table usuario 
       add constraint UKics8o4kc1rvjcm04kqcj4mr9b unique (mail);

    alter table item_carrito 
       add constraint FKqy5dxh64r6jgqhkj8sx1yxf95 
       foreign key (orden_id) 
       references orden (id);

    alter table item_carrito 
       add constraint FKgarw89vvyxd65d4bqvwwmobud 
       foreign key (producto_id) 
       references producto (id);

    alter table item_carrito 
       add constraint FK95ruw8pskqrj0vdmi265vp41t 
       foreign key (usuario_id) 
       references usuario (id);

    alter table orden 
       add constraint FK3ixgmc0l9isf02alg7255pp5m 
       foreign key (usuario_id) 
       references usuario (id);

    alter table producto 
       add constraint FKodqr7965ok9rwquj1utiamt0m 
       foreign key (categoria_id) 
       references categoria (id);

    create table categoria (
        id bigint not null auto_increment,
        descripcion varchar(255),
        nombre varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table item_carrito (
        cantidad integer not null,
        id bigint not null auto_increment,
        orden_id bigint,
        producto_id bigint not null,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table orden (
        fecha datetime(6),
        id bigint not null auto_increment,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table producto (
        precio float(53) not null,
        stock integer not null,
        categoria_id bigint not null,
        id bigint not null auto_increment,
        descripcion varchar(255),
        informacion varchar(255),
        direccion_imagenes varbinary(255),
        primary key (id)
    ) engine=InnoDB;

    create table usuario (
        fecha_nacimiento datetime(6),
        id bigint not null auto_increment,
        tipo_usuario varchar(31) not null,
        apellido varchar(255),
        contrasena varchar(255) not null,
        mail varchar(255) not null,
        nombre varchar(255),
        nombre_usuario varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table usuario 
       add constraint UKics8o4kc1rvjcm04kqcj4mr9b unique (mail);

    alter table item_carrito 
       add constraint FKqy5dxh64r6jgqhkj8sx1yxf95 
       foreign key (orden_id) 
       references orden (id);

    alter table item_carrito 
       add constraint FKgarw89vvyxd65d4bqvwwmobud 
       foreign key (producto_id) 
       references producto (id);

    alter table item_carrito 
       add constraint FK95ruw8pskqrj0vdmi265vp41t 
       foreign key (usuario_id) 
       references usuario (id);

    alter table orden 
       add constraint FK3ixgmc0l9isf02alg7255pp5m 
       foreign key (usuario_id) 
       references usuario (id);

    alter table producto 
       add constraint FKodqr7965ok9rwquj1utiamt0m 
       foreign key (categoria_id) 
       references categoria (id);

    create table categoria (
        id bigint not null auto_increment,
        descripcion varchar(255),
        nombre varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table item_carrito (
        cantidad integer not null,
        id bigint not null auto_increment,
        orden_id bigint,
        producto_id bigint not null,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table orden (
        fecha datetime(6),
        id bigint not null auto_increment,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table producto (
        precio float(53) not null,
        stock integer not null,
        categoria_id bigint not null,
        id bigint not null auto_increment,
        descripcion varchar(255),
        informacion varchar(255),
        direccion_imagenes varbinary(255),
        primary key (id)
    ) engine=InnoDB;

    create table usuario (
        fecha_nacimiento datetime(6),
        id bigint not null auto_increment,
        tipo_usuario varchar(31) not null,
        apellido varchar(255),
        contrasena varchar(255) not null,
        mail varchar(255) not null,
        nombre varchar(255),
        nombre_usuario varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table usuario 
       add constraint UKics8o4kc1rvjcm04kqcj4mr9b unique (mail);

    alter table item_carrito 
       add constraint FKqy5dxh64r6jgqhkj8sx1yxf95 
       foreign key (orden_id) 
       references orden (id);

    alter table item_carrito 
       add constraint FKgarw89vvyxd65d4bqvwwmobud 
       foreign key (producto_id) 
       references producto (id);

    alter table item_carrito 
       add constraint FK95ruw8pskqrj0vdmi265vp41t 
       foreign key (usuario_id) 
       references usuario (id);

    alter table orden 
       add constraint FK3ixgmc0l9isf02alg7255pp5m 
       foreign key (usuario_id) 
       references usuario (id);

    alter table producto 
       add constraint FKodqr7965ok9rwquj1utiamt0m 
       foreign key (categoria_id) 
       references categoria (id);

    create table categoria (
        id bigint not null auto_increment,
        descripcion varchar(255),
        nombre varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table item_carrito (
        cantidad integer not null,
        id bigint not null auto_increment,
        orden_id bigint,
        producto_id bigint not null,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table orden (
        fecha datetime(6),
        id bigint not null auto_increment,
        usuario_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table producto (
        precio float(53) not null,
        stock integer not null,
        categoria_id bigint not null,
        id bigint not null auto_increment,
        descripcion varchar(255),
        informacion varchar(255),
        direccion_imagenes varbinary(255),
        primary key (id)
    ) engine=InnoDB;

    create table usuario (
        fecha_nacimiento datetime(6),
        id bigint not null auto_increment,
        tipo_usuario varchar(31) not null,
        apellido varchar(255),
        contrasena varchar(255) not null,
        mail varchar(255) not null,
        nombre varchar(255),
        nombre_usuario varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table usuario 
       add constraint UKics8o4kc1rvjcm04kqcj4mr9b unique (mail);

    alter table item_carrito 
       add constraint FKqy5dxh64r6jgqhkj8sx1yxf95 
       foreign key (orden_id) 
       references orden (id);

    alter table item_carrito 
       add constraint FKgarw89vvyxd65d4bqvwwmobud 
       foreign key (producto_id) 
       references producto (id);

    alter table item_carrito 
       add constraint FK95ruw8pskqrj0vdmi265vp41t 
       foreign key (usuario_id) 
       references usuario (id);

    alter table orden 
       add constraint FK3ixgmc0l9isf02alg7255pp5m 
       foreign key (usuario_id) 
       references usuario (id);

    alter table producto 
       add constraint FKodqr7965ok9rwquj1utiamt0m 
       foreign key (categoria_id) 
       references categoria (id);
