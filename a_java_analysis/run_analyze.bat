@echo off
chcp 65001 >nul
set PYTHON=D:\Anaconda3\python.exe
set SCRIPT=%~dp0analyze_a_java.py
set OUTDIR=%~dp0..\output
if not exist "%OUTDIR%" mkdir "%OUTDIR%"

echo === Python version === > "%~dp0..\run_log.txt"
"%PYTHON%" --version >> "%~dp0..\run_log.txt" 2>&1
echo. >> "%~dp0..\run_log.txt"
echo === Running analyze_a_java.py === >> "%~dp0..\run_log.txt"
"%PYTHON%" "%SCRIPT%" >> "%~dp0..\run_log.txt" 2>&1
echo. >> "%~dp0..\run_log.txt"
echo === Exit code: %ERRORLEVEL% === >> "%~dp0..\run_log.txt"
echo DONE
