#!/usr/bin/env bash
MAVEN_HOME=
if [ -x "./mvnw" ]; then
  exec ./mvnw "$@"
fi
if command -v mvn >/dev/null 2>&1; then
  mvn "$@"
else
  echo "Maven not found. Install Maven or add the Maven wrapper (mvnw)."
  exit 1
fi
