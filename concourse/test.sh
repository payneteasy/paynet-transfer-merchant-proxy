#!/bin/bash
cd `dirname $0`

set -eux

cd ../paynet-transfer-merchant-proxy-db
../gradlew flywayMigrate

cd ../paynet-transfer-merchant-proxy-web
../gradlew clean build

cd ../paynet-transfer-merchant-proxy-web-integration-test
../gradlew clean build
