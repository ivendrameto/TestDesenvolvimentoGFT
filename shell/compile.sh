#!/bin/bash

javac ../src/main/java/br/eti/vendrameto/gft/*.java
javac -classpath .:../src/main/java:../lib/junit.jar ../src/test/java/*.java
