# LabStats Client
[![Actions Status](https://github.com/philip-bui/labstats-client/workflows/build/badge.svg)](https://github.com/philip-bui/labstats-client/actions)

[LabStats](https://labstats.com/) tracks when, where, and how long students are logged on to hardware resources in computer labs. It allows schools to maximize IT budget by discovering where you can expand, reduce, or eliminate hardware and software resources.

## Requirements

- [Create a valid API Key](https://support.labstats.com/article/api/#api-key-creation) from your Admin with the appropriate API permissions.
- Use the correct API based on your organization's location.
  - [North America](https://api.labstats.com).
  - [Australia, New Zealand, & Asia](https://sea-api.labstats.com).
  - [Europe](https://weu-api.labstats.com).
- Have read and understood the [LabStats API Best Practices](https://support.labstats.com/article/api-usage-best-practices/).

## Installation

### Maven

Set up Apache Maven to authenticate to GitHub Package Registry by editing your ~/.m2/settings.xml. For more information, see "[Authenticating to GitHub Package Registry](https://help.github.com/en/github/managing-packages-with-github-package-registry/configuring-apache-maven-for-use-with-github-package-registry#authenticating-to-github-package-registry)".

```xml
<dependencies>
  <dependency>
    <groupId>com.philipbui.labstats</groupId>
    <artifactId>labstats-client</artifactId>
    <version>1.0.0</version>
  </dependency>
</dependencies>
```

### Gradle

Set up Gradle to authenticate to GitHub Package Registry by editing your build.gradle or build.gradle.kts file. For more information, see "[Authenticating to GitHub Package Registry](https://help.github.com/en/github/managing-packages-with-github-package-registry/configuring-gradle-for-use-with-github-package-registry#authenticating-to-github-package-registry)".

```gradle
dependencies {
    implementation("com.philipbui.labstats:labstats-client:1.0.0")
}
```

## Usage

```java
LabStatsClient labStatsClient = new LabStatsClient(apiKey, Region.SEA);
GroupStatusResponse groupStatusResponse = labStatsClient.getLabStatsGroupStatus(groupID);
```

## Features

- [ ] Applications
- [ ] Availability
- [ ] Files
- [X] Groups (Computer Groups)
  - [ ] By ID
  - [ ] Stations by ID
  - [ ] Sub-Groups by ID
  - [X] Status (On, Offline, In-Use) by ID
  - [ ] Capabilities
- [ ] Maps
- [ ] Schedules
- [ ] Stations
- [ ] Users

## License

LabStats Client is available under the MIT license. [See LICENSE](https://github.com/philip-bui/labstats-client/blob/master/LICENSE) for details.
