DROP DATABASE IF EXISIST questcontrol;

CREATE DATABASE questcontrol;
USE questcontrol;

CREATE TABLE usuario(
    id INT AUTO_INCREMENT,
    habilitado BOOLEAN,
    nombre_usuario VARCHAR(12),
    contraseña VARCHAR(255),
    CONSTRAINT pk_id_usuario PRIMARY KEY (id)
);

CREATE TABLE rol(
    id INT AUTO_INCREMENT,
    rol VARCHAR(255),
    CONSTRAINT pk_id_rol PRIMARY KEY (id)
);

CREATE TABLE rol_usuario(
    role_id INT,
    uruario_id INT,
    CONSTRAINT pk_id_rol_usuario PRIMARY KEY (role_id,usuario_id),
    CONSTRAINT fk_id_rol FOREIGN KEY (role_id) REFERENCES rol(id),
    CONSTRAINT fk_id_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

CREATE TABLE catalogo(
    id INT AUTO_INCREMENT,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    nombre VARCHAR(255),
    CONSTRAINT pk_id_catalogo PRIMARY KEY (id)
);

CREATE TABLE formulario(
    id INT AUTO_INCREMENT,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    descripcion VARCHAR(255),
    nombre VARCHAR(255),
    CONSTRAINT pk_id_formulario PRIMARY KEY (id)
);

CREATE TABLE capitulo(
    id INT AUTO_INCREMENT,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    formulario_id INT,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    numero_capitulo VARCHAR(50),
    titulo_capitulo VARCHAR(50),
    CONSTRAINT pk_id_capitulo PRIMARY KEY (id),
    CONSTRAINT fk_id_formulario FOREIGN KEY (formulario_id) REFERENCES formulario(id)
);

CREATE TABLE preguntas(
    id
);