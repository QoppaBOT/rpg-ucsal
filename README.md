# rpg-ucsal

CREATE TABLE Usuario( id_Usuario serial, nome varchar(50), senha varchar(10), email varchar(50) ); 

CREATE TABLE Personagem( id_Personagem serial, id_Usuario Integer, id_raca Integer, nome varchar(50), raca varchar(50), maiorPersonalidade varchar(50), porntosDeVida Integer, xp Integer, Level Integer );

CREATE TABLE Raca( id_Raca serial, nome_id varchar(10), tipo Integer, forca Integer, destreza Integer, contituicao Integer,inteligencia Integer, percepicao Integer, carisma Integer ); 

CREATE TABLE Sala( id_Sala serial, id_Mestre integer, nome varchar(50), descricao varchar(50) );


CREATE TABLE Mestre( id_Mestre serial, nome varchar(50), descricao varchar(50) );

CREATE TABLE Dangeon( id_Dangeon serial, nome varchar(50), descricao varchar(50) );

CREATE TABLE Montros( id_Montros serial, id_Dangeon Integer, nome varchar(50), porntosDeVida Integer, descricao varchar(50) );


ALTER TABLE Sala ADD CONSTRAINT PK_Sala PRIMARY KEY (id_Sala); 
ALTER TABLE Dangeon ADD CONSTRAINT PK_Dangeon PRIMARY KEY (id_Dangeon); 
ALTER TABLE Montros ADD CONSTRAINT PK_Montros PRIMARY KEY (id_Montros); 
ALTER TABLE Usuario ADD CONSTRAINT PK_Usuario PRIMARY KEY (id_Usuario); 
ALTER TABLE Mestre ADD CONSTRAINT PK_Mestre PRIMARY KEY (id_Mestre); 
ALTER TABLE Personagem ADD CONSTRAINT PK_Personagem PRIMARY KEY (id_Personagem ); 
ALTER TABLE Raca ADD CONSTRAINT PK_Raca PRIMARY KEY (id_Raca);


ALTER TABLE Personagem
ADD CONSTRAINT FK_Personagem
FOREIGN KEY (id_Usuario) REFERENCES Usuario(id_Usuario);
ALTER TABLE Personagem
ADD CONSTRAINT FK_Raca
FOREIGN KEY (id_Usuario) REFERENCES Raca(id_Raca);
ALTER TABLE Sala
ADD CONSTRAINT FK_Sala
FOREIGN KEY (id_Sala) REFERENCES Mestre(id_Mestre);
ALTER TABLE Montros
ADD CONSTRAINT FK_Montros
FOREIGN KEY (id_Dangeon) REFERENCES Dangeon(id_Dangeon);



SELECT * FROM mestre
