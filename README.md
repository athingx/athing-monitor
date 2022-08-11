```text
      _____ _     _
  __ /__   \ |__ (_)_ __   __ _
 / _` |/ /\/ '_ \| | '_ \ / _` |
| (_| / /  | | | | | | | | (_| |
 \__,_\/   |_| |_|_|_| |_|\__, |
                          |___/

Just a Thing
```

# 设备监控

## 框架使用

### 添加仓库

```xml
<!-- pom.xml增加仓库 -->
<repositories>
    <repository>
        <id>github</id>
        <url>https://maven.pkg.github.com/athingx/athing-monitor</url>
    </repository>
</repositories>
```

### 构建客户端

```xml
<!-- pom.xml增加引用 -->
<dependency>
    <groupId>io.github.athingx.athing</groupId>
    <artifactId>athing-monitor-thing</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

```java
// 构建设备监控
thingMonitor = new ThingMonitorBuilder()
        .build(thingDm);
```
