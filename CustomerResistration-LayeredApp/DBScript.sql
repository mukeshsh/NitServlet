
  CREATE TABLE "JDBC"."LAYERED_CUSTOMER1" 
   (	"CNO" NUMBER(10,0) NOT NULL ENABLE, 
	"CNAME" VARCHAR2(20 BYTE), 
	"CADD" VARCHAR2(20 BYTE), 
	"BILLAMT" FLOAT(120), 
	"DISCOUNT" FLOAT(120), 
	"NETAMT" FLOAT(126), 
	 CONSTRAINT "LAYERED_CUSTOMER1_PK" PRIMARY KEY ("CNO")

   CREATE SEQUENCE  "JDBC"."CNO_SEQ"  MINVALUE 100 MAXVALUE 10000 INCREMENT BY 1 START WITH 100 CACHE 20 NOORDER  NOCYCLE ;