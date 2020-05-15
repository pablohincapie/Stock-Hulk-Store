-- Database: BaseDatosVentas

-- DROP DATABASE "BaseDatosVentas";

CREATE DATABASE "BaseDatosVentas"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Spain.1252'
    LC_CTYPE = 'Spanish_Spain.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

COMMENT ON DATABASE "BaseDatosVentas"
    IS 'Creo base de datos para la gestión de ventas e inventario.';
	
-- Table: public.compra

-- DROP TABLE public.compra;

CREATE TABLE public.compra
(
    id_compra serial,
    descripcion varchar(100) NOT NULL,
    referencia varchar(20) NOT NULL,
    cantidad int NOT NULL,
    precio double precision NOT NULL,
    total double precision NOT NULL,
    fecha_compra date NOT NULL,
    CONSTRAINT compra_pk PRIMARY KEY (id_compra)
)

TABLESPACE pg_default;

ALTER TABLE public.compra
    OWNER to postgres;

-- Table: public.producto

-- DROP TABLE public.producto;

CREATE TABLE public.producto
(
    id_producto serial,
    descripcion varchar(100) NOT NULL,
    cantidad int NOT NULL,
    referencia varchar(20) NOT NULL,
    precio double precision NOT NULL,
    CONSTRAINT producto_pk PRIMARY KEY (id_producto)
)

TABLESPACE pg_default;

ALTER TABLE public.producto
    OWNER to postgres;

Create TABLE public.venta
(
    id_venta serial,
    descripcion varchar(100) NOT NULL,
    cantidad int NOT NULL,
    referencia varchar(20) NOT NULL,
   precio double precision NOT NULL,
    total double precision NOT NULL,
    fecha_venta date NOT NULL,
    CONSTRAINT venta_pk PRIMARY KEY (id_venta)
)

TABLESPACE pg_default;

ALTER TABLE public.venta
    OWNER to postgres;	
	
Insert into producto values (1,'Juguetes',10, '012',80000);
Insert into producto values (2,'Comics',10, '018',16000);