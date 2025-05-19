create sequence bm_id_seq start with 1 increment by 50;

create table bookmarks (
	id bigint default nextval('bm_id_seq') not null, 
	title varchar(255) not null, 
	url varchar(255) not null, 
	created_at timestamp,
	primary key (id)
);

ALTER TABLE bookmarks ADD COLUMN delflag CHAR(1) default 'N';