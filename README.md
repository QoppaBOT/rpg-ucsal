# rpg-ucsal
CREATE TABLE Usuario( idUsuario serial PRIMARY KEY, nome varchar(50), senha varchar(10), email varchar(50) );

CREATE TABLE Mestre( idMestre serial PRIMARY KEY, nome varchar(50), descricao varchar(50) );

CREATE TABLE Monstro( idMonstro serial PRIMARY KEY, nome varchar(50), pontosDeVida Integer, descricao varchar(50) );

CREATE TABLE Dangeon( idDangeon serial PRIMARY KEY,idMonstro integer, nome varchar(50), descricao varchar(50) );

CREATE TABLE Sala(idSala serial PRIMARY KEY, idMestre integer, idDangeon integer, nome varchar(50), Senha varchar(15), descricao varchar(50) );

CREATE TABLE Raca( idRaca serial PRIMARY KEY, nome varchar(10), forca Integer, destreza Integer, constituicao Integer,inteligencia Integer, percepicao Integer, carisma Integer );

CREATE TABLE Personagem( idPersonagem serial PRIMARY KEY, idUsuario Integer, idraca Integer, idSala Integer, nome varchar(50), maiorPersonalidade varchar(50), pontosDeVida Integer, pontosDeEnergia Integer, xp Integer, Levelxp Integer );

ALTER TABLE Personagem ADD CONSTRAINT FK_PersonagemUsuario FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario);

ALTER TABLE Personagem ADD CONSTRAINT FK_PersonagemRaca FOREIGN KEY (idraca) REFERENCES Raca(idraca);

ALTER TABLE Personagem ADD CONSTRAINT FK_PersonagemSala FOREIGN KEY (idSala) REFERENCES Sala(idSala);

ALTER TABLE Sala ADD CONSTRAINT Fk_SalaMestre FOREIGN KEY (idMestre) REFERENCES Mestre(idMestre);

ALTER TABLE Sala ADD CONSTRAINT Fk_SalaDangeon FOREIGN KEY (idDangeon) REFERENCES Dangeon(idDangeon);

ALTER TABLE Dangeon ADD CONSTRAINT Fk_DangeonMonstro FOREIGN KEY (idMonstro) REFERENCES Monstro(idMonstro);
------------------------------------------------------------------------------------

INSERT INTO Usuario (nome, senha, email)
VALUES ('luiz', '1234', 'luiz@luiz'),
('hugo', '1234', 'hugo@hugo');

INSERT INTO Mestre (nome, descricao)
VALUES ('luizMestre', 'DEUS'),
('hugo', 'Retardado');
INSERT INTO Monstro (nome, pontosDeVida, descricao)
VALUES ('Ork', 100,'Terrivel ork');

INSERT INTO Dangeon (idMonstro, nome, descricao)
VALUES (1, 'Terra Ork','Terras secas e destruidas');

INSERT INTO Raca (nome, forca, destreza, constituicao,inteligencia, percepicao, carisma)
VALUES ('Arqueiro', 3,1,1,2,1,5),
('Guerreiro', 3,3,3,2,0,0),
('Mago', 3,1,3,2,3,5),
('Tanker', 3,5,5,0,0,0),
('GM', 3,1,3,2,1,5);
INSERT INTO Sala(idMestre, idDangeon, nome, Senha, descricao)
VALUES(1,1,'medieval',123,'mundo de guerra');

INSERT INTO Personagem (idUsuario, idraca, idSala, nome, maiorPersonalidade,pontosDeVida, pontosDeEnergia, xp , Levelxp)
VALUES (1, 2,1,'Qoppa','Simples',100,100,50,1),
(2, 2,1,'Huginho','Ladrao Todo',100,100,50,1);

--------------------------
SELECT dangeon.nome, monstro.nome
FROM dangeon
INNER JOIN monstro ON dangeon.iddangeon = monstro.idmonstro;

select t1.nome, t2.nome, t3.nome
from sala t1 
inner join dangeon t2 on t1.idsala = t2.iddangeon
inner join monstro t3 on t2.idmonstro=t3.idmonstro
