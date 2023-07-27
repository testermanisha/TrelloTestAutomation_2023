# TrelloTestAutomation_2023
This project contains the API automation tests for the Trello. It includes basically two main test scenarios which are as mentioned below:
1. Create a Board : In Create a Board test there are some positive and negative tests are added.
2. Get a Board : In Get a Board test there are some positive and negative tests are added.
The Framework is created using RestAssured, BDD, Java, TestNG and Selenium.
I could not complete the UI tests due to some time constraint and also i have not done that for soemtime.
In the test cases i have not used the basepath and baseURL way while doing the Post and Get, I just used the direct URL with the token and authorization exposed.
I have tried to add the JsonReports as well.
The tests can be run directly by going in the class and doing the run as.

Below mentioned are few of the Improvements that I would like to suggest:
1. Dont use the token and authorization in the API endpoint, may be just create a different authorization.
2. Make proper error codes for some of the things like, when creating a board at one point of time i was getting 400 error but it was not very clear from the error message why was it.

