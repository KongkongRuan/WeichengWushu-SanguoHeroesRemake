@echo off
chcp 65001 >nul 2>&1
title 危城无双之三国群英 - FreeJ2ME

echo ============================================
echo     危城无双之三国群英 - 启动器
echo ============================================
echo.
echo  请选择分辨率模式:
echo.
echo  [1] 标准模式  (240x320,  放大2倍) - 原始手机分辨率
echo  [2] 高清模式  (480x640,  放大2倍) - 2x高清
echo  [3] 超清模式  (540x960,  放大2倍) - 适配现代屏幕
echo  [4] 原始模式  (1080x1920, 放大1倍) - JAD标注分辨率
echo  [5] 自定义
echo  [0] 退出
echo.
set /p choice="请输入选择 (1-5, 0退出): "

set WIDTH=240
set HEIGHT=320
set SCALE=2

if "%choice%"=="1" (
    set WIDTH=240
    set HEIGHT=320
    set SCALE=2
)
if "%choice%"=="2" (
    set WIDTH=480
    set HEIGHT=640
    set SCALE=2
)
if "%choice%"=="3" (
    set WIDTH=540
    set HEIGHT=960
    set SCALE=2
)
if "%choice%"=="4" (
    set WIDTH=1080
    set HEIGHT=1920
    set SCALE=1
)
if "%choice%"=="5" (
    set /p WIDTH="请输入宽度 (如 320): "
    set /p HEIGHT="请输入高度 (如 480): "
    set /p SCALE="请输入放大倍数 (1-4): "
)
if "%choice%"=="0" exit

echo.
echo  正在启动游戏: %WIDTH%x%HEIGHT% 放大%SCALE%倍...
echo  (窗口大小: %WIDTH%*%SCALE% x %HEIGHT%*%SCALE%)
echo.
echo  操控说明:
echo    方向键 = 移动导航
echo    Enter  = 确认/开火
echo    Q/W    = 左/右软键
echo    E/R    = * / # 键
echo    ESC    = 设置菜单
echo    +/-    = 窗口缩放
echo    Ctrl+C = 截图
echo.

cd /d C:\FreeJ2ME\build
java -jar freej2me.jar "file:///C:\FreeJ2ME\build\game.jar" %WIDTH% %HEIGHT% %SCALE%

pause
