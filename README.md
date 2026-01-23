AGGIUNGERE QUERY DB
AGGIUNGERE RESPONSE ENTITY E CONTROLLI SUL NULL -- OK

04-12

-INSERITO LOMBOK NEI PLUGIN E NEL POM ( STUDIARE PER CAPIRE TUTTE LE SUE FUNZIOANLITA' ) - INSERITO NEI DTO PER TESTARLO

-STUDIARE DTO MANUALE -- OK
-STUDIARE CLASSE MAPPER DTO -- OK

-COLLEGARE MYSQL SU PROGETTOSCUOLA -- OK

-EFFETTUARE I CONTROLLI SU ALUNNI (NUMERO DI TELEFONO)

05-12

- MIGLIORAMENTO SULLE RESPONSE ENTITY CON

- STUDIARE TEST

- CREARE AMBIENTE SU DOCKER PER SPRING

10/ 12

-STUDIARE CLASS EXCEPTION ( DA INSERIRE STUNUM ) PERSONALIZZATE
-INSERIRE ANCHE LA InvalidCredentialException

-INSERIRE LOG IN (FINIRE IL CONTROLLER)

15/12

-AGGIUNTA DI COSTRUTTORI PER CREARE I TEST A STUDENT E NEL DTO
-IMPLEMENTAZIONE MOCKITO PER I TEST

// PROFILI MVN

resources>
<!-- indica a maven dove cercare le risorse -->
<directory>sorc/main/resources</directory>
<!-- questo va a dire a mvn di sostituire i valori nel db-properties con i valori del profilo attivo -->
<filtering>true </filtering>

		</resources>
	</build>

	<profiles>
		<profile>
			<id> dev </id>
			<activation>
			<!-- questo indica a mvn che se non è stato un utente specifico deve utilizzare il profilo .dev -->
				<activeByDefault>true</activeByDefault>
				<property>
					<name>env</name>
					<value>dev</value>
				</property>
			</activation>
			<properties>
				<db.driverClassName>com.mysql.cj.jdbc.Driver</db.driverClassName>
				<db.url>jdbc:mysql://localhost:3306/project_school</db.url>
				<db.username>root</db.username>
				<db.password>Lecce2024!</db.password>
			</properties>
		</profile>

/profiles>

id = null o controlli su id - strategy o verify springboot
password utilizzare becrypt
coverage da implementare
test si utilizza should_*nomeMetodoIniziale*_return*- - -* (business exception, empty, etc)

07/01

- COMPLETARE TEACHER -- OK
- PULIRE CONTROLLER TEACHER -- OK
- COMPLETARE CON EXCEPTION -- OK

- CREARE SERVICE E CONTROLLER PER LA LOGIN
- CRYPTARE LA PASSWORD -- OK SOLO PER STUDENT (MODIFICARE ANCHE I TEST AGGIUNGENDO IL MOCK DELL'ENCODER)
- AGGIUNGERE CAMPI ?? NOT NULL ETC -- OK

08/01

- CONTROLLER ADVICE ( STANDARD PROFESSIONALE )
- RFC 7807 ( PROBLEM DETAIL ) DALLA VERSIONE DI SPRINGBOOT 3
- AGGIUNTA DEL LOGIN CONTROLLER E SERVICE -- OK

09/01

- TERMINARE CONTROLLER E LOGIN CAPIRE SE VA -OK
- FINIRE TEACHER- OK

12/01

- CONTROLLARE TEST ERRORE ROSSO (?) - OK
- TEST SUL SAVE NUOVO - OK 2 EXCEPTION
- AGGIUNGERE TOKEN JWT - OK
- INVIO EMAIL CON TOKEN PER RESET? - no
- IMPLEMENTAZIONE JACOCO PER COVERGAGE - OK

13/01
. TESTARE CONTROLLER
OGGETTO PERSON IN USER E SETTARE MEGLIO RUOLI E PERMESSI

- CREARE UN SUPERADMIN PER IL FRONTEND DA POTER PROVARE L'API SENZA PERMESSI - ok

14/01




- (TONDI)
- STUDIARE OPENAPI

- { OPEN API
-STANDARD CHE DESCRIVE LE API IN FORMATO YAML/JSON
-TRASFORMA IL CONTRATTO IN UNA PAGINA WEB INTERATTIVA
-IN SPRING BOOT SI UTILIZZA *CODE-FIRST*, E LO YAML VIENE GENERATO AUTOMATICAMENTE ALL'INDIRIZZO /V3/API- DOCS
}
{ ANNOTAZIONI
- @TAG per raggruppare gli endpoint
- @OPERATION per descrivere un singolo endpoint
- @PARAMETER per descrivere i parametri di un endpoint
- @APIRESPONSE per descrivere le risposte possibili di un endpoint
- @SCHEMA per descrivere gli schemi dei modelli
- @SECURITYREQUIREMENT per descrivere i requisiti di sicurezza (CON JWT O ALTRO)
}


- IMPLEMENTARE DIVERSI DB CON DOCKER - OK
- ELIMINARE LE CLASSI TEST CON JACOCO 
- INTEGRATION TEST 20/01

- QUANDO VIENE EFFETTUATA LA GESTIONE DELL'UTENTE? HA SENSO INSERIRE BCRYPT?
- GESTIONE DTO?
- HA SENSO INSERIRE ANNOT @MAPPING PER IGNORARE I CAMPI NULL?
- vedere cod
- capire cosa fare, se posso continuare in questo modo o c'è qualcosa in particoalre


- CRITERIA CLASSE 
- 
medium, baldung, baldabung
controllare if lambda per fare 100% testing


