CrystalKillListener
---
![Build](https://github.com/GuangChen2333/CrystalKillListener/actions/workflows/build.yml/badge.svg)
![MAVEN](https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Fs01.oss.sonatype.org%2Fcontent%2Frepositories%2Fsnapshots%2Fio%2Fgithub%2Fguangchen2333%2FCrystalKillListener%2Fmaven-metadata.xml&style=flat)
![LICENSE](https://img.shields.io/github/license/GuangChen2333/CrystalKillListener?style=flat)
![STARS](https://img.shields.io/github/stars/GuangChen2333/CrystalKillListener)

> Add an event on Spigot API to listen to players kill a player with EnderCrystal

Supported Minecraft Versions: 1.12 

(1.8 maybe, it can run on the 1.8, Other versions have not been tested)

## Usage
1. Drag & Drop the JAR into the 'plugins' folder of your server.

2. Include the following in your project's plugin.yml

```yaml
depend:
  - CrystalKillListener
```

3. Add dependencies to your build tools.

<details open>
<summary><strong>Gradle :</strong></summary>

```groovy
repositories {
    maven {
        url = "https://s01.oss.sonatype.org/content/repositories/snapshots/"
    }
}

dependencies {
    compileOnly 'io.github.guangchen2333:CrystalKillListener:1.1-SNAPSHOT'
}
```

</details>

<details>
<summary><strong>Maven: </strong></summary>

```xml
<repositories>
    <repository>
        <id>snposs</id>
        <url>https://s01.oss.sonatype.org/content/repositories/snapshots/</url>
    </repository>
</repositories>
```

```xml
<dependencies>
    <dependency>
        <groupId>io.github.guangchen2333</groupId>
        <artifactId>CrystalKillListener</artifactId>
        <version>1.1-SNAPSHOT</version>
        <scope>compile</scope>
    </dependency>
</dependencies>
```

</details>