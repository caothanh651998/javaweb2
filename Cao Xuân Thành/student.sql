create schema `student`;

create table `studen`(
	`id` INT AUTO_INCREMENT,
    `name` NVARCHAR(50),
    `ngaysinh` NVARCHAR(20),
    `address` NVARCHAR(50),
    primary key(id)
);

