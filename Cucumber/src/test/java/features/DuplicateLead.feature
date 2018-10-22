Feature: Duplicate the Leads

Background:
Given Enter the UserName as DemoSalesManager
And Enter the Password as crmsfa
And Click the Login Button
When Click the CRMSFA Link
Then Verify the Home Page

@smoke
Scenario Outline: Positive DuplicateLead
Given Click the Leads Link
And Click the Find Leads Link
And Click the Email Tab
And Enter the EmailId to DuplicateLead <emailId>
And Click the Find Leads
And Get the FirstName
And Click the LeadId
And Click the Duplicate Link
And Verify the Title as Duplicate
When Click the Duplicate Button
Then Verify the DuplicateLead First Name as ganesh

Examples:
|emailId|
|ganesh@test.com|
|divya@test.com|