use DB_PAMYS;

INSERT INTO categorys (active,description,name) VALUES (1,"Zapatos de Bebe","Bebe");
INSERT INTO categorys (active,description,name) VALUES (1,"Zapatos de Ninos","Ninos");

INSERT INTO roles (name) VALUES ("ROLE_USER");
INSERT INTO roles (name) VALUES ("ROLE_ADMIN");


INSERT INTO clients (username,_password,first_name,last_name,address,phone,email,zip_code,active,id_rol) VALUES ("maximope","$2a$10$2KokS2bM7xXpiWtvAebdCePVA0cbJcMdzAMiMImMOmJxnOu7YhZdW","maximo junior","apaza chirhuana","mz M lt 15 Eden del manantial","928644700","maximopeoficiales@gmail.com",5001,1,1);

INSERT INTO clients (username,_password,first_name,last_name,address,phone,email,zip_code,active,id_rol) VALUES ("luis","$2a$10$2KokS2bM7xXpiWtvAebdCePVA0cbJcMdzAMiMImMOmJxnOu7YhZdW","luis","perez","direccion de prueba","92864471","luis@gmail.com",5001,1,2);


INSERT INTO document_types (doctype) VALUES ("DNI");
INSERT INTO document_types (doctype) VALUES ("RUC");
INSERT INTO document_types (doctype) VALUES ("CARNET EXTRANJERO");

INSERT INTO vendors (company,description) VALUES ("BATA","EMPRESA NUMERO 1 EN EL PERU");
INSERT INTO vendors (company,description) VALUES ("NIKE","EMPRESA EXTRANJERA ZAPATERA");
INSERT INTO vendors (company,description) VALUES ("Converse","Marca reconocida en latino America");

INSERT INTO payment_types (type) VALUES ("Contra Entrega");
INSERT INTO payment_types (type) VALUES ("Transferencia");

INSERT INTO order_status (status) VALUES ("on-hold");
INSERT INTO order_status (status) VALUES ("completed");
INSERT INTO order_status (status) VALUES ("pending");
INSERT INTO order_status (status) VALUES ("completed");
INSERT INTO order_status (status) VALUES ("cancelled");

INSERT INTO products (id_category,id_vendor,name ,price,sale_price ,description,thumbnail_url,stock,date_created) VALUES (1,1,"Converse Ct As High Street",203.9,200.0,"Zapatillas de tobillo con cordones para hombre de Converse","https://mister-mango.omni.la/ProductCatalog/Workspace.CWDQQL6GUIJMS/ProductCatalog.CZGGMCYNRPA6E/160x240/CZGKQOS35CTRI.jpg",100,"2020-01-12");

INSERT INTO products (id_category,id_vendor,name,price,sale_price ,description,thumbnail_url,stock,date_created) VALUES (2,2,"Cat Hex Mid",279.9,250.0,"Zapatilla Caterpilar","https://mister-mango.omni.la/ProductCatalog/Workspace.CWDQQL6GUIJMS/ProductCatalog.CX2NMGBOMTGPY/1500x1500/CYP6TEWIZBW6A.jpg",200,"2020-01-12");

INSERT INTO product_images (id_product,url) VALUES (1,"https://mister-mango.omni.la/ProductCatalog/Workspace.CWDQQL6GUIJMS/ProductCatalog.CZGGMCYNRPA6E/1500x1500/CZGKQOS32NF5U.jpg");

INSERT INTO product_images (id_product,url) VALUES (1,"https://mister-mango.omni.la/ProductCatalog/Workspace.CWDQQL6GUIJMS/ProductCatalog.CZGGMCYNRPA6E/1500x1500/CZGKQOS3YSRBI.jpg");

INSERT INTO product_images (id_product,url) VALUES (2,"https://mister-mango.omni.la/ProductCatalog/Workspace.CWDQQL6GUIJMS/ProductCatalog.CX2NMGBOMTGPY/1500x1500/CYP6TEWJVXKVS.jpg");

INSERT INTO product_images (id_product,url) VALUES (2,"https://mister-mango.omni.la/ProductCatalog/Workspace.CWDQQL6GUIJMS/ProductCatalog.CX2NMGBOMTGPY/1500x1500/CYP6TEWJUDPU6.jpg");


INSERT INTO orders (id_client,subtotal,igv,total,shipping_address,comment,zip_code,id_document_type,id_order_status,id_payment_status,date_created) VALUES (1,600,18,618,"Direccion de entrega de prueba","Por favor dejar los zapatos en mi puerta",5001,1,1,1,"2021-01-12");

INSERT INTO orders (id_client,subtotal,igv,total,shipping_address,comment,zip_code,id_document_type,id_order_status,id_payment_status,date_created) VALUES (1,800,18,818,"Av La Molina 202","Por favor tocar el timbre antes de la entrega",5661,1,1,1,"2021-01-28");

INSERT INTO order_details (id_order,id_product,price,quantity) VALUES (1,1,200,3);

INSERT INTO order_details (id_order,id_product,price,quantity) VALUES (2,2,400,2);


INSERT INTO vouchers (amount,id_client,id_operation,id_client_account,id_store_account,image_url,created_at) VALUES (3,1,1321321,1,1,"https://www.printablesample.com/wp-content/uploads/2017/04/gift-vouchers-8.jpg","2021-01-29");

UPDATE orders SET id_voucher=1 WHERE id =1;

