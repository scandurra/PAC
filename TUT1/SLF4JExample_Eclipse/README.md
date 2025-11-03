SLF4J Example (Eclipse / Maven)
================================

This project demonstrates basic logging usage with SLF4J (API) and Logback (implementation).

Files:
- pom.xml : Maven project file
- src/main/java/it/example/logging/App.java : example application (uses MDC, parameterized logging, levels)
- src/main/resources/logback.xml : Logback configuration (console + rolling file)

Import in Eclipse:
- File -> Import... -> Existing Maven Projects -> select project root -> Finish

Notes:
- Logs will be written to console and to logs/app.log (and rotated daily / by size).
- Adjust logback.xml for environment-specific settings (production vs development).
