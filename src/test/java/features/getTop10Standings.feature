Feature: top 10 standings
Scenario: Verify if get call to API is able to fetch the top 10 standings
	Given Get details using the GET API call
	When user pass league "EPL" and season "2015" with "get" http request
	Then the API call is success with status code 200	