--用户信息
insert  into admin_user(id,address,create_time,id_card_num,login_name,password,phone_num,sex,state,update_time,user_name,wxchat_num,create_user) values (1,'云南昭通','2017-06-04 15:48:14','5321000000000','admin','49f3e402c442d89a0158561dacdbda2a','18888888888','1','1','2017-06-04 15:48:46','管理员','111',1);


--基本账户信息
insert  into base_account(id,totalfund,account_name,create_time,type_no,update_time) values (1,0,'支付宝账户','2017-06-03 12:16:41','888888','2017-06-03 12:16:54');
insert  into base_account(id,totalfund,account_name,create_time,type_no,update_time) values (2,0,'微信账户','2017-06-03 12:17:05','666666','2017-06-03 12:17:11');
insert  into base_account(id,totalfund,account_name,create_time,type_no,update_time) values (3,0,'现金账户','2017-06-03 12:17','999999','2017-06-03 12:17:50');

insert  into permission (id,mod_code,mod_name,parent_mode_name,prem_state) values (1,'ADD_USER','添加用户','用户管理','1');
insert  into permission (id,mod_code,mod_name,parent_mode_name,prem_state) values (2,'DEL_USER','删除用户','用户管理','1');
insert  into permission (id,mod_code,mod_name,parent_mode_name,prem_state) values (3,'DEL_USER','编辑用户','用户管理','1');
insert  into permission (id,mod_code,mod_name,parent_mode_name,prem_state) values (4,'ADD_ROLE','添加角色','角色管理','1');
insert  into permission (id,mod_code,mod_name,parent_mode_name,prem_state) values (5,'DEL_ROLE','删除角色','角色管理','1');
insert  into permission (id,mod_code,mod_name,parent_mode_name,prem_state) values (6,'ADD_GOODS','发布商品','进销管理','1');
insert  into permission (id,mod_code,mod_name,parent_mode_name,prem_state) values (7,'DEL_GOODS','删除商品','进销管理','1');
insert  into permission (id,mod_code,mod_name,parent_mode_name,prem_state) values (8,'ADD_SUPLIER','添加供货商','进销管理','1');
insert  into permission (id,mod_code,mod_name,parent_mode_name,prem_state) values (9,'DEL_SUPLIER','删除供货商','进销管理','1');
insert  into permission (id,mod_code,mod_name,parent_mode_name,prem_state) values (10,'ADD_INVIOC','商品进货','进销管理','1');




