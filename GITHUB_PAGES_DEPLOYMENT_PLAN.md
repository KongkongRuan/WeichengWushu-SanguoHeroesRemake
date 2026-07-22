# GitHub Pages 发布方案

## 1. 结论

这个项目可以发布到 GitHub Pages，让其他人直接在浏览器中体验。

当前游戏是一个位于 `game/` 目录的 Vite + TypeScript 纯前端项目，构建输出是 `game/dist/`。它不依赖后端服务器，也没有需要服务器重写规则的前端路由，因此符合 GitHub Pages 的静态托管方式。

当前项目已经具备的有利条件：

- `game/package.json` 已有 `npm run build` 命令。
- `game/vite.config.ts` 的 `base` 已设为 `./`，可适配 `https://<用户名>.github.io/<仓库名>/` 这种子目录地址。
- 图片和 MIDI 使用 `./sprites/...`、`./mid/...` 等相对路径。
- 地图 JSON 已在构建时嵌入 JavaScript，不依赖部署后的绝对 URL。
- 当前构建产物约 5.15 MiB，远低于 GitHub Pages 的常见容量限制。

推荐使用 **GitHub Actions 自动构建并部署**。以后每次把代码推送到发布分支，GitHub 会自动执行安装、测试、构建和上线，不需要手工提交 `dist/`。

预计正式访问地址：

```text
https://<GitHub用户名>.github.io/<GitHub仓库名>/
```

如果仓库名恰好是 `<GitHub用户名>.github.io`，则地址会是：

```text
https://<GitHub用户名>.github.io/
```

## 2. 发布前必须先决定的事

### 2.1 决定哪些内容可以公开

GitHub Pages 只会把 `game/dist/` 发布成网页，但如果 GitHub 仓库设为公开，仓库中的其他文件也会公开。目前仓库不只有 H5 游戏源码，还包含：

- 原始 APK 和 J2ME/JAR 文件；
- 反编译代码及分析产物；
- 从原游戏提取的图片、地图和 MIDI；
- 第三方反编译工具与二进制文件。

因此，正式发布前需要确认自己有权公开、传播相关游戏代码、名称、图片和音乐素材。技术上能发布不等于拥有传播授权。建议至少补充一个 README，写明项目性质、素材来源、非商业用途说明、版权归属和联系/下架方式；免责声明不能替代版权所有者的许可。

公开方式有两种：

1. **直接公开完整仓库**：操作最少，但上述分析文件、APK、反编译内容也会全部公开。
2. **建立单独的公开发布仓库**：只放网页构建产物，或只放允许公开的 `game/` 源码。公开面更小，但需要额外维护发布同步流程。

若素材授权不明确，推荐先厘清授权，再决定是否公开；若只是暂时给少数人测试，可先本地预览或使用有访问控制的托管方式。

### 2.2 整理当前 Git 状态

检查时，仓库状态不是干净的：

```text
当前分支：codex/fix-original-fidelity-controls
已修改：game/src/core/Game.ts
已修改：game/src/core/SaveSystem.ts
已修改：game/src/core/UI.ts
未跟踪：game/src/core/CheatProgress.ts
```

正式部署前，应先确认这些修改是否属于准备发布的版本，然后提交、合并到发布分支，或者明确排除。不要在工作区尚有重要未提交改动时直接切换/合并分支。

现有默认分支名是 `master`，所以下文工作流监听 `master`。如果以后改用 `main`，需要同时修改工作流里的分支名。

## 3. 推荐实施步骤

### 第一步：在 GitHub 创建仓库

在 GitHub 新建一个仓库，例如：

```text
WeichengWushu-SanguoHeroesRemake
```

如果准备推送当前仓库的完整历史，新建时不要勾选自动创建 README、`.gitignore` 或 License，以免产生无关的初始提交和历史冲突。

使用 GitHub 免费版发布公开 Pages 时，最简单的选择是公开仓库。私有仓库能否使用 Pages 取决于 GitHub 账户和组织套餐。

### 第二步：保留 Gitee，并新增 GitHub 远端

当前 `origin` 指向 Gitee：

```text
https://gitee.com/RuanKongkong/WeichengWushu-SanguoHeroesRemake.git
```

为了不破坏已有 Gitee 推送习惯，建议不要替换 `origin`，而是额外添加名为 `github` 的远端：

```powershell
git remote add github https://github.com/<GitHub用户名>/<GitHub仓库名>.git
git remote -v
```

在发布版本已经提交并合并到 `master` 后，再推送：

```powershell
git push -u github master
```

认证可以使用 GitHub CLI、浏览器凭据管理器或 Personal Access Token；GitHub 已不支持用账户密码直接执行 Git HTTPS 推送。

### 第三步：添加 GitHub Pages 工作流

后续实施时，新建：

```text
.github/workflows/deploy-pages.yml
```

推荐内容如下：

```yaml
name: Deploy game to GitHub Pages

on:
  push:
    branches:
      - master
  workflow_dispatch:

permissions:
  contents: read
  pages: write
  id-token: write

concurrency:
  group: pages
  cancel-in-progress: false

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - name: Checkout
        uses: actions/checkout@v4

      - name: Setup Node.js
        uses: actions/setup-node@v4
        with:
          node-version: 20
          cache: npm
          cache-dependency-path: game/package-lock.json

      - name: Install dependencies
        working-directory: game
        run: npm ci

      - name: Run tests
        working-directory: game
        run: npm test

      - name: Build
        working-directory: game
        run: npm run build

      - name: Configure Pages
        uses: actions/configure-pages@v5

      - name: Upload Pages artifact
        uses: actions/upload-pages-artifact@v3
        with:
          path: game/dist

  deploy:
    environment:
      name: github-pages
      url: ${{ steps.deployment.outputs.page_url }}
    runs-on: ubuntu-latest
    needs: build
    steps:
      - name: Deploy to GitHub Pages
        id: deployment
        uses: actions/deploy-pages@v5
```

注意：这些 GitHub 官方 Action 将来可能发布新主版本。真正实施时，可以再对照 GitHub Pages 官方文档确认最新推荐版本。

### 第四步：设置 GitHub Pages 来源

进入 GitHub 仓库：

```text
Settings → Pages → Build and deployment → Source
```

选择：

```text
GitHub Actions
```

然后提交并推送工作流。可以通过下面的位置观察执行情况：

```text
GitHub 仓库 → Actions → Deploy game to GitHub Pages
```

第一次成功后，Pages 页面和工作流摘要中会显示正式访问地址。部署通常需要几十秒到几分钟，偶尔会有缓存延迟。

### 第五步：验收线上版本

不要只确认首页能打开，至少执行以下检查：

- 首屏能从“加载中”进入游戏；
- 浏览器开发者工具 Network 中没有关键资源 404；
- 图片、中文字体、地图均能显示；
- 点击或触摸后能播放音乐；
- 能开始一局、放置建筑、生成敌人并完成基本交互；
- 存档后刷新页面，确认本地存档仍在；
- 在 Chrome/Edge 桌面端和手机浏览器各测试一次；
- 用无痕窗口测试，排除本机缓存造成的假成功。

GitHub Pages 使用 HTTPS，当前使用的 Web Audio、`localStorage` 和 Canvas 均可正常工作。存档保存在访问者自己的浏览器中，不会上传到 GitHub，也不会在不同设备间同步。

## 4. 当前项目不需要修改的地方

### Vite 基础路径

`game/vite.config.ts` 当前已有：

```ts
base: './',
```

这是适合本项目的设置。构建后的脚本、样式、图片和 MIDI 会相对于当前页面加载，无需提前写死仓库名，也能兼容将来改仓库名或使用自定义域名。

### 构建目录

`game/dist/` 已被 `.gitignore` 忽略。使用 Actions 发布时，这正是推荐状态：构建结果作为 Pages artifact 上传，不需要把 `dist/` 提交到源码分支。

### 404 回退文件

当前游戏没有基于 URL 的多页面路由，通常不需要额外复制 `index.html` 为 `404.html`。若以后加入 History API 路由，再补 Pages 的 SPA 回退方案。

## 5. 已识别的风险和处理办法

### 5.1 npm 锁文件使用国内镜像地址

`game/package-lock.json` 中不少依赖的下载地址指向 npmmirror 或华为云镜像。GitHub 的 Ubuntu runner 通常可以访问它们，但可能因跨境网络或镜像状态导致 `npm ci` 偶发失败。

在正式加工作流前，建议用 Node.js 20 在一个干净环境验证：

```powershell
Set-Location game
npm ci
npm test
npm run build
```

如果 Actions 安装依赖时持续出现网络错误，再使用官方 npm registry 重新生成并提交锁文件。不要在没有原因时删除锁文件，因为 `npm ci` 依赖它来保证可复现构建。

### 5.2 SoundFont 依赖远程资源

`soundfont-player` 默认可能从远程站点加载钢琴 SoundFont。远程资源若被拦截、跨域失败或加载缓慢，当前代码会回退到 Web Audio 合成音，因此通常不会阻止游戏启动，但音色可能不同。

如果希望完全离线且音色稳定，后续可把合法授权的 SoundFont 静态文件放到本项目中并改成本地加载。这不是首次发布 GitHub Pages 的必要条件。

### 5.3 浏览器自动播放限制

现代浏览器通常不允许网页在用户交互前自动播放声音。玩家第一次点击或触摸游戏后才有声音属于正常现象，不是 Pages 故障。

### 5.4 中国大陆访问稳定性

GitHub Pages 在中国大陆的访问速度和可用性可能因网络环境不同而波动。若主要玩家位于中国大陆，发布成功后应实地测试；必要时再增加国内静态托管或 CDN 作为镜像。该问题不影响 GitHub Pages 本身的技术部署流程。

### 5.5 仓库公开范围和体积

当前最大受 Git 跟踪文件约 53.5 MiB，未超过 GitHub 单文件 100 MiB 的硬性限制；整个 Git 数据目前也不大。因此从文件大小看可以推送，但公开完整反编译资料和二进制文件是否必要，仍应从版权、隐私和仓库整洁度判断。

## 6. 更新、回滚和维护

工作流建立后，日常发布流程是：

1. 在功能分支开发并本地测试；
2. 提交修改；
3. 合并到 `master`；
4. 推送 `master` 到 GitHub；
5. GitHub Actions 自动部署；
6. 在线验收。

如果新版本有严重问题，优先用 `git revert <有问题的提交>` 生成一个可追踪的回滚提交，再推送 `master`，Actions 会自动把回滚后的版本重新上线。不要用强制推送覆盖公开分支历史，除非非常清楚影响。

建议后续补充：

- 项目首页 README，包括在线体验链接和操作说明；
- 明确的许可证或“暂不授予许可”说明；
- 素材来源与版权说明；
- 发布前测试清单；
- 可选的自定义域名和 HTTPS 配置。

## 7. 实施时的最小改动清单

首次发布真正需要的项目改动只有：

1. 新增 `.github/workflows/deploy-pages.yml`；
2. 视公开要求补充 README/版权说明；
3. 仅在 Actions 无法稳定安装依赖时，处理 `game/package-lock.json` 的镜像地址。

现阶段不需要改 `game/vite.config.ts`、游戏源码或资源引用。

## 8. 发布完成标准

满足以下条件即可认为发布完成：

- GitHub 目标仓库和 Pages 公开范围符合预期；
- `master` 中包含确认过的游戏版本；
- Pages 工作流的测试、构建、部署全部通过；
- 正式 URL 可在未登录 GitHub的无痕窗口打开；
- 桌面端和移动端完成一轮基本游玩验证；
- README 中提供在线体验地址及版权/项目性质说明。
