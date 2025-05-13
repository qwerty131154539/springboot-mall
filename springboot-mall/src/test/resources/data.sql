-- product
INSERT INTO product (product_name, category, image_url, price, stock, description, created_date, last_modified_date) VALUES ('長崎蛋糕脆條', 'COOKIE', 'https://www.zen-kashointw.com/wp-content/uploads/2022/06/cate_s_rask_02-1.jpg', 320, 10, '這是來自澳洲的蘋果！', '2022-03-19 17:00:00', '2022-03-22 18:00:00');
INSERT INTO product (product_name, category, image_url, price, stock, description, created_date, last_modified_date) VALUES ('幻月', 'COOKIE', 'https://www.zen-kashointw.com/wp-content/uploads/2022/06/cate_m_gengetsu_02-1.jpg', 350, 5, '這是來自日本北海道的蘋果！', '2022-03-19 18:30:00', '2022-03-19 18:30:00');
INSERT INTO product (product_name, category, image_url, price, stock, description, created_date, last_modified_date) VALUES ('抹茶幻月', 'COOKIE', 'https://www.zen-kashointw.com/wp-content/uploads/2022/08/3-3.webp', 370, 5, null, '2022-03-20 09:00:00', '2022-03-24 15:00:00');
INSERT INTO product (product_name, category, image_url, price, stock, description, created_date, last_modified_date) VALUES ('長崎蛋糕', 'SNACK', 'https://www.zen-kashointw.com/wp-content/uploads/2022/06/cate_s_castella_06-1.jpg', 380, 5, null, '2022-03-20 09:20:00', '2022-03-20 09:20:00');
INSERT INTO product (product_name, category, image_url, price, stock, description, created_date, last_modified_date) VALUES ('抹茶長崎蛋糕', 'SNACK', 'https://www.zen-kashointw.com/wp-content/uploads/2022/06/cate_s_sekkaso_01-1.jpg', 400, 3, '渦輪增壓，直列4缸，DOHC雙凸輪軸，16氣門', '2022-03-20 12:30:00', '2022-03-20 12:30:00');
INSERT INTO product (product_name, category, image_url, price, stock, description, created_date, last_modified_date) VALUES ('銅鑼燒', 'SNACK', 'https://www.zen-kashointw.com/wp-content/uploads/2022/06/cate_s_honwaka_02-1.jpg', 250, 2, null, '2022-03-21 20:10:00', '2022-03-22 10:50:00');

-- user
INSERT INTO users (email, password, created_date, last_modified_date) VALUES ('user1@gmail.com', '202cb962ac59075b964b07152d234b70', '2022-06-30 10:30:00', '2022-06-30 10:30:00');
INSERT INTO users (email, password, created_date, last_modified_date) VALUES ('user2@gmail.com', '202cb962ac59075b964b07152d234b70', '2022-06-30 10:40:00', '2022-06-30 10:40:00');

-- order, order_item
INSERT INTO `order` (user_id, total_amount, created_date, last_modified_date) VALUES (1, 2270, '2022-06-30 11:10:00', '2022-06-30 11:10:00');
INSERT INTO order_item (order_id, product_id, quantity, amount) VALUES (1, 1, 3, 960);
INSERT INTO order_item (order_id, product_id, quantity, amount) VALUES (1, 2, 2, 700);
INSERT INTO order_item (order_id, product_id, quantity, amount) VALUES (1, 5, 1, 400);

INSERT INTO `order` (user_id, total_amount, created_date, last_modified_date) VALUES (1, 370, '2022-06-30 12:03:00', '2022-06-30 12:03:00');
INSERT INTO order_item (order_id, product_id, quantity, amount) VALUES (2, 4, 1, 370);


