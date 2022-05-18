 computer-database assignment
```
This is the basic project of Java, Selenium, Cucumber, Junit and Rest Assured. I have tried to build a framework based on Page Object Model for this assignment. The task sheet provided by Nova is kept in the framework as 'QA Eng - Test.pdf'
```
## Technology Used
```
  1. Java
  2. Selenium
  3. Junit
  4. Cucumber
  5. Maven
  6. Rest Assured
```	
## Installation/Setup
```
To run this project, you need to have java >= 1.7, maven installed on your machine
```	
## Run Tests
```
	First method
	> mvn clean
	> mvn test
```
## Possible Manual Test Scenarios
```
All the test scenarios are present in 'Manual Test scenarios.xlsx'. This document contains 4 sheet each separate sheet for CRUD operation.
```
## Detailed explanation on Automation Framework

### Framework type: Page Object Model flavored with Cucumber
```
Contains both API and UI tests
```

### Project Structure
```
pageObjects:-
Contains locators of objects involved in pages of website
basePage: Contains common functions used accross step-definitions
```
```
runner:-
This package contains test runner class. This contains the code to glue the code with step def. It is the starting point of the execution of tests
```
```
stepDefinitions:-
This package has all the step definitions. Currently have single step def file containing both API and UI steps
```
```
features:-
This package has all .feature files which represents different test scenarios written in Gherkin Language(plain english).
```
```
drivers:-
This package contains the chrome driver. Currently, these scripts are running on chrome of windows. If you want to execute on chrome of Mac then you need to add the chrome driver for mac in this folder
```
```
pom.xml:-
It contains all the dependencies required to run this project
```

### Report
```
Report can be found out at ./target/cucumber-reports/cucumber.html
```

# Bonus Question
```
All the possible test cases required for full statement, branch, and path coverage of the Bonus question are present in 'Bonus.txt' file
```

  

