--liquibase formatted sql logicalFilePath:V1_004_TB_ROLE.sql
--changeset sanasov:1.4 runOnChange:true context:prod
CREATE TABLE hp.role (
  role_id   INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  role_value VARCHAR(45) UNIQUE  NOT NULL,
  user_id INT(11)
);