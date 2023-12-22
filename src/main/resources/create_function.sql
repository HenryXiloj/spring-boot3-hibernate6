CREATE OR REPLACE FUNCTION get_sum(a INT, b INT)
RETURNS INT AS $$
DECLARE
  total_value INT;
BEGIN
  total_value := a + b;
  RETURN total_value;
END;
$$ LANGUAGE plpgsql;