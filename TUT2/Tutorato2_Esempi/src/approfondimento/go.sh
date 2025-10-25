#!/bin/bash

GREEN='\033[0;32m'
RED='\033[0;31m'
NC='\033[0m'

echo "Compiling Java files..."

# Compile Java files and output class files to parent directory
# This creates the package structure in the parent folder
javac -d .. *.java

if [ $? -eq 0 ]; then
    echo -e "${GREEN}Compilation successful!${NC}"
    echo "Running OpenSaveApp..."
    echo "----------------------------------------"
    
    # Run from parent directory using classpath
    cd ..
    java approfondimento.OpenSaveApp
    
else
    echo -e "${RED}Compilation failed!${NC}"
    exit 1
fi
