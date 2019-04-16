CREATE TABLE employee (
    id integer NOT NULL,
    name character varying(50),
    surname character varying(50),
    depname character varying(50),
    salary double precision
);


CREATE SEQUENCE employee_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

SELECT pg_catalog.setval('employee_id_seq', 5, true);

ALTER TABLE employee
    ADD CONSTRAINT "PK_EMPLOYEE_ID" PRIMARY KEY (id);




INSERT INTO employee (id, name, surname, depname, salary) VALUES (1, 'John', 'Rambo', 'developer', 35000);
INSERT INTO employee (id, name, surname, depname, salary) VALUES (2, 'John ', 'McClain', 'developer', 40000);
INSERT INTO employee (id, name, surname, depname, salary) VALUES (3, 'Jackie', 'Chan', 'developer', 37000);
INSERT INTO employee (id, name, surname, depname, salary) VALUES (4, 'Jason', 'Statham', 'manager', 50000);
INSERT INTO employee (id, name, surname, depname, salary) VALUES (5, 'Will', 'Smith', 'manager', 55000);
