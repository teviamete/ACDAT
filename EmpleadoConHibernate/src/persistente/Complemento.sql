USE Ejemplos
GO
Create Table Cuentos (
	ID SmallInt Not NULL Constraint PKCuento Primary Key,
	Titulo Varchar(40) Not NULL,
	Autor VarChar(40) NULL Constraint DF_Autor Default 'Popular',
	Tema VarChar (20) NULL
)
GO
CREATE Table Criaturitas_Cuentos (
	listaLectores_Id TinyInt Not NULL,
	listaCuentos_ID SmallInt Not NULL,
	Constraint PK_Lecturas Primary Key (listaLectores_Id,listaCuentos_ID),
	Constraint FKLecturasCriaturitas Foreign Key (listaLectores_Id) REFERENCES Criaturitas On Delete No Action,
	Constraint FKLecturasCuentos Foreign Key (listaCuentos_ID) REFERENCES Cuentos On Delete No Action
)

Insert INTO Cuentos (ID, Titulo, Autor, Tema) VALUES
	(1,'La Sirenita','H. C. Andersen','Amores toxicos'),
	(2,'El Patito Feo','H. C. Andersen','Bullying'),
	(4,'El flautista de Hamelin','Hermanos Grimm','Grupies'),
	(7,'Caperucita roja','Charles Perrault','TransEspecismo'),
	(10,'Garbancito',default,'Alimentacion sana'),
	(11,'La buena pipa','Moebius','Bucles infinitos'),
	(13,'El gato con botas','Charles Perrault','Revolucionarios'),
	(14,'Los tres cerditos',default,'Arquitectura')

GO

Insert INTO Criaturitas_Cuentos(listaLectores_Id,listaCuentos_ID) VALUES
	(11,2),(11,4),(11,7),(2,11),(9,1),(9,7),(4,1),(4,2),(6,1),(6,11),(21,7)