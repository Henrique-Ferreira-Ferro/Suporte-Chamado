CREATE DATABASE suporte;

USE suporte;

-- Criação da tabela 'departamento'
CREATE TABLE departamento (
    idDepart INT NOT NULL AUTO_INCREMENT,
    nomeDepart VARCHAR(50) NOT NULL,
    PRIMARY KEY (idDepart)
);

-- Insira os departamentos nessa ordem, pois do contrario haverá um erro na aplicação

INSERT INTO departamento (nomeDepart) VALUES ('Tecnologia');
INSERT INTO departamento (nomeDepart) VALUES ('recursos humanos');
INSERT INTO departamento (nomeDepart) VALUES ('comercial');
INSERT INTO departamento (nomeDepart) VALUES ('operacional');
INSERT INTO departamento (nomeDepart) VALUES ('financeiro');
INSERT INTO departamento (nomeDepart) VALUES ('juridico');

-- Criação da tabela 'usuario'
CREATE TABLE usuario (
    idUsu INT NOT NULL AUTO_INCREMENT,
    nomeUsu VARCHAR(60) NOT NULL,
    senhaUsu INT NOT NULL,
    emailUsu VARCHAR(45),
    nivelUsu VARCHAR(30) NOT NULL,
    loginUsu VARCHAR(60) NOT NULL,
    idDepart INT NOT NULL,
    PRIMARY KEY (IdUsu),
    FOREIGN KEY (idDepart) REFERENCES departamento (idDepart)
);


-- Criação da tabela 'chamado'
CREATE TABLE chamado (
    idCha INT NOT NULL AUTO_INCREMENT,
    tituloCha VARCHAR(100) NOT NULL,
    categoriaCha VARCHAR(50),
    horaCriCha DATE,
    anexoCha BLOB,
    statusCha VARCHAR(45) NOT NULL DEFAULT 'aberto',
    comentarioCha TEXT,
    descricaoCha TEXT,
    idUsu INT NOT NULL,
    PRIMARY KEY (idCha),
    FOREIGN KEY (idUsu) REFERENCES usuario (idUsu)
);
ALTER TABLE chamado MODIFY idCha INTEGER NOT NULL AUTO_INCREMENT;

UPDATE chamado set tituloCha = 'Arrumar bateria', categoriaCha = 'Hardware e Perifericos', horaCricha = NOW(),statusCha = 'fechado',
comentarioCha = 'Problema na bateria chefia', idUsu = 1 WHERE idCha = 1;


-- Criação da tabela 'senhasGerais'
CREATE TABLE senhasGerais (
    idSen INT NOT NULL AUTO_INCREMENT,
	origemSen VARCHAR(100) NOT NULL,
	emailSen VARCHAR(45),
    senhaSen VARCHAR(100) NOT NULL,
    loginSen VARCHAR(60),
    descricaoSen TEXT,
    idUsu INT NOT NULL,
    PRIMARY KEY (idSen),
    FOREIGN KEY (idUsu) REFERENCES usuario (idUsu)
);





-- Inserção usuário
INSERT INTO usuario (nomeUsu, senhaUsu, emailUsu, nivelUsu, loginUsu, idDepart)
VALUES ('Henrique Ferro', 12345, 'henrique@fatec.sp', 'tecnico', 'henrique.ferro', 1);

INSERT INTO usuario (nomeUsu, senhaUsu, emailUsu, nivelUsu, loginUsu, idDepart)
VALUES ('David D Loius', 421412, 'david.31@fatec.sp', 'usuario', 'david.ferro', 3);

INSERT INTO usuario (nomeUsu, senhaUsu, emailUsu, nivelUsu, loginUsu, idDepart)
VALUES ('Nosferato', 51231, 'nosfe@fatec.sp', 'usuario', 'nosfer', 4);

INSERT INTO usuario (nomeUsu, senhaUsu, emailUsu, nivelUsu, loginUsu, idDepart)
VALUES ('Zood', 421112, 'zood@fatec.sp', 'tecnico', 'zood.ferro', 1);

-- Inserção chamado 
INSERT INTO chamado (tituloCha, descricaoCha, categoriaCha, horaCriCha, statusCha, idUsu)
VALUES ('Problema de Login', 'Não consigo acessar minha conta', 'Acesso', CURDATE(), 'aberto', 1);

INSERT INTO chamado (tituloCha, descricaoCha, categoriaCha, horaCriCha, statusCha, idUsu)
VALUES ('Troca de bateria', 'Solicito a troca da minha bateria que está ruim ', 'Hardware e Perifericos', CURDATE(), 'fechado', 5);

INSERT INTO chamado (tituloCha, descricaoCha, categoriaCha, horaCriCha, statusCha, idUsu)
VALUES ('Acesso a pasta', 'Por gentileza me fornecer acesso a pasta do financeiro', 'Acesso', CURDATE(), 'em andamento', 3);

-- Inserção de uma senha geral exemplo
INSERT INTO senhasGerais (descricaoSen, senhaSen, emailSen, loginSen, origemSen, idUsu)
VALUES ('Acesso a Locaweb', 'P@ssw0rdin1995', 'fatec.in2024@fatec.sp.gov.br', 'fatec.caracas', 'Locaweb', 1);

INSERT INTO senhasGerais (descricaoSen, senhaSen, emailSen, loginSen, origemSen, idUsu)
VALUES ('Login no mercado livre', '4214@n1995', 'fatec.in2024@fatec.sp.gov.br', 'fatec.caracas', 'MercadoLivre', 2);

-- Exemplo de Delete
-- Nota: Se você possui a aplicação que desenvolvi em mãos
-- em hipotese alguma execute alguma exclução no departamento,
-- pois a aplicação será comprometida.
-- Os valores foram chumbados na aplicação e não pretendo
-- altera-los

DELETE FROM usuario WHERE idUsu = 19;
DELETE FROM usuario WHERE nomeUsu = 'judas';

DELETE FROM departamento WHERE idDepart = 6;
DELETE FROM departamento WHERE nomeDepart = 'comercial';

DELETE FROM chamado WHERE idCha = 8;
DELETE FROM chamado WHERE status = 'aberto';

DELETE FROM senhasGerais WHERE idSen = 5;
DELETE FROM senhasGerais WHERE idUsu = 1;

-- Update 
UPDATE departamento SET nomeDepart = "facilites" WHERE id = 4;
UPDATE usuario SET senhaUsu = 213 WHERE id = 5;


-- Selecionando os dados das tabelas para verificação
SELECT * FROM departamento;
SELECT * FROM usuario;
SELECT * FROM chamado;
SELECT * FROM senhasGerais;

SELECT * FROM chamado WHERE statusCha LIKE 'aberto';


-- Inner join
SELECT usuario.idUsu, usuario.nomeUsu, departamento.nomeDepart
FROM usuario
INNER JOIN departamento ON usuario.idDepart = departamento.idDepart;

-- Left Join
SELECT usuario.idUsu, usuario.nomeUsu, chamado.tituloCha
FROM usuario
LEFT JOIN chamado ON usuario.idUsu = chamado.idUsu;

-- RIGHT join 
SELECT chamado.idCha, chamado.tituloCha, usuario.nomeUsu
FROM chamado
RIGHT JOIN usuario ON chamado.idUsu = usuario.idUsu;

-- Cros JOIN
SELECT usuario.nomeUsu, departamento.nomeDepart 
FROM usuario 
CROSS JOIN departamento; 

-- Criação da Trigger para a tabela chamado
-- nota: vou remover mais tarde, pois a aplicação já
-- está pegando automaticamente a data atual

DELIMITER //
CREATE TRIGGER before_insert_chamado
BEFORE INSERT ON chamado
FOR EACH ROW
BEGIN 
	IF NEW.horaCriCha IS NULL THEN
		SET NEW.horaCriCha = NOW();
	END IF;
END;
//


INSERT INTO chamado (tituloCha, descricaoCha, categoriaCha, statusCha, idUsu)
VALUES ('Teste Trigger', 'Verificar se o trigger funciona corretamente', 'Teste', 'aberto', 1);

SELECT * FROM chamado WHERE tituloCha = 'Teste Trigger';

