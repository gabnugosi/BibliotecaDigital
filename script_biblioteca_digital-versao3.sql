USE MASTER;
GO
DROP DATABASE BDIGITAL_201902;
go

CREATE DATABASE BDIGITAL_201902;
GO

USE BDIGITAL_201902;
GO

CREATE TABLE imagem_obra(
	id_img_obra		INT					NOT NULL	IDENTITY(1,1)	PRIMARY KEY,
	nm_arquivo		VARCHAR(1000)		NOT NULL,
	vb_imagem		varbinary(MAX)		NOT NULL -- para armazenar referência a imagem (verificar)
);
GO

CREATE TABLE autor(
	id_autor		INT				NOT NULL	IDENTITY(1,1)	PRIMARY KEY,
	nm_autor		VARCHAR(15)		NOT NULL,
	--sobrnm_autor	VARCHAR(15)		NOT NULL, 
	--nacionalidade	VARCHAR(15)		NOT NULL
);
GO

CREATE TABLE editora(
	id_editora		INT			NOT NULL	IDENTITY(1,1)		PRIMARY KEY,
	nm_editora		VARCHAR(70) NOT NULL,	
);
GO

CREATE TABLE obra(
	id_obra					INT				NOT NULL	IDENTITY(1,1)	PRIMARY KEY,
	id_autor				INT				NOT NULL,
	id_editora				INT				NOT NULL,	
	nm_obra					VARCHAR(50)		NOT NULL,
	descricao_obra			VARCHAR(1800),
	ano_publi				VARCHAR(4)		NOT NULL,					
	edicao_obra				INT,
	qtd_pagina				INT				NOT NULL,
	tombo					VARCHAR(5)		NOT NULL,
	genero					VARCHAR(30)		NOT NULL,
	qtd_obra				INT, 						-- verificar a necessidade pode ser definido na consulta apenas
	status_obra				INT				NOT NULL,
	categoria				VARCHAR(40)		NOT NULL,
	idioma					VARCHAR(20)
	CONSTRAINT id_autor_autor			FOREIGN KEY (id_autor)				REFERENCES autor				(id_autor),
	CONSTRAINT id_editora_editora		FOREIGN KEY	(id_editora)			REFERENCES editora				(id_editora)	
);
GO

--tabela de tombos com localização e livro (colunas)
CREATE TABLE tombos(
	id_tombos 		int 	        NOT NULL	IDENTITY(1,1) 	PRIMARY KEY,
	id_obra			int 	        NOT NULL, 
	localizacao 	VARCHAR(10),
	CONSTRAINT 	id_obra	 FOREIGN KEY	(id_obra)	REFERENCES obra	(id_obra)
);
GO

CREATE TABLE endereco (
	id_endereco		INT			NOT NULL		IDENTITY(1,1)	PRIMARY KEY,
	cep				NUMERIC(8)	NOT NULL,
	logradouro		VARCHAR(12)	NOT NULL, -- rua, avenida, etc
	nm_logradouro	VARCHAR(50) NOT NULL,
	num_logradouro	VARCHAR(12) NOT NULL,
	cidade			VARCHAR(20)	NOT NULL,
	bairro			VARCHAR(20)	NOT NULL,
	estado			VARCHAR(20) NOT NULL
);
GO

CREATE TABLE usuario(
	id_usu					INT			NOT NULL	IDENTITY(1,1)	PRIMARY KEY,
	nm_usu					VARCHAR(25)	NOT NULL,
	email_usu				VARCHAR(40)	NOT NULL,
	cel_usu					VARCHAR(13),
	registro_identificador	INT,
	id_endereco				INT,
	CONSTRAINT id_endereco_end		FOREIGN KEY	(id_endereco)	REFERENCES endereco	(id_endereco)
);
GO


CREATE TABLE usuario_inadimplente(
	idusuario_inadimplente		INT				NOT NULL		IDENTITY(1,1)	PRIMARY KEY,
	id_usu						INT				NOT NULL,
	valor_multa					NUMERIC(3,2)	NOT NULL,
	devendo_bool				BIT				NOT NULL,
	multa_paga_data				DATE			NOT NULL,
	CONSTRAINT usuario_id_inadimplente	FOREIGN KEY (id_usu)	REFERENCES usuario (id_usu)

);
GO

CREATE TABLE item_emprestimo(
	iditem_emprestimo			INT				NOT NULL	IDENTITY(1,1)		PRIMARY KEY,
	qtd_item					INT				NOT NULL,
	data_emp					DATE			NOT NULL,
	dt_hora_emprest				SMALLDATETIME	NOT	NULL,
	dt_hora_devolucao			SMALLDATETIME	NOT	NULL,
	id_usu						int				not null,
	CONSTRAINT usuario_id_item_emprestimo	FOREIGN KEY (id_usu)	REFERENCES usuario (id_usu)
);
GO

CREATE TABLE emprestimo (
	id_emp					INT					NOT NULL	IDENTITY(1,1)		PRIMARY KEY,
	id_usu					INT					NOT NULL,
	iditem_emprestimo		INT					NOT NULL,	
	dt_hora_devolucao		SMALLDATETIME		NOT NULL,
	dt_reserva				DATE				NOT NULL,
	hora_emp				DATE				NOT NULL,
	emprestimo_concluido	BIT					NOT NULL,
	CONSTRAINT item_iditem_emprestimo	FOREIGN KEY (iditem_emprestimo)	REFERENCES item_emprestimo (iditem_emprestimo),
	CONSTRAINT usuario_id_emprestimo	FOREIGN KEY (id_usu)	REFERENCES usuario (id_usu)
);
GO

CREATE TABLE usuario_senha(
	idsuario_senha				INT			NOT NULL	IDENTITY(1,1)	PRIMARY KEY,
	id_usu						INT			NOT NULL,
	senha						VARCHAR(8)	NOT NULL,
	CONSTRAINT usuario_id_senha	FOREIGN KEY (id_usu)	REFERENCES usuario (id_usu)
);
GO


CREATE TABLE moderador(
	idmoderador INT			NOT NULL	IDENTITY(1,1)	PRIMARY KEY,
	id_usu		INT			NOT NULL,
	CONSTRAINT usuario_id_moderador	FOREIGN KEY (id_usu)	REFERENCES usuario (id_usu)
);
GO

CREATE TABLE reserva(
	id_reserva				INT 				NOT NULL	IDENTITY(1,1)	PRIMARY KEY,
	dt_hora_reserva			SMALLDATETIME		NOT NULL,	
	prazo_reserva			INT 				NOT NULL,
	situacao_reserva		VARCHAR(12)			NOT NULL,
	id_usu					INT					NOT NULL,
	id_obra					INT					NOT NULL,
	CONSTRAINT	id_usuario_reserva 	FOREIGN KEY (id_usu) REFERENCES usuario (id_usu),
	CONSTRAINT	id_obra_reserva 	FOREIGN KEY (id_obra) REFERENCES obra (id_obra)		
);


CREATE TABLE pendencia(
	id_usuario_pendencia		INT				NOT NULL	IDENTITY(1,1)	PRIMARY KEY,
	id_usu						INT				NOT NULL,
	valor_multa					NUMERIC(3,2)	NOT NULL,
	pendente_bool				BIT				NOT NULL,
	CONSTRAINT	id_usuario_pendencia 	FOREIGN KEY (id_usu) REFERENCES usuario (id_usu)		
);
GO



alter table obra
alter column descricao_obra varchar(1800) null;

alter table obra
alter column edicao_obra int null;

alter table obra 
alter column tombo varchar(5) null;

alter table obra 
alter column status_obra varchar(12) null;

alter table obra 
drop column qtd_pagina, genero, idioma;

ALTER TABLE reserva
ADD CONSTRAINT id_obra_reserva FOREIGN KEY (id_obra) REFERENCES obra(id_obra);


alter table autor
drop column sobrnm_autor;

alter table autor
drop column nacionalidade;

alter table endereco
alter column cep  int not null;

alter table imagem_obra
drop column nm_arquivo ;

alter table imagem_obra
add urlimg varchar(1000) not null ;

alter table imagem_obra
drop column vb_imagem;

alter table imagem_obra
add id_obra int;

alter table obra 
drop column qtd_obra;

--incluir constraint
alter table pendencia
alter column valor_multa float not null;

alter table usuario_inadimplente
alter column valor_multa float not null;

alter table autor
alter column nm_autor varchar(60);

CREATE TABLE obra_autor(
	id int primary key not null  identity(1,1),
	id_autor int not null, 
	id_obra int not null,
	constraint id_obra_obraautor FOREIGN KEY (id_obra) REFERENCES obra (id_obra),
	constraint  id_autor_obraautor FOREIGN KEY (id_autor) REFERENCES autor (id_autor)
	);

alter table obra
DROP CONSTRAINT id_autor_autor;

alter table obra
drop column id_autor;

alter table reserva
drop constraint id_obra_reserva;

alter table reserva
drop column id_obra;

create table reserva_obra(
	id int primary key  not null  identity(1,1),
	id_reserva int not null, 
	id_obra int not null,
	constraint id_reserva_obrareserva FOREIGN KEY (id_reserva) REFERENCES reserva (id_reserva),
	constraint  id_reserva_obraobra FOREIGN KEY (id_obra) REFERENCES obra (id_obra)
);

--- executar essa semana na base da etec
alter table emprestimo 
drop column emprestimo_concluido; 

alter table emprestimo 
add dt_emprestimo_concluido smalldatetime not null; 




alter table item_emprestimo 
drop constraint usuario_id_item_emprestimo;

alter table item_emprestimo 
drop column id_usu;

alter table item_emprestimo 
add id_obra int not null;

alter table item_emprestimo 
add constraint obra_id_item_emprestimo FOREIGN KEY (id_obra) REFERENCES obra (id_obra);

alter table item_emprestimo 
add id_usuario int not null;

alter table item_emprestimo 
add constraint usuario_id_item_emprestimo FOREIGN KEY (id_usuario) REFERENCES usuario (id_usu);

alter table usuario
alter column registro_identificador numeric(19,0) not null


alter table pendencia 
drop constraint id_usuario_pendencia;

alter table pendencia 
drop column id_usu;


alter table pendencia 
add idusuario_inadimplente int not null;

alter table pendencia 
add constraint pendencia_id_inadimplente FOREIGN KEY (idusuario_inadimplente) REFERENCES usuario_inadimplente (idusuario_inadimplente);

alter table pendencia
alter column registro_identificador numeric(19,0) not null

sp_help pendencia


