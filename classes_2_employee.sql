--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.2
-- Dumped by pg_dump version 9.5.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: employee; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE employee (
    id integer NOT NULL,
    name character varying(50),
    surname character varying(50),
    depname character varying(50),
    salary double precision
);


ALTER TABLE employee OWNER TO postgres;

--
-- Name: employee_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE employee_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE employee_id_seq OWNER TO postgres;

--
-- Name: employee_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE employee_id_seq OWNED BY employee.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY employee ALTER COLUMN id SET DEFAULT nextval('employee_id_seq'::regclass);


--
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO employee (id, name, surname, depname, salary) VALUES (1, 'John', 'Rambo', 'developer', 35000);
INSERT INTO employee (id, name, surname, depname, salary) VALUES (2, 'John ', 'McClain', 'developer', 40000);
INSERT INTO employee (id, name, surname, depname, salary) VALUES (3, 'Jackie', 'Chan', 'developer', 37000);
INSERT INTO employee (id, name, surname, depname, salary) VALUES (4, 'Jason', 'Statham', 'manager', 50000);
INSERT INTO employee (id, name, surname, depname, salary) VALUES (5, 'Will', 'Smith', 'manager', 55000);


--
-- Name: employee_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('employee_id_seq', 5, true);


--
-- Name: PK_EMPLOYEE_ID; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY employee
    ADD CONSTRAINT "PK_EMPLOYEE_ID" PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

