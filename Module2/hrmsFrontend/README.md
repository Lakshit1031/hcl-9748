# PeopleFlow HRMS

## Run locally

Requires Java 17 and Node.js 20.19+ (or 22.12+). From `hrmsdatabase`, run `./mvnw spring-boot:run` (Windows: `mvnw.cmd spring-boot:run`). In another terminal, from `hrmsFrontend`, run `npm install` and `npm run dev`. Open http://localhost:5173.

The frontend proxies `/api` to the backend at port 8080, so session cookies work on the same origin. Registration signs in immediately; login uses the employee ID and password. The dashboard reads the current employee's attendance, checks in once per day, and checks out. Dates and times use Asia/Kolkata. Local data persists in `hrmsdatabase/hrms-data.mv.db` (H2). To use MySQL instead, set `DB_USERNAME`, `DB_PASSWORD` and optionally `DB_URL`, then run with `--spring.profiles.active=mysql`. Existing plaintext passwords are upgraded to PBKDF2 on successful login.

Do not expose this development app directly to the public internet without adding production authentication hardening, CSRF protection, HTTPS and an appropriate deployment configuration.
