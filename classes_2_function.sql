CREATE FUNCTION income_tax(salary double precision) RETURNS real AS $$
BEGIN
	IF salary < 1000 THEN
		RETURN salary*0.06;
	ELSE
		RETURN salary*0.16;
	END IF;
END;
$$ LANGUAGE plpgsql;
