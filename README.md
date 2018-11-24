# rpg-ucsal

CREATE TABLE Usuario( idUsuario serial PRIMARY KEY, nome varchar(50), senha varchar(10), email varchar(50) );
CREATE TABLE Mestre( idMestre serial PRIMARY KEY, nome varchar(50), descricao varchar(50) );
CREATE TABLE Personagem( idPersonagem serial PRIMARY KEY, idUsuario Integer, idraca Integer, idSala Integer, nome varchar(50), maiorPersonalidade varchar(50), porntosDeVida Integer, xp Integer, Level Integer );
CREATE TABLE Sala(idSala serial PRIMARY KEY, idMestre integer, idDangeon integer, nome varchar(50), descricao varchar(50) );
CREATE TABLE Raca( idRaca serial PRIMARY KEY, nome varchar(10), forca Integer, destreza Integer, contituicao Integer,inteligencia Integer, percepicao Integer, carisma Integer ); 
CREATE TABLE Dangeon( idDangeon serial PRIMARY KEY,idMontro integer, nome varchar(50), descricao varchar(50) );
CREATE TABLE Montro( idMontro serial PRIMARY KEY, nome varchar(50), porntosDeVida Integer, descricao varchar(50) );

ALTER TABLE Personagem
ADD CONSTRAINT FK_PersonagemUsuario
FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario);

ALTER TABLE Personagem
ADD CONSTRAINT FK_Personagemraca
FOREIGN KEY (idraca) REFERENCES Raca(idraca);

ALTER TABLE Personagem
ADD CONSTRAINT FK_PersonagemracaSala
FOREIGN KEY (idSala) REFERENCES Sala(idSala);

ALTER TABLE Sala
ADD CONSTRAINT Fk_SalaMestre
FOREIGN KEY (idMestre) REFERENCES Mestre(idMestre);

ALTER TABLE Sala
ADD CONSTRAINT Fk_SalaDangeon
FOREIGN KEY (idDangeon) REFERENCES Dangeon(idDangeon);

ALTER TABLE Dangeon
ADD CONSTRAINT Fk_DangeonMonstro
FOREIGN KEY (idMontro) REFERENCES Montro(idMontro);