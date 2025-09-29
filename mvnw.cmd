@echo off
setlocal
where mvn >nul 2>nul
if %ERRORLEVEL% EQU 0 (
  mvn %*
) else (
  echo Maven not found. Install Maven or add the Maven wrapper (mvnw).
  exit /b 1
)
