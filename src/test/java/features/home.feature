Feature: Test the login functionality

  Scenario: verify the login section
    Given User open login page
    When enter valid userId and password
    Then User see success message and home title
    And User take a snapshot