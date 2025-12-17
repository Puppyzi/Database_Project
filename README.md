## Police Force Database


https://github.com/user-attachments/assets/af911521-7287-4af2-8352-4232e97fa6e7


Full-stack CRUD web app for managing Stations, Officers, Police Cases, and Suspects.

### Tech Stack

**Back-end**
- Java + Spring Boot (REST API)
- Spring Data JPA (Hibernate) for ORM
- MySQL/MariaDB (MySQL Connector/J)
- Maven Wrapper (`mvnw`) for build/run

**Front-end**
- Single-page UI served from Spring Boot static resources
- HTML + Bootstrap 5 (CDN)
- Vanilla JavaScript using `fetch()` to call the REST API

Front-end entry point: `src/main/resources/static/index.html`

### Requirements / Prerequisites

- Java (JDK) installed
- MySQL or MariaDB running locally
- A database named `police_force_db` (or update the connection in `src/main/resources/application.properties`)

### Configuration

Update these in `src/main/resources/application.properties` as needed:

- `spring.datasource.url`
- `spring.datasource.username`
- `spring.datasource.password`

### Run

PowerShell:

```powershell
cd .
Remove-Item Env:SPRING_PROFILES_ACTIVE -ErrorAction SilentlyContinue
./mvnw spring-boot:run
```

Then open:
- `http://localhost:8080/`

If port `8080` is already in use, run on `8081`:

```powershell
./mvnw "-Dspring-boot.run.arguments=--server.port=8081" spring-boot:run
```

### REST API Endpoints (CRUD)

- Stations: `GET/POST /api/stations`, `GET/PUT/DELETE /api/stations/{id}`
- Officers: `GET/POST /api/officers`, `GET/PUT/DELETE /api/officers/{id}`
- Cases: `GET/POST /api/cases`, `GET/PUT/DELETE /api/cases/{id}`
- Suspects: `GET/POST /api/suspects`, `GET/PUT/DELETE /api/suspects/{id}`

### Database Schema (JPA Entities)

Tables (generated/managed by Hibernate):

**stations**
- `station_id` (PK)
- `name`
- `address`
- `phone`

**officers**
- `officer_id` (PK)
- `first_name`
- `last_name`
- `badge_number` (UNIQUE)
- `rank`
- `station_id` (FK → `stations.station_id`, nullable)

**cases**
- `case_id` (PK)
- `title`
- `description`
- `status`
- `date_opened`
- `date_closed`
- `lead_officer_id` (FK → `officers.officer_id`, nullable)

**suspects**
- `suspect_id` (PK)
- `first_name`
- `last_name`
- `dob`
- `address`
- `case_id` (FK → `cases.case_id`, nullable)

Relationships:
- Station 1 → many Officers
- Officer 1 → many Cases (as lead officer)
- Case 1 → many Suspects

### UI Features

- Create/List/Edit/Delete for all 4 entity types
- Relationship dropdowns (Station on Officer, Lead Officer on Case, Case on Suspect)
- Client-side search + reset per table (filters already-loaded rows)

