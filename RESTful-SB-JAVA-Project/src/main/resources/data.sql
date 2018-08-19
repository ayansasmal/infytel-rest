-- insert into states
insert into tbl_state (id, code, name) values ('1','IN','Andhra Pradesh');
insert into tbl_state (id, code, name)  values ('2','IN','Arunachal Pradesh');
insert into tbl_state (id, code, name)  values('3','IN','Jammu & Kashmir');
insert into tbl_state (id, code, name)  values('4','IN','Himachal Pradesh');
insert into tbl_state (id, code, name)  values('5','IN','Haryana');
insert into tbl_state (id, code, name)  values('6','IN','Punjab');
insert into tbl_state (id, code, name)  values('7','IN','Telangana');
insert into tbl_state (id, code, name)  values('8','IN','Kerela');
insert into tbl_state (id, code, name)  values('9','IN','Odisha');
insert into tbl_state (id, code, name)  values('10','IN','Goa');
insert into tbl_state (id, code, name)  values('11','IN','Maharashtra');
insert into tbl_state (id, code, name)  values('12','IN','Madhya Pradesh');
insert into tbl_state (id, code, name)  values('13','IN','Uttar Pradesh');
insert into tbl_state (id, code, name)  values('14','IN','Bihar');
insert into tbl_state (id, code, name)  values('15','IN','West Bengal');
insert into tbl_state (id, code, name)  values('16','IN','Gujarat');
insert into tbl_state (id, code, name)  values('17','IN','Rajasthan');
insert into tbl_state (id, code, name)  values('18','IN','Uttarakhand');
insert into tbl_state (id, code, name)  values('19','IN','Jharkhand');
insert into tbl_state (id, code, name)  values('20','IN','Chattisgarh');
insert into tbl_state (id, code, name)  values('21','IN','Karnataka');
insert into tbl_state (id, code, name)  values('22','IN','Tamilnadu');
insert into tbl_state (id, code, name)  values('23','IN','Manipur');
insert into tbl_state (id, code, name)  values('24','IN','Mizoram');
insert into tbl_state (id, code, name)  values('25','IN','Meghalaya');
insert into tbl_state (id, code, name)  values('26','IN','Tripura');
insert into tbl_state (id, code, name)  values('27','IN','Sikkim');
insert into tbl_state (id, code, name)  values('28','IN','Assam');
insert into tbl_state (id, code, name)  values('29','IN','Nagaland');

-- insert into identityDetails
insert into tbl_identitydetails (document_id, expiry_date,identity_number,issue_date, issued_at, type_of_identity_document, first_name, last_name, date_of_birth) values 
('1','01/01/2040','P1234567','01/01/2018','delhi','passport','ayan','sasmal','18/10/1988');
insert into tbl_identitydetails (document_id, expiry_date,identity_number,issue_date, issued_at, type_of_identity_document, first_name, last_name, date_of_birth) values 
('2','','A1234567','','delhi','aadhaar','amit','sasmal','01/01/1980');
insert into tbl_identitydetails (document_id, expiry_date,identity_number,issue_date, issued_at, type_of_identity_document, first_name, last_name, date_of_birth) values 
('3','01/01/2035','P2345678','01/01/2015','mumbai','passport','sumit','sasmal','01/02/1990');
insert into tbl_identitydetails (document_id, expiry_date,identity_number,issue_date, issued_at, type_of_identity_document, first_name, last_name, date_of_birth) values 
('4','','A2345678','','chennai','aadhaar','test','test','01/02/1990');
insert into tbl_identitydetails (document_id, expiry_date,identity_number,issue_date, issued_at, type_of_identity_document, first_name, last_name, date_of_birth) values 
('5','01/01/2040','P3456789','01/01/2018','delhi','passport','dummy','test','01/01/1991');
insert into tbl_identitydetails (document_id, expiry_date,identity_number,issue_date, issued_at, type_of_identity_document, first_name, last_name, date_of_birth) values 
('6','','A3456789','','shimla','aadhaar','nikunj','jain','01/04/1990');
insert into tbl_identitydetails (document_id, expiry_date,identity_number,issue_date, issued_at, type_of_identity_document, first_name, last_name, date_of_birth) values 
('7','01/01/2035','P4567890','01/01/2015','mumbai','passport','firstname','lastname','01/04/1990');
insert into tbl_identitydetails (document_id, expiry_date,identity_number,issue_date, issued_at, type_of_identity_document, first_name, last_name, date_of_birth) values 
('8','','A4567890','','kolkata','aadhaar','test','customer','01/01/1988');

-- insert into sims
insert into tbl_sim (id, activation_date, sim_number) values ('1','','123412341234');
insert into tbl_sim (id, activation_date, sim_number) values ('2','','234523452345');
insert into tbl_sim (id, activation_date, sim_number) values ('3','','345634563456');
insert into tbl_sim (id, activation_date, sim_number) values ('4','','456745674567');
insert into tbl_sim (id, activation_date, sim_number) values ('5','','567856785678');
insert into tbl_sim (id, activation_date, sim_number) values ('6','','678967896789');
insert into tbl_sim (id, activation_date, sim_number) values ('7','','789078907890');
insert into tbl_sim (id, activation_date, sim_number) values ('8','01/08/2018','987698769876');