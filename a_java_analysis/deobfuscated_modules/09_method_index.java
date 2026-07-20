/**
 * ============================================================================
 *  模块 09: 完整方法索引
 * ============================================================================
 *
 *  本文件是 a 类所有方法的快速索引
 *  按方法名字母顺序排列, 标注功能、来源模块、Vineflower行号
 *
 *  来源标记:
 *    [VF]  = Vineflower 成功反编译
 *    [BC]  = Vineflower 失败, javap 字节码恢复
 *    [?]   = 功能未完全确认
 * ============================================================================
 */

/**
 * ============================================================================
 * A. J2ME 回调方法 (6个) — 模块 03
 * ============================================================================
 *
 * 方法                    | 返回类型 | 功能                    | VF行号 | 来源
 * ------------------------|----------|------------------------|--------|-----
 * paint(Graphics)         | void     | 渲染回调                | 27281  | [VF]
 * run()                   | void     | 游戏主循环              | 27351  | [VF]
 * keyPressed(int)         | void     | 按键处理                | 27169  | [VF]
 * keyReleased(int)        | void     | 按键释放                | 27275  | [VF]
 * showNotify()            | void     | Canvas显示通知          | 27505  | [VF]
 * hideNotify()            | void     | Canvas隐藏通知          | 27115  | [VF]
 */

/**
 * ============================================================================
 * B. A-Z 无参数方法 (26个) — 模块 04
 * ============================================================================
 *
 * 方法 | 返回类型 | 功能                              | VF行号 | 来源
 * -----|----------|----------------------------------|--------|-----
 * A()  | void     | 渲染分发器 (switch l)             | 4741   | [VF]
 * B()  | void     | 加载流程 (e/c调用链)              | 5443   | [VF]
 * C()  | void     | RMS 存档保存 "sanGuoTd"           | 5620   | [VF]
 * D()  | void     | RMS 存档读取 "sanGuoTdData"       | 6668   | [VF]
 * E()  | void     | RMS 存档读取 "freeGame"           | 7035   | [VF]
 * F()  | void     | 循环处理(15次)                    | 7270   | [VF]
 * G()  | void     | ★主帧更新逻辑 (状态机分发)        | 7309   | [VF]
 * H()  | void     | 调用 J()+I()                      | 7771   | [VF]
 * I()  | void     | 背景绘制                          | 7784   | [VF]
 * J()  | void     | 滚动计算                          | 7856   | [VF]
 * K()  | void     | 关卡选择 (switch aw)              | 8146   | [VF]
 * L()  | void     | 输入处理 (switch h1047)           | 8219   | [VF]
 * M()  | void     | 科技树                            | 8273   | [VF]
 * N()  | void     | 遍历 E1163 数组                   | 8469   | [VF]
 * O()  | void     | ★游戏状态更新 (aS/aR/aT)          | 8518   | [VF]
 * P()  | void     | 武将选择 (h1074)                  | 8568   | [VF]
 * Q()  | void     | 武将选择 (同P)                    | 8592   | [VF]
 * R()  | void     | 关卡推进 (o1077)                  | 8633   | [VF]
 * S()  | void     | 渲染 (r1086)                      | 8768   | [VF]
 * T()  | void     | 胜利检查 (aT==aX)                 | 8868   | [VF]
 * U()  | void     | 初始化 (aq,aw=0,bg=0)             | 8903   | [VF]
 * V()  | void     | 遍历 bf                           | 8955   | [VF]
 * W()  | void     | 地图主绘制 (825行)                | 9023   | [VF]
 * X()  | void     | ★★主游戏帧更新                    | 9224   | [VF]
 * Y()  | void     | 渲染 (n1152,b1066)                | 9590   | [VF]
 * Z()  | void     | 渲染 (bn)                         | 9926   | [VF]
 */

/**
 * ============================================================================
 * C. aa-az 方法 (26个) — 模块 05
 * ============================================================================
 *
 * 方法  | 返回类型 | 功能                           | VF行号 | 来源
 * ------|----------|-------------------------------|--------|-----
 * aa()  | void     | [?]                           | 13349  | [VF]
 * ab()  | void     | [?]                           | 13419  | [VF]
 * ac()  | void     | [?]                           | 13437  | [VF]
 * ad()  | void     | [?]                           | 13492  | [VF]
 * ae()  | void     | [?]                           | 13555  | [VF]
 * af()  | void     | [?]                           | 13574  | [VF]
 * ag()  | void     | [?] (298行)                   | 13592  | [VF]
 * ah()  | void     | [?]                           | 13890  | [VF]
 * ai()  | void     | [?]                           | 13975  | [VF]
 * aj()  | void     | [?]                           | 14081  | [VF]
 * ak()  | void     | [?] (297行)                   | 14159  | [VF]
 * al()  | void     | [?] (235行)                   | 14456  | [VF]
 * am()  | void     | [?]                           | 14691  | [VF]
 * an()  | void     | [?]                           | 14739  | [VF]
 * ao()  | void     | ★按键状态机分发 (switch l)     | 14790  | [VF]
 * ap()  | void     | 渲染 (b1015[175])              | 14870  | [VF]
 * aq()  | void     | 输入处理 (switch h1047)        | 14936  | [VF]
 * ar()  | void     | 渲染 (结局动画)                | 15006  | [VF]
 * as()  | void     | 状态机 (switch b1174)          | 15082  | [VF]
 * at()  | void     | 设置b1174=1                    | 15239  | [VF]
 * au()  | void     | 日历初始化                     | 15244  | [VF]
 * av()  | void     | ★启动游戏线程                  | 15268  | [BC]
 * aw()  | void     | ★RMS读取"__sfSmsInfo"          | 15313  | [BC]
 * ax()  | void     | RMS写入"__sfSmsInfo"           | 15473  | [VF]
 * ay()  | void     | 存档缓冲区处理                 | 15744  | [VF]
 */

/**
 * ============================================================================
 * D. a() 系列方法 (20+个) — 模块 06/07
 * ============================================================================
 *
 * 方法                              | 返回类型 | 功能                    | VF行号 | 来源
 * ----------------------------------|----------|------------------------|--------|-----
 * a()                               | int      | 随机数 0-255            | 9993   | [VF]
 * a(int)                            | int      | 瓦片属性 E1163[n]>>1    | 9997   | [VF]
 * a(int,int)                        | int      | 瓦片索引                | 10001  | [VF]
 * a(int,int,int)                    | int      | 角度计算 (正切表)       | 10009  | [VF]
 * a(int,int,int,int)                | int      | 距离/角度计算           | 10074  | [VF]
 * a(int,byte[],int)                 | int      | HP计算                  | 10095  | [VF]
 * a(DataInputStream)                | String   | 读取自定义格式字符串    | 10142  | [VF]
 * a(String)                         | String   | URL主机名提取           | 10170  | [VF]
 * a(InputStream)                    | short    | 读取2字节short          | 10184  | [VF]
 * a()                               | void     | 菜单返回 (m--,l=b[m])   | 10190  | [VF]
 * a(byte)                           | void     | 游戏模式设置            | 10199  | [VF]
 * a(int)                            | void     | 菜单跳转 (b[m]=l,l=n,m++)| 10214 | [VF]
 * a(int,int)                        | void     | 精灵图加载              | 10225  | [VF]
 * a(int,int,int)                    | void     | [?]                     | 10482  | [VF]
 * a(int,int,int,byte,int,boolean)   | void     | 瓦片填充 (建造/拆除)    | 10490  | [VF]
 * a(int,int,int,int)                | void     | [?]                     | 10573  | [VF]
 * a(int,int,int,int,int)            | void     | 范围攻击渲染            | 10672  | [VF]
 * a(int,int,int,int,int,int)        | void     | [?]                     | 10685  | [VF]
 * a(int,int,int,int,int,int,int)    | void     | [?]                     | 10701  | [VF]
 * a(int,...,8参数)                  | void     | [?]                     | 10775  | [VF]
 * a(int,int,int,int,boolean)        | void     | [?]                     | 10967  | [VF]
 * a(int,int,int,boolean)            | void     | [?]                     | 11010  | [VF]
 * a(int,int,boolean)                | void     | [?]                     | 11058  | [VF]
 * a(String)                         | void     | 滚动文字渲染            | 11087  | [VF]
 * a(String,int,int)                 | void     | [?]                     | 11094  | [VF]
 * a(String,int,int,int,int,int)     | void     | 文字面板绘制            | 11110  | [VF]
 * a(Image,int,int,int)              | void     | 旋转绘制图片            | 11150  | [VF]
 * a(Image,int,int,int,int)          | void     | 平铺绘制                | 11156  | [VF]
 * a(Image,...,6参数)                | void     | [?]                     | 11170  | [VF]
 * a(Image,...,7参数)                | void     | [?]                     | 11202  | [VF]
 * a(Image,...,8参数)                | void     | [?]                     | 11211  | [VF]
 * a(Image,...,9参数)                | void     | [?]                     | 11291  | [VF]
 * a(Image,...,10参数)               | void     | [?]                     | 11334  | [VF]
 * a(Image,int,int,int,boolean)      | void     | [?]                     | 11470  | [VF]
 * a(Image,Image,...,7参数)          | void     | [?]                     | 11485  | [VF]
 * a(Image,Image,Image,...,7参数)    | void     | [?]                     | 11632  | [VF]
 * a(boolean)                        | void     | 帮助页渲染              | 11675  | [VF]
 * a(byte[])                         | void     | [?]                     | 11772  | [VF]
 * a(char[],int,int,int,int,int,int,boolean) | void | 字符渲染        | 11784  | [VF]
 * a(int[],int[][],int,int)          | void     | 静态-数组处理           | 12007  | [VF]
 * a()                               | boolean  | ★RMS存档读取 "sanGuoTd" | 12049  | [VF]
 * a(int)                            | boolean  | 静态-布尔检查           | 13099  | [VF]
 * a(int,int)                        | boolean  | [?]                     | 13111  | [VF]
 * a(int,int,int)                    | boolean  | [?]                     | 13175  | [VF]
 * a(int,int,int,int,int)            | boolean  | [?]                     | 13249  | [VF]
 * a(int,int,int,int,int,int)        | boolean  | 静态-布尔检查           | 13262  | [VF]
 * a(int,int,int,boolean)            | boolean  | [?]                     | 13276  | [VF]
 */

/**
 * ============================================================================
 * E. b() 系列方法 (8个) — 模块 06/07
 * ============================================================================
 *
 * 方法              | 返回类型 | 功能                        | VF行号 | 来源
 * ------------------|----------|----------------------------|--------|-----
 * b()               | int      | ★同步锁+返回bV             | 15768  | [BC]
 * b(int)            | int      | ★敌人HP计算                | 15818  | [VF]
 * b(int,int)        | int      | 瓦片坐标转换               | 15841  | [VF]
 * b(int,int,int,int)| int      | 静态-计算                  | 15913  | [VF]
 * b(String)         | String   | URL重写(代理)              | 15923  | [VF]
 * b()               | void     | 菜单重置 (m=0)             | 15941  | [VF]
 * b(int)            | void     | 菜单回退到指定状态         | 15945  | [VF]
 * b(int,int)        | void     | 背景绘制                    | 15961  | [VF]
 * b(int,int,int)    | void     | [?]                         | 15989  | [VF]
 * b(int,int,int,int)| void     | [?]                         | 16046  | [VF]
 * b(int,int,int,int,int) | void| [?]                        | 16085  | [VF]
 * b(int,...,6参数)  | void     | [?]                         | 16109  | [VF]
 * b(int,...,8参数)  | void     | [?]                         | 16166  | [VF]
 * b(int,int,int,int,boolean) | void | [?]                    | 16316  | [VF]
 * b(String)         | void     | 静态-字符串处理            | 16351  | [VF]
 * b(Image,int,int,int) | void  | [?]                         | 16410  | [VF]
 * b(Image,int,int,int,int) | void | [?]                      | 16447  | [VF]
 * b(Image,...,9参数)| void     | [?]                         | 16479  | [VF]
 * b()               | boolean  | RMS存档读取 "sanGuoTdData"  | 16602  | [VF]
 * b(int)            | boolean  | 瓦片可建造检查             | 16845  | [VF]
 * b(int,int)        | boolean  | [?]                         | 16868  | [VF]
 */

/**
 * ============================================================================
 * F. c() 系列方法 (6个) — 模块 06/07
 * ============================================================================
 *
 * 方法              | 返回类型 | 功能                        | VF行号 | 来源
 * ------------------|----------|----------------------------|--------|-----
 * c()               | int      | ★循环调用d()               | 16889  | [VF]
 * c(int)            | int      | 静态-计算                  | 16902  | [VF]
 * c(int,int)        | int      | 坐标边界检查               | 16925  | [VF]
 * c(int,int,int)    | int      | [?]                         | 16946  | [VF]
 * c()               | void     | 重置计数器 (aP=0,bt=0)      | 16979  | [VF]
 * c(int)            | void     | ★精灵图加载                | 16985  | [VF]
 * c(int,int)        | void     | [?]                         | 17192  | [VF]
 * c(int,int,int)    | void     | [?]                         | 17241  | [VF]
 * c(int,int,int,int)| void     | [?]                         | 17252  | [VF]
 * c(int,int,int,int,int) | void| [?]                        | 17288  | [VF]
 * c(int,...,6参数)  | void     | [?]                         | 17379  | [VF]
 * c(int,int,int,int,boolean) | void | [?]                    | 17598  | [VF]
 * c(String)         | void     | 设备适配                    | 17673  | [VF]
 * c(Image,int,int,int) | void  | [?]                         | 17689  | [VF]
 * c()               | boolean  | RMS存档读取 "freeGame"      | 17696  | [VF]
 * c(int)            | boolean  | 瓦片奇偶检查               | 17854  | [VF]
 * c(int,int)        | boolean  | [?]                         | 17868  | [VF]
 */

/**
 * ============================================================================
 * G. d() 系列方法 (6个) — 模块 06/07
 * ============================================================================
 *
 * 方法              | 返回类型 | 功能                        | VF行号 | 来源
 * ------------------|----------|----------------------------|--------|-----
 * d()               | int      | ★★★HTTP通信               | 17883  | [BC]
 * d(int)            | int      | 瓦片类型转换               | 18640  | [VF]
 * d(int,int,int)    | int      | 静态-计算                  | 18663  | [VF]
 * d()               | void     | 建造菜单背景               | 18667  | [VF]
 * d(int)            | void     | 背景卷轴绘制               | 18699  | [VF]
 * d(int,int)        | void     | [?]                         | 18719  | [VF]
 * d(int,int,int)    | void     | [?]                         | 18758  | [VF]
 * d(int,int,int,int)| void     | [?]                         | 18772  | [VF]
 * d(int,int,int,int,int) | void| [?]                        | 18876  | [VF]
 * d(int,...,6参数)  | void     | [?]                         | 18882  | [VF]
 * d(Image,int,int,int) | void  | [?]                         | 18997  | [VF]
 * d()               | boolean  | 横屏标志检查               | 19041  | [VF]
 * d(int)            | boolean  | 敌人路径检查               | 19056  | [VF]
 * d(int,int)        | boolean  | [?]                         | 19214  | [VF]
 */

/**
 * ============================================================================
 * H. e()-z() 方法 — 模块 06/07
 * ============================================================================
 *
 * 方法              | 返回类型 | 功能                        | VF行号 | 来源
 * ------------------|----------|----------------------------|--------|-----
 * e(int)            | int      | 静态-计算                  | 19228  | [VF]
 * e()               | void     | 清屏                        | 19257  | [VF]
 * e(int)            | void     | 加载进度控制               | 19264  | [VF]
 * e(int,int)        | void     | [?]                         | 19287  | [VF]
 * e(int,int,int)    | void     | [?]                         | 19314  | [VF]
 * e(int,int,int,int)| void     | [?]                         | 19320  | [VF]
 * e(int,int,int,int,int) | void| [?]                        | 19357  | [VF]
 * e(Image,int,int,int) | void  | [?]                         | 19379  | [VF]
 * e()               | boolean  | 科技树全解锁检查           | 19432  | [VF]
 * e(int)            | boolean  | 敌人检查                   | 19455  | [VF]
 * e(int,int)        | boolean  | 瓦片==8检查                | 19613  | [VF]
 * f()               | void     | ★进度条渲染                | 19628  | [VF]
 * f(int)            | void     | [?]                         | 19681  | [VF]
 * f(int,int)        | void     | [?]                         | 19715  | [VF]
 * f(int,int,int)    | void     | [?]                         | 20071  | [VF]
 * f(int,int,int,int)| void     | [?]                         | 20267  | [VF]
 * f(int,int,int,int,int) | void| [?]                        | 20357  | [VF]
 * f(Image,int,int,int) | void  | [?]                         | 20420  | [VF]
 * f()               | boolean  | 初始化 (aw+au+E1179=true)   | 20430  | [VF]
 * f(int)            | boolean  | 静态-布尔检查              | 20438  | [VF]
 * f(int,int)        | boolean  | 瓦片==10检查               | 20456  | [VF]
 * g()               | void     | ★音量控制                  | 20471  | [VF]
 * g(int)            | void     | [?]                         | 20518  | [VF]
 * g(int,int)        | void     | [?]                         | 20808  | [VF]
 * g(int,int,int)    | void     | [?]                         | 21002  | [VF]
 * g(int,int,int,int)| void     | [?]                         | 21008  | [VF]
 * g(int,int,int,int,int) | void| [?]                        | 21087  | [VF]
 * g()               | boolean  | 网络上传                   | 21114  | [VF]
 * g(int)            | boolean  | 静态-布尔检查              | 21354  | [VF]
 * g(int,int)        | boolean  | [?]                         | 21366  | [VF]
 * h()               | void     | 结局文字渲染               | 21381  | [VF]
 * h(int)            | void     | [?]                         | 21414  | [VF]
 * h(int,int)        | void     | [?]                         | 21515  | [VF]
 * h(int,int,int)    | void     | [?]                         | 21715  | [VF]
 * h(int,int,int,int)| void     | [?]                         | 21750  | [VF]
 * h(int,int,int,int,int) | void| [?]                        | 21857  | [VF]
 * h(int)            | boolean  | 随机数比较                 | 21952  | [VF]
 * h(int,int)        | boolean  | [?]                         | 21964  | [VF]
 * i()               | void     | 输入处理                   | 21989  | [VF]
 * i(int)            | void     | MIDI播放器控制             | 22009  | [VF]
 * i(int,int)        | void     | [?]                         | 22068  | [VF]
 * i(int,int,int)    | void     | [?]                         | 22107  | [VF]
 * i(int,int,int,int)| void     | [?]                         | 22126  | [VF]
 * i(int)            | boolean  | [?]                         | 22219  | [VF]
 * i(int,int)        | boolean  | [?]                         | 22243  | [VF]
 * j()               | void     | 渲染                        | 22265  | [VF]
 * j(int)            | void     | [?]                         | 22347  | [VF]
 * j(int,int)        | void     | [?]                         | 22371  | [VF]
 * j(int,int,int)    | void     | [?]                         | 22413  | [VF]
 * j(int)            | boolean  | [?]                         | 22439  | [VF]
 * j(int,int)        | boolean  | [?]                         | 22453  | [VF]
 * k()               | void     | 初始化随机数               | 22470  | [VF]
 * k(int)            | void     | [?]                         | 22492  | [VF]
 * k(int,int)        | void     | [?]                         | 22538  | [VF]
 * k(int,int,int)    | void     | [?]                         | 22570  | [VF]
 * k(int,int)        | boolean  | [?]                         | 22585  | [VF]
 * l()               | void     | 地图绘制                    | 22601  | [VF]
 * l(int)            | void     | 更新塔逻辑                 | 22811  | [VF]
 * l(int,int)        | void     | [?]                         | 22950  | [VF]
 * l(int,int,int)    | void     | [?]                         | 22958  | [VF]
 * l(int,int)        | boolean  | [?]                         | 22967  | [VF]
 * m()               | void     | 敌人移动状态机             | 22984  | [VF]
 * m(int)            | void     | [?]                         | 23397  | [VF]
 * m(int,int)        | void     | [?]                         | 23416  | [VF]
 * m(int,int,int)    | void     | [?]                         | 23458  | [VF]
 * m(int,int)        | boolean  | [?]                         | 23535  | [VF]
 * n()               | void     | ★滚动位置更新              | 23551  | [VF]
 * n(int)            | void     | [?]                         | 23591  | [VF]
 * n(int,int)        | void     | [?]                         | 23611  | [VF]
 * n(int,int,int)    | void     | [?]                         | 23640  | [VF]
 * n(int,int)        | boolean  | [?]                         | 23685  | [VF]
 * o()               | void     | 状态机 (switch U)           | 23702  | [VF]
 * o(int)            | void     | [?]                         | 23725  | [VF]
 * o(int,int)        | void     | [?]                         | 23768  | [VF]
 * o(int,int,int)    | void     | [?]                         | 23806  | [VF]
 * o(int,int)        | boolean  | [?]                         | 23832  | [VF]
 * p()               | void     | ★背景清屏                  | 23848  | [VF]
 * p(int)            | void     | [?]                         | 23859  | [VF]
 * p(int,int)        | void     | [?]                         | 23898  | [VF]
 * p(int,int,int)    | void     | [?]                         | 23940  | [VF]
 * p(int,int)        | boolean  | [?]                         | 23964  | [VF]
 * q()               | void     | 菜单渲染                    | 23981  | [VF]
 * q(int)            | void     | [?]                         | 24149  | [VF]
 * q(int,int)        | void     | [?]                         | 24225  | [VF]
 * q(int,int,int)    | void     | [?]                         | 24321  | [VF]
 * q(int,int)        | boolean  | [?]                         | 24329  | [VF]
 * r()               | void     | 输入处理                   | 24345  | [VF]
 * r(int)            | void     | [?]                         | 24405  | [VF]
 * r(int,int,int)    | void     | [?]                         | 24522  | [VF]
 * s()               | void     | 存档面板                    | 24545  | [VF]
 * s(int)            | void     | [?]                         | 24631  | [VF]
 * s(int,int,int)    | void     | [?]                         | 24703  | [VF]
 * t()               | void     | 存档加载                    | 24708  | [VF]
 * t(int)            | void     | [?]                         | 24925  | [VF]
 * t(int,int,int)    | void     | [?]                         | 25020  | [VF]
 * u()               | void     | ★阵营选择状态机            | 25041  | [VF]
 * u(int)            | void     | [?]                         | 25232  | [VF]
 * u(int,int,int)    | void     | [?]                         | 25238  | [VF]
 * v()               | void     | ★阵营选择渲染              | 25285  | [VF]
 * v(int)            | void     | [?]                         | 25469  | [VF]
 * v(int,int,int)    | void     | [?]                         | 25478  | [VF]
 * w()               | void     | 特殊模式渲染               | 25793  | [VF]
 * w(int)            | void     | [?]                         | 25823  | [VF]
 * w(int,int,int)    | void     | [?]                         | 25959  | [VF]
 * x()               | void     | [?]                         | 26145  | [VF]
 * x(int)            | void     | [?]                         | 26182  | [VF]
 * y()               | void     | 地图渲染                    | 26190  | [VF]
 * y(int)            | void     | [?]                         | 26281  | [VF]
 * z()               | void     | ★敌人移动更新              | 26684  | [VF]
 * z(int)            | void     | [?]                         | 26859  | [VF]
 */

/**
 * ============================================================================
 * 统计
 * ============================================================================
 *
 * 总方法数: ~150+ (含重载)
 *   - J2ME回调: 6个
 *   - A-Z无参数: 26个
 *   - aa-ay: 25个
 *   - a()系列: 47个
 *   - b()系列: 21个
 *   - c()系列: 17个
 *   - d()系列: 14个
 *   - e()-z()系列: ~100个
 *
 * Vineflower成功: ~145个 (97%)
 * Vineflower失败: 5个 (3%) — b()/d()/av()/aw()/ay()
 * 字节码恢复: 5个 (100%)
 * ============================================================================
 */
