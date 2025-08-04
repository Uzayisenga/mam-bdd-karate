Feature: Check login page
Given the user is on the login page
When the user enters a valid username and an invalid password
And clicks the login button
Then an error message should be displayed
And the user should remain on the login page