--liquibase formatted sql logicalFilePath:V1_003_TB_USER.sql
--changeset sanasov:1.3 runOnChange:true context:prod
CREATE TABLE hp.user (
  user_id        INT(11) PRIMARY KEY     NOT NULL AUTO_INCREMENT,
  login          VARCHAR(100) UNIQUE     NOT NULL,
  fio            VARCHAR(600)            NOT NULL,
  password       VARCHAR(64)             NOT NULL,
  enabled        TINYINT(4) DEFAULT '1'  NOT NULL,
  create_date    DATETIME          DEFAULT CURRENT_TIMESTAMP,
  modify_date    DATETIME ON UPDATE CURRENT_TIMESTAMP
);