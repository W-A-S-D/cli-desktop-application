CREATE DATABASE IF NOT EXISTS wasd;
use wasd;

CREATE TABLE empresa (
    empresa_id INT PRIMARY KEY AUTO_INCREMENT
    , nome VARCHAR(100) NOT NULL
    , email_empresarial VARCHAR(50)
    , cnpj CHAR(14) NOT NULL
    , logradouro varchar(100) NOT NULL
    , numero INT
    , bairro VARCHAR(25) NOT NULL
    , cidade VARCHAR(30) NOT NULL
    , uf CHAR(2) NOT NULL
    , cep CHAR(9) NOT NULL
    , telefone VARCHAR(11) NOT NULL
);
CREATE TABLE usuario (
    usuario_id INT PRIMARY KEY AUTO_INCREMENT
    , fk_empresa INT NOT NULL
    , nome VARCHAR(100) NOT NULL
    , email VARCHAR(100) NOT NULL
    , senha VARCHAR(255) NOT NULL
    , nivelAcesso INT NOT NULL
    , avatar VARCHAR(255)
    , criado DATETIME(0) DEFAULT NOW()
    , atualizado DATETIME(0)
    , FOREIGN KEY(fk_empresa) REFERENCES empresa(empresa_id)
);

CREATE TABLE pedido(
    pedido_id INT PRIMARY KEY AUTO_INCREMENT
    , hostname VARCHAR(25) NOT NULL
    , status INT NOT NULL
    , fk_usuario INT NOT NULL
    , FOREIGN KEY (fk_usuario) REFERENCES usuario(usuario_id)
  );

CREATE TABLE setor (
    setor_id INT PRIMARY KEY AUTO_INCREMENT
    , fk_usuario INT NOT NULL
    , jogo VARCHAR(50) NOT NULL
    , avatar_jogo VARCHAR(255)
    , FOREIGN KEY(fk_usuario) REFERENCES usuario(usuario_id)
);

CREATE TABLE maquina (
    maquina_id INT PRIMARY KEY AUTO_INCREMENT
    , fk_setor INT NOT NULL
    , nome VARCHAR(30) NOT NULL
    , so VARCHAR(20) NOT NULL
    , cpu VARCHAR(50) NOT NULL
    , ram DECIMAL(6,2) NOT NULL
    , gpu VARCHAR(50)
    , status VARCHAR(20) NOT NULL
    , FOREIGN KEY(fk_setor) REFERENCES setor(setor_id)
);

CREATE TABLE processo (
    processo_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT
    , fk_maquina INT NOT NULL
    , nome VARCHAR(30) NOT NULL
    , usoCpu DOUBLE NOT NULL 
    , usoMemoria DOUBLE NOT NULL
    , iniciado DATETIME(0) DEFAULT NOW()
    , atualizado DATETIME(0) 
    , FOREIGN KEY(fk_maquina) REFERENCES maquina(maquina_id)
);

CREATE TABLE pedido(
    pedido_id INT PRIMARY KEY AUTO_INCREMENT
    , hostname VARCHAR(25) NOT NULL
    , status INT NOT NULL
    , fk_usuario INT NOT NULL
    , FOREIGN KEY (fk_usuario) REFERENCES usuario(usuario_id)
  );

CREATE TABLE disco (
    disco_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT
    , fk_maquina INT NOT NULL
    , nome VARCHAR(100) NOT NULL
    , volume DECIMAL(6,2) NOT NULL
    , FOREIGN KEY(fk_maquina) REFERENCES maquina(maquina_id)
);

CREATE TABLE log (
    log_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT
    , fk_maquina INT NOT NULL
    , freq_cpu DECIMAL(6,2) NOT NULL
    , uso_ram DECIMAL(6,2) NOT NULL
    , temperatura DECIMAL(6,2) NOT NULL
    , criado DATETIME(0) DEFAULT NOW()
    , FOREIGN KEY(fk_maquina) REFERENCES maquina(maquina_id)
);

CREATE TABLE log_disco (
    fk_log INT NOT NULL
    , fk_disco INT NOT NULL
    , uso_disco DECIMAL(6,2) NOT NULL
    , FOREIGN KEY(fk_log) REFERENCES log(log_id)
    , FOREIGN KEY(fk_disco) REFERENCES disco(disco_id)
    , PRIMARY KEY (fk_log, fk_disco)
);

INSERT INTO empresa(nome,email_empresarial,cnpj,logradouro,numero,bairro,cidade,uf,cep,telefone) 
    VALUES ('juninhoCorp','juninho@gmail.com','12345678911234','Rua Paulo Ramos',25,'Vila','São Paulo','SP','08461200','95790779'
); 

INSERT INTO usuario (
    fk_empresa, nome, email, senha, nivelAcesso, avatar) 
    VALUES  (1, 'Bia Vediner', 'admin@gmail.com', 'teste', 1, '/img/teste'
);

INSERT INTO setor (
    fk_usuario, jogo, avatar_jogo) 
    VALUES  (1, 'lol', 'imagemboladona.png'
);
