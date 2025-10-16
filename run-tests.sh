#!/bin/bash
mvn clean test
# generate report if allure CLI installed
if command -v allure >/dev/null 2>&1; then
  allure serve allure-results
else
  echo "Allure CLI not found. Install it to view HTML reports or run: mvn allure:report"
fi
