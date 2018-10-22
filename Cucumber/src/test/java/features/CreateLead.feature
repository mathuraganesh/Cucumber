Feature: Create the Leads

Background:
Given Enter the UserName as DemoSalesManager
And Enter the Password as crmsfa
And Click the Login Button
When Click the CRMSFA Link
Then Verify the Home Page

@sanity
Scenario Outline: Positive CreateLead
Given Click the Create Lead Button
And Enter the Company Name as <cName>
And Enter the First Name as <fName>
And Enter the Last Name as <lName>
And Enter the EmailId as <emailId>
And Enter the PhoneNo as <phoneNo>
When Click the Create Lead Submit Button
Then Verify the First Name as <fName>

Examples:
|cName|fName|lName|emailId|phoneNo|
|IBM|Mathura|Ganesh|ganesh@test.com|9003187315|
|CGI|Divya|Lakshmi|divya@test.com|9003187316|