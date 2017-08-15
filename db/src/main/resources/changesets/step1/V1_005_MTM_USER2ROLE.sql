--liquibase formatted sql logicalFilePath:V1_005_MTM_USER2ROLE.sql
--changeset sanasov:1.5 runOnChange:true context:prod
CREATE TABLE hp.mtm_user2role (
  user_id bigint NOT NULL REFERENCES hp.user (id) ON DELETE CASCADE ON UPDATE CASCADE,
  role_id bigint NOT NULL REFERENCES hp.role (id) ON DELETE CASCADE ON UPDATE CASCADE
);