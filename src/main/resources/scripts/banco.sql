-- INSERÇÃO DE DADOS PADRÃO

INSERT INTO grupo_usuario(ID, DESCRICAO, DATA_CADASTRO) 
  VALUES(DEFAULT, 'Administrador', CURRENT_DATE);

INSERT INTO usuario(ID, LOGIN, SENHA, ATIVO, FK_GRUPO_USUARIO_ID, DATA_CADASTRO, DATA_EXPIRACAO) 
  VALUES(DEFAULT, 'wesley', '123', TRUE, 1, CURRENT_DATE, CURRENT_DATE + INTERVAL '1 YEAR'),
        (DEFAULT, 'marco', '123', TRUE, 1, CURRENT_DATE, CURRENT_DATE + INTERVAL '1 YEAR');

INSERT INTO menu_painel(ID, TITULO, ORDEM) 
  VALUES(DEFAULT, 'cadastros', 1);

INSERT INTO menu_item(ID, TITULO, IMAGEM, FXML_TELA, ORDEM, FK_ID_MENU_PAINEL) 
  VALUES(DEFAULT, 'usuario', 'user_16', 'UsuarioLista', 1, 1),
        (DEFAULT, 'grupoUsuario', 'users_16', 'GrupoUsuarioLista', 2, 1);