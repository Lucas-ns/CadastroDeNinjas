-- V3: Fazer a primeira inserção de dados no banco

INSERT INTO TB_MISSOES(nome, dificuldade)
VALUES('Salvar cachorro', 'FACIL');

INSERT INTO TB_MISSOES(nome, dificuldade)
VALUES('Resgatar pergaminho', 'DIFICIL');

INSERT INTO TB_NINJAS(nome, email, idade, missao_id, url_image)
VALUES('Naruto Uzumaki', 'naruto@gmail.com', 15, 1, 'http://exemplo.com/naruto.jpg');

INSERT INTO TB_NINJAS(nome, email, idade, missao_id, url_image)
VALUES('Sasuke Uchiha', 'sasuke@gmail.com', 16, 1, 'http://exemplo.com/sasuke.jpg');