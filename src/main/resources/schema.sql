CREATE TABLE IF NOT EXISTS person (
  Id INTEGER PRIMARY KEY NOT NULL,
  document_national INTEGER NOT NULL,
  type_document VARCHAR(50) NOT NULL,
  age INTEGER NOT NULL,
  name VARCHAR(100) NOT NULL,
  gender VARCHAR(20)
  );

CREATE TABLE IF NOT EXISTS address (
  id INTEGER PRIMARY KEY NOT NULL,
  street VARCHAR(20) NOT NULL,
  city VARCHAR(20) NOT NULL,
  country VARCHAR (20) NOT NULL,
  postal_code INTEGER,
  person_id INTEGER NOT NULL
);

ALTER TABLE address
  ADD CONSTRAINT address_person_fk
  FOREIGN KEY (person_id)
  REFERENCES person(id);

CREATE TABLE IF NOT EXISTS contact (
  id INTEGER PRIMARY KEY NOT NULL,
  mail VARCHAR(50) NOT NULL,
  number_call VARCHAR(50) NOT NULL,
  person_id INTEGER NOT NULL
);

ALTER TABLE contact
  ADD CONSTRAINT contact_person_fk
  FOREIGN KEY (person_id)
  REFERENCES person(id);
