--liquibase formatted sql logicalFilePath:V1_004_ROLE.sql
--changeset sanasov:1.4 runOnChange:true context:prod
CREATE TABLE hp.role (
  id  BIGSERIAL PRIMARY KEY,
  role_value VARCHAR(45) UNIQUE  NOT NULL
);