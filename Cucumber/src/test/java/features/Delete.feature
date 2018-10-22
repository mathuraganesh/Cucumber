Feature: Delete the Leads

Background:
Given Enter the UserName as DemoSalesManager
And Enter the Password as crmsfa
And Click the Login Button
When Click the CRMSFA Link
Then Verify the Home Page

@smoke
Scenario Outline: Positive DeleteLead
Given Click the Leads Link
And Click the Find Leads Link
And Click the Delete Phone Tab
And Enter the Phone Number to be Delete as <phoneNo>
And Click the Find Leads
And Get the LeadId
And Click the LeadId
And Click the Delete Button
And Click the Find Leads Link
And Enter the LeadId
And Click the Find Leads
Then Verify No Record To Display

Examples:
|phoneNo|
|9003187315|
|9003187316|