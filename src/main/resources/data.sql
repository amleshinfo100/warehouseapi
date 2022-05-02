-- Inserting default products in box 1
insert into box (box_id) values (default);
insert into product (product_id, code, name, details, box_id) values (default, 'P1', 'product1' , 'product1 details', 1);
insert into product (product_id, code, name, details, box_id) values (default, 'P2', 'product2' , 'product2 details', 1);
insert into product (product_id, code, name, details, box_id) values (default, 'P3', 'product3' , 'product3 details', 1);

-- Inserting default products in box 2
insert into box (box_id) values (default);
insert into product (product_id, code, name, details, box_id) values (default, 'P4', 'product4', 'product4 details', 2);
insert into product (product_id, code, name, details, box_id) values (default, 'P5', 'product5', 'product5 details', 2);
insert into product (product_id, code, name, details, box_id) values (default, 'P6', 'product6', 'product6 details', 2);

