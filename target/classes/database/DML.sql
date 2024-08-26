INSERT INTO rol (rol) VALUES ('Administrador'), ('Encuestado');

INSERT INTO usuario (habilitado, nombre_usuario, contraseña) VALUES 
(TRUE, 'mau', 'mau1'), 
(TRUE, 'lau', 'lau1');

INSERT INTO rol(rol) VALUES
("Administrador"), -- Administrador
("Encuestado"); -- Encuestado

INSERT INTO rol_usuario (rol_id, usuario_id) VALUES
(1, 1), -- Administrador
(2, 2); -- Encuestado

INSERT INTO categoria_catalogo (nombre) VALUES 
('Familiar'), 
('Personal'), 
('Seguridad'),
('Politica'), 
('Nutricion'), 
('.'), 
('.'), 
('.');

INSERT INTO formulario (descripcion, nombre) VALUES 
('Formulario para evaluar satisfacción del usuario', 'Formulario Satisfacción'),
('Formulario para evaluar la usabilidad del sistema', 'Formulario Usabilidad'),
('Formulario para evaluar la experiencia del cliente', 'Formulario Experiencia');

INSERT INTO capitulo (formulario_id, numero_capitulo, titulo_capitulo) VALUES
(1, '1', 'Capítulo 1: Introducción'),
(1, '2', 'Capítulo 2: Detalles'),
(2, '1', 'Capítulo 1: Usabilidad General'),
(2, '2', 'Capítulo 2: Aspectos Específicos'),
(3, '1', 'Capítulo 1: Experiencia General'),
(3, '2', 'Capítulo 2: Sugerencias');

INSERT INTO pregunta (capitulo_id, numero_pregunta, tipo_respuesta, comentario_pregunta, texto_pregunta) VALUES
-- Formulario Satisfacción, Capítulo 1
(1, '1', 'Multiple Choice', 'Pregunta sobre la satisfacción general', '¿Cómo calificaría su experiencia general con nuestro producto?'),
(1, '2', 'Multiple Choice', 'Pregunta sobre la facilidad de uso', '¿Qué tan fácil fue usar nuestro producto?'),
(1, '3', 'Open-ended', 'Pregunta abierta sobre mejoras', '¿Qué mejoras sugeriría para nuestro producto?'),

-- Formulario Satisfacción, Capítulo 2
(2, '1', 'Multiple Choice', 'Pregunta sobre las características', '¿Qué características del producto encontró más útiles?'),
(2, '2', 'Multiple Choice', 'Pregunta sobre el soporte', '¿Cómo calificaría la calidad del soporte recibido?'),
(2, '3', 'Open-ended', 'Pregunta abierta sobre la experiencia', 'Describa su experiencia general con el producto.'),

-- Formulario Usabilidad, Capítulo 1
(3, '1', 'Multiple Choice', 'Pregunta sobre la navegación', '¿Cómo calificaría la facilidad de navegación en la interfaz?'),
(3, '2', 'Multiple Choice', 'Pregunta sobre la claridad de instrucciones', '¿Las instrucciones y mensajes eran claros y comprensibles?'),
(3, '3', 'Open-ended', 'Pregunta abierta sobre usabilidad', '¿Cómo podría mejorar la usabilidad del sistema?'),

-- Formulario Usabilidad, Capítulo 2
(4, '1', 'Multiple Choice', 'Pregunta sobre la respuesta del sistema', '¿El sistema respondió rápidamente a sus acciones?'),
(4, '2', 'Multiple Choice', 'Pregunta sobre errores', '¿Experimentó algún error durante el uso del sistema?'),
(4, '3', 'Open-ended', 'Pregunta abierta sobre errores', 'Describa cualquier error o problema que encontró.'),

-- Formulario Experiencia, Capítulo 1
(5, '1', 'Multiple Choice', 'Pregunta sobre la experiencia general', '¿Cómo calificaría su experiencia general con nuestro servicio?'),
(5, '2', 'Multiple Choice', 'Pregunta sobre el personal', '¿Cómo calificaría la atención del personal?'),
(5, '3', 'Open-ended', 'Pregunta abierta sobre la atención', '¿Qué aspecto de la atención al cliente le gustaría que se mejorara?'),

-- Formulario Experiencia, Capítulo 2
(6, '1', 'Multiple Choice', 'Pregunta sobre la rapidez del servicio', '¿Qué tan rápido recibió el servicio que solicitó?'),
(6, '2', 'Multiple Choice', 'Pregunta sobre la calidad', '¿Cómo calificaría la calidad del servicio recibido?'),
(6, '3', 'Open-ended', 'Pregunta abierta sobre sugerencias', '¿Tiene alguna sugerencia para mejorar nuestro servicio?');

INSERT INTO opcion_respuesta (valor_opcion, catalogo_id, pregunta_id, tipo_componente_html, comentario_pregunta, opcion_text) VALUES
-- Opción 1 para la primera pregunta del primer formulario
(1, 1, 1, 'radio', 'Satisfacción general', 'Muy Satisfecho'),
(2, 1, 1, 'radio', 'Satisfacción general', 'Satisfecho'),
(3, 1, 1, 'radio', 'Satisfacción general', 'Neutral'),
(4, 1, 1, 'radio', 'Satisfacción general', 'Insatisfecho'),
(5, 1, 1, 'radio', 'Satisfacción general', 'Muy Insatisfecho'),

-- Opción 2 para la segunda pregunta del primer formulario
(6, 2, 2, 'checkbox', 'Facilidad de uso', 'Fácil de usar'),
(7, 2, 2, 'checkbox', 'Facilidad de uso', 'Moderadamente fácil de usar'),
(8, 2, 2, 'checkbox', 'Facilidad de uso', 'Difícil de usar'),

-- Opción 3 para la primera pregunta del segundo formulario
(9, 3, 4, 'radio', 'Características', 'Muy Útil'),
(10, 3, 4, 'radio', 'Características', 'Útil'),
(11, 3, 4, 'radio', 'Características', 'Poco Útil'),
(12, 3, 4, 'radio', 'Características', 'No Útil'),

-- Opción 4 para la segunda pregunta del segundo formulario
(13, 4, 5, 'checkbox', 'Calidad del soporte', 'Excelente'),
(14, 4, 5, 'checkbox', 'Calidad del soporte', 'Buena'),
(15, 4, 5, 'checkbox', 'Calidad del soporte', 'Regular'),
(16, 4, 5, 'checkbox', 'Calidad del soporte', 'Mala'),

-- Opción 5 para la primera pregunta del tercer formulario
(17, 5, 7, 'radio', 'Navegación', 'Muy Fácil'),
(18, 5, 7, 'radio', 'Navegación', 'Fácil'),
(19, 5, 7, 'radio', 'Navegación', 'Neutral'),
(20, 5, 7, 'radio', 'Navegación', 'Difícil'),
(21, 5, 7, 'radio', 'Navegación', 'Muy Difícil'),

-- Opción 6 para la segunda pregunta del tercer formulario
(22, 6, 8, 'radio', 'Claridad de instrucciones', 'Muy Claro'),
(23, 6, 8, 'radio', 'Claridad de instrucciones', 'Claro'),
(24, 6, 8, 'radio', 'Claridad de instrucciones', 'Neutral'),
(25, 6, 8, 'radio', 'Claridad de instrucciones', 'Poco Claro'),
(26, 6, 8, 'radio', 'Claridad de instrucciones', 'Nada Claro'),

-- Opción 7 para la primera pregunta del cuarto formulario
(27, 7, 9, 'radio', 'Rapidez', 'Muy Rápido'),
(28, 7, 9, 'radio', 'Rapidez', 'Rápido'),
(29, 7, 9, 'radio', 'Rapidez', 'Moderado'),
(30, 7, 9, 'radio', 'Rapidez', 'Lento'),
(31, 7, 9, 'radio', 'Rapidez', 'Muy Lento'),

-- Opción 8 para la segunda pregunta del cuarto formulario
(32, 8, 10, 'radio', 'Calidad', 'Excelente'),
(33, 8, 10, 'radio', 'Calidad', 'Buena'),
(34, 8, 10, 'radio', 'Calidad', 'Regular'),
(35, 8, 10, 'radio', 'Calidad', 'Mala');

INSERT INTO opcion_subrespuesta (numero_subrespuesta, opcion_respuesta_id, tipo_componente_html, subrespueta_text) VALUES
(1, 6, 'checkbox', 'Opción A'),
(2, 6, 'checkbox', 'Opción B'),
(3, 7, 'checkbox', 'Opción A'),
(4, 7, 'checkbox', 'Opción B');

INSERT INTO respuesta_pregunta (respuesta_id, subrespuesta_id, respuesta_text) VALUES
(6, 1, NULL),
(6, 2, NULL),
(7, 3, NULL),
(7, 4, NULL);
