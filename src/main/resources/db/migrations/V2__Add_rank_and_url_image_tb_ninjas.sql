-- V2: Migration para adicionar colunas de RANK e URL_IMAGE na tabela de ninjas

ALTER TABLE TB_NINJAS ADD rank VARCHAR(255) DEFAULT 'Genin';
ALTER TABLE TB_NINJAS ADD url_image VARCHAR(255);