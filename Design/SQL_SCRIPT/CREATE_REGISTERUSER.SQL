CREATE TABLE public.register_users (
	username varchar(50) NULL,
	address varchar(100) NULL,
	province varchar(30) NULL,
	zipcode varchar(10) NULL,
	"password" varchar(50) NULL,
	create_date timestamp(0) NULL,
	update_date timestamp(0) NULL,
	refercode varchar(50) NULL,
	classify varchar(50) NULL,
	phoneno varchar(30) NULL,
	salary numeric(16,2) NULL
);