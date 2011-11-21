
CREATE TABLE RIIGI_ADMIN_YKSUSE_LIIK (
       riigi_admin_yksuse_lik_id INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       kood                 VARCHAR(10) NOT NULL,
       nimetus              VARCHAR(100) NOT NULL,
       kommentaar           VARCHAR(100),
       alates               DATE NOT NULL,
       kuni                 DATE NOT NULL,
       PRIMARY KEY (riigi_admin_yksuse_lik_id)
);

CREATE UNIQUE INDEX XPKRIIGI_ADMIN_YKSUSE_LIIK ON RIIGI_ADMIN_YKSUSE_LIIK
(
       riigi_admin_yksuse_lik_id
);


CREATE TABLE RIIGI_ADMIN_YKSUS (
       riigi_admin_yksus_ID INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       kood                 VARCHAR(20),
       nimetus              VARCHAR(100),
       kommentaar           VARCHAR(100),
       alates               DATE NOT NULL,
       kuni                 DATE NOT NULL,
       riigi_admin_yksuse_lik_id INTEGER NOT NULL,
       PRIMARY KEY (riigi_admin_yksus_ID), 
       FOREIGN KEY (riigi_admin_yksuse_lik_id)
                             REFERENCES RIIGI_ADMIN_YKSUSE_LIIK
                             ON DELETE RESTRICT
);

CREATE UNIQUE INDEX XPKRIIGI_ADMIN_YKSUS ON RIIGI_ADMIN_YKSUS
(
       riigi_admin_yksus_ID
);

CREATE INDEX XIF5RIIGI_ADMIN_YKSUS ON RIIGI_ADMIN_YKSUS
(
       riigi_admin_yksuse_lik_id
);


CREATE TABLE VAEOSA (
       vaeosa_ID_id         INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       kood                 VARCHAR(20) NOT NULL,
       nimetus              VARCHAR(100) NOT NULL,
       kommentaar           VARCHAR(100),
       riigi_admin_yksus_ID INTEGER NOT NULL,
       alates               DATE NOT NULL,
       kuni                 DATE NOT NULL,
       PRIMARY KEY (vaeosa_ID_id), 
       FOREIGN KEY (riigi_admin_yksus_ID)
                             REFERENCES RIIGI_ADMIN_YKSUS
                             ON DELETE RESTRICT
);

CREATE UNIQUE INDEX XPKVAEOSA ON VAEOSA
(
       vaeosa_ID_id
);

CREATE INDEX XIF1VAEOSA ON VAEOSA
(
       riigi_admin_yksus_ID
);


CREATE TABLE PIIRIPUNKT (
       piiripunkt_ID        INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       kood                 VARCHAR(20) NOT NULL,
       nimetus              VARCHAR(100) NOT NULL,
       GPS_Longituide       DECIMAL(9) NOT NULL,
       GPS_latitude         DECIMAL(9) NOT NULL,
       korgus_merepinnast   DECIMAL(6) NOT NULL,
       kommentaar           VARCHAR(100),
       alates               DATE NOT NULL,
       kuni                 DATE NOT NULL,
       PRIMARY KEY (piiripunkt_ID)
);

CREATE UNIQUE INDEX XPKPIIRIPUNKT ON PIIRIPUNKT
(
       piiripunkt_ID
);


CREATE TABLE VAHTKOND (
       vahtkond_ID          INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       kood                 VARCHAR(20),
       nimetus              VARCHAR(60),
       kommentaar           VARCHAR(100),
       alates               DATE,
       kuni                 DATE,
       piiripunkt_ID        INTEGER,
       vaeosa_ID_id         INTEGER,
       PRIMARY KEY (vahtkond_ID), 
       FOREIGN KEY (vaeosa_ID_id)
                             REFERENCES VAEOSA
                             ON DELETE SET NULL, 
       FOREIGN KEY (piiripunkt_ID)
                             REFERENCES PIIRIPUNKT
                             ON DELETE SET NULL
);

CREATE UNIQUE INDEX XPKVAHTKOND ON VAHTKOND
(
       vahtkond_ID
);

CREATE INDEX XIF41VAHTKOND ON VAHTKOND
(
       piiripunkt_ID
);

CREATE INDEX XIF42VAHTKOND ON VAHTKOND
(
       vaeosa_ID_id
);


CREATE TABLE INTSIDENDI_LIIK (
       intsidendi_liik_ID   INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       kood                 CHAR(18),
       nimetus              VARCHAR(60),
       kommentaar           VARCHAR(100),
       PRIMARY KEY (intsidendi_liik_ID)
);

CREATE UNIQUE INDEX XPKINTSIDENDI_LIIK ON INTSIDENDI_LIIK
(
       intsidendi_liik_ID
);


CREATE TABLE PIIRILOIK (
       piiriloik_ID         INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       kood                 CHAR(18),
       nimetus              VARCHAR(60),
       GPS_koordinaadid     VARCHAR(100),
       kommentaar           VARCHAR(100),
       PRIMARY KEY (piiriloik_ID)
);

CREATE UNIQUE INDEX XPKPIIRILOIK ON PIIRILOIK
(
       piiriloik_ID
);


CREATE TABLE INTSIDENT (
       intsident_ID         INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       kood                 VARCHAR(20),
       nimetus              VARCHAR(100),
       toimumise_algus      DATE,
       toimumise_lopp       DATE,
       kirjeldus            VARCHAR(100),
       kommentaar           VARCHAR(100),
       piiriloik_ID         INTEGER,
       intsidendi_liik_ID   INTEGER NOT NULL,
       GPS_Longituud        DECIMAL(9),
       GPS_latituud         DECIMAL(9),
       PRIMARY KEY (intsident_ID), 
       FOREIGN KEY (intsidendi_liik_ID)
                             REFERENCES INTSIDENDI_LIIK
                             ON DELETE RESTRICT, 
       FOREIGN KEY (piiriloik_ID)
                             REFERENCES PIIRILOIK
                             ON DELETE SET NULL
);

CREATE UNIQUE INDEX XPKINTSIDENT ON INTSIDENT
(
       intsident_ID
);

CREATE INDEX XIF51INTSIDENT ON INTSIDENT
(
       piiriloik_ID
);

CREATE INDEX XIF52INTSIDENT ON INTSIDENT
(
       intsidendi_liik_ID
);


CREATE TABLE VAHTKOND_INTSIDENDIS (
       vahtkond_intsidendis_ID INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       alates               DATE,
       kuni                 DATE,
       kirjeldus            VARCHAR(100),
       kommentaar           VARCHAR(100),
       intsident_ID         INTEGER NOT NULL,
       vahtkond_ID          INTEGER,
       PRIMARY KEY (vahtkond_intsidendis_ID), 
       FOREIGN KEY (vahtkond_ID)
                             REFERENCES VAHTKOND
                             ON DELETE SET NULL, 
       FOREIGN KEY (intsident_ID)
                             REFERENCES INTSIDENT
                             ON DELETE RESTRICT
);

CREATE UNIQUE INDEX XPKVAHTKOND_INTSIDENDIS ON VAHTKOND_INTSIDENDIS
(
       vahtkond_intsidendis_ID
);

CREATE INDEX XIF53VAHTKOND_INTSIDENDIS ON VAHTKOND_INTSIDENDIS
(
       intsident_ID
);

CREATE INDEX XIF54VAHTKOND_INTSIDENDIS ON VAHTKOND_INTSIDENDIS
(
       vahtkond_ID
);


CREATE TABLE PIIRIVALVUR (
       piirivalvur_ID       INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       isikukood            VARCHAR(20),
       eesnimed             VARCHAR(25),
       perekonnanimi        VARCHAR(35),
       sugu                 CHAR(1),
       soduri_kood          VARCHAR(20),
       kommentaar           VARCHAR(100),
       PRIMARY KEY (piirivalvur_ID)
);

CREATE UNIQUE INDEX XPKPIIRIVALVUR ON PIIRIVALVUR
(
       piirivalvur_ID
);


CREATE TABLE PiIRIVALVUR_INTSIDENDIS (
       piirivalvur_intsidendis_ID INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       alates               DATE,
       kuni                 DATE,
       kirjeldus            VARCHAR(100),
       kommentaar           VARCHAR(100),
       intsident_ID         INTEGER,
       piirivalvur_ID       INTEGER NOT NULL,
       vahtkond_intsidendis_ID INTEGER,
       PRIMARY KEY (piirivalvur_intsidendis_ID), 
       FOREIGN KEY (vahtkond_intsidendis_ID)
                             REFERENCES VAHTKOND_INTSIDENDIS
                             ON DELETE SET NULL, 
       FOREIGN KEY (piirivalvur_ID)
                             REFERENCES PIIRIVALVUR
                             ON DELETE RESTRICT, 
       FOREIGN KEY (intsident_ID)
                             REFERENCES INTSIDENT
                             ON DELETE SET NULL
);

CREATE UNIQUE INDEX XPKPiIRIVALVUR_INTSIDENDIS ON PiIRIVALVUR_INTSIDENDIS
(
       piirivalvur_intsidendis_ID
);

CREATE INDEX XIF55PiIRIVALVUR_INTSIDENDIS ON PiIRIVALVUR_INTSIDENDIS
(
       intsident_ID
);

CREATE INDEX XIF56PiIRIVALVUR_INTSIDENDIS ON PiIRIVALVUR_INTSIDENDIS
(
       piirivalvur_ID
);

CREATE INDEX XIF57PiIRIVALVUR_INTSIDENDIS ON PiIRIVALVUR_INTSIDENDIS
(
       vahtkond_intsidendis_ID
);


CREATE TABLE RUUMIYKSUSE_LIIK (
       ruumiyksuse_liik_ID  INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       kood                 VARCHAR(20),
       nimetus              VARCHAR(60),
       kommentaar           VARCHAR(100),
       PRIMARY KEY (ruumiyksuse_liik_ID)
);

CREATE UNIQUE INDEX XPKRUUMIYKSUSE_LIIK ON RUUMIYKSUSE_LIIK
(
       ruumiyksuse_liik_ID
);


CREATE TABLE RUUMIYKSUS (
       ruumiyksus_ID        INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       aadress              CHAR(18),
       nimetus              CHAR(18),
       kommentaar           CHAR(18),
       kood                 CHAR(18),
       ruumiyksuse_liik_ID  INTEGER NOT NULL,
       ylem_ruumiyksus_ID   INTEGER,
       riigi_admin_yksus_ID INTEGER,
       PRIMARY KEY (ruumiyksus_ID), 
       FOREIGN KEY (riigi_admin_yksus_ID)
                             REFERENCES RIIGI_ADMIN_YKSUS
                             ON DELETE SET NULL, 
       FOREIGN KEY (ylem_ruumiyksus_ID)
                             REFERENCES RUUMIYKSUS
                             ON DELETE SET NULL, 
       FOREIGN KEY (ruumiyksuse_liik_ID)
                             REFERENCES RUUMIYKSUSE_LIIK
                             ON DELETE RESTRICT
);

CREATE UNIQUE INDEX XPKRUUMIYKSUS ON RUUMIYKSUS
(
       ruumiyksus_ID
);

CREATE INDEX XIF45RUUMIYKSUS ON RUUMIYKSUS
(
       ruumiyksuse_liik_ID
);

CREATE INDEX XIF46RUUMIYKSUS ON RUUMIYKSUS
(
       ylem_ruumiyksus_ID
);

CREATE INDEX XIF50RUUMIYKSUS ON RUUMIYKSUS
(
       riigi_admin_yksus_ID
);


CREATE TABLE VOODIKOHT (
       voodikoht_ID         INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       number               VARCHAR(20),
       pikkus               INTEGER,
       laius                INTEGER,
       kommentaar           VARCHAR(100),
       ruumiyksus_ID        INTEGER NOT NULL,
       PRIMARY KEY (voodikoht_ID), 
       FOREIGN KEY (ruumiyksus_ID)
                             REFERENCES RUUMIYKSUS
                             ON DELETE RESTRICT
);

CREATE UNIQUE INDEX XPKVOODIKOHT ON VOODIKOHT
(
       voodikoht_ID
);

CREATE INDEX XIF47VOODIKOHT ON VOODIKOHT
(
       ruumiyksus_ID
);


CREATE TABLE PIIRIVALVUR_VODIKOHAL (
       _id                  INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       voodikoht_ID         INTEGER NOT NULL,
       piirivalvur_ID       INTEGER NOT NULL,
       alates               DATE,
       kuni                 DATE,
       kommentaar           VARCHAR(100),
       PRIMARY KEY (_id), 
       FOREIGN KEY (piirivalvur_ID)
                             REFERENCES PIIRIVALVUR
                             ON DELETE RESTRICT, 
       FOREIGN KEY (voodikoht_ID)
                             REFERENCES VOODIKOHT
                             ON DELETE RESTRICT
);

CREATE UNIQUE INDEX XPKPIIRIVALVUR_VODIKOHAL ON PIIRIVALVUR_VODIKOHAL
(
       _id
);

CREATE INDEX XIF48PIIRIVALVUR_VODIKOHAL ON PIIRIVALVUR_VODIKOHAL
(
       voodikoht_ID
);

CREATE INDEX XIF49PIIRIVALVUR_VODIKOHAL ON PIIRIVALVUR_VODIKOHAL
(
       piirivalvur_ID
);


CREATE TABLE VAHTKONNA_LIIGE (
       vahtkonna_liige_ID   INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       vahtkond_ID          INTEGER NOT NULL,
       piirivalvur_ID       INTEGER NOT NULL,
       alates               CHAR(18),
       kuni                 CHAR(18),
       kommentaar           CHAR(18),
       PRIMARY KEY (vahtkonna_liige_ID), 
       FOREIGN KEY (piirivalvur_ID)
                             REFERENCES PIIRIVALVUR
                             ON DELETE RESTRICT, 
       FOREIGN KEY (vahtkond_ID)
                             REFERENCES VAHTKOND
                             ON DELETE RESTRICT
);

CREATE UNIQUE INDEX XPKVAHTKONNA_LIIGE ON VAHTKONNA_LIIGE
(
       vahtkonna_liige_ID
);

CREATE INDEX XIF43VAHTKONNA_LIIGE ON VAHTKONNA_LIIGE
(
       vahtkond_ID
);

CREATE INDEX XIF44VAHTKONNA_LIIGE ON VAHTKONNA_LIIGE
(
       piirivalvur_ID
);


CREATE TABLE VAHTKONND_PIIRILOIGUL (
       vahtkond_piiriloiul_ID INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       piiriloik_ID         INTEGER NOT NULL,
       vahtkond_ID          INTEGER NOT NULL,
       alates               DATE,
       kuni                 DATE,
       kommentaar           VARCHAR(100),
       PRIMARY KEY (vahtkond_piiriloiul_ID), 
       FOREIGN KEY (vahtkond_ID)
                             REFERENCES VAHTKOND
                             ON DELETE RESTRICT, 
       FOREIGN KEY (piiriloik_ID)
                             REFERENCES PIIRILOIK
                             ON DELETE RESTRICT
);

CREATE UNIQUE INDEX XPKVAHTKONND_PIIRILOIGUL ON VAHTKONND_PIIRILOIGUL
(
       vahtkond_piiriloiul_ID
);

CREATE INDEX XIF39VAHTKONND_PIIRILOIGUL ON VAHTKONND_PIIRILOIGUL
(
       piiriloik_ID
);

CREATE INDEX XIF40VAHTKONND_PIIRILOIGUL ON VAHTKONND_PIIRILOIGUL
(
       vahtkond_ID
);


CREATE TABLE OBJEKTI_LIIK (
       objekt_liik_ID       INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       nimetus              VARCHAR(100) NOT NULL,
       kommentaar           VARCHAR(100),
       kood                 CHAR(18),
       PRIMARY KEY (objekt_liik_ID)
);

CREATE UNIQUE INDEX XPKOBJEKTI_LIIK ON OBJEKTI_LIIK
(
       objekt_liik_ID
);


CREATE TABLE OBJEKT (
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       nimetus              VARCHAR(100),
       kommentaar           VARCHAR(100),
       objekt_ID            INTEGER NOT NULL,
       objekt_liik_ID       INTEGER NOT NULL,
       PRIMARY KEY (objekt_ID), 
       FOREIGN KEY (objekt_liik_ID)
                             REFERENCES OBJEKTI_LIIK
                             ON DELETE RESTRICT
);

CREATE UNIQUE INDEX XPKOBJEKT ON OBJEKT
(
       objekt_ID
);

CREATE INDEX XIF58OBJEKT ON OBJEKT
(
       objekt_liik_ID
);


CREATE TABLE AMET (
       amet_ID              INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       ISCO_kood            VARCHAR(10),
       nimetus              VARCHAR(60),
       kommentaar           VARCHAR(100),
       PRIMARY KEY (amet_ID)
);

CREATE UNIQUE INDEX XPKAMET ON AMET
(
       amet_ID
);


CREATE TABLE AMET_PIIRIPUNKTIS (
       amet_piiripunktis_ID INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       alates               DATE NOT NULL,
       kuni                 DATE NOT NULL,
       kommentaar           VARCHAR(100),
       piiripunkt_ID        INTEGER NOT NULL,
       amet_ID              INTEGER NOT NULL,
       PRIMARY KEY (amet_piiripunktis_ID), 
       FOREIGN KEY (amet_ID)
                             REFERENCES AMET
                             ON DELETE RESTRICT, 
       FOREIGN KEY (piiripunkt_ID)
                             REFERENCES PIIRIPUNKT
                             ON DELETE RESTRICT
);

CREATE UNIQUE INDEX XPKAMET_PIIRIPUNKTIS ON AMET_PIIRIPUNKTIS
(
       amet_piiripunktis_ID
);

CREATE INDEX XIF30AMET_PIIRIPUNKTIS ON AMET_PIIRIPUNKTIS
(
       piiripunkt_ID
);

CREATE INDEX XIF31AMET_PIIRIPUNKTIS ON AMET_PIIRIPUNKTIS
(
       amet_ID
);


CREATE TABLE PIIRIVALVUR_PIIRIPUNKTIS (
       piirivalvur_piiripunktis_ID INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       alates               DATE NOT NULL,
       kuni                 DATE NOT NULL,
       koormus              DECIMAL(5) NOT NULL,
       kommentaar           VARCHAR(100),
       piirivalvur_ID       INTEGER NOT NULL,
       amet_piiripunktis_ID INTEGER NOT NULL,
       PRIMARY KEY (piirivalvur_piiripunktis_ID), 
       FOREIGN KEY (piirivalvur_ID)
                             REFERENCES PIIRIVALVUR
                             ON DELETE RESTRICT, 
       FOREIGN KEY (amet_piiripunktis_ID)
                             REFERENCES AMET_PIIRIPUNKTIS
                             ON DELETE RESTRICT
);

CREATE UNIQUE INDEX XPKPIIRIVALVUR_PIIRIPUNKTIS ON PIIRIVALVUR_PIIRIPUNKTIS
(
       piirivalvur_piiripunktis_ID
);

CREATE INDEX XIF34PIIRIVALVUR_PIIRIPUNKTIS ON PIIRIVALVUR_PIIRIPUNKTIS
(
       amet_piiripunktis_ID
);

CREATE INDEX XIF35PIIRIVALVUR_PIIRIPUNKTIS ON PIIRIVALVUR_PIIRIPUNKTIS
(
       piirivalvur_ID
);


CREATE TABLE AMET_VAEOSAS (
       amet_vaeosas_ID      INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       alates               DATE NOT NULL,
       kuni                 DATE NOT NULL,
       kommentaar           VARCHAR(100),
       vaeosa_ID_id         INTEGER NOT NULL,
       amet_ID              INTEGER NOT NULL,
       PRIMARY KEY (amet_vaeosas_ID), 
       FOREIGN KEY (amet_ID)
                             REFERENCES AMET
                             ON DELETE RESTRICT, 
       FOREIGN KEY (vaeosa_ID_id)
                             REFERENCES VAEOSA
                             ON DELETE RESTRICT
);

CREATE UNIQUE INDEX XPKAMET_VAEOSAS ON AMET_VAEOSAS
(
       amet_vaeosas_ID
);

CREATE INDEX XIF28AMET_VAEOSAS ON AMET_VAEOSAS
(
       vaeosa_ID_id
);

CREATE INDEX XIF29AMET_VAEOSAS ON AMET_VAEOSAS
(
       amet_ID
);


CREATE TABLE PIIRIPUNKTI_ORG_YKSUS (
       piiripunkti_org_yksus_ID INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       kood                 VARCHAR(20) NOT NULL,
       nimetus              VARCHAR(100) NOT NULL,
       kommentaar           VARCHAR(100),
       ylem_org_yksus_ID    INTEGER,
       vaeosa_ID_id         INTEGER NOT NULL,
       alates               DATE NOT NULL,
       kuni                 DATE NOT NULL,
       piiripunkt_ID        INTEGER NOT NULL,
       PRIMARY KEY (piiripunkti_org_yksus_ID), 
       FOREIGN KEY (ylem_org_yksus_ID)
                             REFERENCES PIIRIPUNKTI_ORG_YKSUS
                             ON DELETE SET NULL, 
       FOREIGN KEY (piiripunkt_ID)
                             REFERENCES PIIRIPUNKT
                             ON DELETE RESTRICT
);

CREATE UNIQUE INDEX XPKPIIRIPUNKTI_ORG_YKSUS ON PIIRIPUNKTI_ORG_YKSUS
(
       piiripunkti_org_yksus_ID
);

CREATE INDEX XIF25PIIRIPUNKTI_ORG_YKSUS ON PIIRIPUNKTI_ORG_YKSUS
(
       piiripunkt_ID
);

CREATE INDEX XIF26PIIRIPUNKTI_ORG_YKSUS ON PIIRIPUNKTI_ORG_YKSUS
(
       ylem_org_yksus_ID
);


CREATE TABLE PIIRIVALVUR_VAEOSAS (
       piirivalvur_vaeosas_ID INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       alates               DATE,
       kuni                 DATE,
       koormus              DECIMAL(5),
       kommentaar           VARCHAR(100),
       piirivalvur_ID       INTEGER NOT NULL,
       amet_vaeosas_ID      INTEGER NOT NULL,
       PRIMARY KEY (piirivalvur_vaeosas_ID), 
       FOREIGN KEY (amet_vaeosas_ID)
                             REFERENCES AMET_VAEOSAS
                             ON DELETE RESTRICT, 
       FOREIGN KEY (piirivalvur_ID)
                             REFERENCES PIIRIVALVUR
                             ON DELETE RESTRICT
);

CREATE UNIQUE INDEX XPKPIIRIVALVUR_VAEOSAS ON PIIRIVALVUR_VAEOSAS
(
       piirivalvur_vaeosas_ID
);

CREATE INDEX XIF32PIIRIVALVUR_VAEOSAS ON PIIRIVALVUR_VAEOSAS
(
       piirivalvur_ID
);

CREATE INDEX XIF33PIIRIVALVUR_VAEOSAS ON PIIRIVALVUR_VAEOSAS
(
       amet_vaeosas_ID
);


CREATE TABLE SUGULUSE_ROLLI_LIIK (
       suguluse_rolli_liik_ID INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       nimetus              VARCHAR(60) NOT NULL,
       kommentaar           VARCHAR(100) NOT NULL,
       sugulane_voi_mitte   CHAR(1),
       PRIMARY KEY (suguluse_rolli_liik_ID)
);

CREATE UNIQUE INDEX XPKSUGULUSE_ROLLI_LIIK ON SUGULUSE_ROLLI_LIIK
(
       suguluse_rolli_liik_ID
);


CREATE TABLE SEOTUD_KONTAKTISIK (
       piirivalvuri_kontakt_ID INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       kommentaar           VARCHAR(100) NOT NULL,
       piirivalvur_ID       INTEGER NOT NULL,
       suguluse_rolli_liik_ID INTEGER NOT NULL,
       alates               DATE,
       kuni                 DATE,
       PRIMARY KEY (piirivalvuri_kontakt_ID), 
       FOREIGN KEY (suguluse_rolli_liik_ID)
                             REFERENCES SUGULUSE_ROLLI_LIIK
                             ON DELETE RESTRICT, 
       FOREIGN KEY (piirivalvur_ID)
                             REFERENCES PIIRIVALVUR
                             ON DELETE RESTRICT
);

CREATE UNIQUE INDEX XPKSEOTUD_KONTAKTISIK ON SEOTUD_KONTAKTISIK
(
       piirivalvuri_kontakt_ID
);

CREATE INDEX XIF19SEOTUD_KONTAKTISIK ON SEOTUD_KONTAKTISIK
(
       piirivalvur_ID
);

CREATE INDEX XIF20SEOTUD_KONTAKTISIK ON SEOTUD_KONTAKTISIK
(
       suguluse_rolli_liik_ID
);


CREATE TABLE KONTAKTI_LIIK (
       kontakti_liik_ID     INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       nimetus              VARCHAR(60) NOT NULL,
       kommentaar           VARCHAR(100) NOT NULL,
       XML_kirjeldus        VARCHAR(100),
       PRIMARY KEY (kontakti_liik_ID)
);

CREATE UNIQUE INDEX XPKKONTAKTI_LIIK ON KONTAKTI_LIIK
(
       kontakti_liik_ID
);


CREATE TABLE PIIRIVALVURI_KONTAKT (
       piirivalvuri_kontakt_ID INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       kontakt              VARCHAR(120) NOT NULL,
       kommentaar           VARCHAR(100) NOT NULL,
       peamine_kontakt      VARCHAR(1),
       piirivalvur_ID       INTEGER NOT NULL,
       kontakti_liik_ID     INTEGER NOT NULL,
       alates               DATE,
       kuni                 DATE,
       PRIMARY KEY (piirivalvuri_kontakt_ID), 
       FOREIGN KEY (kontakti_liik_ID)
                             REFERENCES KONTAKTI_LIIK
                             ON DELETE RESTRICT, 
       FOREIGN KEY (piirivalvur_ID)
                             REFERENCES PIIRIVALVUR
                             ON DELETE RESTRICT
);

CREATE UNIQUE INDEX XPKPIIRIVALVURI_KONTAKT ON PIIRIVALVURI_KONTAKT
(
       piirivalvuri_kontakt_ID
);

CREATE INDEX XIF17PIIRIVALVURI_KONTAKT ON PIIRIVALVURI_KONTAKT
(
       piirivalvur_ID
);

CREATE INDEX XIF18PIIRIVALVURI_KONTAKT ON PIIRIVALVURI_KONTAKT
(
       kontakti_liik_ID
);


CREATE TABLE AUASTE (
       auaste_ID            INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       kood                 VARCHAR(20),
       nimetus              VARCHAR(60),
       kommentaar           VARCHAR(100),
       PRIMARY KEY (auaste_ID)
);

CREATE UNIQUE INDEX XPKAUASTE ON AUASTE
(
       auaste_ID
);


CREATE TABLE AUASTME_MUUTUMINE (
       auastme_muutumine_ID INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       piirivalvur_ID       INTEGER NOT NULL,
       auaste_ID            INTEGER NOT NULL,
       alates               DATE,
       kuni                 DATE,
       kommentaar           VARCHAR(100),
       PRIMARY KEY (auastme_muutumine_ID), 
       FOREIGN KEY (auaste_ID)
                             REFERENCES AUASTE
                             ON DELETE RESTRICT, 
       FOREIGN KEY (piirivalvur_ID)
                             REFERENCES PIIRIVALVUR
                             ON DELETE RESTRICT
);

CREATE UNIQUE INDEX XPKAUASTME_MUUTUMINE ON AUASTME_MUUTUMINE
(
       auastme_muutumine_ID
);

CREATE INDEX XIF15AUASTME_MUUTUMINE ON AUASTME_MUUTUMINE
(
       piirivalvur_ID
);

CREATE INDEX XIF16AUASTME_MUUTUMINE ON AUASTME_MUUTUMINE
(
       auaste_ID
);


CREATE TABLE ADMIN_ALLUVUS (
       admin_alluvus_id     INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       alates               CHAR(18),
       kuni                 CHAR(18),
       kommentaar           CHAR(18),
       ylemus_yksus_ID      INTEGER NOT NULL,
       alluv_yksus_ID       INTEGER NOT NULL,
       PRIMARY KEY (admin_alluvus_id), 
       FOREIGN KEY (alluv_yksus_ID)
                             REFERENCES RIIGI_ADMIN_YKSUS
                             ON DELETE RESTRICT, 
       FOREIGN KEY (ylemus_yksus_ID)
                             REFERENCES RIIGI_ADMIN_YKSUS
                             ON DELETE RESTRICT
);

CREATE UNIQUE INDEX XPKADMIN_ALLUVUS ON ADMIN_ALLUVUS
(
       admin_alluvus_id
);

CREATE INDEX XIF3ADMIN_ALLUVUS ON ADMIN_ALLUVUS
(
       ylemus_yksus_ID
);

CREATE INDEX XIF4ADMIN_ALLUVUS ON ADMIN_ALLUVUS
(
       alluv_yksus_ID
);


CREATE TABLE PIIRILOIGU_HALDAJA (
       piiriloigu_haldaja_ID INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       piiriloik_ID         INTEGER,
       piiripunkt_ID        INTEGER NOT NULL,
       vaeosa_ID_id         INTEGER NOT NULL,
       alates               DATE,
       kuni                 DATE,
       kommentaar           VARCHAR(100),
       PRIMARY KEY (piiriloigu_haldaja_ID), 
       FOREIGN KEY (vaeosa_ID_id)
                             REFERENCES VAEOSA
                             ON DELETE RESTRICT, 
       FOREIGN KEY (piiripunkt_ID)
                             REFERENCES PIIRIPUNKT
                             ON DELETE SET NULL, 
       FOREIGN KEY (piiriloik_ID)
                             REFERENCES PIIRILOIK
                             ON DELETE SET NULL
);

CREATE UNIQUE INDEX XPKPIIRILOIGU_HALDAJA ON PIIRILOIGU_HALDAJA
(
       piiriloigu_haldaja_ID
);

CREATE INDEX XIF36PIIRILOIGU_HALDAJA ON PIIRILOIGU_HALDAJA
(
       piiriloik_ID
);

CREATE INDEX XIF37PIIRILOIGU_HALDAJA ON PIIRILOIGU_HALDAJA
(
       piiripunkt_ID
);

CREATE INDEX XIF38PIIRILOIGU_HALDAJA ON PIIRILOIGU_HALDAJA
(
       vaeosa_ID_id
);


CREATE TABLE VOIMALIK_ALLUVUS (
       voimalik_alluvus_id  INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       riigi_admin_yksuse_lik_id INTEGER NOT NULL,
       voimalik_alluv_liik_ID INTEGER NOT NULL,
       kommentaar           VARCHAR(100),
       PRIMARY KEY (voimalik_alluvus_id), 
       FOREIGN KEY (voimalik_alluv_liik_ID)
                             REFERENCES RIIGI_ADMIN_YKSUSE_LIIK
                             ON DELETE RESTRICT, 
       FOREIGN KEY (riigi_admin_yksuse_lik_id)
                             REFERENCES RIIGI_ADMIN_YKSUSE_LIIK
                             ON DELETE RESTRICT
);

CREATE UNIQUE INDEX XPKVOIMALIK_ALLUVUS ON VOIMALIK_ALLUVUS
(
       voimalik_alluvus_id
);

CREATE INDEX XIF6VOIMALIK_ALLUVUS ON VOIMALIK_ALLUVUS
(
       riigi_admin_yksuse_lik_id
);

CREATE INDEX XIF7VOIMALIK_ALLUVUS ON VOIMALIK_ALLUVUS
(
       voimalik_alluv_liik_ID
);


CREATE TABLE PIIRIPUNKTI_ALLUVUS (
       piiripunkti_alluvus_ID INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       alates               CHAR(18),
       kuni                 CHAR(18),
       kommentaar           CHAR(18),
       vaeosa_ID            INTEGER NOT NULL,
       piiripunkt_ID        INTEGER NOT NULL,
       PRIMARY KEY (piiripunkti_alluvus_ID), 
       FOREIGN KEY (piiripunkt_ID)
                             REFERENCES PIIRIPUNKT
                             ON DELETE RESTRICT, 
       FOREIGN KEY (vaeosa_ID)
                             REFERENCES VAEOSA
                             ON DELETE RESTRICT
);

CREATE UNIQUE INDEX XPKPIIRIPUNKTI_ALLUVUS ON PIIRIPUNKTI_ALLUVUS
(
       piiripunkti_alluvus_ID
);

CREATE INDEX XIF10PIIRIPUNKTI_ALLUVUS ON PIIRIPUNKTI_ALLUVUS
(
       vaeosa_ID
);

CREATE INDEX XIF27PIIRIPUNKTI_ALLUVUS ON PIIRIPUNKTI_ALLUVUS
(
       piiripunkt_ID
);


CREATE TABLE VAEOSA_ALLUVUS (
       vaeosa_alluvus_id    INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       ylemus_vaeosa_ID     INTEGER NOT NULL,
       alluva_vaeosa_ID     INTEGER NOT NULL,
       alates               DATE NOT NULL,
       kuni                 DATE NOT NULL,
       kommentaar           VARCHAR(100),
       PRIMARY KEY (vaeosa_alluvus_id), 
       FOREIGN KEY (alluva_vaeosa_ID)
                             REFERENCES VAEOSA
                             ON DELETE RESTRICT, 
       FOREIGN KEY (ylemus_vaeosa_ID)
                             REFERENCES VAEOSA
                             ON DELETE RESTRICT
);

CREATE UNIQUE INDEX XPKVAEOSA_ALLUVUS ON VAEOSA_ALLUVUS
(
       vaeosa_alluvus_id
);

CREATE INDEX XIF8VAEOSA_ALLUVUS ON VAEOSA_ALLUVUS
(
       ylemus_vaeosa_ID
);

CREATE INDEX XIF9VAEOSA_ALLUVUS ON VAEOSA_ALLUVUS
(
       alluva_vaeosa_ID
);


CREATE TABLE ORG_YKSUS (
       org_yksus_ID         INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       kood                 VARCHAR(20) NOT NULL,
       nimetus              VARCHAR(100) NOT NULL,
       kommentaar           VARCHAR(100),
       ylem_org_yksus_ID    INTEGER,
       vaeosa_ID_id         INTEGER NOT NULL,
       alates               DATE NOT NULL,
       kuni                 DATE NOT NULL,
       PRIMARY KEY (org_yksus_ID), 
       FOREIGN KEY (vaeosa_ID_id)
                             REFERENCES VAEOSA
                             ON DELETE RESTRICT, 
       FOREIGN KEY (ylem_org_yksus_ID)
                             REFERENCES ORG_YKSUS
                             ON DELETE SET NULL
);

CREATE UNIQUE INDEX XPKORG_YKSUS ON ORG_YKSUS
(
       org_yksus_ID
);

CREATE INDEX XIF12ORG_YKSUS ON ORG_YKSUS
(
       ylem_org_yksus_ID
);

CREATE INDEX XIF13ORG_YKSUS ON ORG_YKSUS
(
       vaeosa_ID_id
);


CREATE TABLE SEADUS (
       seaduse_ID           INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       kood                 VARCHAR(20) NOT NULL,
       nimetus              VARCHAR(20) NOT NULL,
       kommentaar           VARCHAR(20) NOT NULL,
       kehtiv_alates        CHAR(18),
       kehtiv_kuni          CHAR(18),
       PRIMARY KEY (seaduse_ID)
);

CREATE UNIQUE INDEX XPKSEADUS ON SEADUS
(
       seaduse_ID
);


CREATE TABLE SEADUSE_PUNKT (
       seaduse_punkt_ID     INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       paragrahv            CHAR(18),
       pais                 CHAR(18),
       tekst                CHAR(18),
       kommentaar           CHAR(18),
       kehtiv_alates        CHAR(18),
       kehtiv_kuni          CHAR(18),
       seaduse_ID           INTEGER NOT NULL,
       ylemus_seaduse_punkt_ID INTEGER,
       PRIMARY KEY (seaduse_punkt_ID), 
       FOREIGN KEY (ylemus_seaduse_punkt_ID)
                             REFERENCES SEADUSE_PUNKT
                             ON DELETE SET NULL, 
       FOREIGN KEY (seaduse_ID)
                             REFERENCES SEADUS
                             ON DELETE RESTRICT
);

CREATE UNIQUE INDEX XPKSEADUSE_PUNKT ON SEADUSE_PUNKT
(
       seaduse_punkt_ID
);

CREATE INDEX XIF60SEADUSE_PUNKT ON SEADUSE_PUNKT
(
       seaduse_ID
);

CREATE INDEX XIF61SEADUSE_PUNKT ON SEADUSE_PUNKT
(
       ylemus_seaduse_punkt_ID
);


CREATE TABLE OBJEKT_INTSIDENDIS (
       objekt_intsidendis_ID INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       intsident_ID         INTEGER NOT NULL,
       alates               DATE,
       kuni                 DATE,
       kirjeldus            VARCHAR(100),
       kommentaar           VARCHAR(100),
       objekt_ID            INTEGER NOT NULL,
       PRIMARY KEY (objekt_intsidendis_ID), 
       FOREIGN KEY (intsident_ID)
                             REFERENCES INTSIDENT
                             ON DELETE RESTRICT, 
       FOREIGN KEY (objekt_ID)
                             REFERENCES OBJEKT
                             ON DELETE RESTRICT
);

CREATE UNIQUE INDEX XPKOBJEKT_INTSIDENDIS ON OBJEKT_INTSIDENDIS
(
       objekt_intsidendis_ID
);

CREATE INDEX XIF51OBJEKT_INTSIDENDIS ON OBJEKT_INTSIDENDIS
(
       objekt_ID
);

CREATE INDEX XIF52OBJEKT_INTSIDENDIS ON OBJEKT_INTSIDENDIS
(
       intsident_ID
);


CREATE TABLE PIIRIRIKKUJA (
       piiririkkuja_ID      INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       isikukood            VARCHAR(20),
       kommentaar           VARCHAR(100),
       eesnimi              VARCHAR(25),
       perek_nimi           VARCHAR(35),
       sugu                 CHAR(1),
       synniaeg             DATE,
       objekt_ID            INTEGER NOT NULL,
       PRIMARY KEY (piiririkkuja_ID), 
       FOREIGN KEY (objekt_ID)
                             REFERENCES OBJEKT
                             ON DELETE RESTRICT
);

CREATE UNIQUE INDEX XPKPIIRIRIKKUJA ON PIIRIRIKKUJA
(
       piiririkkuja_ID
);

CREATE INDEX XIF59PIIRIRIKKUJA ON PIIRIRIKKUJA
(
       objekt_ID
);


CREATE TABLE ISIK_INTSIDENDIS (
       isik_intsidendis_ID  INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       alates               DATE NOT NULL,
       kuni                 DATE NOT NULL,
       kirjeldus            VARCHAR(100) NOT NULL,
       kommentaar           VARCHAR(100),
       intsident_ID         INTEGER NOT NULL,
       piiririkkuja_ID      INTEGER NOT NULL,
       PRIMARY KEY (isik_intsidendis_ID), 
       FOREIGN KEY (piiririkkuja_ID)
                             REFERENCES PIIRIRIKKUJA
                             ON DELETE RESTRICT, 
       FOREIGN KEY (intsident_ID)
                             REFERENCES INTSIDENT
                             ON DELETE SET NULL
);

CREATE UNIQUE INDEX XPKISIK_INTSIDENDIS ON ISIK_INTSIDENDIS
(
       isik_intsidendis_ID
);

CREATE INDEX XIF53ISIK_INTSIDENDIS ON ISIK_INTSIDENDIS
(
       intsident_ID
);

CREATE INDEX XIF54ISIK_INTSIDENDIS ON ISIK_INTSIDENDIS
(
       piiririkkuja_ID
);


CREATE TABLE RIIK (
       riik_ID              INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       ISO_kood             VARCHAR(20) NOT NULL,
       kommentaar           VARCHAR(100),
       ANSI_kood            CHAR(18),
       PRIMARY KEY (riik_ID)
);

CREATE UNIQUE INDEX XPKRIIK ON RIIK
(
       riik_ID
);


CREATE TABLE ISIKU_SEADUS_INTSIDENDIS (
       isiku_seadus_intsidendis_ID INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       alates               DATE NOT NULL,
       kuni                 DATE NOT NULL,
       kirjeldus            VARCHAR(100) NOT NULL,
       kommentaar           VARCHAR(100),
       isik_intsidendis_ID  INTEGER NOT NULL,
       seaduse_punkt_ID     INTEGER NOT NULL,
       PRIMARY KEY (isiku_seadus_intsidendis_ID), 
       FOREIGN KEY (seaduse_punkt_ID)
                             REFERENCES SEADUSE_PUNKT
                             ON DELETE RESTRICT, 
       FOREIGN KEY (isik_intsidendis_ID)
                             REFERENCES ISIK_INTSIDENDIS
                             ON DELETE RESTRICT
);

CREATE UNIQUE INDEX XPKISIKU_SEADUS_INTSIDENDIS ON ISIKU_SEADUS_INTSIDENDIS
(
       isiku_seadus_intsidendis_ID
);

CREATE INDEX XIF63ISIKU_SEADUS_INTSIDENDIS ON ISIKU_SEADUS_INTSIDENDIS
(
       isik_intsidendis_ID
);

CREATE INDEX XIF64ISIKU_SEADUS_INTSIDENDIS ON ISIKU_SEADUS_INTSIDENDIS
(
       seaduse_punkt_ID
);


CREATE TABLE OBJEKTI_SEADUS_INTSIDENDIS (
       objekti_seadus_intsidendis_ID INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       alates               DATE NOT NULL,
       kuni                 DATE NOT NULL,
       kirjeldus            VARCHAR(100) NOT NULL,
       kommentaar           VARCHAR(100),
       objekt_intsidendis_ID INTEGER NOT NULL,
       seaduse_punkt_ID     INTEGER NOT NULL,
       PRIMARY KEY (objekti_seadus_intsidendis_ID), 
       FOREIGN KEY (seaduse_punkt_ID)
                             REFERENCES SEADUSE_PUNKT
                             ON DELETE RESTRICT, 
       FOREIGN KEY (objekt_intsidendis_ID)
                             REFERENCES OBJEKT_INTSIDENDIS
                             ON DELETE RESTRICT
);

CREATE UNIQUE INDEX XPKOBJEKTI_SEADUS_INTSIDENDIS ON OBJEKTI_SEADUS_INTSIDENDIS
(
       objekti_seadus_intsidendis_ID
);

CREATE INDEX XIF65OBJEKTI_SEADUS_INTSIDENDI ON OBJEKTI_SEADUS_INTSIDENDIS
(
       objekt_intsidendis_ID
);

CREATE INDEX XIF66OBJEKTI_SEADUS_INTSIDENDI ON OBJEKTI_SEADUS_INTSIDENDIS
(
       seaduse_punkt_ID
);


CREATE TABLE KODAKONDSUS (
       kodakondsus_ID       INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       kommentaar           VARCHAR(100),
       alates               DATE,
       kuni                 DATE,
       riik_ID              INTEGER NOT NULL,
       piiririkkuja_ID      INTEGER NOT NULL,
       isikukood            VARCHAR(20),
       PRIMARY KEY (kodakondsus_ID), 
       FOREIGN KEY (piiririkkuja_ID)
                             REFERENCES PIIRIRIKKUJA
                             ON DELETE RESTRICT, 
       FOREIGN KEY (riik_ID)
                             REFERENCES RIIK
                             ON DELETE RESTRICT
);

CREATE UNIQUE INDEX XPKKODAKONDSUS ON KODAKONDSUS
(
       kodakondsus_ID
);

CREATE INDEX XIF67KODAKONDSUS ON KODAKONDSUS
(
       riik_ID
);

CREATE INDEX XIF68KODAKONDSUS ON KODAKONDSUS
(
       piiririkkuja_ID
);


CREATE TABLE PIIRIVALVURI_SEADUS_INTSIDENDI (
       piirivalvuri_seadus_intsidendi INTEGER,
       avaja                VARCHAR(32) NOT NULL,
       avatud               DATE NOT NULL,
       muutja               VARCHAR(32) NOT NULL,
       muudetud             DATE NOT NULL,
       sulgeja              VARCHAR(32),
       suletud              DATE NOT NULL,
       alates               DATE NOT NULL,
       kuni                 DATE NOT NULL,
       kirjeldus            VARCHAR(100) NOT NULL,
       kommentaar           VARCHAR(100),
       piirivalvur_intsidendis_ID INTEGER NOT NULL,
       seaduse_punkt_ID     INTEGER NOT NULL,
       PRIMARY KEY (piirivalvuri_seadus_intsidendi), 
       FOREIGN KEY (seaduse_punkt_ID)
                             REFERENCES SEADUSE_PUNKT
                             ON DELETE RESTRICT, 
       FOREIGN KEY (piirivalvur_intsidendis_ID)
                             REFERENCES PiIRIVALVUR_INTSIDENDIS
                             ON DELETE RESTRICT
);

CREATE UNIQUE INDEX XPKPIIRIVALVURI_SEADUS_INTSIDE ON PIIRIVALVURI_SEADUS_INTSIDENDI
(
       piirivalvuri_seadus_intsidendi
);

CREATE INDEX XIF69PIIRIVALVURI_SEADUS_INTSI ON PIIRIVALVURI_SEADUS_INTSIDENDI
(
       piirivalvur_intsidendis_ID
);

CREATE INDEX XIF70PIIRIVALVURI_SEADUS_INTSI ON PIIRIVALVURI_SEADUS_INTSIDENDI
(
       seaduse_punkt_ID
);



