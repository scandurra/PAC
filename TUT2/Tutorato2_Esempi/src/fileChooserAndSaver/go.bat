@echo off

echo Compiling Java files...
javac -d .. *.java

if %errorlevel% equ 0 (
    echo Compilation successful!
    echo Running OpenSaveApp...
    echo ----------------------------------------
    cd ..
    java approfondimento.OpenSaveApp
) else (
    echo Compilation failed!
    exit /b 1
)