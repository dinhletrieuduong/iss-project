-- Create admin user for the system
-- In security issues, we don't allow ourselves permission to use administrator account
-- for creating any tables.
-- First, it can cause conflicting problems for other systems running in the same database server.
-- Second, one wrong step cause thousand times of pain (developers pain, dba pain, leaders pain, product owner pain ...)

CREATE USER courseman IDENTIFIED BY courseman;

GRANT CONNECT TO courseman;
GRANT ALL PRIVILEGES TO courseman;
-- Configure OLS
GRANT LBAC_DBA TO courseman;
GRANT EXECUTE ON sa_sysdba TO courseman;
GRANT EXECUTE ON to_lbac_data_label  TO courseman;

EXEC LBACSYS.CONFIGURE_OLS;
EXEC LBACSYS.OLS_ENFORCEMENT.ENABLE_OLS;

