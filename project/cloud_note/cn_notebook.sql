/*CREATE TABLE cn_notebook (
	cn_notebook_id VARCHAR(100) PRIMARY KEY,
	cn_user_id VARCHAR(100)  NULL ,
	cn_notebook_type_id VARCHAR(10) NULL ,
	cn_notebook_name VARCHAR(500) NULL ,
	cn_notebook_desc TEXT not null,
	cn_notebook_createtime  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);*/

insert into cn_notebook (cn_notebook_id, cn_user_id, cn_notebook_name,cn_notebook_desc) values ('091101', 'qwer', 'notebook_1','ddddddddddddddd');
insert into cn_notebook (cn_notebook_id, cn_user_id, cn_notebook_name,cn_notebook_desc) values ('091102', 'qwer', 'notebook_2','aaaaaaaaaaaaaaa');
insert into cn_notebook (cn_notebook_id, cn_user_id, cn_notebook_name,cn_notebook_desc) values ('091103', 'qwer', 'notebook_3','wwwwwwwwwwwwwwww');
insert into cn_notebook (cn_notebook_id, cn_user_id, cn_notebook_name,cn_notebook_desc) values ('091104', 'qwer', 'notebook_4','pppppppppppppppp');