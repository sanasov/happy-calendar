--liquibase formatted sql logicalFilePath:V1_008_EVENT.sql
--changeset sanasov:1.8 runOnChange:true context:prod

CREATE TABLE hp.event (
  id             BIGSERIAL                PRIMARY KEY,
  title          VARCHAR(200)             NOT NULL,
  description    VARCHAR(1000)            NOT NULL,
  category_id    BIGINT                   NOT NULL REFERENCES hp.event_category (id) ON DELETE CASCADE ON UPDATE CASCADE,
  date_time      TIMESTAMP                NOT NULL,
  create_date    TIMESTAMP                DEFAULT now()
);