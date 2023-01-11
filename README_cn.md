CrystalKillListener
---
![Build](https://github.com/GuangChen2333/CrystalKillListener/actions/workflows/build.yml/badge.svg)
![Dev-Build](https://github.com/GuangChen2333/CrystalKillListener/actions/workflows/dev-build.yml/badge.svg)
![MAVEN](https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Fs01.oss.sonatype.org%2Fcontent%2Frepositories%2Fsnapshots%2Fio%2Fgithub%2Fguangchen2333%2FCrystalKillListener%2Fmaven-metadata.xml&style=flat)
![LICENSE](https://img.shields.io/github/license/GuangChen2333/CrystalKillListener?style=flat)
![STARS](https://img.shields.io/github/stars/GuangChen2333/CrystalKillListener)
![DOWNLOAD](https://img.shields.io/github/downloads/GuangChen2333/CrystalKillListener/total)

[English](https://github.com/GuangChen2333/CrystalKillListener/blob/master/README.md) | **简体中文**

> 在Spigot中添加一个玩家使用末影水晶击杀玩家的事件

受支持的Minecraft版本: 1.12

[**JavaDoc**](https://guangchen2333.github.io/CrystalKillListener/)
->
[**PlayerDeathByPlayerWithCrystalEvent**](
https://guangchen2333.github.io/CrystalKillListener/cn/guangchen233/crystallistener/events/PlayerDeathByPlayerWithCrystalEvent.html
)

## 使用方法

### 对于用户

将 `JAR` 文件放入服务器的 `plugins` 文件夹中

### 对于开发者

1. 在工程的 `plugin.yml` 中包含下列内容

```yaml
depend:
  - CrystalKillListener
```

2. 在你的构建工具中添加依赖项

<details open>
<summary><strong>Gradle :</strong></summary>

```groovy
repositories {
    maven {
        url = "https://s01.oss.sonatype.org/content/repositories/snapshots/"
    }
}

dependencies {
    compileOnly 'io.github.guangchen2333:CrystalKillListener:{VERSION}'
}
```

</details>

<details>
<summary><strong>Maven: </strong></summary>

```xml

<repositories>
    <repository>
        <id>OSSRH</id>
        <url>https://s01.oss.sonatype.org/content/repositories/snapshots/</url>
    </repository>
</repositories>
```

```xml

<dependencies>
    <dependency>
        <groupId>io.github.guangchen2333</groupId>
        <artifactId>CrystalKillListener</artifactId>
        <version>{VERSION}</version>
        <scope>compile</scope>
    </dependency>
</dependencies>
```

</details>

## 使用示例

```java
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import cn.guangchen233.crystallistener.events.PlayerDeathByPlayerWithCrystalEvent;

public class Example implements Listener {
    @EventHandler
    public void onPlayerDeathWithCrystal(PlayerDeathByPlayerWithCrystalEvent event) {
        System.out.println(event.toString());
    }
}
```

## 更新计划 | 2.0 版本

- [x] build(script): 更换新的发布插件

- [x] build(script): 标准化构建脚本

- [x] test(plugin-test): 增加测试插件项目

- [x] refactor(event): 重构事件方法

- [x] feat(event): 添加死亡信息相关方法

## 关于

如果你喜欢这个项目，请给本项目点个Star。

如果你有任何关于本项目的想法或建议，欢迎提交Pull Requests或Issue，我会认真的审核您的提交。
