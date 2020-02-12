DROP TABLE IF EXISTS usuarios;
 
CREATE TABLE usuarios (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  usuario VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  role VARCHAR(250)
);
 
INSERT INTO usuarios (usuario, password, role) VALUES
  ('omar', '12345', 'USER'),
  ('admin', '12345', 'ADMIN');