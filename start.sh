#!/bin/bash

exec java -XX:NativeMemoryTracking=detail -Xmx50m -jar hello-world.jar 
