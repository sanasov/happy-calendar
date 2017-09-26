--liquibase formatted sql logicalFilePath:V1_007_EVENT_CATEGORY.sql
--changeset sanasov:1.7 runOnChange:true context:prod

CREATE TABLE hp.event_event (
  id             BIGSERIAL                PRIMARY KEY,
  title          VARCHAR(200)             NOT NULL,
  description    VARCHAR(1000)            NOT NULL,
  create_date    TIMESTAMP                DEFAULT now()
);