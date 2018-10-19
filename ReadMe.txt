It is an basic automation framework based on page object model and testng. It has 3 packages
customException: implemented user defined exception.
pageFactory: In page object model each page is defined as a class and each element is defined as a member in that class. All methods that can be perfomed on a page is 
also defined here like login method in login page. All page classes are defined in this package.
testCases: This is the test suite. Execution strats from DriverScript class which is defined in this package. Each method is an individual test case in driverscript class.

Execution stats from DriverScript and it calls methods from page object classes. Page object class (LoginPage) reads input if required and perform it's operation
and marked it as pass or fail as per the result (We can read input from xml file instead of hard coded value.). If the test case fails, it will throw the custom 
exception with proper error message and execuution of this test cases will be aborted.

I have automated one signup scenario and try to cover all validation. Here are these test cases.
1. User shoould be able to successfully signup if all input values i.e username, email and password are valid
2. User should not able to signup if username is invalid and should generate proper error message.
3. User should not able to signup if email is invalid and should generate proper error message.
4. User should not able to signup if password is invalid and should generate proper error message.
5. User should not able to signup if all fields are invalid and should generate proper error message.
6. User should not able to signup if username is any of the field is left blank and should generate proper error message.