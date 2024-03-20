Feature: Operations about user

  @PostUser
  Scenario: Create user successfully.
    When I consume the endpoint and I send the user information
    Then I can validate the create user response code

  @GetUser
  Scenario: Get user successfully.
    When I consume the endpoint and I get the user information
    Then I can validate the get user response code

  @PutUser
  Scenario: Update user successfully.
    When I consume the endpoint and I update the user information
    Then I can validate the update user response code

  @DeleteUser
  Scenario: Delete user successfully.
    When I consume the endpoint and I delete the user information
    Then I can validate the delete user response code