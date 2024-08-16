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

CREATE TABLE categoria_catalogo(
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

CREATE TABLE pregunta(
    id INT AUTO_INCREMENT,
    caputilo_id INT,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    numero_pregunta VARCHAR(10),
    tipo_respuesta VARCHAR(20),
    comentario_pregunta TEXT,
    texto_pregunta TEXT,
    CONSTRAINT pk_id_pregunta PRIMARY KEY (id),
    CONSTRAINT fk_id_capitulo FOREIGN KEY (capuitulo_id) REFERENCES capitulo(id)
);

CREATE TABLE opcion_respuesta(
    id INT AUTO_INCREMENT,
    valor_opcion INT(4),
    catalogo_id INT,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    respuesta_padre_id INT,
    pregunta_id INT,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    tipo_componente_html VARCHAR(255),
    comentario_pregunta TEXT,
    opcion_text TEXT,
    CONSTRAINT pk_id_opcion_respuesta PRIMARY KEY (id),
    CONSTRAINT fk_id_catalogo FOREIGN KEY (catalogo_id) REFERENCES categoria_catalogo(id),
    CONSTRAINT fk_id_respuesta_padre FOREIGN KEY (respuesta_padre_id) REFERENCES opcion_respuesta(id),
    CONSTRAINT  fk_id_pregunta FOREIGN KEY (pregunta_id) REFERENCES pregunta(id)
);

CREATE TABLE opcion_subrespuesta(
    id INT AUTO_INCREMENT,
    numero_subrespuesta INT(4),
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    opcion_respuesta_id INT,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    tipo_componente_html VARCHAR(255),
    subrespueta_text TEXT,
    CONSTRAINT pk_id_opcion_subrespuesta FOREIGN KEY (id),
    CONSTRAINT fk_id_opcion_respuesta FOREIGN KEY (opcion_respuesta_id) REFERENCES opcion_respuesta(id)
);

CREATE TABLE respuesta_pregunta(
    id INT AUTO_INCREMENT,
    respuesta_id INT,
    subrespuesta_id INT,
    respuesta_text TEXT,
    CONSTRAINT pk_id_respuesta_pregunta PRIMARY KEY (id),
    CONSTRAINT fk_id_respuesta_pregunta FOREIGN KEY (respuesta_id) REFERENCES opcion_respuesta(id),
    CONSTRAINT fk_id_subrespuesta_pregunta FOREIGN KEY (subrespuesta_id) REFERENCES opcion_subrespuesta(id)
);