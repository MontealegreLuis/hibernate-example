# Hibernate example

[![license](https://img.shields.io/github/license/mashape/apistatus.svg?maxAge=2592000)]()
[![Build Status](https://travis-ci.org/MontealegreLuis/hibernate-example.svg?branch=master)](https://travis-ci.org/MontealegreLuis/hibernate-example)

Example project using Hibernate.

## Setup

Create a Hibernate configuration file.

```bash
$ cp hibernate.cfg.xml.dist src/main/resources/hibernate.cfg.xml
```

Customize the URL, username and password.

Run the `main` method in the `Application` class.

## Tests

To run the unit tests, execute:

```bash
$ mvn test
```
