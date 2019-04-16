
CREATE TABLE emp_audit(
operation char(1) NOT NULL,
stamp timestamp NOT NULL,
pguser text NOT NULL,
id integer NOT NULL,
name character varying(50),
surname character varying(50),
depname character varying(50),
salary double precision);

CREATE OR REPLACE FUNCTION process_emp_audit() RETURNS TRIGGER AS $emp_audit_fn$
BEGIN
--
-- Create a row in emp_audit to reflect the operation performed on emp,
-- make use of the special variable TG_OP to work out the operation.
--
IF (TG_OP = 'DELETE') THEN
	INSERT INTO emp_audit SELECT 'D', now(), user, OLD.*;
	RETURN OLD;

ELSIF (TG_OP = 'INSERT') THEN
	INSERT INTO emp_audit SELECT 'I', now(), user, NEW.*;
	RETURN NEW;
END IF;
RETURN NULL; -- result is ignored since this is an AFTER trigger
END;
$emp_audit_fn$ LANGUAGE plpgsql;


CREATE TRIGGER emp_audit_trig
AFTER INSERT OR DELETE ON employee
FOR EACH ROW EXECUTE PROCEDURE process_emp_audit();