Feature: Edit the Leads

Background:
Given Enter the UserName as DemoSalesManager
And Enter the Password as crmsfa
And Click the Login Button
When Click the CRMSFA Link
Then Verify the Home Page

@smoke
Scenario Outline: Positive EditLead
Given Click the Leads Link
And Click the Find Leads Link
And Enter the First Name to be Edit as <fName>
And Click the Find Leads
And Click the LeadId
And Click the Edit Button
And Clear the Company Field
And Enter the Company Name to be Edit as <cName>
When Click the Edit Submit Button
Then Verify the Company Name as <cName>

Examples:
|fName|cName|
|Mathura|CGI|
|Divya|IBM|