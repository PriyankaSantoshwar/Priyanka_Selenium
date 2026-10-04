# Priyanka Selenium Hybrid Framework

A clean Selenium + TestNG hybrid framework structure for automating the Jumia application using the Page Object Model (POM).

## Tech stack
- Java 17
- Maven
- Selenium WebDriver
- TestNG
- Allure / Extent Reports (ready for integration)

## Project structure

```text
Priyanka_Selenium/
├── pom.xml
├── README.md
├── testng.xml
├── .gitignore
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── yourcompany/
│   │               ├── base/
│   │               │   ├── BasePage.java
│   │               │   └── BaseTest.java
│   │               ├── pages/
│   │               │   ├── HomePage.java
│   │               │   ├── LoginPage.java
│   │               │   ├── SearchResultsPage.java
│   │               │   ├── CartPage.java
│   │               │   └── MyAccountPage.java
│   │               └── utils/
│   │                   ├── ConfigReader.java
│   │                   ├── DriverFactory.java
│   │                   └── WaitUtils.java
│   └── test/
│       └── java/
│           └── com/
│               └── yourcompany/
│                   └── tests/
│                       ├── login/
│                       │   └── LoginTests.java
│                       ├── cart/
│                       │   └── CartTests.java
│                       ├── search/
│                       │   └── SearchTests.java
│                       ├── register/
│                       │   └── RegisterTests.java
│                       └── logout/
│                           └── LogoutTests.java
```

## Key principles
- Page classes contain locators and page actions.
- Test classes contain only test scenarios and assertions.
- Base classes handle driver setup, teardown, and common utilities.
- Common configuration exists at the project root.

## How to run

```bash
mvn clean test
```

You can also run a specific suite:

```bash
mvn test -Dtestng.xml=testng.xml
```

## Notes
This repository has been restructured to follow a standard hybrid framework layout so that
page objects are separated from test classes and the project remains maintainable and scalable.
