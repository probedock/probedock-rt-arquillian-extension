# probedock-rt-arquillian-extension

> [Arquillian](http://arquillian.org) extension to support the test filtering of Probe Dock RT.

When this extension is used with Arquillian, it is not necessary to use the [JUnit Probe Dock RT](http://github.com/probedock/probedock-rt-junit) probe. The probe
is shipped with this Arquillian extension.

## Requirements

* Java 6+
* Arquillian 1.10+

## Usage

1. Put the following dependency in your pom.xml

```xml
<dependency>
  <groupId>io.probedock.rt.client</groupId>
  <artifactId>probedock-rt-arquillian-extension</artifactId>
  <version>0.1.0</version>
  <scope>test</scope>
</dependency>
```

2. Configuration with Maven Surefire

```xml
<plugins>
  <!-- Add the Maven Surefire plugin or adapt its configuration. -->
  <plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>2.18.1</version>
    <configuration>
      <properties>
        <property>
          <name>listener</name>
          <value>io.probedock.rt.client.junit.ProbeRTListener</value>
        </property>
      </properties>
    </configuration>
  </plugin>
</plugins>
```

If you want to use Probe Dock and Probe Dock RT at the same time, you can configure several listeners in the `maven surefire`
plugin.

**Warning**: Take car of spaces, the plugin will consider them as part of class names. This will produce an error saying
the class is missing.

```xml
<plugins>
  <!-- Add the Maven Surefire plugin or adapt its configuration. -->
  <plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>2.18.1</version>
    <configuration>
      <properties>
        <property>
          <name>listener</name>
          <value>io.probedock.client.junit.ProbeListener,io.probedock.rt.client.junit.ProbeRTListener</value>
        </property>
      </properties>
    </configuration>
  </plugin>
</plugins>
```

3. Nothing else to do. The extension will be loaded automatically by Arquillian at the test runtime.

## Code usage

Once you have setup everything correctly, you can start to write tests as usual. You have to annotate each test method
with `@Test` like you do normally. You can use the annotation ´@ProbeTest´ or not. It is no more mandatory to have this
annotation present on your test methods.

If you choose to use the `@ProbeTest` annotation, you can leave the `key` value blank. This value is not mandatory.
When the `key` is not provided, a fingerprint of the tests are used to identify your tests in a unique way.

In `Probe Dock RT`, you will see `package.class.method` in place of standard keys when they are not available. The `key`
filtering try first by the normal `key` mechanism and if not present on the test, try to match `package.class.method` as
a fallback.

## Contributing

* [Fork](https://help.github.com/articles/fork-a-repo)
* Create a topic branch - `git checkout -b feature`
* Push to your branch - `git push origin feature`
* Create a [pull request](http://help.github.com/pull-requests/) from your branch

Please add a changelog entry with your name for new features and bug fixes.

## License

**probedock-rt-junit** is licensed under the [MIT License](http://opensource.org/licenses/MIT).
See [LICENSE.txt](LICENSE.txt) for the full text.
