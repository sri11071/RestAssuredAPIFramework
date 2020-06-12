Feature: Validate Add place API verification

Scenario Outline: Verify if place API is successfully added  using API

Given Add place payload
When User calls <APIName> with Post http request
Then The API call got success with status code <statuscode>
And "status" in response body is "OK"
And "scope" in response body is "APP"


Examples:
|APIName	|statuscode|
|add  |200	|
