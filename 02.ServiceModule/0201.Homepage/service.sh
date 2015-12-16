#!/usr/bin/env bash

mvn clean package
unzip ./target/homepage_service.zip -d ./target/homepage_service/
java -Djava.ext.dirs=./target/homepage_service cn.martin.homepage.Launcher
