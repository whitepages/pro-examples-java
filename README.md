# Whitepages Pro Code Examples in Java [![Build Status](https://travis-ci.org/whitepages/pro-examples-java.svg?branch=master)](https://travis-ci.org/whitepages/pro-examples-java)

Use [Gradle] for build and dependency management (installation instructions [here][installation]).

## Build

To build the java examples type:

```shell
gradle build
```

## Run

```shell
gradle -PmainClass=IdentityCheckGet execute
gradle -PmainClass=LeadVerifyGet execute
gradle -PmainClass=CallerIdentificationGet execute
```

[Gradle]: http://gradle.org/
[installation]: https://docs.gradle.org/current/userguide/installation.html
