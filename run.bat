@echo off
echo Compiling...

REM List all .java files recursively inside src into sources.txt
dir /s /b src\*.java > sources.txt

REM Compile all Java files into bin folder
javac -d bin --module-path "C:\javafx-sdk-21.0.8\lib" --add-modules javafx.controls,javafx.fxml ^
-cp "lib\sqlite-jdbc-3.50.3.0.jar;src" @sources.txt

if %errorlevel% neq 0 (
    echo Compilation failed.
    pause
    exit /b %errorlevel%
)

REM Copy all FXML files from src\main\view to bin\main\view
xcopy /E /I /Y src\main\view bin\main\view

del sources.txt

echo Running...
java --module-path "C:\javafx-sdk-21.0.8\lib" --add-modules javafx.controls,javafx.fxml ^
-cp "bin;lib\sqlite-jdbc-3.50.3.0.jar" main.Main

pause
