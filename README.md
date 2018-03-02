# Hibernate example

[![license](https://img.shields.io/github/license/mashape/apistatus.svg?maxAge=2592000)]()
[![Build Status](https://travis-ci.org/MontealegreLuis/hibernate-example.svg?branch=master)](https://travis-ci.org/MontealegreLuis/hibernate-example)
[![codebeat badge](https://codebeat.co/badges/df70242a-a3d4-4367-8785-6703e4e243e6)](https://codebeat.co/projects/github-com-montealegreluis-hibernate-example)

Example project using Hibernate.

## Setup

Create a Hibernate configuration file.

```bash
$ cp hibernate.cfg.xml.dist src/main/resources/hibernate.cfg.xml
```

Customize the URL in the configuration file with your local database username and password.

Package and run the application with Maven

```
$ mvn package -Dmaven.test.skip=true
$ java -jar target/hibernate-example-1.0.0.jar
```

## Tests

Run the JUnit test suite with Maven

```bash
$ mvn test
```
