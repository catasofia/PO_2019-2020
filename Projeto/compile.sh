#!/bin/bash

NUM=0
SUC=0
FAIL=0
javac -cp po-uilib.jar:. `find m19 -name "*.java"`
java -cp po-uilib.jar:. -Dimport=tests/ImportGiant.import m19.app.App

rm -rf `find m19 -name "*.class"`
