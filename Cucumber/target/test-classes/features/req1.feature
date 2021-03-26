Feature: Login Functionality 

Scenario: Login to the application with Invalid Credentails
Given User navigate to homepage 
When User login to the application with invalid username "pujitha@gmail.com" and password "hello"
Then User should see an error message


Scenario: Login to the application with Invalid Credentails
Given User navigate to homepage 
When User login to the application with invalid username "purna@gmail.com" and password "hello123"
Then User should see an error message