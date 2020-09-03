create table person (
   id serial primary key not null,
   username varchar(2000),
   password varchar(2000)
);

create table room (
   id serial primary key not null,
   name varchar(2000)
);

CREATE TABLE message
(
  id SERIAL primary key,
  content character varying(255),
  person_id bigint,
  room_id bigint,
  CONSTRAINT fk_message_p FOREIGN KEY (person_id)
      REFERENCES person (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_message_r FOREIGN KEY (room_id)
      REFERENCES room (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

-- insert into person (username, password) values ('Rustymattok', '123');
-- insert into room (name) values ('chat1');
-- insert into message (content,person_id,room_id) values ('privet drug',1,1)