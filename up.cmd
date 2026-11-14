
chcp 65001 >nul
@echo off
title Gerador de README - Projeto Java LP2 2026

REM === Configurações ===
set "project_name=sfin - Sistema de Finanças (em desenvolvimento)"
set "author=Josimar Ribeiro"
set "save_path=%CD%"
set "date_time=%DATE% %TIME%"

set "logo_url2=https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/310597043/original/d3aa29b66783cc7d6e28fd86b4818742dbbf8f68/develop-spring-boot-web-application-with-spring-security-thymleaf-mysql.png"

set "filename=README.md"

REM === Cria o README.md ===
echo # %project_name% > "%filename%"
echo. >> "%filename%"
echo ## Informações do sistema >> "%filename%"
echo - Data e hora: %date_time% >> "%filename%"
echo - Usuário: %USERNAME% >> "%filename%"
echo - Computador: %COMPUTERNAME% >> "%filename%"
echo - Diretório atual: %CD% >> "%filename%"
for /f "tokens=* delims=" %%g in ('git --version') do echo - %%g >> "%filename%"
echo. >> "%filename%"

echo ^<img src="%logo_url2%" width="300"^> >> "%filename%"

echo. >> "%filename%"
echo ## Autor >> "%filename%"
echo %author% >> "%filename%"
echo. >> "%filename%"

set "REG_PATH=HKLM\SOFTWARE\Microsoft\Windows NT\CurrentVersion"

for /f "tokens=3" %%a in ('reg query "%REG_PATH%" /v CurrentBuild') do set "BUILD_NUM=%%a"
for /f "tokens=3" %%a in ('reg query "%REG_PATH%" /v UBR') do set /a "UBR_NUM=%%a"
for /f "tokens=3" %%a in ('reg query "%REG_PATH%" /v CurrentVersion') do set "OS_VER=%%a"
for /f "tokens=3" %%a in ('reg query "%REG_PATH%" /v BuildLabEx') do set "BUILD_INFO=%%a"

echo - Versao do Windows: %OS_VER% >> "%filename%"
echo - Build: %BUILD_NUM%.%UBR_NUM% >> "%filename%"
echo - Detalhes: %BUILD_INFO% >> "%filename%"
echo. >> "%filename%"
echo Usando : Netbeans 12 +  Tomcat 9 e Java 11 >> "%filename%"
echo. >> "%filename%"
echo OBS : atalho para out.println(""); >> "%filename%"
echo. >> "%filename%"


::git init
git add . -v
git commit -m "first commit"
git branch -M main
git remote set-url origin https://github.com/Prof-Josimar/testemuitobom.git
git push -u origin main