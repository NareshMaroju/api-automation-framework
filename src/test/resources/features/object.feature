Feature: Object API Testing

Scenario: Create an item
Given user prepares object with name "Apple MacBook Pro 16"
And CPU model is "Intel Core i9"
And price is "1849.99"
When user sends POST request
Then response status should be 200
And response should contain name "Apple MacBook Pro 16"

Scenario: Get an item
Given an item is already created
When user sends GET request for that item
Then response status should be 200

Scenario: List all items
When user sends GET request for all objects
Then response status should be 200
And response should contain list

Scenario: Delete an item
Given an item is already created
When user sends DELETE request
Then response status should be 200
