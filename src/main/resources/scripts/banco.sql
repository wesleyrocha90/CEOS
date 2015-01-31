-- CRIAÇÃO DE TODAS AS TABELAS

-- GRUPO_USUARIO
CREATE SEQUENCE seq_grupo_usuario_id INCREMENT 1 START 1;
CREATE TABLE grupo_usuario (
  id int4 PRIMARY KEY DEFAULT nextval('seq_grupo_usuario_id'),
  descricao VARCHAR(255) NOT NULL,
  data_cadastro DATE NOT NULL
);
CREATE UNIQUE INDEX idx_grupo_usuario_id ON grupo_usuario(id);

-- USUARIO
CREATE SEQUENCE seq_usuario_id INCREMENT 1 START 1;
CREATE TABLE usuario (
  id int4 PRIMARY KEY DEFAULT nextval('seq_usuario_id'),
  login VARCHAR(255) NOT NULL,
  senha VARCHAR(255) NOT NULL,
  ativo BOOLEAN DEFAULT TRUE,
  fk_grupo_usuario_id int4 REFERENCES grupo_usuario(id) ON DELETE RESTRICT ON UPDATE CASCADE,
  data_cadastro DATE NOT NULL,
  data_expiracao DATE
);
CREATE UNIQUE INDEX idx_usuario_id ON usuario(id);

-- INSERÇÃO DE DADOS PADRÃO

INSERT INTO grupo_usuario VALUES(DEFAULT, 'Administrador', CURRENT_DATE);

INSERT INTO usuario VALUES(DEFAULT, 'wesley', '123', TRUE, 1, CURRENT_DATE, CURRENT_DATE + INTERVAL '1 YEAR');
INSERT INTO usuario VALUES(DEFAULT, 'marco', '123', TRUE, 1, CURRENT_DATE, CURRENT_DATE + INTERVAL '1 YEAR');
INSERT INTO usuario VALUES(DEFAULT, 'danilo', '123', TRUE, 1, CURRENT_DATE, CURRENT_DATE + INTERVAL '1 YEAR');

CREATE SEQUENCE seq_menu_painel_id INCREMENT 1 START 1;
CREATE TABLE menu_painel (
  id int4 PRIMARY KEY DEFAULT nextval('seq_menu_painel_id'),
  titulo VARCHAR(255) NOT NULL,
  ordem INT NOT NULL
);

CREATE SEQUENCE seq_menu_item_id INCREMENT 1 START 1;
CREATE TABLE menu_item (
  id int4 PRIMARY KEY DEFAULT nextval('seq_menu_item_id'),
  titulo VARCHAR(255) NOT NULL,
  imagem VARCHAR(255) NOT NULL,
  fxml_tela VARCHAR(255) NOT NULL,
  fk_id_menu_painel int4 REFERENCES menu_painel(id) ON DELETE RESTRICT ON UPDATE CASCADE,
  ordem int NOT NULL
);

INSERT INTO menu_painel VALUES(DEFAULT, 'cadastros', 1);
INSERT INTO menu_item VALUES(DEFAULT, 'usuario', 'user_16', 'UsuarioLista', 1, 1);
INSERT INTO menu_item VALUES(DEFAULT, 'grupoUsuario', 'users_16', 'GrupoUsuarioLista', 1, 2);