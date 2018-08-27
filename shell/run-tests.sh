#!/bin/bash

cd ../src/test/java
java -cp ../../../lib/junit.jar:../../../lib/hamcrest.core.jar org.junit.runner.JUnitCore ProcessorGFTTest
