--liquibase formatted sql logicalFilePath:V1_009_EVENT_DATA.sql
--changeset sanasov:1.9 runOnChange:true context:prod

INSERT INTO hp.category_event (title, description) VALUES ('В первый раз', 'События, которые произошли впервые');
INSERT INTO hp.category_event (title, description)
VALUES ('Последние события', 'Например, последний раз был у бабушки в июне 2016');


INSERT INTO hp.event (category_id, title, description, date_time)
VALUES (1, 'В первый раз был на море', 'Мы отдыхали в Лазаревском 10 дней', '1995-07-27 16:17:59.195591');
INSERT INTO hp.event (category_id, title, description, date_time)
VALUES (2, 'Полседний раз был у бабушки', 'Приехал к ней, когда была свадьба у Статса', '2016-09-26 16:17:59.267493');

INSERT INTO hp.event (category_id, title, description, date_time)
VALUES (1, 'Пример в первый раз', '', '1995-07-27 16:17:59.195591');
INSERT INTO hp.event (category_id, title, description, date_time)
VALUES (2, 'Пример в последний раз', '', '2016-09-26 16:17:59.267493');