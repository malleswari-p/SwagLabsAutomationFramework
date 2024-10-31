# SwagLabsAutomationFramework

Project Name : Swag Labs E-Commerce Website

About Project- The Swag labs application is an e-commerce website and providing the different products for placing the order. Different Users having accounts and can login to application and place the order. User can view the product details and add to cart for selected product. Ensure that user can provide the personal information and address to ship the product. In final checkout overview, user can confirm the product details and finish the order for final submission.

I have created the Automation test suite for this application using BDD approach and implemented the framework using Selenium WebDriver and Cucumber with Java as programming language.

I have checked in my code to git.

Tools and Libraries This project using 2 main tools, Selenium and Cucumber. On the other hand, I have used some of the other tools that support this framework. The complete list of dependencies are listed in the pom.xml file.

Requirements

Java Development Kit

Maven

Selenium WebDriver

Cucumber

About Framework

This framework contains 7 feature files that covering all the scenarios and total of 141 test cases including positive, negative and invalid combinations

Directory structure:

TestAutomationAssessment

src/main/java/Packages- pages,utils

src/test/java/Packages- factory,hooks,runner,stepdefinitions

src/test/resources/Packages-config,features

Steps to run at your system:

Clone the repository from git

Open the project using any Java IDE

Running the tests in Browser

Tests are running in chrome browser. To run tests in firefox browser,change browser in config.properties file to browser = firefox

Run the tests in command line

mvn clean install

mvn clean test > for running all tests

mvn test -Dcucumber.options="--tags @tagName" > To run specific test using cucumber tags

Test Reports:

In Console - Cucumber Reports In Target - CucumberReports -CucumberReport.html

html reports, spark reports and extent pdf reports

Screenshots:

In test-output - screenshots
