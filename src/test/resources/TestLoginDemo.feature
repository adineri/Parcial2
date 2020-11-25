Feature: Test user login
	
	Scenario: User logins succesfully with credentials
	Given Browser is open
	And user is in login page
	When users enters <username> and <password>
	And user clicks login button
	Then website shows main page

	Examples:
	|username||password|
	|jorge||12345|
	|Eloy|| 12345|