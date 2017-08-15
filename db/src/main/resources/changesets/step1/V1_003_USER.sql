--liquibase formatted sql logicalFilePath:V1_003_USER.sql
--changeset sanasov:1.3 runOnChange:true context:prod
CREATE TABLE hp.user (
  id             BIGSERIAL PRIMARY KEY,
  login          VARCHAR(100) UNIQUE     NOT NULL,
  password       VARCHAR(64)             NOT NULL,
  user_name      VARCHAR(200),
  user_last_name VARCHAR(200),
  birthday       TIMESTAMP               NOT NULL,
  create_date    TIMESTAMP DEFAULT now()
);