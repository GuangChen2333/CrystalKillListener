CrystalKillListener
---
![Build](https://github.com/GuangChen2333/CrystalKillListener/actions/workflows/build.yml/badge.svg)
![Dev-Build](https://github.com/GuangChen2333/CrystalKillListener/actions/workflows/dev-build.yml/badge.svg)
![MAVEN](https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Fs01.oss.sonatype.org%2Fcontent%2Frepositories%2Fsnapshots%2Fio%2Fgithub%2Fguangchen2333%2FCrystalKillListener%2Fmaven-metadata.xml&style=flat)
![LICENSE](https://img.shields.io/github/license/GuangChen2333/CrystalKillListener?style=flat)
![STARS](https://img.shields.io/github/stars/GuangChen2333/CrystalKillListener)
![DOWNLOAD](https://img.shields.io/github/downloads/GuangChen2333/CrystalKillListener/total)

**English** | [简体中文](https://github.com/GuangChen2333/CrystalKillListener/blob/master/README_cn.md)

Add an event in Spigot API to listen to players kill a player with End Crystal

Supported Minecraft Version: 1.12

[**JavaDoc**](https://guangchen2333.github.io/CrystalKillListener/)
->
[**PlayerDeathByPlayerWithCrystalEvent**](
https://guangchen2333.github.io/CrystalKillListener/cn/guangchen233/crystallistener/events/PlayerDeathByPlayerWithCrystalEvent.html
)

## Usage

### For Users

Drag & Drop the `JAR` into the `plugins` folder of your server.

### For Developers

1. Include the following in your project's `plugin.yml`

```yaml
depend:
  - CrystalKillListener
```

2. Add dependencies to your build tools.

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

## Usage example

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

## TO-DO | Version 2.0

- [x] build(script): new publish plugin

- [x] build(script): standardize build script

- [x] test(plugin-test): add test subproject in gradle

- [x] refactor(event): refactor the event functions

- [x] feat(event): add deathMessage method in event

## About

If you like this project, please give this project a star.

If you have any ideas or suggestions about this project, feel free to submit Pull Requests or Issue and I will review
them carefully.
