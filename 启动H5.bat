@echo off
chcp 65001 >nul 2>&1
title 危城无双之三国群英 - H5重制版

echo ============================================
echo     危城无双之三国群英 - H5重制版启动器
echo ============================================
echo.

REM 检查 Node.js 是否安装
where node >nul 2>&1
if errorlevel 1 (
    echo [错误] 未检测到 Node.js，请先安装 Node.js 16+ 后重试。
    echo        下载地址: https://nodejs.org/
    echo.
    pause
    exit /b 1
)

REM 显示 Node 版本
echo [1/3] Node.js 环境检查... OK
for /f "delims=" %%i in ('node -v') do set NODE_VER=%%i
echo        Node 版本: %NODE_VER%
echo.

REM 切换到游戏目录
cd /d "%~dp0game"

REM 检查 node_modules 是否存在，不存在则自动安装
if not exist "node_modules" (
    echo [2/3] 首次运行，正在安装依赖包...
    echo        ^(这可能需要1-3分钟，请耐心等待^)
    echo.
    call npm install
    if errorlevel 1 (
        echo.
        echo [错误] 依赖安装失败，请检查网络连接后重试。
        echo        可尝试使用镜像源: npm config set registry https://registry.npmmirror.com
        pause
        exit /b 1
    )
    echo.
    echo        依赖安装完成!
) else (
    echo [2/3] 依赖包检查... OK ^(已安装^)
)
echo.

echo [3/3] 正在启动开发服务器...
echo.
echo ============================================
echo  游戏启动后，浏览器会自动打开:
echo      http://localhost:3000
echo.
echo  操控说明:
echo    鼠标点击 = 选择菜单 / 放置建筑 / 升级
echo    空格/点击 = 开始游戏 / 进入下一关
echo    顶部按钮  = 暂停 / 加速 / 菜单
echo.
echo  按 Ctrl+C 可停止服务器
echo ============================================
echo.

REM 启动 vite 开发服务器
call npx vite --host

pause
