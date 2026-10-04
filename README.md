# SauceDemo UI Automation

A Java/Selenium UI automation portfolio project covering realistic e-commerce user journeys on [SauceDemo](https://www.saucedemo.com), a public application built for software testing practice.

## What it demonstrates

- Page Object Model with page-specific actions and locators
- Selenium explicit waits and Selenium Manager browser-driver setup
- TestNG test organization and assertions
- Positive and negative login coverage
- Product sorting, cart validation, demo checkout, and logout flows
- Failure screenshots saved to `target/screenshots`
- CI execution through GitHub Actions

## Technology

Java 17 · Maven · Selenium WebDriver 4.50 · TestNG 7

## Test scenarios

| Area | Scenario |
| --- | --- |
| Login | Valid user reaches the inventory; invalid password shows the expected error |
| Products | Products sort by price in ascending order |
| Cart | Added backpack appears in the cart |
| Checkout | Cart opens the customer-details step with all required fields |
| Logout | Logged-in user returns to the login page |

The suite uses SauceDemo's public test account (`standard_user` / `secret_sauce`). It verifies the checkout form but does not submit an order or enter payment details.

## Requirements

- JDK 17
- Maven 3.9+
- Chrome, Firefox, or Edge
- Internet access to SauceDemo (Selenium Manager resolves the browser driver)

## Run

Run the full suite in a visible browser:

```bash
mvn clean test
```

Run headlessly (as in CI):

```bash
mvn clean test -Dselenium.headless=true
```

Select a supported browser or override the demo URL:

```bash
mvn clean test -Dbrowser=firefox
mvn clean test -Dbrowser=edge
mvn clean test -Dsite.url=https://www.saucedemo.com/
```

Failure screenshots and TestNG reports are written under `target/`.

## Structure

```text
src/
├── main/java/com/saucedemo/automation/
│   ├── base/                 # Shared page actions and explicit waits
│   └── pages/                # Login, products, cart, and checkout page objects
└── test/java/com/saucedemo/automation/
    ├── base/                 # Browser lifecycle and failure screenshots
    ├── testdata/             # Shared public demo account
    └── tests/                # Focused TestNG scenarios by feature
```

## Design notes

- Each test gets a fresh browser session, so scenarios are isolated.
- Browser selection is configurable with `-Dbrowser=chrome|firefox|edge`.
- Headless mode is opt-in for local runs and enabled in CI.
- Tests use the application's stable `data-test` attributes where available.
- This is a UI automation demo, not a load test or a test against a production store.

## CI

GitHub Actions runs `mvn clean test` headlessly on pushes and pull requests, then uploads TestNG reports and any failure screenshots.
