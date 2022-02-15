
INSERT INTO departamentos (nombre, ubicacion) VALUES ("RECURSOS HUMANOS", "Planta 1");
INSERT INTO departamentos (nombre, ubicacion) VALUES ("INFORMÁTICA", "Planta 2");
INSERT INTO departamentos (nombre, ubicacion) VALUES ("DIRECCION", "Planta 4");


INSERT INTO empleados (dni, nombre, salario, telefono, departamento_id) VALUES ("12345678A", "Judith", 2300, 612345678, 1);
INSERT INTO empleados (dni, nombre, salario, telefono, departamento_id) VALUES ("91011121B", "David", 1500, 678897766, 2);
INSERT INTO empleados (dni, nombre, salario, telefono, departamento_id) VALUES ("31415161C", "Alvaro", 3300, 654321244, 1);
INSERT INTO empleados (dni, nombre, salario, telefono, departamento_id) VALUES ("71819202D", "Irene", 1890, 678990055, 2);
INSERT INTO empleados (dni, nombre, salario, telefono, departamento_id) VALUES ("12223242E", "Alba", 2080, 655221144, 1);


INSERT INTO jefes (dni, nombre, salario, telefono, departamento_id) VALUES ("22556677F", "Maria", 9500, 656467271, 2);
INSERT INTO jefes (dni, nombre, salario, telefono, departamento_id) VALUES ("88991010G", "Pablo", 6800, 163757437, 3);
INSERT INTO jefes (dni, nombre, salario, telefono, departamento_id) VALUES ("11121213H", "Alex", 4353, 865747474, 2);
INSERT INTO jefes (dni, nombre, salario, telefono, departamento_id) VALUES ("98745688I", "Rober", 5359, 746372849, 3);
INSERT INTO jefes (dni, nombre, salario, telefono, departamento_id) VALUES ("44556600J", "Loly", 7543, 74634217, 1);

INSERT INTO login (dni, contraseña) VALUES ("22556677F","12345");
INSERT INTO login (dni, contraseña) VALUES ("88991010G","6789");
INSERT INTO login (dni, contraseña) VALUES ("98745688I","101112");

