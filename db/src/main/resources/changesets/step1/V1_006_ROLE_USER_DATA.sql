--liquibase formatted sql logicalFilePath:V1_005_ROLE_USER_DATA.sql
--changeset sanasov:1.6 runOnChange:true context:prod

INSERT INTO hp.hp_user (id, login, password, user_name, user_last_name, birthday)
VALUES (1, 'igrey', 'q', 'Sergey', 'Anasov', '1991-02-28 11:18:55.005000');
INSERT INTO hp.role (id, role_value) VALUES (1, 'ROLE_ADMIN');
INSERT INTO hp.role (id, role_value) VALUES (2, 'ROLE_USER');

INSERT INTO hp.mtm_hp_user2role (user_id, role_id) VALUES (1, 1);
INSERT INTO hp.mtm_hp_user2role (user_id, role_id) VALUES (1, 2);


