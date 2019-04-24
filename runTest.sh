#!/bin/bash

Xvfb :99 &
export local_addr="127.0.0.1:8080"

/Katalon_Studio_Linux_64-5.7.1/katalon --args -noSplash -runMode=console \
	-projectPath="HolygramKatalon" -retry=0 -testSuitePath="Test Suites/Basic" \
	-executionProfile="default" -browserType="Chrome (headless)" \
	-Djava.awt.headless
