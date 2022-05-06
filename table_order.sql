-- Table: public.Order

-- DROP TABLE IF EXISTS public."Order";

CREATE TABLE IF NOT EXISTS public."Order"
(
    id integer NOT NULL DEFAULT nextval('"Order_id_seq"'::regclass),
    product_id integer[] NOT NULL,
    name_client character varying COLLATE pg_catalog."default" NOT NULL,
    surname_client character varying COLLATE pg_catalog."default" NOT NULL,
    middlename_client character varying COLLATE pg_catalog."default" NOT NULL,
    phonenumber_client integer NOT NULL,
    date_order date NOT NULL,
    price_order numeric NOT NULL,
    status_order text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Order_pkey" PRIMARY KEY (id),
    CONSTRAINT fk_order FOREIGN KEY (product_id)
        REFERENCES public."Product" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Order"
    OWNER to postgres;