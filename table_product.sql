-- Table: public.Product

-- DROP TABLE IF EXISTS public."Product";

CREATE TABLE IF NOT EXISTS public."Product"
(
    id integer[] NOT NULL,
    category_id integer NOT NULL,
    name_product character varying COLLATE pg_catalog."default" NOT NULL,
    price_product numeric NOT NULL,
    CONSTRAINT "Product_pkey" PRIMARY KEY (id),
    CONSTRAINT category_id_fk FOREIGN KEY (category_id)
        REFERENCES public."Category" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Product"
    OWNER to postgres;