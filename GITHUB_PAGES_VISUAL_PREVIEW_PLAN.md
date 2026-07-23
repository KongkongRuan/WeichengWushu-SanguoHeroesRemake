# GitHub Pages 画面改版预发布计划

## 1. 当前状态

- 状态：**等待 `master` 当前功能开发完成后实施**。
- 当前阶段只保留本计划，不修改 `.github/workflows/deploy-pages.yml`。
- 正式分支：`master`。
- 预览分支：`preview/visual-redesign`。
- 只使用一个 GitHub Pages 工作流，不新增第二个部署工作流。

执行本计划时，应从已经完成、测试通过并成功发布的最新 `master` 创建预览分支，确保画面改版以当时的正式功能为基线。

## 2. 目标地址

正式版保持现有地址：

```text
https://kongkongruan.github.io/WeichengWushu-SanguoHeroesRemake/
```

画面改版预览地址：

```text
https://kongkongruan.github.io/WeichengWushu-SanguoHeroesRemake/preview/visual-redesign/
```

预览分支的代码不得覆盖正式地址。正式地址的内容必须始终由 `master` 构建，预览地址的内容必须由 `preview/visual-redesign` 构建。

## 3. 为什么只使用一个工作流

一个 GitHub 仓库只有一个 GitHub Pages 站点目标。两个工作流分别调用 `actions/deploy-pages` 时，会向同一个站点部署完整 artifact，存在互相覆盖和并发竞争的风险。

因此应把现有 `.github/workflows/deploy-pages.yml` 改造成单一组合部署工作流：

```text
master 构建产物
└── site/
    ├── index.html
    ├── assets/
    └── 其他正式版资源

preview/visual-redesign 构建产物
└── site/preview/visual-redesign/
    ├── index.html
    ├── assets/
    └── 其他预览版资源
```

然后只上传并部署一次完整的 `site/`。

工作流需要监听：

```yaml
on:
  push:
    branches:
      - master
      - preview/visual-redesign
  workflow_dispatch:
```

无论哪个分支触发，都应重新读取两个分支的最新版本并组合部署。这样：

- 推送 `master` 后，正式版更新，同时保留并重新构建预览版。
- 推送 `preview/visual-redesign` 后，预览版更新，正式版仍从 `master` 构建。
- 不依赖上一次 Pages artifact，也不会因为某次部署丢失另一个目录。

## 4. 实施顺序

### 阶段 A：完成并发布当前 `master`

在开始画面改版之前：

1. 完成当前 `master` 的功能开发。
2. 确认应该进入正式版的修改已经全部提交。
3. 在 `game/` 中运行测试和构建。
4. 推送 `master` 到 GitHub。
5. 等待现有 Pages 工作流成功完成。
6. 在无痕窗口验收正式地址。
7. 确认本地工作区干净。

建议命令：

```powershell
Set-Location game
npm test
npm run build
Set-Location ..
git status
git push github master
```

只有以下条件全部满足，才进入阶段 B：

- `master` 的测试、构建均通过。
- GitHub Actions 中正式部署成功。
- 正式地址可以正常开始游戏。
- `git status` 没有遗漏的功能修改。

### 阶段 B：升级 Pages 工作流

当前功能版发布成功后，在 `master` 上把现有 `deploy-pages.yml` 改造成组合部署工作流，并作为独立 CI 提交，不夹带游戏功能或画面代码。

建议提交信息：

```text
ci: add isolated GitHub Pages visual preview
```

此时 `preview/visual-redesign` 可能尚未存在，所以新工作流必须允许预览分支不存在：

- 找不到预览分支时，只构建和发布 `master`。
- 找到预览分支后，构建并发布正式版和预览版。
- 预览分支不存在不能让正式版部署失败。

提交并推送工作流后，先确认正式地址没有变化，再进入阶段 C。

### 阶段 C：从最新 `master` 创建画面分支

工作流升级且正式部署验收成功后，从最新 `master` 创建预览分支：

```powershell
git switch master
git pull --ff-only github master
git status
git switch -c preview/visual-redesign
git push -u github preview/visual-redesign
```

创建分支前，`git status` 应当是干净的。不要从带有未提交修改或落后于 GitHub 的 `master` 创建预览分支。

第一次推送预览分支时，两个地址的游戏内容应当相同。这是组合部署和子目录资源加载的基线测试。

### 阶段 D：开发和发布画面改版

后续画面开发只在 `preview/visual-redesign` 进行：

```powershell
git switch preview/visual-redesign
```

每个可测试阶段执行：

```powershell
Set-Location game
npm test
npm run build
Set-Location ..
git status
git add <本次修改的文件>
git commit -m "feat: update visual presentation"
git push github preview/visual-redesign
```

推送完成且 Actions 成功后，预览 URL 更新；正式 URL 继续展示 `master` 版本。

## 5. 存档隔离是强制要求

正式版与预览版虽然 URL 路径不同，但都位于同一个 origin：

```text
https://kongkongruan.github.io
```

浏览器 `localStorage` 按 origin 隔离，不按路径隔离。当前项目使用以下固定键名：

```text
weicheng_save_v1
weicheng_settings_v1
weicheng_cheat_profile_v1
weicheng_enhancement_profile_v1
```

如果不处理，预览版会读取或覆盖正式版的存档、设置及强化进度。画面改版分支首次公开预览前，必须为预览路径增加独立存储命名空间，并满足：

- 正式路径继续使用现有键名，不能让正式玩家丢档。
- 预览路径使用单独的 preview 键名。
- 正式版和预览版分别保存、刷新、删除存档时互不影响。
- 将来画面改版合并回 `master` 后，正式路径仍使用原有正式键名。

可以根据部署路径或明确的构建渠道选择存储命名空间，但不要通过手工修改浏览器数据来规避该问题。

## 6. 工作流实现要求

正式编写 `deploy-pages.yml` 时必须满足：

- 使用现有的 GitHub Pages 官方 Actions 发布方式。
- 保留 `contents: read`、`pages: write` 和 `id-token: write` 权限。
- 保留统一的 `pages` concurrency group。
- 分别 checkout `master` 与 `preview/visual-redesign` 到不同目录。
- 两个源码目录分别执行 `npm ci`、`npm test` 和 `npm run build`。
- 正式构建结果复制到最终 artifact 根目录。
- 预览构建结果复制到 `preview/visual-redesign/`。
- 只调用一次 `actions/upload-pages-artifact`。
- 只调用一次 `actions/deploy-pages`。
- 预览分支不存在时安全跳过预览构建。
- 任意一个需要发布的版本测试或构建失败时，不执行部署。

还要在 GitHub 仓库中检查：

```text
Settings → Environments → github-pages
```

如果设置了 deployment branch protection rules，需要允许 `master` 和 `preview/visual-redesign` 触发部署。

## 7. 项目路径兼容性

`game/vite.config.ts` 当前使用：

```ts
base: './',
```

游戏图片、精灵图和 MIDI 等也主要使用相对路径，所以构建结果适合放入 `preview/visual-redesign/` 子目录。实施工作流时不应把 Vite `base` 改成只适用于正式地址的绝对路径。

预览版还应考虑：

- 加入 `noindex`，避免搜索引擎收录预发布页面。
- 保持 canonical 指向正式地址。
- 检查分享卡片是否应继续使用正式版 URL 和封面。

## 8. 验收清单

### 自动化验收

- `master` push 能触发唯一的 Pages 工作流。
- `preview/visual-redesign` push 能触发同一个工作流。
- 两套源码均通过测试和构建。
- Actions 只产生一次 Pages 部署。
- 工作流失败时不会发布残缺 artifact。

### 正式版验收

- 正式 URL 能正常加载。
- Network 中没有关键资源 404。
- 可以进入游戏、播放声音并完成基本操作。
- 原有正式存档仍然存在。
- 预览版操作不会改变正式版存档。

### 预览版验收

- 预览 URL 能直接打开和刷新。
- 脚本、字体、图片、精灵图、地图和 MIDI 没有路径错误。
- 桌面和移动端画面符合预期。
- 预览存档刷新后仍存在。
- 预览存档不会出现在正式版中。
- 正式版后续重新部署时，预览 URL 不会变成 404。

## 9. 合并或取消预览

画面改版验收完成后：

1. 将 `preview/visual-redesign` 合并回 `master`。
2. 推送 `master`，让正式地址发布合并后的版本。
3. 再次确认正式存档键名和旧存档兼容。
4. 删除预览分支前，先决定是否继续保留预览 URL。
5. 若不再保留，修改组合工作流，使下一次部署不再生成 `preview/visual-redesign/` 目录。

如果取消画面改版，不需要回滚 `master` 的游戏代码，因为开发代码没有进入 `master`。删除预览分支，并让工作流下一次只生成正式目录即可移除预览页面。

## 10. 完成标准

满足以下条件后，可认为预发布方案实施完成：

- 画面分支从已验收的最新 `master` 创建。
- 仓库只有一个 Pages 部署工作流。
- 正式版和预览版可通过各自 URL 同时访问。
- 正式内容只来自 `master`。
- 预览内容只来自 `preview/visual-redesign`。
- 两套游戏的存档和设置互不影响。
- 任一分支后续推送都不会意外删除另一套页面。
